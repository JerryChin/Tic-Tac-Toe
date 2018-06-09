package jerrychin.resource;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for resource.
 */
public class ResourceTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ResourceTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    	TestSuite suite = new TestSuite(ResourceTest.class); 
        return suite; 
    }
    
    /**
     * Factory Producer Test :-)
     */
    public void testResourceFactoryProducer()
    {
    	assertTrue(ResourceFactoryProducer.getResourceFactory("image") != null);
    	assertTrue(ResourceFactoryProducer.getResourceFactory("audio") != null);
    }
    
    /**
     * Factory Test :-)
     */
    public void testResourceFactory()
    {
    	assertTrue(ResourceFactoryProducer.getResourceFactory("image").getResource() != null);
    	assertTrue(ResourceFactoryProducer.getResourceFactory("audio").getResource() != null);
    }
    
    /**
     * Element Test :-)
     */
    public void testResource()
    {
    	Resource res = ResourceFactoryProducer.getResourceFactory("image").getResource();
    	assertTrue(res.getElement("cross") != null);
    	assertTrue(res.getElement("nought") != null);
    	
    	res = ResourceFactoryProducer.getResourceFactory("audio").getResource();
    	assertTrue(res.getElement("click") != null);
    	assertTrue(res.getElement("draw") != null);
    	assertTrue(res.getElement("success") != null);
    	assertTrue(res.getElement("failure") != null);
    }
    
}

