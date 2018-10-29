package Lesson6;

public class Knight extends BattleUnit implements SpeakerUnit {

    public Knight(int health, int attackScore) {
        super(health, attackScore);
    }

    protected void addHealth(){
        if (this.health > 0) this.health += 5;
    }

    @Override
    public void attack(BattleUnit enemy) {
        enemy.health -= enemy.attackScore;
        addHealth();
    }

    @Override
    public void say(String text) {
        System.out.println("Knight" + text);
    }

    @Override
    public void sing(String song) {
        System.out.println("Knight" + song);
    }
}
