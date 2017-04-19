package com.spring.demo.service;

import org.springframework.stereotype.Service;

/**
 * redis 示例
 * @author HuangKai
 */
@Service
public class RedisSimpleService extends ServiceBase {
	
	public void set(String key,String value){
		super.stringRedisTemplate.opsForValue().set(key, value);
	}
	
	public String get(String key){
		return super.stringRedisTemplate.opsForValue().get(key);
	}
	
	public void setList(String key,String value){
		super.stringRedisTemplate.opsForList().leftPush(key, value);
	}
	
	public String getList(String key,long index){
		return super.stringRedisTemplate.opsForList().index(key, index);
	}
	
	public void setHash(String key,String hashKey,String value){
		super.stringRedisTemplate.opsForHash().put(key, hashKey, value);;
	}
	
	public Object getHash(String key,String hashKey){
		return super.stringRedisTemplate.opsForHash().get(key, hashKey);
	}
	
	
}
