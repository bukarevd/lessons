package lesson1718.decorator;

public class Service2 extends ServiceDecorator {
    public Service2(IService iService) {
        super(iService);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Service2";
    }
}
