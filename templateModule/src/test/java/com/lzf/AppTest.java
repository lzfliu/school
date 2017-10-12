package com.lzf;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
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
    public void testApp(){
        Integer a = 5;
        Integer b = a ;

        a++;

        System.out.println("b的值是：--- " + b + "，当前方法=AppTest.testApp()");
        System.out.println("a的值是：--- " + a + "，当前方法=AppTest.testApp()");
    }
}
