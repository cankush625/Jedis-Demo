package Jedis_demo.jedis_demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class AppTest {
    @Test
    public void test() {
    	Jedis jedis = new Jedis("127.0.0.1", 6379);
    	String result = jedis.set("hello", "world");
    	assertEquals(result, "OK");
    	String value = jedis.get("hello");
        assertEquals(value, "world");
        jedis.close();
    }
}
