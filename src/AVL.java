import java.util.LinkedList;

public class AVL<T> {

    private AVLNode<T> root;

    AVL() {
        this.root = null;
    }

    public void insert(int key, T data) {
        // key - the new key we will insert
        AVLNode<T> node_to_insert = new AVLNode<>(key, data);
        if (this.root == null) {
            this.root = node_to_insert;
            this.root.setHeight(0);
            this.root.setFather(null);
        } else {
            AVLNode<T> checker = this.root;
            while (true) {
                if (checker.getKey() < key) {
                    if (checker.getRightChild() != null) { // go right
                        checker = checker.getRightChild();
                    } else { // if node holds null to the right, insert there
                        node_to_insert.setFather(checker);
                        checker.setRightChild(node_to_insert);
                        checker.setHeight(0); // inserted as leaf
                        break; // break while loop
                    }
                } else {
                    if (checker.getLeftChild() != null) { // go left
                        checker = checker.getLeftChild();
                    } else { // if node holds null to the left, insert there
                        node_to_insert.setFather(checker);
                        checker.setLeftChild(node_to_insert);
                        checker.setHeight(0); // inserted as leaf
                        break; // break while loop
                    }
                }
            }
            update_height_and_fix(checker, key); // update height in the path from inserted node to root and fix inplace
        }
    }

    private void update_height_and_fix(AVLNode<T> node, int key) {
        /* This function go trough path from specific node to the root (by recursion), update the heights of the nodes and balances the tree if need to by rotations */
        if (node == null) { // if reached to the father of the root
            return;
        }

        update_height(node);
//        if (node.getRightChild() != null && node.getLeftChild() != null) {
//            int rightChildHeight = node.getRightChild().getHeight(); // the height of the right child
//            int leftChildHeight = node.getLeftChild().getHeight();  //  the height of the left  child
//            node.setHeight(1 + Math.max(rightChildHeight, leftChildHeight));
//        } else if (node.getRightChild() == null) {
//            node.setHeight(1 + node.getLeftChild().getHeight());
//        } else if (node.getLeftChild() == null) {
//            node.setHeight(1 + node.getRightChild().getHeight());
//        }
        int balance;
        if (node.getRightChild() == null && node.getLeftChild() == null)
            balance = 0;
        else if (node.getRightChild() == null && node.getLeftChild() != null)
            balance = node.getLeftChild().getHeight() - (-1);
        else if (node.getRightChild() != null && node.getLeftChild() == null)
            balance = (-1) - node.getRightChild().getHeight();
        else // have 2 children
            balance = node.getLeftChild().getHeight() - node.getRightChild().getHeight();

        // case 1
        if (balance > 1 && key < node.getLeftChild().getKey()) {
            right_rotate(node);
        }
        // case 2
        else if (balance < -1 && key > node.getRightChild().getKey()) {
            left_rotate(node);
        }
        // case 3
        else if (balance > 1 && key > node.getLeftChild().getKey()) {
            left_rotate(node.getLeftChild());
            right_rotate(node);
        }
        // case 4
        else if (balance < -1 && key < node.getRightChild().getKey()) {
            right_rotate(node.getRightChild());
            left_rotate(node);
        }

        update_height_and_fix(node.getFather(), key);
    }

    private void update_height(AVLNode<T> node) {
        /* this function update the height of a given node */
        if (node.getRightChild() != null && node.getLeftChild() != null) {
            node.setHeight(1 + Math.max(node.getRightChild().getHeight(), node.getLeftChild().getHeight()));
        } else if (node.getRightChild() == null && node.getLeftChild() != null) {
            node.setHeight(1 + node.getLeftChild().getHeight());
        } else if (node.getLeftChild() == null && node.getRightChild() != null) {
            node.setHeight(1 + node.getRightChild().getHeight());
        } else {
            node.setHeight(0); // node is leaf
        }
    }

    private void right_rotate(AVLNode<T> k2) {
        AVLNode<T> k1 = k2.getLeftChild();
        AVLNode<T> temp = k1.getRightChild();

        // rotate
        k1.setRightChild(k2);
        k1.setFather(k2.getFather());
        if (k2 != this.root) {
            if (k1.getFather().getKey() > k1.getKey())
                k1.getFather().setLeftChild(k1);
            else
                k1.getFather().setRightChild(k1);
        }
        k2.setFather(k1);
        k2.setLeftChild(temp);
        if (temp != null)
            temp.setFather(k2);

        if (this.root == k2) {
            this.root = k1;
        }
        // update height
        update_height(k2);
        update_height(k1);

    }

    private void left_rotate(AVLNode<T> k2) {
        AVLNode<T> k1 = k2.getRightChild();
        AVLNode<T> temp = k1.getLeftChild();

        // rotate
        k1.setLeftChild(k2);
        k1.setFather(k2.getFather());
        if (k2 != this.root) {
            if (k1.getFather().getKey() > k1.getKey())
                k1.getFather().setLeftChild(k1);
            else
                k1.getFather().setRightChild(k1);
        }
        k2.setFather(k1);
        k2.setRightChild(temp);
        if (temp != null)
            temp.setFather(k2);

        if (this.root == k2) {
            this.root = k1;
        }

        // update height
        update_height(k2);
        update_height(k1);
    }

    public T search(int key) {
        AVLNode<T> node = this.getRoot();
        while (node != null) {
            if (key > node.getKey())
                node = node.getRightChild();
            else if (key < node.getKey())
                node = node.getLeftChild();
            else {
                return node.getData();
            }
        }
        return null;
    }

    public AVLNode<T> getRoot() {
        return this.root;
    }

    /*
    private func that create path from the root to the key
     */
    private void pathTo(int key, LinkedList<AVLNode<T>> list) {
        AVLNode<T> node = this.getRoot();
        while (node != null) {
            if (key > node.getKey()) {
                list.add(node);
                node = node.getRightChild();
            } else if (key < node.getKey()) {
                list.add(node);
                node = node.getLeftChild();
            } else {
                list.add(node);
                return;
            }
        }
    }

    private void addInorder(LinkedList<T> list, AVLNode<T> node) {
        if (node == null)
            return;
        addInorder(list, node.getLeftChild());
        list.add(node.getData());
        addInorder(list, node.getRightChild());
    }


    public Object[] range(int a, int b) {
        LinkedList<AVLNode<T>> pathA = new LinkedList<>();
        LinkedList<AVLNode<T>> pathB = new LinkedList<>();
        LinkedList<T> allRange = new LinkedList<>();
        pathTo(a, pathA);
        pathTo(b, pathB);

        // find the common father
        while (pathA.get(1).equals(pathB.get(1))) {
            pathA.remove();
            pathB.remove();
        }

        AVLNode<T> tmp = pathA.getLast(); // hold the a node or his previous
        int common_ancestor = pathA.peekFirst().getKey();
        while (tmp.getKey() != common_ancestor) {
            allRange.add(tmp.getData());
            addInorder(allRange, tmp.getRightChild());
            tmp = tmp.getFather();
        }

        AVLNode<T> last = pathB.getLast();
        while (tmp.getKey() != last.getKey()) {
            addInorder(allRange, tmp.getLeftChild());
            allRange.add(tmp.getData());
            tmp = tmp.getRightChild();
        }

        Object[] finale = allRange.toArray(); //cast the linked list to array
        return finale;
    }
}