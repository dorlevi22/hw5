import java.util.LinkedList;

public class StudentSolution implements MyInterface {

    private AVL<Point> AVL_X = new AVL<>();
    private AVL<Point> AVL_Y = new AVL<>();
    private HashTable map = new HashTable();

    public void insertDataFromDBFile(String objectName, int objectX, int objectY) {
        Point p1 = new Point(objectName, objectX, objectY);
        AVL_X.insert(objectX, p1);
        AVL_Y.insert(objectY, p1);
        map.insert(p1);
    }

    public String[] firstSolution(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY) {
        Object[] X_range = AVL_X.range(Math.min(rightBottomX,leftTopX), Math.max(rightBottomX,leftTopX));
        Object[] Y_range = AVL_Y.range(Math.min(rightBottomY,leftTopY), Math.max(rightBottomY,leftTopY));
        LinkedList<Object> data = new LinkedList<>();

        for (int i = 0; i < X_range.length; i++) {
            for (int j = 0; j < Y_range.length; j++) {
                if (X_range[i].equals(Y_range[j]))
                    data.add(X_range[i]);
            }
        }
        //convert the linked list to string array
        String[] To_return = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            To_return[i] = (String) ((Point) data.get(i)).getData();
        }

        return To_return;
    }

    @Override
    public String[] secondSolution(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY) {
        // TODO Auto-generated method stub
        return null;
    }
}