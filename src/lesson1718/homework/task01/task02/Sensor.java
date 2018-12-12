package lesson1718.homework.task01.task02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sensor {
    private List<Alarm> alarmList = new ArrayList<>();

    private void addInList(Alarm alarm) {
        alarmList.add(alarm);
    }

    private boolean[] AlarmMessage(int temp, boolean[] alarmCheck) {
        //System.out.println(temp);

        return notifyAlarm(temp, alarmCheck);

    }

    private boolean[] notifyAlarm(int temp, boolean[] alarmCheck) {
        boolean[] alarmCheckNotify = null;
        for (Alarm alarm : alarmList) {
            alarmCheckNotify = alarm.tempChanged(temp, alarmCheck);
        }
        return alarmCheckNotify;
    }

    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        boolean[] alarmCheck = {false, false, false};
        sensor.addInList(new Alarm() {
            @Override
            public boolean[] tempChanged(int temp, boolean[] alarmCheckInsert) {
                if (temp >= 100 && temp < 300 && alarmCheckInsert[0] == false) {
                    alarmCheckInsert[0] = true;
                    System.out.println("100 градусов - Green");
                } else if (temp < 100) alarmCheckInsert[0] = false;
                if (temp >= 300 && temp < 600 && alarmCheckInsert[1] == false) {
                    alarmCheckInsert[1] = true;
                    System.out.println("300 градусов - Green, Yellow");
                } else if (temp < 300) alarmCheckInsert[1] = false;

                if (temp >= 600 && alarmCheckInsert[2] == false) {
                    alarmCheckInsert[2] = true;
                    System.out.println("600 градусов - Green, Yellow, Red");
                }else if(temp < 600) alarmCheckInsert[2] = false;
                return alarmCheckInsert;
            }
        });
        Scanner in = new Scanner(System.in);
        while (true) {
            alarmCheck = sensor.AlarmMessage(in.nextInt(), alarmCheck);
        }

    }
}
