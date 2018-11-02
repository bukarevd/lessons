package lesson2.homework;

public class Task05 {
    public static void main(String[] args) {
        int[] fibArray = new int[11];
        fibArray[0] = 1;
        fibArray[1] = 1;
        for (int i = 2; i < fibArray.length; i++){
            fibArray[i] = fibArray[i-1] + fibArray[i -2];
        }
        for (int i = 0; i < fibArray.length; i++){
            System.out.print(fibArray[i] + " ");
        }
    }
}
