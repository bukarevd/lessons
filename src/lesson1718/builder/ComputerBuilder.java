package lesson1718.builder;

abstract class ComputerBuilder {
    Computer computer;
    public Computer getComputer(){
        return computer;
    }

    public void createComputer(){
        computer = new Computer();
    }

    public abstract void buildDisplay();
    public abstract void buildSystemBlock();
    public abstract void buildManipulator();
}
