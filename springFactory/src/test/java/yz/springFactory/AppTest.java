package yz.springFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import redis.clients.jedis.JedisPool;
import yz.bean.Apple;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testApp1()
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext( new String[] {"beans.xml"});
    	Apple apple=(Apple) context.getBean("apple");
    	System.out.println(apple);
    }
    
    public void testApp2()
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext( new String[] {"beans.xml"});
    	JedisPool jp=(JedisPool) context.getBean("redisPool");
    	System.out.println(jp);
    }
}
