package jerrychin.service;

import java.util.Map;
import java.util.Random;
import jerrychin.controller.TicTacToeGame;
import jerrychin.model.ChessBoard;
import jerrychin.model.Player;
import jerrychin.model.Square;
import jerrychin.model.TicTacToeBoard;
import jerrychin.util.Null;
import jerrychin.util.PlayState;
import jerrychin.util.Result;
import static jerrychin.util.Announcement.*;

public class TicTacToeReferee implements Referee {
	
	/**
	 * @param player whose performance to judge
	 */
	@Override
	public Result judge(ChessBoard chessBoard, Player player) {
		// line in rank
		for(int i = 0; i < TicTacToeBoard.TOTAL_SQUARE; i += 3) {
			if(chessBoard.getPiece(i) == chessBoard.getPiece(i + 1) && chessBoard.getPiece(i + 1) == chessBoard.getPiece(i + 2))
				return new Result(chessBoard.getPiece(i) == player ? SUCCESS : FAILURE, chessBoard.getPiece(i));		
		}
		
		// line in file
		for(int i = 0; i < 3; i++) {
			if(chessBoard.getPiece(i) == chessBoard.getPiece(i + 3) && chessBoard.getPiece(i + 3) == chessBoard.getPiece(i + 6))
				return new Result(chessBoard.getPiece(i) == player ? SUCCESS : FAILURE, chessBoard.getPiece(i));
		}
		
		// line in diagonal
		if(chessBoard.getPiece(0) == chessBoard.getPiece(4) && chessBoard.getPiece(4) == chessBoard.getPiece(8))
			return new Result(chessBoard.getPiece(0) == player ? SUCCESS : FAILURE, chessBoard.getPiece(0));
		if(chessBoard.getPiece(2) == chessBoard.getPiece(4) && chessBoard.getPiece(4) == chessBoard.getPiece(6))
			return new Result(chessBoard.getPiece(2) == player ? SUCCESS : FAILURE, chessBoard.getPiece(2));
		
		if(chessBoard.isFull())
			return new Result(DRAW);
		return new Result(CONTINUING);
		// TODO Auto-generated method stub
	}
	


	@Override
	public Square whereToAdd(ChessBoard chessBoard, Player opponent) {
		// TODO Auto-generated method stub
			
		//rank threats
		for(int i = 0; i < TicTacToeBoard.TOTAL_SQUARE; i += 3) {
			//C(3, 2) = 3
			if(opponent == chessBoard.getPiece(i) && opponent == chessBoard.getPiece(i + 1) &&
					(chessBoard.getPiece(i + 2) instanceof Null)) {
				return new Square(i + 2);
			}
			if(opponent == chessBoard.getPiece(i + 1) && opponent == chessBoard.getPiece(i + 2) &&
					(chessBoard.getPiece(i) instanceof Null)) {
				return new Square(i);
			}
			if(opponent == chessBoard.getPiece(i) && opponent == chessBoard.getPiece(i + 2) &&
					(chessBoard.getPiece(i + 1) instanceof Null)) {
				return new Square(i + 1);
			}
		}
		
		//file threats
		for(int i = 0; i < 3; i++) {
			//C(3, 2) = 3
			if(opponent == chessBoard.getPiece(i) && opponent == chessBoard.getPiece(i + 3) &&
					(chessBoard.getPiece(i + 6) instanceof Null)) {
				return new Square(i + 6);
			}
			if(opponent == chessBoard.getPiece(i + 3) && opponent == chessBoard.getPiece(i + 6) &&
					(chessBoard.getPiece(i) instanceof Null)) {
				return new Square(i);
			}
			if(opponent == chessBoard.getPiece(i) && opponent == chessBoard.getPiece(i + 6) &&
					(chessBoard.getPiece(i + 1) instanceof Null)) {
				return new Square(i + 1);
			}
		}
		
		//diagonal threats
		if(opponent == chessBoard.getPiece(0) && opponent == chessBoard.getPiece(4) &&
				(chessBoard.getPiece(8) instanceof Null)) {
			return new Square(8);
		}
		if(opponent == chessBoard.getPiece(4) && opponent == chessBoard.getPiece(8) &&
				(chessBoard.getPiece(0) instanceof Null)) {
			return new Square(0);
		}
		if(opponent == chessBoard.getPiece(0) && opponent == chessBoard.getPiece(8) &&
				(chessBoard.getPiece(4) instanceof Null)) {
			return new Square(4);
		}
		
		if(opponent == chessBoard.getPiece(2) && opponent == chessBoard.getPiece(4) &&
				(chessBoard.getPiece(6) instanceof Null)) {
			return new Square(6);
		}
		if(opponent == chessBoard.getPiece(4) && opponent == chessBoard.getPiece(6) &&
				(chessBoard.getPiece(2) instanceof Null)) {
			return new Square(2);
		}
		if(opponent == chessBoard.getPiece(2) && opponent == chessBoard.getPiece(6) &&
				(chessBoard.getPiece(4) instanceof Null)){
			return new Square(4);
		}
		
		//randomly stuff an empty square;
		Random rand = new Random(47);
		if(!chessBoard.isFull()) {
			int i = 0;
			while(!(chessBoard.getPiece(i) instanceof Null))
				i = rand.nextInt(TicTacToeBoard.TOTAL_SQUARE);
			return new Square(i);
		}
		
		return null;
	}
	
	public boolean isThreatening(ChessBoard chessBoard, Player opponent) {
		//rank threats
		for(int i = 0; i < TicTacToeBoard.TOTAL_SQUARE; i += 3) {
			//C(3, 2) = 3
			if(opponent == chessBoard.getPiece(i) && opponent == chessBoard.getPiece(i + 1) &&
					(chessBoard.getPiece(i + 2) instanceof Null))
				return true;
			if(opponent == chessBoard.getPiece(i + 1) && opponent == chessBoard.getPiece(i + 2) &&
					(chessBoard.getPiece(i) instanceof Null))
				return true;
			if(opponent == chessBoard.getPiece(i) && opponent == chessBoard.getPiece(i + 2) &&
					(chessBoard.getPiece(i + 1) instanceof Null))
				return true;
		}
		
		//file threats
		for(int i = 0; i < 3; i++) {
			//C(3, 2) = 3
			if(opponent == chessBoard.getPiece(i) && opponent == chessBoard.getPiece(i + 3) &&
					(chessBoard.getPiece(i + 6) instanceof Null))
				return true;
			if(opponent == chessBoard.getPiece(i + 3) && opponent == chessBoard.getPiece(i + 6) &&
					(chessBoard.getPiece(i) instanceof Null))
				return true;
			if(opponent == chessBoard.getPiece(i) && opponent == chessBoard.getPiece(i + 6) &&
					(chessBoard.getPiece(i + 1) instanceof Null))
				return true;
		}
		
		//diagonal threats
		if(opponent == chessBoard.getPiece(0) && opponent == chessBoard.getPiece(4) &&
				(chessBoard.getPiece(8) instanceof Null))
			return true;
		if(opponent == chessBoard.getPiece(4) && opponent == chessBoard.getPiece(8) &&
				(chessBoard.getPiece(0) instanceof Null))
			return true;
		if(opponent == chessBoard.getPiece(0) && opponent == chessBoard.getPiece(8) &&
				(chessBoard.getPiece(4) instanceof Null))
			return true;
		
		if(opponent == chessBoard.getPiece(2) && opponent == chessBoard.getPiece(4) &&
				(chessBoard.getPiece(6) instanceof Null))
			return true;
		if(opponent == chessBoard.getPiece(4) && opponent == chessBoard.getPiece(6) &&
				(chessBoard.getPiece(2) instanceof Null))
			return true;
		if(opponent == chessBoard.getPiece(2) && opponent == chessBoard.getPiece(6) &&
				(chessBoard.getPiece(4) instanceof Null))
			return true;
		
		return false;
	}



	@Override
	public Player updateWhoToPlay(Map<String, Player> playerMap) {
		// TODO Auto-generated method stub
		switch(playerMap.get(TicTacToeGame.userName).isPlayable()) {
		case PLAYABLE:
			playerMap.get(TicTacToeGame.computerName).setPlayable(PlayState.PLAYABLE);
			playerMap.get(TicTacToeGame.userName).setPlayable(PlayState.UNPLAYABLE);
			return playerMap.get(TicTacToeGame.computerName);
			
		case UNPLAYABLE:
			playerMap.get(TicTacToeGame.userName).setPlayable(PlayState.PLAYABLE);
			playerMap.get(TicTacToeGame.computerName).setPlayable(PlayState.UNPLAYABLE);
			return playerMap.get(TicTacToeGame.userName);
		}
		return null;
	}


	@Override
	public void cleanMind() {
		// TODO Auto-generated method stub
		
	}
}
