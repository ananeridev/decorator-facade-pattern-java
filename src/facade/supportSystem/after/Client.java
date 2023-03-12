package facade.supportSystem.after;

import facade.supportSystem.after.facade.SupportSystemFacade;
import facade.supportSystem.before.model.Card;

public class Client {

    public static void main(String[] args) {
        SupportSystemFacade facade = new SupportSystemFacade();

        Card card = facade.getCardByUser(123456L);
        System.out.println(card);

        facade.getSumary(card);

        facade.getPaymentInfoByCard(card);

        facade.cancelLastRegister(card);

        Card newCard = facade.getCardByUser(123456L);
        System.out.println(newCard);
    }
}
