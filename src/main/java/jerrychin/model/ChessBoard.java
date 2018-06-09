package jerrychin.model;

public interface ChessBoard {
	public void addPiece(Player player, Square square);
	public Player getPiece(int id);
	public void removePiece(Square square);
	public boolean isFull();
	public void cleanBoard();
}
