package Lesson6;

public class BattleUnitFactory {
    public BattleUnit create(String UserChoose){
        BattleUnit unit;

        if(UserChoose.equals("knight")) return new Knight(100, 20);
        if(UserChoose.equals("spearman")) return new Spearman(60, 60);

        return new Doctor(50, 10);

    }
}
