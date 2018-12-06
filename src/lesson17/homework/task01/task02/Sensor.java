package lesson17.homework.task01.task02;

import chat.Server;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private List<Alarm> alarmList = new ArrayList<>();

    private void addInList(Alarm alarm) {
        alarmList.add(alarm);
    }

    private void AlarmMessage(int temp) {
        //System.out.println(temp);
        notifyAlarm(temp);

    }

    private void notifyAlarm(int temp) {
        for (Alarm alarm : alarmList) {
            alarm.tempChanged(temp);
        }
    }

    public static void main(String[] args) {
        Sensor sensor = new Sensor();

        sensor.addInList(new Alarm() {
            @Override
            public void tempChanged(int temp) {
                if (temp == 100)
                    System.out.println("100 градусов - Green");
                else if (temp == 300)
                    System.out.println("300 градусов - Green, Yellow");
                else if(temp == 600)
                    System.out.println("600 градусов - Green, Yellow, Red");
            }
        });
        for(int i= 0; i < 1000; i++)
        sensor.AlarmMessage(i);
    }
}
