package com.interview.算法.三.Q4_DogCatQueue;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.RuntimeErrorException;

import com.interview.算法.三.Q4_DogCatQueue.DogCatQueue.PetEnterQueue;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 猫狗队列
 * 要求如下： 用户可以调用add方法将cat类或dog类的实例放入队列中； 
 * 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出； 
 * 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出； 
 * 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出； 
 * 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例； 
 * 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例； 
 * 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 * @author Peter
 *
 */
public class DogCatQueue {
	public static class Pet {
		private String type;

		public Pet(String type) {
			this.type = type;
		}

		public String getPetType() {
			return this.type;
		}
	}

	public static class Dog extends Pet {
		public Dog() {
			super("Dog");
		}
	}

	public static class Cat extends Pet {
		public Cat() {
			super("Cat");
		}
	}
	
	// 实际的入队类型
	@Data
	@AllArgsConstructor
	public static class PetEnterQueue{
		private Pet pet;
		private int count;
	}
	
	public static class DCQueue{
		private Queue<PetEnterQueue> DQ;
		private Queue<PetEnterQueue> CQ;
		private int count;
		public DCQueue() {
			this.DQ = new LinkedList<PetEnterQueue>();
			this.CQ = new LinkedList<PetEnterQueue>();
			this.count = 0;
		}
		
		public void add(Pet pet) {
			if(pet.getPetType().equals("Dog")) {
				// Dog Queue
				DQ.add(new PetEnterQueue(pet, count++));
			}else if(pet.getPetType().equals("Cat")) {
				CQ.add(new PetEnterQueue(pet, count++));
			}else {
				throw new IllegalArgumentException("Unsupported Animal Type");
			}
		}
		
		// 按照入队顺序出队元素
		public Pet pollAll() {
			if(!DQ.isEmpty() && !CQ.isEmpty()) {
				return DQ.peek().getCount() < CQ.peek().getCount() ? DQ.poll().getPet() : CQ.poll().getPet();
			}else if(!DQ.isEmpty()) {
				return DQ.poll().getPet(); 
			}else if(!CQ.isEmpty()) {
				return CQ.poll().getPet();
			}else {
				throw new RuntimeException("The Queue is Empty");
			}
		}
		
		public Dog pollDog() {
			if(!DQ.isEmpty()) {
				return (Dog) DQ.poll().getPet();
			}
			throw new RuntimeException("Dog Queue is Empty");
		}
		public Cat pollCat() {
			if(!CQ.isEmpty()) {
				return (Cat) CQ.poll().getPet();
			}
			throw new RuntimeException("Cat Queue is Empty");
		}
		public boolean isEmpty() {
			return CQ.isEmpty() && DQ.isEmpty();
		}
		public boolean isDogQueueEmpty() {
			return DQ.isEmpty();
		}
		public boolean isCatQueueEmpty() {
			return CQ.isEmpty();
		}
	}
	
	public static void main(String[] args) {
		DCQueue test = new DCQueue();

		Pet dog1 = new Dog();
		Pet cat1 = new Cat();
		Pet dog2 = new Dog();
		Pet cat2 = new Cat();
		Pet dog3 = new Dog();
		Pet cat3 = new Cat();

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);
		while (!test.isDogQueueEmpty()) {
			System.out.println(test.pollDog().getPetType());
		}
		while (!test.isEmpty()) {
			System.out.println(test.pollAll().getPetType());
		}
	}
}
