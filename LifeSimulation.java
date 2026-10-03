/**
 * Sawyer Rogers
 * Purpose: Simulate the game of life
 * to run code type on command line
 */
public class LifeSimulation {
    public static void main(String[] args) throws InterruptedException {
        // Default grid size, probability of alive cells, and time steps
        int rows = 50;
        int cols = 50;
        double initialAliveProb = 0.25;
        int timeSteps = 10;
        int count = 0;

        // Check if command-line arguments are passed and update values
        if (args.length >= 3) {
            try {
                rows = Integer.parseInt(args[0]);
                cols = Integer.parseInt(args[1]);
                initialAliveProb = Double.parseDouble(args[2]);
                if (args.length >= 4) {
                    timeSteps = Integer.parseInt(args[3]);  // Optional argument for time steps
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default values.");
            }
        }

        // Initialize the Landscape with random conditions
        Landscape scape = new Landscape(rows, cols, initialAliveProb);

        // Set up the display with a scaling factor
        LandscapeDisplay display = new LandscapeDisplay(scape, 10);


        // Run the simulation for the remaining time steps
        for (int i = 0; i < timeSteps; i++) {
            scape.advance();  // Move forward by one step
            display.repaint();  // Refresh 
            Thread.sleep(250);  // Pause between steps
        }

        //counting number of ailve cells
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j ++){
                if(scape.getCell(i, j).getAlive() == true){
                    count++;
                }

            }
        }
        System.out.println(count);
    }

    
}