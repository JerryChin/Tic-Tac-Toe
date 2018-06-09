package jerrychin.controller;

import static jerrychin.util.PlayState.PLAYABLE;
import static jerrychin.util.PlayState.UNPLAYABLE;
import static jerrychin.util.SimplePrint.println;
import static jerrychin.util.SwingConsole.run;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import jerrychin.model.ChessBoard;
import jerrychin.model.Player;
import jerrychin.model.Square;
import jerrychin.model.TicTacToeBoard;
import jerrychin.service.DeclareResultCommand;
import jerrychin.service.Invoker;
import jerrychin.service.PlayAudioCommand;
import jerrychin.service.PrepareForNextGameCommand;
import jerrychin.service.Referee;
import jerrychin.service.SendClickCommand;
import jerrychin.service.TicTacToeReferee;
import jerrychin.service.UpdateSquareLabelIconCommand;
import jerrychin.ui.GameWindow;
import jerrychin.ui.SquareLabel;
import jerrychin.util.DEBUG;
import jerrychin.util.Result;
public class TicTacToeGame implements ChessGame{
	public static String userName = "玩家";
	public static String computerName = "电脑";
	public static int modelAnswer;
	private Referee referee;
	private ChessBoard chessBoard;
	private Map<String, Player> allPlayer;
	private Invoker invoker;
	private GameWindow gameWindow;
	
	//indicating who is playing
	private Player whoIsPlaying;
	TicTacToeGame(int modelAnswer) {
		TicTacToeGame.modelAnswer = modelAnswer;
		referee = new TicTacToeReferee();
		chessBoard = new TicTacToeBoard();
		invoker = new Invoker();
		gameWindow = new GameWindow(getMouseListenerImp());
		allPlayer = new HashMap<String, Player>();
		allPlayer.put(userName, new Player(userName, "nought", PLAYABLE));
		allPlayer.put(computerName, new Player(computerName, "cross", UNPLAYABLE));
		setWhoIsPlaying(allPlayer.get(userName));
		
		DEBUG.disable();;
	}
	
	TicTacToeGame(String userName, int modelAnswer) {
		this(modelAnswer);
		if(userName != null)
			TicTacToeGame.userName = userName;
	}
	TicTacToeGame(String userAName, String userBName, int modelAnswer) {
		this(userAName, modelAnswer);
		if(userBName != null)
			TicTacToeGame.computerName = userBName;
	}
	
	/**
	 * @return the gameWindow
	 */
	public GameWindow getGameWindow() {
		return gameWindow;
	}

	/**
	 * @param gameWindow the gameWindow to set
	 */
	public void setGameWindow(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}
	
	public MouseListener getMouseListenerImp() {
		return new MouseListenerImp();
	}
	
	private class MouseListenerImp extends MouseAdapter {

		@Override
		public synchronized void mouseClicked(MouseEvent e) {
			SquareLabel source = (SquareLabel)e.getSource();
			
			if(source.getPlayer() != null)
				return;
			println("before remove event?" + source.getMouseListeners());
			println("before remove event?" + (MouseListener)gameWindow.getMouseListener());
			// stop this label listening
			source.removeMouseListener(gameWindow.getMouseListener());
			

			Player player = getWhoIsPlaying();
			
			source.setPlayer(player);
			
			// update which square that the player/computer has clicked
			player.setSquare(new Square(source.getId()));
			
			// update model command initiated
			player.addPiece(invoker, chessBoard);
			invoker.execute();
			
			// update UI initiated
			invoker.setCommand(new UpdateSquareLabelIconCommand(gameWindow, source.getId(), player.getPiece()));
			
			
			if(DEBUG.debug) {
				println("Who is playing " + getWhoIsPlaying() + "  " + new Date());
				println("Label id " + source.getId());
				println("player piece shape " + player.getPiece());
				println("after remove event?" + source.getMouseListeners());
				
			}
			
			// play audio
			invoker.setCommand(new PlayAudioCommand("click"));
			invoker.asynExecute();
			
			Result result = referee.judge(chessBoard, allPlayer.get(userName));
			
			// set default cursor icon
			gameWindow.setCursor(null);
			
			if(DEBUG.debug) {
				println("Player : " + getWhoIsPlaying());
				println("Result : " + result.getAnnouncement());
				println("Label ID : " + result.getAnnouncement());
				println("Chess Board : \n" + chessBoard);
			}
			
			switch(result.getAnnouncement()) {
			case CONTINUING:
					// next player's turn
					setWhoIsPlaying(referee.updateWhoToPlay(allPlayer));
					
					int id = 10;
					if(DEBUG.debug) {
						println("CONTINUING: next player \n" + getWhoIsPlaying());
						println("CONTINUING: chess count " + ((TicTacToeBoard)chessBoard).getCount());
						println("CONTINUING: full " + ((TicTacToeBoard)chessBoard).isFull());
					}
					
					if(modelAnswer != JOptionPane.NO_OPTION && getWhoIsPlaying().toString().equalsIgnoreCase(allPlayer.get(computerName).getName())) {
					
						
						gameWindow.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
						
						// two in line, add one missing
						if(referee.isThreatening(chessBoard, allPlayer.get(computerName)))
							id = referee.whereToAdd(chessBoard, allPlayer.get(computerName)).getId();
						else
							id = referee.whereToAdd(chessBoard, allPlayer.get(userName)).getId();

						invoker.setCommand(new SendClickCommand(gameWindow, id));
						invoker.execute();

						if(DEBUG.debug) {
							println("Next Player : " + getWhoIsPlaying());
							println("Being threatened : " + referee.isThreatening(chessBoard, allPlayer.get(userName)));
							println("Next to place : " + id);
						}
					}
					
					break;
			default:
					if(DEBUG.debug) {
						println("clean before \n" + chessBoard);
					}
					
					// play game over audio
					invoker.setCommand(new PlayAudioCommand(result.getAnnouncement().getAudio()));
					//declare result
					invoker.setCommand(new DeclareResultCommand(gameWindow, String.format(result.getAnnouncement().toString(),result.getWinner())));			
					//prepare for next match
					invoker.setCommand(new PrepareForNextGameCommand(TicTacToeGame.this));
					invoker.asynExecute();
				
					if(DEBUG.debug)
						println("clean after \n" + chessBoard);	
					break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		//get user name
		String userAName = null;
		String userBName = null;
		TicTacToeGame tictactoe;
		userAName = JOptionPane.showInputDialog("请输入你的大名："); 
		int modelAnwser = JOptionPane.showConfirmDialog(null, "是否选择“电脑对战模式”？", "模式选择", JOptionPane.YES_NO_OPTION);
		
		//two player
		if(modelAnwser == JOptionPane.NO_OPTION)
			userBName = JOptionPane.showInputDialog("请输入你对手的大名：");
		tictactoe = new TicTacToeGame(userAName, userBName, modelAnwser);
			
		if(DEBUG.debug)
			System.out.println(userAName + " " + userBName + " "+ modelAnwser);
			
		tictactoe = new TicTacToeGame(modelAnwser);
		run(tictactoe.gameWindow, 450, 470);
	}

	public Player getWhoIsPlaying() {
		return whoIsPlaying;
	}

	public void setWhoIsPlaying(Player whoIsPlaying) {
		this.whoIsPlaying = whoIsPlaying;
	}

	@Override
	public void prepareForNextGame() {
		// TODO Auto-generated method stub
		chessBoard.cleanBoard();
		gameWindow.setMouseListener(getMouseListenerImp());
		gameWindow.cleanWidnow();
		
		referee.cleanMind();
		allPlayer.clear();
		allPlayer.put(userName, new Player(userName, "nought", PLAYABLE));
		allPlayer.put(computerName, new Player(computerName, "cross", UNPLAYABLE));
		setWhoIsPlaying(allPlayer.get(userName));
	}

}
