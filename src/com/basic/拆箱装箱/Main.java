package com.basic.²ğÏä×°Ïä;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
        List<String> list = new ArrayList<String>(10);
        // Ìî³ä¡°¡£¡±·ûºÅ
        Collections.fill(list,"\\.");
        // ±éÀúqueues
        list.set(0,"Q");
        System.out.println(list);
	}

}
