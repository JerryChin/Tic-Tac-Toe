package jerrychin.model;

import jerrychin.util.PlayState;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Player.
 */
public class PlayerTest extends TestCase {
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PlayerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    	TestSuite suite = new TestSuite(PlayerTest.class); 
        return suite; 
    }
    
    /**
     * GetterTest :-)
     */
    public void testGetter()
    {
    	Player player= new Player("Jerry", "cross", PlayState.PLAYABLE);
    	
    	assertTrue(player.getName().equalsIgnoreCase("Jerry"));
    	assertTrue(player.getPiece().equalsIgnoreCase("cross"));
    	assertTrue(player.isPlayable() == PlayState.PLAYABLE);
    }
}
