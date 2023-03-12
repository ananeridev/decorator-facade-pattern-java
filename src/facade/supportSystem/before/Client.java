package facade.supportSystem.before;

import facade.supportSystem.before.model.Card;
import facade.supportSystem.before.model.Registration;
import facade.supportSystem.before.service.*;

import java.util.List;

public class Client {

    // alto acoplamento e baixo encapsulamento

    public static void main(String[] args) {
        CardService cardService = new CardService();
        RegistrationService registrationService = new RegistrationService();
        ReportService reportService = new ReportService(registrationService);
        PaymentService paymentService = new PaymentService(registrationService);
        SecurityService securityService = new SecurityService(cardService, registrationService);

        Card card = cardService.getCardByUser(123456L);
        System.out.println(card);

        reportService.getSumary(card);

        paymentService.getPaymentInfoByCard(card);

        List<Registration> registers = registrationService.getRegistersByCard(card);
        registrationService.removeByIndex(card, registers.size() - 1);
        List<Registration> pendingRegisters = securityService.blockCard(card);
        Card newCard = cardService.createNewCard(123456L, 33445566L);
        registrationService.addCardRegisters(newCard, pendingRegisters);
        reportService.getSumary(newCard);
    }
}
