package decorator.coffeeStore.model.decorators;

import decorator.coffeeStore.model.Coffee;

public class DoubleCoffee extends CoffeeDecorator {

    public DoubleCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void serve() {
        coffee.serve();
        coffee.serve();
    }

    @Override
    public Double getPrice() {
        return coffee.getPrice() * 2.00d;
    }
}
