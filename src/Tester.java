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
        System.out.println("The tree: " + tree.getRoot());

        Object[] TreeRange = tree.range(0, 30);
        System.out.println("The range between a and b");
        for (Object o : TreeRange) {
            System.out.print(o + ", ");
        }

        HashTable t1 = new HashTable(2);
        Point p1 = new Point("Q 1,1", 1, 1);
        Point p2 = new Point("Q 2,2", 2, 2);
        Point p3 = new Point("Q 3,3", 3, 3);
        Point p4 = new Point("Q 4,4", 4, 4);
        Point p5 = new Point("Q 5,5", 5, 5);
        Point p6 = new Point("Q 6,6", 6, 6);
        t1.insert(p1);
        t1.insert(p2);
        t1.insert(p3);
        t1.insert(p4);
        t1.insert(p5);
        t1.insert(p6);

        System.out.println("hash" +t1.search(1, 1));
        System.out.println("hash" +t1.search(2, 2));
        System.out.println("hash" +t1.search(3, 3));
        System.out.println("hash" +t1.search(4, 4));
        System.out.println("hash" +t1.search(5, 5));
        System.out.println("hash" +t1.search(6, 6));

        AVL<Point> treeP = new AVL<>();
        treeP.insert(p1.getY(), p1);
        treeP.insert(p2.getY(), p2);
        treeP.insert(p3.getY(), p3);
        treeP.insert(p4.getY(), p4);

        System.out.println("hash" + t1.search(1, 1).getData());
        System.out.println("hash" + t1.search(6, 6).getData());

//        Object[] TreeRange2 = treeP.range(0, 5);
//        StudentSolution st = new StudentSolution();
//      //   need to change to public if want to check it
//        System.out.println("exist?: " + st.binarySearch(TreeRange2, 0, TreeRange2.length - 1, p3));
    }
}
