package com.interview.�㷨.��.Q4_DogCatQueue;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.RuntimeErrorException;

import com.interview.�㷨.��.Q4_DogCatQueue.DogCatQueue.PetEnterQueue;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * è������
 * Ҫ�����£� �û����Ե���add������cat���dog���ʵ����������У� 
 * �û����Ե���pollAll�����������������е�ʵ�����ս����е��Ⱥ�˳�����ε����� 
 * �û����Ե���pollDog��������������dog���ʵ�����ս����е��Ⱥ�˳�����ε����� 
 * �û����Ե���pollCat��������������cat���ʵ�����ս����е��Ⱥ�˳�����ε����� 
 * �û����Ե���isEmpty���������������Ƿ���dog��cat��ʵ���� 
 * �û����Ե���isDogEmpty���������������Ƿ���dog���ʵ���� 
 * �û����Ե���isCatEmpty���������������Ƿ���cat���ʵ����
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
	
	// ʵ�ʵ��������
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
		
		// �������˳�����Ԫ��
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
