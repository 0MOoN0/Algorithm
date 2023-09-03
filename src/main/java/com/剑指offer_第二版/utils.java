package com.剑指offer_第二版;

public class utils {

    public static void printLinkedNode(Node node) {
        while (node != null) {
            System.out.print(node.val +"  ->  ");
            node = node.next;
        }
        System.out.println();
    }

}
