
package com.mycompany.singlelinkedlist;

class Node {
   public int data;
   public Node next;

   public Node(int data) {
      this.data = data;
      this.next = null;
   }
}

class LinkedList {
   private Node head;
   private Node tail;
    
   public LinkedList() {
      head = null;
      tail = null;
   }
    
   public void append(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         tail.next = newNode;
         tail = newNode;
      }
   }
   
   public void prepend(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         newNode.next = head;
         head = newNode;
      }
   }
   

   
   public void insertAfter(Node currentNode, Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else if (currentNode == tail) {
         tail.next = newNode;
         tail = newNode;
      }
      else {
         newNode.next = currentNode.next;
         currentNode.next = newNode;
      }
   }
   

   public void removeAfter(Node currentNode) {
      if (currentNode == null && head != null) {
         // Special case: remove head
         Node succeedingNode = head.next;
         head = succeedingNode;
         if (succeedingNode == null) {
             // Last item was removed
             tail = null;
         }
      }
      else if (currentNode.next != null) {
         Node succeedingNode = currentNode.next.next;
         currentNode.next = succeedingNode;
         if (succeedingNode == null) {
            // Remove tail
            tail = currentNode;
         }
      }
   }
   public void printList() {
      Node node = head;
      while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
      }
      System.out.println();
   }
    
   public int size() {
       int count = 0;
       Node temp = head;
       while(temp != null){
           count++;
           temp = temp.next;
       }
       return count;
   }
//After that find the sum of numbers in the second list.  (n should be less than 1,000,000).
   public int sum() {
       Node temp = head;
       int sum=0;
       while(temp != null){
           sum += temp.data;
           temp = temp.next;
       }
       return sum;
   }     
}
