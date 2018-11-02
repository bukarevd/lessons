package lesson2.homework;

public class Task07 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j ++){
                    int hour1 = i / 10;
                    int hour2 = i % 10;
                    int minutes1 = j / 10;
                    int minutes2 = j % 10;
                    if (hour1 == minutes2 && hour2 == minutes1) count++;
                }
            }
        System.out.println(count + " симетричных комбинаций");
        }
    }

