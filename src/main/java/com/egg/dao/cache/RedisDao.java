package com.egg.dao.cache;

import com.egg.utils.Log4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {

    private final JedisPool jedisPool;

    public RedisDao(String ip, int port){
        jedisPool = new JedisPool(ip, port);
    }

    public void putToken(long userId, String token){
        try{
            Jedis jedis = jedisPool.getResource();
            try{
                String uid = String.valueOf(userId);
                int timeout = 60 * 60 * 24;

                jedis.setex(uid, timeout, token);
            }finally {
                jedis.close();
            }
        }catch (Exception why){
            Log4j.error("redis put token error!");
            why.printStackTrace();
        }
    }

    public String getToken(long userId){
        try{
            Jedis jedis = jedisPool.getResource();
            try {
                String uid = String.valueOf(userId);
                return jedis.get(uid);
            }finally {
                jedis.close();
            }
        }catch (Exception why){
            Log4j.error("redis get token error!");
            why.printStackTrace();
        }
        return null;
    }
}
