package com.cocoa.collection;

import java.util.LinkedList;

public class TestLinkedList {

    public static void main(String[] args) {
        System.out.println("--------basic------");

        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.addFirst("0");
        linkedList.add("2")
        linkedList.addLast("3");
        for (String s : linkedList) {
            System.out.println(s);
        }
        LinkedList<String> ll = new LinkedList();
        ll.addFirst("1");
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());

//      1. LinkedList 实现了 List, Deque 两个接口，数据结构是双向队列，关于Queue 的分析，可以查看本目录的 Queue
//      2. LinkedList 内部的存储是由双向指针的Node 实现, 看下面的代码

//        private static class Node<E> {
//            E item;
//            LinkedList.Node<E> next;  // 指向前一个节点
//            LinkedList.Node<E> prev;  // 指向后一个节点
//
//            Node(LinkedList.Node<E> prev, E element, LinkedList.Node<E> next) {
//                this.item = element;
//                this.next = next;
//                this.prev = prev;
//            }
//        }
//        3.接着来看源码
    }
}
