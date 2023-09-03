package com.demos.cas_demo.lock_free_accumulator;

import java.util.concurrent.atomic.AtomicStampedReference;

public class LockFreeAccumulator {
    private AtomicStampedReference<Integer> value = new AtomicStampedReference<>(0, 0); //创建一个初始值为0，版本号为0的原子引用

    public void add(int delta) { //累加方法
        int[] stampHolder = new int[1]; //创建一个数组来存储版本号，get方法只会修改数组第0个位置
        while (true) { //自旋循环
            int currentValue = value.get(stampHolder); //获取当前值和版本号
            int nextValue = currentValue + delta; //计算下一个值
            int currentStamp = stampHolder[0]; //获取当前版本号
            int nextStamp = currentStamp + 1; //计算下一个版本号
            if (value.compareAndSet(currentValue, nextValue, currentStamp, nextStamp)) { //尝试用CAS更新值和版本号
                return; //如果成功，退出循环
            }
        }
    }

    public int get() { //获取值方法
        return value.getReference(); //返回当前值
    }
}
