class LinkedSet<T> {
    
  private static class Node<T> {            
    private T item;         // data       
    private Node<T> next;     // successor node 
                                                            
    Node(T item0, Node<T> next0) { 
      item = item0; next = next0;
    }
  }         
    
  private Node<T> head = null;   

  public int size() {
    Node<T> p = head; int numItems = 0;
    while (p!=null) {
      numItems++; p = p.next;
    }
    return(numItems);
  }
  
  public boolean add(T t) { 
    if (contains(t)) return false;
    head = new Node<T>(t,head); // place t at front (easiest)
    return true;
  }

  public boolean contains(T t) { 
    Node<T> p = head; // remains to search from p on
    while (p!=null && !equals(p.item,t)) p = p.next;
    return p!=null;
  }

  public boolean remove(T t) { 
    Node<T> p = head; // t if present occurs from node p on
    Node<T> pPred = null; // predecessor of p (if any)
    while (p!=null && !equals(t,p.item)) {
      pPred = p; p = p.next;
    }
    // t is present iff node p!=null & p!=null => t in node p
    if (p==null) return false; // t not found
    if (p==head) head = head.next; // t in node p at front  
    else pPred.next = p.next; // t in node p, not at front  
    return true;
  }  

  public void clear() {
    head = null;
  }

  private boolean equals(T t1, T t2) { // allows t1, t2 be null
    if (t1!=null) return t1.equals(t2);
    else return t2==null; 
  }

}
