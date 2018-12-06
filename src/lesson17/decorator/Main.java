package lesson17.decorator;

public class Main {
    public static void main(String[] args) {
        IService service = new Service2(new WashDecorator(new TO()));
        System.out.println(service.getPrice() + " " + service.getDescription());

        IService service1 = new WashDecorator(new TO());
        System.out.println(service1.getPrice() + " " + service1.getDescription());
    }
}
