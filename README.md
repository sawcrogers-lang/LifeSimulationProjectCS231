# LifeSimulationProjectCS231
This project is a simulation of the game of life.

In order to run this simulation using command line arguments compile all files, then run the file LifeSimulation.

LifeSimulation has four command line parameters. 
-The first one defines teh number of rows that will be in the landscape grid
-the second one defines the number of columns that will be in the landscape grid
-the third is the percentage chance that the cells are alive when they are initialized
-the fourth is the timesteps, which is the number of iterations that the simulation will run

an example of what you could type on the command line to run the code:
    java LifeSimulation 50 50 0.25 10

this command would run the simulation 10 times, on a 50x50 grid with each cell having 0.25 chance of starting alive.
