package lesson22.homework.task01.Task02;


class Order {
    boolean client = false;
    boolean waiter = false;
    boolean cook = false;



    public boolean isClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public boolean isWaiter() {
        return waiter;
    }

    public void setWaiter(boolean waiter) {
        this.waiter = waiter;
    }

    public boolean isCook() {
        return cook;
    }

    public void setCook(boolean cook) {
        this.cook = cook;
    }

}
