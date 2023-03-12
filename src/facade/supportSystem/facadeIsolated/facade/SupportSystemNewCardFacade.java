package facade.supportSystem.facadeIsolated.facade;

import facade.supportSystem.facadeIsolated.model.Card;
import facade.supportSystem.facadeIsolated.model.Registration;
import facade.supportSystem.facadeIsolated.service.CardService;
import facade.supportSystem.facadeIsolated.service.RegisterService;
import facade.supportSystem.facadeIsolated.service.ReportService;
import facade.supportSystem.facadeIsolated.service.SecurityService;

import java.util.List;

public class SupportSystemNewCardFacade {

    CardService cardService;
    RegisterService registerService;
    ReportService reportService;
    SecurityService securityService;

    public SupportSystemNewCardFacade() {
        cardService = new CardService();
        registerService = new RegisterService();
        reportService = new ReportService(registerService);
        securityService = new SecurityService(cardService, registerService);
    }

    public void cancelLastRegister(Long user) {
        Card card = cardService.getCardByUser(user);
        List<Registration> registers = registerService.getRegistersByCard(card);
        registerService.removeByIndex(card, registers.size() - 1);
        List<Registration> pendingRegisters = securityService.blockCard(card);
        Card newCard = cardService.createNewCard(123456L, 33445566L);
        registerService.addCardRegisters(newCard, pendingRegisters);
        reportService.getSumary(newCard);
    }

    public void orderNewCard(Long user) {
        Card card = cardService.getCardByUser(user);
        List<Registration> pendingRegisters = securityService.blockCard(card);
        Card newCard = cardService.createNewCard(123456L, 99887766L);
        registerService.addCardRegisters(newCard, pendingRegisters);
        reportService.getSumary(newCard);
    }
}
