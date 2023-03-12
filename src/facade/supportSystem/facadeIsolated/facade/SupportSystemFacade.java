package facade.supportSystem.facadeIsolated.facade;

import facade.supportSystem.facadeIsolated.model.Card;
import facade.supportSystem.facadeIsolated.service.CardService;
import facade.supportSystem.facadeIsolated.service.PaymentService;
import facade.supportSystem.facadeIsolated.service.RegisterService;
import facade.supportSystem.facadeIsolated.service.ReportService;

public class SupportSystemFacade {

    CardService cardService;
    RegisterService registerService;
    ReportService reportService;
    PaymentService paymentService;

    public SupportSystemFacade() {
        cardService = new CardService();
        registerService = new RegisterService();
        reportService = new ReportService(registerService);
        paymentService = new PaymentService(registerService);
    }

    public Long getCardByUser(Long l) {
        Card card = cardService.getCardByUser(l);
        return card.getCardNumber();
    }

    public void getSumary(Long cardNumber) {
        reportService.getSumary(new Card(null, cardNumber));
    }

    public void getPaymentInfoByCard(Long cardNumber) {
        paymentService.getPaymentInfoByCard(new Card(null, cardNumber));
    }

}
