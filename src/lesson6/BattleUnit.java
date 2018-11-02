package lesson6;

abstract public class BattleUnit implements SpeakerUnit{ //Абстрактному классу необязательно реализовывать методы интерфейса
    protected int health;
    protected int attackScore;

    public BattleUnit(int health, int attackScore) {
        this.health = health;
        this.attackScore = attackScore;
    }

    public boolean isAlive(){
        return health > 0;
    }

    abstract public void attack(BattleUnit enemy);

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
