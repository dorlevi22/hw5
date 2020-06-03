public class AVLNode<T> {

    // fields
    private int key;
    private int height;
    private AVLNode<T> right;
    private AVLNode<T> left;
    private AVLNode<T> father;
    private T data;

    //constructor
    AVLNode(int key, T data) {
        this.key = key;
        this.data = data;
        this.height = 0;
        this.right = null;
        this.left = null;
        this.father = null;
    }

    public AVLNode<T> getLeftChild() {
        return this.left;
    }

    public void setLeftChild(AVLNode<T> x) {
        this.left = x;
    }

    public AVLNode<T> getRightChild() {
        return this.right;
    }

    public void setRightChild(AVLNode<T> x) {
        this.right = x;
    }

    public AVLNode<T> getFather() {
        return this.father;
    }

    public void setFather(AVLNode<T> x) {
        this.father = x;
    }

    public int getKey() {
        return this.key;
    }

    public T getData() {
        return this.data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {

        String s = "";

        if (getLeftChild() != null) {
            s += "(";
            s += getLeftChild().toString();
            s += ")";
        }
        s += getKey();

        if (getRightChild() != null) {
            s += "(";
            s += getRightChild().toString();
            s += ")";
        }

        return s;
    }
}