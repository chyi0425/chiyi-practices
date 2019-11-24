package com.chiyi.stream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.junit.Assert.*;

/**
 * @author chiyi
 * @date 2019/9/17.
 */
public class AppTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

}