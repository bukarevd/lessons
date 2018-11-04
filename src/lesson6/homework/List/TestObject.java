package lesson6.homework.List;

public class TestObject {
    private TestObject nextObj = null;

    protected void setNextObj(TestObject nextObj){
        this.nextObj = nextObj;
    }


    @Override
    public String toString() {
        return "TestObj{" +
                "nextObj=" + nextObj +
                '}';
    }
}
