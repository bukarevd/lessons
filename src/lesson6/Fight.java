package lesson6;

public class Fight {

    BattleUnit unit1;
    BattleUnit unit2;

    public Fight(BattleUnit unit1, BattleUnit unit2) {
        this.unit1 = unit1;
        this.unit2 = unit2;
    }

    public void fight (){
        while (unit1.isAlive() && unit2.isAlive()){
            unit1.attack(unit2);
            if (unit2.isAlive())
                unit2.attack(unit1);
        }
    }

    public String fightresult(){
        return "Health unit1 =" + unit1.getHealth()
                + " Health unit2 = " + unit2.getHealth();
    }
}
