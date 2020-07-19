package Jedis_demo.jedis_demo;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class CreateJedisPoolTest {
	public JedisPool createPool() {
		final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(64);
        poolConfig.setMaxIdle(64);
		JedisPool jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379);
		return jedisPool;
	}
}