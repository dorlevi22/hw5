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

        System.out.println(tree.getRoot());

        Object[] A = tree.range(31, 36);

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ", ");
        }

//        HashTable t1 = new HashTable();
//        Point p1 = new Point("Q 1,1", 1,1);
//        Point p2 = new Point("Q 2,2", 2,2);
//        Point p3 = new Point("Q 3,3", 3,3);
//        Point p4 = new Point("Q 4,4", 4,4);
//        Point p5 = new Point("Q 5,5", 5,5);
//        Point p6 = new Point("Q 6,6", 6,6);
//        t1.insert(p1);
//        t1.insert(p2);
//        t1.insert(p3);
//        t1.insert(p4);
//        t1.insert(p5);
//        t1.insert(p6);
//        System.out.println( t1.search(1,1).getData());
//        System.out.println( t1.search(6,6).getData());
    }

}
