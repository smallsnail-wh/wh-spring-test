package com.wh.demo.test.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wh.demo.test.dao.TestDao;
import com.wh.demo.test.dao.UserDao;
import com.wh.demo.test.model.TestEntity;
import com.wh.demo.test.model.UserEntity;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TestDao testDao;
	
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@GetMapping("/redis/set/{mes}")
	public String reidsSet(@PathVariable("mes") String mes) {
		
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		
		SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
		ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
		
		setOperations.add("set", "a","c","d","c");
		
		zSetOperations.add("zset", "a", 1);
		zSetOperations.add("zset", "b", 3);
		zSetOperations.add("zset", "c", 2);
		
		redisTemplate.expire("set", 60, TimeUnit.SECONDS);
		
		/*redisTemplate.opsForValue().set("redisTemplate", testEntity);*/
		
		/*redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
		
		HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("a", testEntityGet(1));
		map.put("b", testEntityGet(2));
		map.put("c", testEntityGet(3));
		hashOperations.putAll("hash", map);*/
		
		/*redisTemplate.setKeySerializer(new StringRedisSerializer());*/
		/*redisTemplate.setKeySerializer(new StringRedisSerializer());*/
		/*redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));*/
		/*redisTemplate.setValueSerializer(new StringRedisSerializer());
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		Collection<String> list = new ArrayList<String>();
		list.add("q");
		list.add("w");
		list.add("e");
		
		listOperations.rightPushAll("list", "a","b","c");
		listOperations.rightPushAll("list", list);*/
		/*listOperations.set("list", 1, testEntityGet(1));*/
		/*listOperations.set("list", 1, "b");*/
		/*listOperations.rightPush("list", testEntityGet(2));*/
		
		/*redisTemplate.opsForHash().put("hash", "redisTemplate", testEntity);*/
		/*redisTemplate.opsForHash().put("redisTemplate", "redisTemplate", "123123");*/
		
		/*stringRedisTemplate.opsForValue().set("stringRedisTemplate", "wanghuan");
		stringRedisTemplate.opsForList().set("list", 1, "wanghuan");
		stringRedisTemplate.opsForHash().put("hash", "wanghuan", "mtt");
		stringRedisTemplate.opsForSet().add("set", "wanghuan");
		Set<TypedTuple<String>> set = new HashSet<TypedTuple<String>>();
		stringRedisTemplate.opsForZSet().add("zset", set);*/
		
		return "SUCCESS";
	}
	
	public TestEntity testEntityGet(int i) {
		TestEntity testEntity = new TestEntity();
		testEntity.setId(i);
		testEntity.setName("test"+i);
		testEntity.setLoginName("test"+i);
		testEntity.setPassword("whmtt"+i);
		testEntity.setEmail("whmtt"+i+"@qq.com");
		return testEntity;
	}
	
	@GetMapping("/redis/get")
	public TestEntity reidsGet() {
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<TestEntity>(TestEntity.class));
		TestEntity object = (TestEntity) redisTemplate.opsForHash().get("hash", "redisTemplate");
		/*Object object = redisTemplate.opsForValue().get("redisTemplate");*/
		return object;
	}
	
	@GetMapping("/insert10000")
	public String insert10000() {
		new Thread(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			TestEntity testEntity = new TestEntity();
			for(int i = 10001;i<=100000;i++) {
				testEntity.setName("test"+i);
				testEntity.setLoginName("test"+i);
				testEntity.setPassword("whmtt");
				testEntity.setEmail("whmtt@qq.com");
				testDao.insert10000(testEntity);
			}
		}).start();
		
		return "SUCCESS";
	}
	
	@GetMapping("/userAll")
	public List<UserEntity> userAll(){
		return userDao.userAll();
	}
	
	private int count = 0;
	
	
	
	@GetMapping("1")
	public Map test() {
		
		Map<String,Object> result = new HashMap();
		result.put("id", 1);
		result.put("name", "wanghuan");
		
		return result;
	}
	
	@GetMapping("/thread")
	public String thread() {
		System.out.println(count);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		countAdd();
		/*new Thread(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countAdd();
		}).start();*/
		
		return "SUCCESS";
	}
	
	public void countAdd() {
		/*synchronized(getClass()) {
			count++;
		}*/
		count++;
		
	}
	
	public void threadTest() {
		System.out.println("主方法线程开始");
		new Thread(() -> {
			System.out.println("new 方法线程开始");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("new 方法线程结束");
		}).start();
		;

		new MyThread().start();

		new Thread(new MyRunnableThread()).start();
		System.out.println("主方法线程结束");
	}

	class MyThread extends Thread {

		@Override
		public void run() {
			System.out.println("MyThread 方法线程开始");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("MyThread 方法线程结束");
		}

	}

	class MyRunnableThread implements Runnable {

		@Override
		public void run() {
			System.out.println("MyRunnableThread 方法线程开始");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("MyRunnableThread 方法线程结束");
		}
	}

}
