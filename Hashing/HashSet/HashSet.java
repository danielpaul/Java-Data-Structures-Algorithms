class HashSet<T> { 

  private LinkedSet<T>[] hashTable; // hash table
  private int numItems = 0;

  HashSet() { // create the empty set
    hashTable = (LinkedSet<T>[])(new LinkedSet[1000]); 
    for (int i=0; i<hashTable.length; i++)
      hashTable[i] = new LinkedSet<T>();    
  }

  private int hash(T t) { // hash t into hashTable index
    return Math.abs(t.hashCode()%hashTable.length);
  }

  int size() {  
    return numItems;
  }

  boolean contains(T t) { 
    return hashTable[hash(t)].contains(t);
  }

  boolean add(T t) { 
    numItems++;
    return hashTable[hash(t)].add(t);
  } 
       
  boolean remove(T t) {
    numItems--;
    return hashTable[hash(t)].remove(t);
  }

  void clear() {
    for (int i=0; i<hashTable.length; i++)
      hashTable[i].clear();
  }
}
