package facade.supportSystem.before.service;

import facade.supportSystem.before.model.Card;
import facade.supportSystem.before.model.Registration;

import java.util.List;

public class ReportService {

    private RegistrationService registrationService;

    public ReportService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public void getSumary(Card card) {
        List<Registration> registers = registrationService.getRegistersByCard(card);
        for(Registration reg: registers) {
            System.out.println(String.format("%s\t%.2f\t%s",
                    reg.getStoreName(),
                    reg.getValue(),
                    reg.getDate().toString()
            ));
        }
    }
}
