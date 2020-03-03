package com.interview.�㷨.��.Q2_RandomPool;

import java.util.HashMap;
import java.util.Map;

/**
 * ���RandomPool�ṹ
 * ����Ŀ�� ���һ�ֽṹ���ڸýṹ���������������ܣ� 
	insert(key)����ĳ��key���뵽�ýṹ���������ظ����롣 
	delete(key)����ԭ���ڽṹ�е�ĳ��key�Ƴ��� getRandom()��
	�ȸ���������ؽṹ�е��κ�һ��key��
	��Ҫ�� Insert��delete��getRandom������ʱ�临�Ӷȶ���
	O(1)
 * @author Peter
 *
 */
public class RandomPool {

	Map<Object, Integer> map = new HashMap<Object,Integer>();
	Map<Integer, Object> map2 = new HashMap<Integer,Object>();
	int size = 0;
	
	// ɾ��
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
