package com.basic.����װ��;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
        List<String> list = new ArrayList<String>(10);
        // ��䡰��������
        Collections.fill(list,"\\.");
        // ����queues
        list.set(0,"Q");
        System.out.println(list);
	}

}
