package decorator.coffeeStore.model.decorators;

import decorator.coffeeStore.model.Coffee;

public abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
