package Jedis_demo.jedis_demo;

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
}
