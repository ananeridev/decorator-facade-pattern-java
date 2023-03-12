package decorator.coffeeStore.model;

public class Expresso implements Coffee {
    @Override
    public void serve() {
        System.out.println("Little and strong coffee");
    }

    @Override
    public Double getPrice() {
        return 1d;
    }
}
