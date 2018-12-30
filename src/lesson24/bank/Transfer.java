package lesson24.bank;

public class Transfer extends Thread {
    Account src;
    Account dst;
    Account obj1, obj2;
    double money;

    Transfer(Account src, Account dst, double money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    @Override
    public void run() {
        if (src.getId() < dst.getId()) {
            obj1 = src;
            obj2 = dst;
        } else {
            obj2 = src;
            obj1 = dst;
        }

        synchronized (obj1) {
            synchronized (obj2) {
                double amountsrc = src.getMoney();
                double amountdst = dst.getMoney();
                if (amountsrc - money < 0) {
                    System.out.println("Денег на счету не хватает");
                    System.out.println("На счете:" + src.getMoney());
                    return;
                }else{
                    amountsrc -= money;
                }
                amountdst += money;

                dst.setMoney(amountdst);
                src.setMoney(amountsrc);

                System.out.println("Перевод успешно произведен");
                System.out.println("На счету отправителя: " + src.getMoney());
                System.out.println("На счету получателя: " + dst.getMoney());


            }
        }
    }
}
