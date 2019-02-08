package repository;

import control.Agent;
import control.MyObserver;

import java.util.ArrayList;
import java.util.Random;

public class SimCardRepository implements MyObserver {
    ArrayList<SimCard> repository = new ArrayList<>();


    public void updateRepositorySim(SimCard simCard) {
        for (int i = 0; i < repository.size(); i++) {
            if (repository.get(i).getPhoneNumber().equals(simCard.getPhoneNumber())) {
                repository.set(i, simCard);
                break;
            }
        }
    }

    public boolean addSim(SimCard newSim) {
        if (findSimByPhoneNumber(newSim.getPhoneNumber()) == null) {
            repository.add(newSim);
            return true;
        } else {
            System.out.println("Не могу добавить, такой номер уже есть в базе!");
            return false;
        }

    }

    public SimCard findSimByPhoneNumber(String phoneNumber) {
        for (SimCard testSim : repository) {
            if (testSim.getPhoneNumber().equals(phoneNumber)) {
                return testSim;
            }
        }
        return null;
    }

    @Override
    public void update(Agent agent, SimCard simCard) {
        System.out.println("Данные в базе о Sim-карте с номером " + simCard.getPhoneNumber() + " обновлены.");
        updateRepositorySim(simCard);
    }
}
