package jerrychin.service;

import jerrychin.model.ChessBoard;
import jerrychin.model.Square;

public class RemovePieceCommand implements Command{
	private ChessBoard chessBoard;
	private Square square;
	
	RemovePieceCommand(ChessBoard chessBoard, Square square) {
		this.chessBoard = chessBoard;
		this.square = square;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		chessBoard.removePiece(square);
	}

}
