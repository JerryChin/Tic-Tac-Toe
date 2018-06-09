package jerrychin.model;

import jerrychin.service.AddPieceCommand;
import jerrychin.service.Invoker;
import jerrychin.util.PlayState;

public class Player {
	private String name;
	private PlayState playable;
	private String piece;
	private Square square;
	
	public Player(){}
	
	public Player(String name, String piece, PlayState playable) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.piece = piece;
		this.playable = playable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayState isPlayable() {
		return playable;
	}

	public void setPlayable(PlayState playable) {
		this.playable = playable;
	}

	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}
	
	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}
	
	public void addPiece(Invoker invoker, ChessBoard chessBoard) {
		invoker.setCommand(new AddPieceCommand(chessBoard, this, getSquare()));
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
