package facade.supportSystem.facadeIsolated;

import facade.supportSystem.facadeIsolated.facade.SupportSystemFacade;
import facade.supportSystem.facadeIsolated.facade.SupportSystemNewCardFacade;

public class Client {

    public static void main(String[] args) {
        SupportSystemFacade facade = new SupportSystemFacade();
        SupportSystemNewCardFacade newFacade = new SupportSystemNewCardFacade();
        Long userNumber = 123456L;

        Long cardNumber = facade.getCardByUser(userNumber);
        System.out.println(cardNumber);

        facade.getSumary(cardNumber);

        facade.getPaymentInfoByCard(cardNumber);

        newFacade.cancelLastRegister(userNumber);

        Long newCardNumber = facade.getCardByUser(userNumber);
        System.out.println(newCardNumber);

        newFacade.orderNewCard(userNumber);
        Long newNewCardNumber = facade.getCardByUser(userNumber);
        System.out.println(newNewCardNumber);
    }
}
