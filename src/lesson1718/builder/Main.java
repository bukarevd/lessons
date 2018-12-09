package lesson1718.builder;

public class Main {
    public static void main(String[] args) {
//        Computer computer = new Computer();
//        computer.setDisplay("");
//        computer.setSystemBlock("");
//        computer.setManipulators("");
//
        Director director = new Director();
        ComputerBuilder computerBuilder = new SomeComputerBuilder();
        director.setComputerBuilder(computerBuilder);
        director.constructComputer();
        Computer computer = director.getComputer();
        System.out.println(computer);

    }
}
