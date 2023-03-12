package decorator.coffeeStore;

import decorator.coffeeStore.model.Coffee;
import decorator.coffeeStore.model.Expresso;
import decorator.coffeeStore.model.IrishCoffee;
import decorator.coffeeStore.model.decorators.DoubleCoffee;
import decorator.coffeeStore.model.decorators.Milk;

public class Client {

    public static void order(String name, Coffee Coffee) {
        System.out.println("Ordering a " + name);
        Coffee.serve();
        System.out.println(Coffee.getPrice());
        System.out.println("---------------");
    }

    public static void main(String[] args) {
        order("Expresso", new Expresso());
        order("Irish Coffe", new IrishCoffee());
        order("Lungo", new DoubleCoffee(new Expresso()));
        order("Coffee Milk", new Milk(new Expresso()));
        order("I don't know about this, but sounds good :D", new Milk(new IrishCoffee()));
    }
}
