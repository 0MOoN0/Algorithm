package com.basic.并发.Atomic类.原子引用;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;


@Data
@AllArgsConstructor
class User{
    private String name;
    private int age;
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User zs = new User("zs", 22);
        User ls = new User("ls", 22);
        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(zs);
        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"\t"+userAtomicReference.get().toString());
        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"\t"+userAtomicReference.get().toString());
    }
}
