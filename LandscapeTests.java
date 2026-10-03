/*
file name:      LandscapeTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  9/18/2022

How to run:     java -ea LandscapeTests
*/

import java.util.ArrayList;

public class LandscapeTests {

    public static void landscapeTests() {

        // case 1: testing Landscape(int, int)
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10);

            // verify
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);

            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";
            assert l2 != null : "Error in Landscape::Landscape(int, int)";
        }

        // case 2: testing reset()
        {
            // set up
            Landscape l1 = new Landscape(3, 3, 0.5); // Random initialization
            System.out.println("Initial Landscape:\n" + l1);
            l1.reset(); // Resetting the landscape
            System.out.println("Landscape after reset:\n" + l1);


            // verify
            assert l1 != null : "Error in Landscape::reset()";
        }



            // test
            
        }

        // case 3: testing getRows()
        {
            // set up
            Landscape l1 = new Landscape(5, 5);
            int expectedRows = 5;

            // verify
            int actualRows = l1.getRows();
            System.out.println("Expected Rows: " + expectedRows + ", Actual Rows: " + actualRows);


            // test
            assert actualRows == expectedRows : "Error in Landscape::getRows()";
        }

        // case 4: testing getCols()
        {
            // set up
            Landscape l1 = new Landscape(5, 7);
            int expectedCols = 7;

            // verify
            int actualCols = l1.getCols();
            System.out.println("Expected Columns: " + expectedCols + ", Actual Columns: " + actualCols);

            // test
            assert actualCols == expectedCols : "Error in Landscape::getCols()";
        }

        

        // case 5: testing getCell(int, int)
        {
            // set up
            Landscape l1 = new Landscape(4, 4);
            int row = 1, col = 2;
            Cell cell = l1.getCell(row, col);


            // verify
            System.out.println("Cell at (" + row + ", " + col + ") is alive: " + cell.getAlive());


            // test
            assert cell != null : "Error in Landscape::getCell(int, int)";
        }

        

        // case 6: testing getNeighbors()
        {
            // set up
            Landscape l1 = new Landscape(5, 5);
            int row = 2, col = 2;

            // verify
ArrayList<Cell> neighbors = l1.getNeighbors(row, col);
            System.out.println("Neighbors of Cell (" + row + ", " + col + "):");
            for (Cell neighbor : neighbors) {
                System.out.println(neighbor.getAlive() ? "Alive" : "Dead");
            }

            // test
            assert neighbors.size() == 8 : "Error in Landscape::getNeighbors()";
        }

        

        // case 7: testing advance()
        {
            // set up
            Landscape l1 = new Landscape(3, 3, 0.5);
            System.out.println("Initial Landscape before advance:\n" + l1);
            l1.advance(); // Assuming advance is defined to progress the game state
            System.out.println("Landscape after advance:\n" + l1);


            // verify
            assert l1 != null : "Error in Landscape::advance()";
        }
    


            // test

        


    public static void main(String[] args) {

        landscapeTests();
    }
}