package Tables;

public class Table {
    private int ID;
    private boolean isOccupied;

    public Table(int ID, boolean isOccupied) {
        this.ID = ID;
        this.isOccupied = isOccupied;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return ID + " , " + isOccupied;
    }
} 