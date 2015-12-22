import java.util.*;
    
class LinkedList<T> {
    
  private static class Node<T> {            
    private T item;         // data       
    private Node<T> next;     // successor node 
                                                            
    Node(T item0, Node<T> next0) { 
      item = item0; next = next0;
    }
  }
    
  private Node<T> head = null; // first node (null if list empty)
  private Node<T> tail = null; // final node (null if list empty)
  private int numItems = 0;   // number of items

  public int size() {return(numItems);}

  public T get(int i) {
    if (i<0||i>=numItems) throw new IndexOutOfBoundsException();
    Node<T> p = head; int pIndex = 0; // Node p at index pIndex
    while (pIndex!=i) {
      p = p.next; pIndex++;
    }
    return p.item;
  }
  
  public T set(int i, T t) {
    if (i<0||i>=numItems) throw new IndexOutOfBoundsException();
    Node<T> p = head; int pIndex = 0; // Node p at index pIndex
    while (pIndex!=i) {
      p = p.next; pIndex++;
    }
    T temp = p.item; p.item = t;
    return temp;
  }
  
  public boolean add(T t) { 
    Node<T> tNode = new Node<T>(t,null); // new tail node
    if (tail!=null) tail.next = tNode; 
    else head = tNode;
    tail = tNode;
    numItems++;
    return true; // for compatibility reasons only
  }

  public void add(int i, T t) { 
    if (i<0 || i>numItems) throw new IndexOutOfBoundsException();
    if (i==0) { // insert at front
      head = new Node<T>(t,head);
      if (tail==null) tail = head;
    }
    else { // not at front
      Node<T> p = head;
      int index = 1; // p references node at position index-1
      while (index!=i) {
        p = p.next; index++;
      } // node p at position i-1
      p.next = new Node<T>(t,p.next); // insert t following p
      if (tail==p) tail = p.next;
    }
    numItems++;
  } 
     
}
