package decorator.coffeeStore.model.decorators;

import decorator.coffeeStore.model.Coffee;

public class Milk extends CoffeeDecorator {

    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void serve() {
    coffee.serve();
    System.out.println(" serving coffee with milk");
    }

    @Override
    public Double getPrice() {
        return coffee.getPrice() + 1.0d;
    }
}
