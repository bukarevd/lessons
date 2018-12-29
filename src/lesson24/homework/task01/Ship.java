package lesson24.homework.task01;

public class Ship {
    boolean loading = false;
    boolean unloading = false;

    public Ship(boolean loading, boolean unloading) {
        this.loading = loading;
        this.unloading = unloading;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public boolean isUnloading() {
        return unloading;
    }

    public void setUnloading(boolean unloading) {
        this.unloading = unloading;
    }
}
