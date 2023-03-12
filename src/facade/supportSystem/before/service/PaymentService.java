package facade.supportSystem.before.service;

import facade.supportSystem.before.model.Card;
import facade.supportSystem.before.model.Registration;

import java.util.List;

public class PaymentService {

    private RegistrationService registrationService;

    public PaymentService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public void getPaymentInfoByCard(Card card) {
        List<Registration> registers = registrationService.getRegistersByCard(card);
        double sum = registers.stream()
                .reduce(0d, (partialValue, reg) -> partialValue + reg.getValue(), Double::sum);
        System.out.println(String.format("You need to pay %.2f until next week", sum));
    }
}
