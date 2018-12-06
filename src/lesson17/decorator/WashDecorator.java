package lesson17.decorator;

public class WashDecorator extends ServiceDecorator {
    public WashDecorator(IService iService){
        super(iService);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Wash";
    }
}
