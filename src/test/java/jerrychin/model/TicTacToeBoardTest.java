package jerrychin.model;

import jerrychin.util.Null;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for TicTacToeBoard.
 */
public class TicTacToeBoardTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TicTacToeBoardTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    	TestSuite suite = new TestSuite(TicTacToeBoardTest.class); 
        return suite; 
    }
    
    /**
     * manipulate pieces Test :-)
     */
    public void testManipulatePieces()
    {
    	int id = 0;
    	Player player = new Player();
    	Square square = new Square(0);
   	 	TicTacToeBoard board = new TicTacToeBoard();
   	 	
    	assertTrue(board.getPiece(id) instanceof Null);
    	
    	board.addPiece(player, square);
    	assertTrue(board.getPiece(id) == player);
    	
    	board.removePiece(square);
    	assertTrue(board.getPiece(id) != player);
    }
    
    /**
     * clean board Test :-)
     */
    public void testCleanBoard()
    {
    	Player player = new Player();
   	 	TicTacToeBoard board = new TicTacToeBoard();
   	 
		for(int i = 0; i < TicTacToeBoard.TOTAL_SQUARE; i++) {
			board.addPiece(player, new Square(i));
		}
		assertTrue(board.isFull() == true);
		
		board.cleanBoard();
		assertTrue(board.isFull() == false);
		assertTrue(board.getCount() == 0);
    }
}