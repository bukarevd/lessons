package Lesson3.Homework;


public class Task01 {
    public static void main(String[] args) {
        int[] intArr = new int[10];

        for (int i = 2, j = 0; i < 22; i += 2, j++){
            intArr[j] = i;
        }

       for (int i = 0; i < intArr.length; i++)
           System.out.print(intArr[i] +" ");

       System.out.println();

        for (int num: intArr){
            System.out.println(num);
        }
    }
}
