package jerrychin.util;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static jerrychin.util.Announcement.*;
/**
 * Unit test for class Announcement
 */
public class AnnouncementTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AnnouncementTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    	TestSuite suite = new TestSuite(AnnouncementTest.class);
        return suite; 
    }
        
    /**
     * Message String Equality Test :-)
     */
    public void testMessageEquality()
    {
    	assertEquals("很不走运，你输啦！", FAILURE.toString());
    	assertEquals("玩家  %s 赢得本回合胜利！", SUCCESS.toString());
    	assertEquals("本回合平局！", DRAW.toString());
    	assertEquals("continuing", CONTINUING.toString());
    }
    
    /**
     * Audio String Equality Test :-)
     */
    public void testAudioEquality()
    {
    	assertEquals("failure", FAILURE.getAudio());
    	assertEquals("success", SUCCESS.getAudio());
    	assertEquals("draw", DRAW.getAudio());
    	assertEquals("continuing", CONTINUING.getAudio());
    }
    
}
