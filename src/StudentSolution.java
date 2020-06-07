import java.util.LinkedList;

public class StudentSolution implements MyInterface {

    private AVL<Point> AVL_X = new AVL<>(); // tree that will hold points sorted by X
    private AVL<Point> AVL_Y = new AVL<>(); // tree that will hold points sorted by Y

    public void insertDataFromDBFile(String objectName, int objectX, int objectY) {
        // create point and insert it to our 2 trees.
        Point p1 = new Point(objectName, objectX, objectY);
        AVL_X.insert(objectX, p1);
        AVL_Y.insert(objectY, p1);
    }

    public String[] firstSolution(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY) {
        // get the necessary points in the x,y range
        Object[] X_range = AVL_X.range(Math.min(rightBottomX, leftTopX), Math.max(rightBottomX, leftTopX));
        Object[] Y_range = AVL_Y.range(Math.min(rightBottomY, leftTopY), Math.max(rightBottomY, leftTopY));

        LinkedList<Object> data = new LinkedList<>(); // list that will hold the data that is in both ranges

        // if one of them is empty there is no common data
        if (Y_range.length == 0 || X_range.length == 0)
            return new String[]{};

        // put the Y range in hash-table
        HashTable map = new HashTable(Y_range.length);

        for (int i = 0; i < Y_range.length; i++) {
            map.insert((Point) Y_range[i]);
        }
        // search for the X range points that are in the Y range
        for (int i = 0; i < X_range.length; i++) {
            if (map.search(((Point) X_range[i]).getX(), ((Point) X_range[i]).getY()) != null)
                data.add(X_range[i]);
        }

        //convert the linked list to string array
        String[] To_return = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            To_return[i] = (String) ((Point) data.get(i)).getData();
        }
        return To_return;
    }

    public String[] secondSolution(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY) {
        Object[] X_range = AVL_X.range(Math.min(rightBottomX, leftTopX), Math.max(rightBottomX, leftTopX));
        Object[] Y_range = AVL_Y.range(Math.min(rightBottomY, leftTopY), Math.max(rightBottomY, leftTopY));
        LinkedList<Object> data = new LinkedList<>();
        if (X_range.length >= Y_range.length) {
            for (int i = 0; i < X_range.length; i++) {
                // search every point from range X in range Y, using binary search.
                if (binarySearch(Y_range, 0, Y_range.length - 1, X_range[i], "Y") >= 0) {
                    // if the output is bigger than 0 -> the point exist in both ranges
                    data.add(X_range[i]);
                }
            }
        } else {
            for (int i = 0; i < Y_range.length; i++) {
                // search every point from range Y in range X, using binary search.
                if (binarySearch(X_range, 0, X_range.length - 1, Y_range[i], "X") >= 0) {
                    // if the output is bigger than 0 -> the point exist in both ranges
                    data.add(Y_range[i]);
                }
            }
        }
        //convert the linked list to string array
        String[] To_return = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            To_return[i] = (String) ((Point) data.get(i)).getData();
        }
        return To_return;
    }

    private int binarySearch(Object[] range, int l, int r, Object p, String XY) {
        if (r == l) {
            if (range[r].equals(p))
                return r;
            return -1;
        }
        if (r > l) {
            int mid = (l + r) / 2;
            if (range[mid].equals(p)) //==
                return mid;
            // go right
            if (XY.equals("Y")) {
                if (((Point) range[mid]).getY() > ((Point) p).getY())
                    return binarySearch(range, l, mid - 1, p, XY); // go left
            } else {
                if (((Point) range[mid]).getX() > ((Point) p).getX())
                    return binarySearch(range, l, mid - 1, p,XY ); // go left
            }
            return binarySearch(range, mid + 1, r, p, XY); // go right
        }
        return -1;
    }
}