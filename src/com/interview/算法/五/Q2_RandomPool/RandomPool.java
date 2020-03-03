package com.interview.算法.五.Q2_RandomPool;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计RandomPool结构
 * 【题目】 设计一种结构，在该结构中有如下三个功能： 
	insert(key)：将某个key加入到该结构，做到不重复加入。 
	delete(key)：将原本在结构中的某个key移除。 getRandom()：
	等概率随机返回结构中的任何一个key。
	【要求】 Insert、delete和getRandom方法的时间复杂度都是
	O(1)
 * @author Peter
 *
 */
public class RandomPool {

	Map<Object, Integer> map = new HashMap<Object,Integer>();
	Map<Integer, Object> map2 = new HashMap<Integer,Object>();
	int size = 0;
	
	// 删除
	public void delete(Object o) {
		if(map.containsKey(o)) {
			int deleteIndex = map.get(o);
			int lastIndex = --size;
			Object lastObject = map2.get(lastIndex);
			map.put(lastObject, deleteIndex);
			map2.put(deleteIndex, lastObject);
			map2.remove(lastIndex);
			map.remove(o);
		}
	}
	
	public void insert(Object o) {
		if(!map.containsKey(o)) {
			map.put(o, size);
			map2.put(size++, o);
		}
	}
	
	public Object getRandom() {
		if(size == 0) {
			return null;
		}
		int random = (int) (Math.random()*size);
		return map2.get(random);
	}
	
	
	public static void main(String[] args) {
		RandomPool pool = new RandomPool();
		pool.insert("123");
		pool.insert("321");
		pool.insert("1234567");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		pool.delete("123");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		pool.delete("1234567");
		System.out.println(pool.getRandom());

	}

}
