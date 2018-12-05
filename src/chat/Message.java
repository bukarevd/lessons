package chat;

import java.io.Serializable;

public class Message implements Serializable {
    private String messText;
    private String sender;

    public Message(String sender, String messText){
        this.sender = sender;
        this.messText = messText;
    }

    public String getMessText() {
        return messText;
    }

    public void setMessText(String messText) {
        this.messText = messText;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messText='" + messText + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
