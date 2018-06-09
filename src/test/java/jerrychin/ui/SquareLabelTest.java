package jerrychin.ui;

import javax.swing.ImageIcon;

import jerrychin.resource.ResourceFactoryProducer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for SquareLabel.
 */
public class SquareLabelTest extends TestCase {
	int id = 10;
	SquareLabel label = new SquareLabel(id);
	ImageIcon imageIcon = (ImageIcon)ResourceFactoryProducer.
			getResourceFactory("image").getResource().getElement("cross");
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SquareLabelTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    	TestSuite suite = new TestSuite(SquareLabelTest.class); 
        return suite; 
    }
    
    /**
     * GetterTest :-)
     */
    public void testGetter()
    {
    	assertTrue(label.getId() == id);
    	label.setImageIcon(imageIcon);
    }
}
