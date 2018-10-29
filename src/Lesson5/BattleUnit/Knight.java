package Lesson5.BattleUnit;

public class Knight extends BattleUnit {

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

}
