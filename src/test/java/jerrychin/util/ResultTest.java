package jerrychin.util;

import jerrychin.model.Player;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for class Result
 */
public class ResultTest extends TestCase {
	Result result1 = new Result(Announcement.SUCCESS);
	Player player = new Player();
	Result result2 = new Result(Announcement.SUCCESS, player);
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ResultTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    	TestSuite suite = new TestSuite(ResultTest.class);
        return suite; 
    }
        
    /**
     * Getter Test :-)
     */
    public void testGetter()
    {
    	assertTrue(result1.getAnnouncement()  == Announcement.SUCCESS);
    	assertTrue(result2.getAnnouncement()  == Announcement.SUCCESS);
    	assertTrue(result2.getWinner()  == player);
    }  
}
