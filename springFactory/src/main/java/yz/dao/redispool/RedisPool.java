package yz.dao.redispool;

import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
	private static Logger logger=LogManager.getLogger(RedisPool.class);
	private static JedisPool pool;
	
	public synchronized static JedisPool getPool(){
		if(pool==null){
			new RedisPool();
		}
		return pool;
	};
	
	private RedisPool(){
		logger.info("redis pool begin to start..");
		ResourceBundle bundle =ResourceBundle.getBundle("redis");
		if(bundle==null){
			throw new IllegalArgumentException("[redis.properties] iis not found!");
		}
		JedisPoolConfig config=new JedisPoolConfig();
		config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxActive")));
		config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
		config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.pool.maxWait")));
		config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));
		pool=new JedisPool(config,bundle.getString("redis.ip"),Integer.valueOf(
				bundle.getString("redis.port")));
		logger.info("redis pool is running...");
	}
}
