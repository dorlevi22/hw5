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

        Object[] TreeRange = tree.range(-10, 66);
        System.out.println("The range between a and b");
        for (int i = 0; i < TreeRange.length; i++) {
            System.out.print(TreeRange[i] + ", ");
        }

        HashTable t1 = new HashTable(2);
        Point p1 = new Point("point 11", 1, 1);
        Point p2 = new Point("point 22", 2, 2);
        Point p3 = new Point("point 33", 3, 3);
        Point p4 = new Point("point 44", 4, 4);
        Point p5 = new Point("point 55", 5, 5);
        Point p6 = new Point("point 66", 6, 6);
        t1.insert(p1);
        System.out.println(p1);
        t1.insert(p2);
        System.out.println(p2);
        t1.insert(p3);
        System.out.println(p3);
        t1.insert(p4);
        System.out.println(p4);
        t1.insert(p5);
        System.out.println(p5);
        t1.insert(p6);
        System.out.println(p6);
    }
}
