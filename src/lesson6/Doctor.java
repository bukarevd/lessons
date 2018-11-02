package lesson6;

public class Doctor extends BattleUnit implements SpeakerUnit {
    public Doctor(int health, int atackScore){
        super(health, atackScore);
    }

    @Override
    public void attack(BattleUnit unit) {
        unit.health += attackScore;
    }

    @Override
    public void say(String text) {
        System.out.println(text);
    }

    @Override
    public void sing(String song) {
        System.out.println(song);
    }
}
