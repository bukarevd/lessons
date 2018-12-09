package lesson19.reflection;

// reflection api

public class Child extends Parrent{
    private String name;
    private int version = 1;

    public Child(String name, int version){
        this.name = name;
        this.version = version;
    }

    private String getName(){
        return name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    private String getInfo(){
        return "private getInfo()";
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}

class Parrent{

}
