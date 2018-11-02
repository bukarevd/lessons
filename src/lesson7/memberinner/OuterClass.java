package lesson7.memberinner;

public class OuterClass {
    String value;
    static int intVal = 1;

    public OuterClass(String value){
        this.value = value;
    }

    public InnerClass getInnerClass(){
        return new InnerClass("Innerclass");
    }

//    NORMAL INNER CLASS




//    STATIC

    static class InnerClass{
        String val;

        public InnerClass(String val){
            this.val = val;
        }

        public void someVoid(){
            intVal += 1;
            System.out.println(intVal);
//            System.out.println(value); ошибка, не имеет доступа к не статическим переменным внешнего класса
        }

    }
}
