
/**
 * Sawyer Rogers
 * Purpose: create Cell class
 * to run code type: java Cell
 */
import java.util.ArrayList;

public class Cell {

    /**
     * The status of the Cell.
     */
    private boolean alive;

    /**
     * Constructs a dead cell.
     */
    public Cell() {
        this.alive = false;
    }

    /**
     * Constructs a cell with the specified status.
     * 
     * @param status a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean status) {
        this.alive = status;
    }

    /**
     * Returns whether the cell is currently alive.
     * 
     * @return whether the cell is currently alive
     */
    public boolean getAlive() {
        return this.alive;
    }

    /**
     * Sets the current status of the cell to the specified status.
     * 
     * @param status a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean status) {
        this.alive = status;
    }

    /**
     * Updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     */
    public void updateState(ArrayList<Cell> neighbors) {
        int aliveCount = 0;
        for (Cell neighbor : neighbors) {
            if (neighbor.getAlive()) {
                aliveCount++;
            }
        }
        
        if (this.alive) {
            this.alive = (aliveCount == 2 || aliveCount == 3);
        } else {
            this.alive = (aliveCount == 3);
        }
    }

    /**
     * Returns a String representation of this Cell.
     * 
     * @return 1 if this Cell is alive, otherwise 0.
     */

    public String toString() {
        if (getAlive()){
            return "1";
        }
        else{
            return "0";
        }
    }

    /**
     * main method
     * testing methods above
     * @param args
     */
    public static void main(String[] args) {
        // Create cells
        Cell cell1 = new Cell();
        Cell cell2 = new Cell(true);
        
        // Test initial state
        System.out.println("Cell1 (dead): " + cell1);
        System.out.println("Cell2 (alive): " + cell2);
        
        // change state
        cell1.setAlive(true);
        System.out.println("Cell1 after setAlive(true): " + cell1);
        
        // Testing updateState method
        ArrayList<Cell> neighbors = new ArrayList<>();
        neighbors.add(new Cell(true));
        neighbors.add(new Cell(true));
        neighbors.add(new Cell(false));
        
        cell1.updateState(neighbors);
        System.out.println("Cell1 after updateState: " + cell1);
    }
}
