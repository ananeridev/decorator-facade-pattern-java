package facade.supportSystem.after.facade;

import facade.supportSystem.before.model.Card;
import facade.supportSystem.before.model.Registration;
import facade.supportSystem.before.service.*;

import java.util.List;

public class SupportSystemFacade {

    CardService cardService;
    RegistrationService registrationService;
    ReportService reportService;
    PaymentService paymentService;
    SecurityService securityService;

    public SupportSystemFacade() {
        cardService = new CardService();
        registrationService = new RegistrationService();
        reportService = new ReportService(registrationService);
        paymentService = new PaymentService(registrationService);
        securityService = new SecurityService(cardService, registrationService);
    }

    public Card getCardByUser(Long l) {
        return cardService.getCardByUser(l);
    }

    public void getSumary(Card card) {
        reportService.getSumary(card);
    }

    public void getPaymentInfoByCard(Card card) {
        paymentService.getPaymentInfoByCard(card);
    }

    public void cancelLastRegister(Card card) {
        List<Registration> registers = registrationService.getRegistersByCard(card);
        registrationService.removeByIndex(card, registers.size() - 1);
        List<Registration> pendingRegisters = securityService.blockCard(card);
        Card newCard = cardService.createNewCard(123456L, 33445566L);
        registrationService.addCardRegisters(newCard, pendingRegisters);
        reportService.getSumary(newCard);
    }
}
