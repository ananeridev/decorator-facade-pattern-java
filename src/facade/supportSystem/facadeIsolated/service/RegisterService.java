package facade.supportSystem.facadeIsolated.service;

import facade.supportSystem.facadeIsolated.model.Card;
import facade.supportSystem.facadeIsolated.model.Registration;

import java.util.*;

public class RegisterService {
    private Map<Long, List<Registration>> memory;

    public RegisterService() {
        memory = new HashMap<Long, List<Registration>>();
        memory.put(11223344L, new ArrayList<>(Arrays.asList(
                new Registration("McDonalds", 15d, new Date()),
                new Registration("Pizza Hut", 25d, new Date()),
                new Registration("Nike Store", 50d, new Date())
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

    public void addCardRegisters(Card card, List<Registration> registers) {
        System.out.println("Associating pending Registers to new Card!");
        memory.put(card.getCardNumber(), registers);
    }

}
