package com.cocoa.collection;

import java.util.LinkedList;

public class TestLinkedList {

    public static void main(String[] args) {
        System.out.println("--------basic------");

        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.addFirst("0");
        linkedList.add("2");
        linkedList.addLast("3");
        for (String s : linkedList) {
            System.out.println(s);
        }
        LinkedList<String> ll = new LinkedList();
        ll.addFirst("1");
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());

    }
}
