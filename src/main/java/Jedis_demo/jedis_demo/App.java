package Jedis_demo.jedis_demo;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class App {
	public int setAdd(JedisPool pool, String setName, String value) {
		try (Jedis jedis = pool.getResource()) {
			Long result = jedis.sadd(setName, value);
			if (result != 0) {
				System.out.println("Entry succesful to the database");
				return 1;
			}
			return 0;
		}
	}
	
    public static void main( String[] args ){
    	CreateJedisPool Jedispool = new CreateJedisPool();
    	
    	JedisPool pool = Jedispool.createPool();
    	
		App app = new App();
		String setName = "jedisHello";
		String value = "jedisset";
		app.setAdd(pool, setName, value);
    }

	public Set<String> getSetValue(JedisPool pool, String setName) {
		try (Jedis jedis = pool.getResource()) {
			if (setName == null) { return null; }
			Set<String> result = jedis.smembers(setName);
			return result;
		}
	}
}
