package com.saschalorenz.matchgame.test;

import matchGameCommon.GameUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestGameUtils 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestGameUtils( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestGameUtils.class );
    }

    
    public void testInitialize()
    {
    	int testNumber = GameUtils.initializeGame();
        assertTrue( testNumber >= 30 && testNumber <= 40);
    }
}
