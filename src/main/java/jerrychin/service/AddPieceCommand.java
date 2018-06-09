package jerrychin.service;

import jerrychin.model.ChessBoard;
import jerrychin.model.Player;
import jerrychin.model.Square;

public class AddPieceCommand implements Command{
	private ChessBoard chessBoard;
	private Player player;
	private Square square;
	
	public AddPieceCommand(ChessBoard chessBoard, Player player, Square square) {
		this.chessBoard = chessBoard;
		this.player = player;
		this.square = square;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		chessBoard.addPiece(player, square);
	}

}
