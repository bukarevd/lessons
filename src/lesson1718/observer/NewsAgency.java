package lesson1718.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private List<Listener> listenerList = new ArrayList<>();

    public void addListener(Listener listener){
        listenerList.add(listener);
    }

    public void removeListener(Listener listener){
        listenerList.remove(listener);
    }

    public void newMessage(String str){
        System.out.println("Message" + str);
        notifyListeners(str);
    }

    private void notifyListeners(String mess){
        for (Listener listener : listenerList){
            listener.publish(mess);
        }
    }

    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        newsAgency.addListener(new Listener() {
            @Override
            public void publish(String str) {
                //Своя реализация
                System.out.println("listener1" + str);
            }
        });
        newsAgency.addListener(new Listener() {
            @Override
            public void publish(String str) {

                System.out.println("listener2" + str);
            }
        });

        newsAgency.newMessage("new message");
    }
}
