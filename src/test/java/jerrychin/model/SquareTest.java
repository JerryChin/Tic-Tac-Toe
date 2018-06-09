package jerrychin.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Square.
 */
public class SquareTest extends TestCase {
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SquareTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    	TestSuite suite = new TestSuite(SquareTest.class); 
        return suite; 
    }
    
    /**
     * GetterTest :-)
     */
    public void testGetter()
    {
    	int id = 10;
    	Square square = new Square(10);
    	assertTrue(square.getId() == id);
    }
}
