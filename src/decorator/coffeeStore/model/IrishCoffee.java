package decorator.coffeeStore.model;

public class IrishCoffee implements Coffee {
    @Override
    public void serve() {
        System.out.println("Irish Coffe, strong and alcohol");
    }

    @Override
    public Double getPrice() {
        return 5.0;
    }
}
