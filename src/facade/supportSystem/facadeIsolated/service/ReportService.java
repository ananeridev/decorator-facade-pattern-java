package facade.supportSystem.facadeIsolated.service;

import facade.supportSystem.facadeIsolated.model.Card;
import facade.supportSystem.facadeIsolated.model.Registration;

import java.util.List;

public class ReportService {


    private RegisterService registerService;

    public ReportService(RegisterService registerService) {
        this.registerService = registerService;
    }

    public void getSumary(Card card) {
        List<Registration> registers = registerService.getRegistersByCard(card);
        for(Registration reg: registers) {
            System.out.println(String.format("%s\t%.2f\t%s",
                    reg.getStoreName(),
                    reg.getValue(),
                    reg.getDate().toString()
            ));
        }
    }

}
