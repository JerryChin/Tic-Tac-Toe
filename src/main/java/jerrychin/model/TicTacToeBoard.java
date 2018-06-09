package jerrychin.model;

import java.util.ArrayList;
import java.util.List;

import jerrychin.util.Null;
public class TicTacToeBoard implements ChessBoard {
	private List<Player> squareList;
	public static final int TOTAL_SQUARE = 9;
	public int count;
	
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	public TicTacToeBoard() {
		squareList = new ArrayList<Player>();
		
		for(int i = 0; i < TOTAL_SQUARE; i++) {
			squareList.add(new Null());
		}
		
		setCount(0);
	}
	
	@Override
	public synchronized void addPiece(Player player, Square square) {
		// modification to element initiated is prohibited
		if(!isFull() && squareList.get(square.getId()) instanceof Null) {
			squareList.set(square.getId(), player);
			setCount(getCount() + 1);
		}
		
	}
	
	@Override
	public synchronized void removePiece(Square square) {
		// TODO Auto-generated method stub
		squareList.remove(square.getId());
		setCount(getCount() - 1);
	}
	
	@Override
	public String toString() {
		String string = "";
		int i = 0;
		
		for(Player player : squareList) {
			string += ("" + i++  + ": " + player + "   ");
			if(i % 3 == 0)
				string += "\n";
		}
		
		return string;
	}

	@Override
	public synchronized Player getPiece(int id) {
		// TODO Auto-generated method stub
		return squareList.get(id);
	}

	@Override
	public synchronized boolean isFull() {
		// TODO Auto-generated method stub
		return count >= TOTAL_SQUARE;
	}

	@Override
	public synchronized void cleanBoard() {
		// TODO Auto-generated method stub
		squareList.clear();
		
		for(int i = 0; i < TOTAL_SQUARE; i++) {
			squareList.add(new Null());
		}
		
		setCount(0);
	}
}
