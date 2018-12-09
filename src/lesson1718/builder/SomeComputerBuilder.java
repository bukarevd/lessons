package lesson1718.builder;

public class SomeComputerBuilder extends ComputerBuilder{
    @Override
    public void buildDisplay() {
        computer.setDisplay("Some Display");
    }

    @Override
    public void buildSystemBlock() {
        computer.setSystemBlock("Some systemblock");

    }

    @Override
    public void buildManipulator() {
        computer.setManipulators("Some manipulator");
    }
}
