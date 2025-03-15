package Simulation;

public class Main {
    private static final Simulation simulation = new Simulation();


    public static void main(String[] args) throws InterruptedException {
        simulation.startSimulation();
    }

    public static Simulation getSimulation(){
        return simulation;
    }
}