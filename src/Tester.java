public class Tester {

    public static void main(String[] args) {

        AVL<String> tree = new AVL<>();
        tree.insert(10, "10");
        tree.insert(20, "20");
        tree.insert(5, "5");
        tree.insert(26, "26");
        tree.insert(30, "30");
        tree.insert(15, "15");
        tree.insert(23, "23");
        tree.insert(1, "1");
        tree.insert(0, "0");
        tree.insert(6, "6");
//        System.out.println(tree.getRoot().getLeftChild().getFather());
        System.out.println(tree.getRoot());

        Object[] A = tree.range(10, 26);

        for (Object o : A) {
            System.out.print(o + ", ");
        }

    }

}
