package Lesson6;

public class Spearman extends BattleUnit {

    public Spearman(int health, int attackScore) {
        super(health, attackScore);
    }

    @Override
    public void attack(BattleUnit enemy) {
        enemy.health -= enemy.attackScore;
    }

    @Override
    public void say(String text) {
        System.out.println("Spearman" + text);
    }

    @Override
    public void sing(String song) {
        System.out.println("Spearman" + song);
    }
}
