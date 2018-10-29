package Lesson5.BattleUnit;

public class BattleUnit {
    protected int health;
    protected int attackScore;

    public BattleUnit(int health, int attackScore) {
        this.health = health;
        this.attackScore = attackScore;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public void attack(BattleUnit enemy){
        enemy.health -= this.attackScore;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }
}
