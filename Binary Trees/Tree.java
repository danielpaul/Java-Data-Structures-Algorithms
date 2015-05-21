class Tree {
  
  public Node root; // First node of the tree.

  public Tree() {
    root = null; // Set the root to null when initially there are no values.
  }

  /* Create a Tree with root. */
  public Tree(Node root) {
    this.root = root;
  }

  /* Create a Tree with value and add that as root. */
  public Tree(int value) {
    Node newNode = new Node(value);
    this.root = newNode;
  }



  /* ---------- Insert ---------- */

  /* Insert a new value to the Tree. */
  public void insert(int value) {

    Node newNode = new Node();
    newNode.data = value;

    if(this.root == null) {
      this.root = newNode; // If no root in this tree, set this as root.
    } else {

      // Find where to insert new value/node.

      Node current = this.root; // Start at root.
      Node parent; // To keep track of who the parent Node is.

      while(true) { // Will be exited internally.

        parent = current;

        if(value < current.data) { // Go left?

          current = current.leftChild;

          if(current == null) { // If there is no left child.
            parent.leftChild = newNode;
            return;
          }

        } else { // Go right.

          current = current.rightChild;

          if(current == null) {
            parent.rightChild = newNode;
            return;
          }

        } // END if less than value.

      } // END while(true)

    } // END else not root.

  } // END insert()


  /* ---------- Find ---------- */

  /* Find a value in the Tree. */
  public Node find(int key) {

    Node current = root; // Start at the root.

    while(current.data != key) { // While there is no match found yet.

      if(key < current.data) { // Go left?
        current = current.leftChild;
      } else { // Go right.
        current = current.rightChild;
      }

      // If there are no child, value is not in tree.
      if(current == null) {
        return null;
      }

    }

    return current; // Return the found Node.
  }



  /* ---------- Tree Traversals ---------- */


  /* InOrder Traversal */
  /*
   * 1. Call itself to traverse the node's left subtree.
   * 2. Visit the node.
   * 3. Call itself to traverse the node's right subtree.
   *
   */
  public void inOrder(Node localRoot) {
    if(localRoot != null) {
      inOrder(localRoot.leftChild);
      System.out.print(localRoot.data + " ");
      inOrder(localRoot.rightChild);
    }
  }

  /* PreOrder Traversal. */
  /*
   * 1. Print Node first.
   * 2. Left Subtree.
   * 3. Right Subtree.
   *
   * Printing out in this order will allow to recreate the exact same tree at a later date.
   */
  public void preOrder(Node localRoot) {
    if(localRoot != null) {
      System.out.print(localRoot.data + " ");
      preOrder(localRoot.leftChild);
      preOrder(localRoot.rightChild);
    }
  }

  /* PostOrder Traversal. */
  /*
   * 1. Left Subtree.
   * 2. Right Subtree.
   * 3. Print Node.
   */
  public void postOrder(Node localRoot) {
    if(localRoot != null) {
      postOrder(localRoot.leftChild);
      postOrder(localRoot.rightChild);
      System.out.print(localRoot.data + " ");
    }
  }



  /* ---------- Min & Max ---------- */
  // Left most child is always the smallest value & right most the largest value.

  public Node minimum() {
    Node current = this.root;
    while(current.leftChild != null) {
      current = current.leftChild;
    }
    return current;
  }

  public Node maximum() {
    Node current = this.root;
    while(current.rightChild != null) current = current.rightChild;
    return current;
  }


  /* ---------- Delete ---------- */

  public boolean delete(int value) {

    // Find the Node.

    Node current = this.root;
    Node parent = this.root;

    boolean isLeftChild = true;

    while(current.data != value) { // loop till we find the Node with value.

      parent = current;

      if(value < current.data) { // Go left?

        isLeftChild = true;
        current = current.leftChild;

      } else { // Go right.

        isLeftChild = false;
        current = current.rightChild;

      }

      // If current does not exist, the value cannot be found.
      if(current == null) {
        return false;
      }

    } // END while loop. We have found the Node to delete.


    // ----- Case 1: Delete a Node without any child Nodes.
    // Make the parent point to 'null' as it's left/right child.
    // Current Node is no longer part of the tree and will be removed by Java's garbage collection.
    if(current.leftChild == null & current.rightChild == null) {
      if(current == root) {
        root = null; // if is root.
      } else if(isLeftChild) {
        parent.leftChild = null;
      } else {
        parent.rightChild = null;
      }

      return true; // Deleted.
    }


    // ----- Case 2: Has one Child.
    // Only has one child Node. Either left OR right.
    // Connect the child Node to the current Node's parent Node on the same side as the current Node.
    
    if(current.leftChild == null) { // If has Right child.

      if(current == root) {
        root = current.rightChild; // If is toot.
      } else if(isLeftChild) {
        parent.leftChild = current.rightChild;
      } else {
        parent.rightChild = current.rightChild;
      }

      return true; // Deleted.

    } else if(current.rightChild == null) { // If has Left Child.

      if(root == current) {
        root = current.leftChild;
      } else if(isLeftChild) {
        parent.leftChild = current.leftChild;
      } else {
        parent.rightChild = current.rightChild;
      }

      return true; // Deleted.

    }


    // ----- Case 3: Has Two Children.
    // Need to find successor. Start with the delted node's right child.
    // Then go to this node's left child and then to it's left child and so on, following down the path of left children.
    // The last left child in this path is the successor of the original node.

    Node successor = getSuccessor(current); // Get successor of the current Node.

    // Swapping Successor. 3 possibilities.

    // --- Successor is rightChild of the Node to be deleted.
    // Swap and successor takes delted Node's left child and keeps its right child.


    // --- Successor is not rightChild of Node to be deleted.
    // It takes the left and right children of delNode.


    // --- If successor wasn't a left - one more step.
    // Successor's parent takes it's right child and it's left child.

    if(current == root) {
      root = successor;
    } else if(isLeftChild) {
      parent.leftChild = successor;
    } else {
      parent.rightChild = successor;
    }

    // ??? 

    return true;

  }

  private Node getSuccessor(Node delNode) {

    Node successorParent = delNode;
    Node successor = delNode;
    Node current = delNode.rightChild;

    while(current != null) {

      successorParent = successor;
      successor = current;
      current = current.leftChild;

    }

    if(successor != delNode.rightChild) {
      successorParent.leftChild = successor.rightChild;
      successor.rightChild = delNode.rightChild;
    }

    return successor;

  }



}