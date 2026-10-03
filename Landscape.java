/**
 * Sawyer Rogers
 * purpose: create landscape for Cells, and methods to update cells depending on neighbors
 * to run code: java Landscape
 */

 import java.awt.Color;
 import java.awt.Graphics;
 import java.util.ArrayList;
 
 
 public class Landscape {
 
     /**
      * The underlying grid of Cells for Conway's Game
      */
     private Cell[][] landscape;
 
     /**
      * The original probability each individual Cell is alive
      */
     private double initialChance;
 
     /**
      * Constructs a Landscape of the specified number of rows and columns.
      * All Cells are initially dead.
      * 
      * @param rows    the number of rows in the Landscape
      * @param columns the number of columns in the Landscape
      */
     public Landscape(int rows, int columns) {
         landscape = new Cell[rows][columns];
         for(int r=0; r<rows; r++){
             for(int c=0;c<columns; c++){
                 landscape[r][c]=new Cell();
             }
         }
         reset();
         
     }
 
     /**
      * Constructs a Landscape of the specified number of rows and columns.
      * Each Cell is initially alive with probability specified by chance.
      * 
      * @param rows    the number of rows in the Landscape
      * @param columns the number of columns in the Landscape
      * @param chance  the probability each individual Cell is initially alive
      */
     public Landscape(int rows, int columns, double chance) {
         landscape = new Cell[rows][columns];
         for (int r = 0; r < rows; r++) {
         //for loop to determine whether each cell is alive or dead
             for (int c = 0; c < columns; c++) {
                 if (Math.random() < chance) {
                     landscape[r][c] = new Cell(true);  
                 } else {
                     landscape[r][c] = new Cell(false); 
                 }
             }
         }
         
     }
 
     /**
      * Recreates the Landscape according to the specifications given
      * in its initial construction.
      */
     public void reset() {
         int rows = getRows();
         int cols = getCols();
 
         // Recreate the grid according to the initial construction
         //construction if there is a chance of them being alive
         if (initialChance > 0) { 
             for (int r = 0; r < rows; r++) {
                 for (int c = 0; c < cols; c++) {
                     landscape[r][c] = new Cell(Math.random() < initialChance); // Randomly reset based on initial chance
                 }
             }
         } else { 
             //construction when all the cells are initialized as dead
             for (int r = 0; r < rows; r++) {
                 for (int c = 0; c < cols; c++) {
                     landscape[r][c] = new Cell(false);  
                 }
             }
         }
     }
 
     /**
      * Returns the number of rows in the Landscape.
      * 
      * @return the number of rows in the Landscape
      */
     public int getRows() {
         return landscape.length;
     }
 
     /**
      * Returns the number of columns in the Landscape.
      * 
      * @return the number of columns in the Landscape
      */
     public int getCols() {
         return landscape[0].length;
     }
 
     /**
      * Returns the Cell specified the given row and column.
      * 
      * @param row the row of the desired Cell
      * @param col the column of the desired Cell
      * @return the Cell specified the given row and column
      */
     public Cell getCell(int row, int col) {
         return landscape[row][col];
     }
 
     /**
      * Returns a String representation of the Landscape.
      */
     public String toString() {
         String stringy = "";
         for (int i = 0; i < getRows(); i++) {
             for (int j = 0; j < getCols(); j++) {
                 stringy = stringy + landscape[i][j].toString();
             }
             //showing the different rows by creating a new line
             stringy = stringy + "\n";
         }
         return stringy;
     }
 
     /**
      * Returns an ArrayList of the neighboring Cells to the specified location.
      * 
      * @param row the row of the specified Cell
      * @param col the column of the specified Cell
      * @return an ArrayList of the neighboring Cells to the specified location
      */
     public ArrayList<Cell> getNeighbors(int row, int col) {
         //create list to store neighbors
         ArrayList<Cell> neighbors = new ArrayList<>(); 
         //Finding all the possible neighbors by storing their indeces in lists
         int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1}; 
         int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1}; 
 
         // Loop through each possible neighbor
         for (int i = 0; i < dRow.length; i++) {
             int newRow = row + dRow[i]; 
             int newCol = col + dCol[i]; 
             // Check if the new row and column are within bounds
             if (newRow >= 0 && newRow < getRows() && newCol >= 0 && newCol < getCols()) {
                 //adding the neighbors to the list, using the indeces from the dRow and dCol lists
                 neighbors.add(getCell(newRow, newCol)); 
             }
         }
         return neighbors; 
     }
 
     /**
      * Advances the current Landscape by one step. 
      */
     public void advance() {
         int rows = getRows();  // Get number of rows
         int cols = getCols();  // Get number of columns
         Cell[][] tempGrid = new Cell[rows][cols]; // Temporary grid to store updated cells
 
         // Initialize temporary grid with the current state
         for (int r = 0; r < rows; r++) {
             for (int c = 0; c < cols; c++) {
                 tempGrid[r][c] = new Cell(this.landscape[r][c].getAlive());
             }
         }
 
         // Update each cell in the temporary grid given naeighbors in the original grid
         for (int r = 0; r < rows; r++) {
             for (int c = 0; c < cols; c++) {
                 ArrayList<Cell> neighbors = getNeighbors(r, c);
                 tempGrid[r][c].updateState(neighbors); 
             }
         }
 
         // Copy the temporary grid back to the original grid
         for (int r = 0; r < rows; r++) {
             for (int c = 0; c < cols; c++) {
                 landscape[r][c] = tempGrid[r][c]; 
             }
         }
     
     }
 
     /**
      * Draws the Cell to the given Graphics object at the specified scale.
      * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
      * 
      * @param g     the Graphics object on which to draw
      * @param scale the scale of the representation of this Cell
      */
     public void draw(Graphics g, int scale) {
         for (int x = 0; x < getRows(); x++) {
             for (int y = 0; y < getCols(); y++) {
                 if (getCell(x,y).getAlive()){
                     g.setColor(Color.BLACK);
                 }
                 else{
                     g.setColor(Color.gray);
                 }
                 g.fillOval(x * scale, y * scale, scale, scale);
             }
         }
     }
 
     public static void main(String[] args) {
         // Create a 5x5 landscape with random initialization
         Landscape landscape = new Landscape(5, 5, 0.3);
         
         // Print the landscape
         System.out.println("Initial Landscape:");
         System.out.println(landscape);
 
         // Get and print neighbors of a specific cell
         int testRow = 2;
         int testCol = 2;
         ArrayList<Cell> neighbors = landscape.getNeighbors(testRow, testCol);
         System.out.println("Neighbors of Cell (" + testRow + ", " + testCol + "):");
         for (Cell neighbor : neighbors) {
             System.out.println(neighbor.getAlive() ? "Alive" : "Dead");
         }
 
         // Reset and print the landscape
         landscape.reset();
         System.out.println("Landscape after reset:");
         System.out.println(landscape);
     }
 }