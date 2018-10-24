package Lesson2.Homework;

public class Task06 {
    public static void main(String[] args) {
        int count = 0;
        int left = 0;
        int right = 0;
        for(int i = 1; i < 1000000; i++){
            int sumright =0, sumleft = 0;
            right = i % 1000;
            left = i / 1000;
            for (int j = 0; j < 3; j++){
                sumleft += left % 10;
                sumright += right % 10;
            }

            if (sumleft == sumright) count++;

        }
        System.out.println(count + " счастливых билетов в одном рулоне");

    }
}
