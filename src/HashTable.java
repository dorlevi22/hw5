import java.util.LinkedList;

public class HashTable {

    // fields
    private int size; // represent the size of the table
    private LinkedList<ObjectWithCoordinates>[] table;

    // constructor
    public HashTable(int size) {
        this.size = size;
        this.table = new LinkedList[size];
    }

    private int hashFunc(int x, int y) {
        return (x + y) % this.size;
    }

    public void insert(ObjectWithCoordinates object) {
        // insert a new object to the hash table
        int i = hashFunc(object.getX(), object.getY());
        if (this.table[i] == null) { // if this cell is empty
            this.table[i] = new LinkedList<>();
        }
        this.table[i].add(object); // add the new point to the right cell
    }

    public ObjectWithCoordinates search(int x, int y) {
        // search the
        int index = hashFunc(x, y);
        ObjectWithCoordinates tmp;
        if (this.table[index] != null) {
            for (int i = 0; i < this.table[index].size(); i++) {
                tmp = this.table[index].get(i);
                if (tmp.getX() == x && tmp.getY() == y) {
                    return tmp;
                }
            }
        }
        return null;
    }
}
