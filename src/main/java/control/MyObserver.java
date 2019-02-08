package control;

import repository.SimCard;

public interface MyObserver {
    // Метка, для включения в список Наблюдателей

    void update(Agent agent, SimCard simCard);
}
