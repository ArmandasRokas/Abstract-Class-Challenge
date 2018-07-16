package com.rokas;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	    NodeList myList = new MyLinkedList(null);
        myList.traverse(myList.getRoot());

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String[] data = stringData.split(" ");
        for (String s: data){
            myList.addItem(new Node(s));
        }
        myList.removeItem(new Node("Hej"));
        myList.traverse(myList.getRoot());

    }
}
