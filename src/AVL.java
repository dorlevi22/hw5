public class AVL<T> {

    private AVLNode<T> root;

    AVL() {
        this.root = null;
    }

    public void insert(int key, T data) {
        AVLNode<T> node_to_insert = new AVLNode<>(key, data);
        if (this.root == null) {
            this.root = node_to_insert;
            this.root.setHeight(0);
            this.root.setFather(null);
        } else {
            AVLNode<T> checker = this.root;
            while (true) {
                if (checker.getKey() > key) {
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
    	if (node == null){ // if reached to the father of the root
    		return;
		}
    	if (node.getRightChild() != null && node.getLeftChild() != null){
			node.setHeight(1 + Math.max(node.getRightChild().getHeight(), node.getLeftChild().getHeight()));
		}
    	else if (node.getRightChild() == null){
			node.setHeight(1 + node.getLeftChild().getHeight());
		}
    	else if (node.getLeftChild() == null){
			node.setHeight(1 + node.getRightChild().getHeight());
		}
    	int balance = node.getLeftChild().getHeight()-node.getRightChild().getHeight();
    	// case 1
    	if( balance > 1 && key < node.getLeftChild().getKey()){
    		right_rotate(node);
		} // case 2
    	if (balance < -1 && key > node.getRightChild().getKey()){
			left_rotate(node);
    	} // case 3
    	if (balance > 1 && key > node.getLeftChild().getKey()){
    		left_rotate(node.getLeftChild());
    		right_rotate(node);
		} // case 4
    	if (balance < -1 && key < node.getRightChild().getKey()){
    		right_rotate(node.getRightChild());
    		left_rotate(node);
		}
		update_height_and_fix(node.getFather(),key);
	}

	private void update_height(AVLNode<T> node){
		/* this function update the height of a given node */
		if (node.getRightChild() != null && node.getLeftChild() != null){
			node.setHeight(1 + Math.max(node.getRightChild().getHeight(), node.getLeftChild().getHeight()));
		}
		else if (node.getRightChild() == null && node.getLeftChild() != null){
			node.setHeight(1 + node.getLeftChild().getHeight());
		}
		else if (node.getLeftChild() == null){
			node.setHeight(1 + node.getRightChild().getHeight());
		}
		else{
			node.setHeight(0); // node is leaf
		}
	}

	private void left_rotate(AVLNode<T> k2){
		AVLNode<T> k1 = k2.getLeftChild();
		AVLNode<T> temp = k1.getRightChild();

		// rotate
		k1.setRightChild(k2);
		k2.setLeftChild(temp);

		// update height
		update_height(k2);
		update_height(k1);

	}

	private void right_rotate(AVLNode<T> k2){
		AVLNode<T> k1 = k2.getRightChild();
		AVLNode<T> temp = k1.getLeftChild();

		// rotate
		k1.setLeftChild(k2);
		k2.setRightChild(temp);

		// update height
		update_height(k2);
		update_height(k1);
	}

	public T search(int key) {
        //TODO
        return null;
    }

    public AVLNode<T> getRoot() {
        return this.root;
    }
}
