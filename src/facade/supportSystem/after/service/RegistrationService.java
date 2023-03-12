package facade.supportSystem.after.service;


import facade.supportSystem.after.model.Card;
import facade.supportSystem.after.model.Registration;

import java.util.*;

public class RegistrationService {

    private Map<Long, List<Registration>> memory;

    public RegistrationService() {
        memory = new HashMap<Long, List<Registration>>();
        memory.put(11223344L, new ArrayList<>(Arrays.asList(
                new Registration("Apple", 2000d, new Date()),
                new Registration("Shein", 33d, new Date()),
                new Registration("Mercado Livre shoes", 500d, new Date())
        )));
    }

    public List<Registration> getRegistersByCard(Card card) {
        return memory.get(card.getCardNumber());
    }

    public void removeByIndex(Card card, int i) {
        List<Registration> list = memory.get(card.getCardNumber());
        Registration reg = list.remove(i);
        System.out.println(reg.toString() + " Deleted!");
        memory.put(card.getCardNumber(), list);
    }

    public void deleteCardRegistries(Card card) {
        memory.remove(card.getCardNumber());
    }

    public void addCardRegisters(Card card, List<Registration> registrationList) {
        System.out.println("Associating pending Registers to new Card!");
        memory.put(card.getCardNumber(), registrationList);
    }
}
