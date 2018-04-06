package com.egg.dao.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {

    private final JedisPool jedisPool;

    public RedisDao(String ip, int port){
        jedisPool = new JedisPool(ip, port);
    }

    public String putToken(long userId, String token){
        try{
            Jedis jedis = jedisPool.getResource();
            try{
                String uid = String.valueOf(userId);
                int timeout = 60 * 60 * 24;

                return jedis.setex(uid, timeout, token);
            }finally {
                jedis.close();
            }
        }catch (Exception why){
            why.printStackTrace();
        }
        return null;
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
            why.printStackTrace();
        }
        return null;
    }
}
