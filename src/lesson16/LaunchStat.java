package lesson16;

import java.io.Serializable;
import java.util.Date;

public class LaunchStat implements Serializable {//если не будет пометки, объект нельзя сериализовать.
    private  int launchCount;
    private Date lastLaunch;

   transient private String lastUser; //transient - отмеченые поля не участвуют в сериализации

    public void update(){
        launchCount++;
        lastLaunch = new Date();
        lastUser = System.getProperty("user.name"); // из -за этого исключение
    }

    @Override
    public String toString() {
        return "LaunchStat{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                ", lastUser='" + lastUser + '\'' +
                '}';
    }

    public boolean isFirstLaunch(){
        return launchCount == 0 && lastLaunch == null;
    }

}
