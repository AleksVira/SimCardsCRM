package control;

// Запускается раз в сутки (время настраивается). Проверяет все сим по базе, смотрит у кого подходит срок реактивации. Формирует список сим, о которых надо уведомить
// (если до даты реактивации остаётся неделя или меньше). Может создавать отчёты о реактивации. При заполнении отчёта (после выполненной руками или через модем реактивации)
// уведомляет об изменении данных в SimRepository, а так же в NotificationManager. Последний должен после проверки даты убрать эту сим из отображаемого списка.

import repository.SimCard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Agent {

    private List<MyObserver> observers = new ArrayList<>();

    // Подключение Наблюдателя
    public void attach(MyObserver observer) {
        observers.add(observer);
    }

    // Отключение Наблюдателя
    public void detach(MyObserver observer) {
        observers.remove(observer);
    }

    // Уведомление всех Наблюдателей
    public void notify(SimCard simCard) {
        for (MyObserver observer : observers) {
            observer.update(this, simCard);
        }
    }


    public ArrayList<SimCard> startSimCheck() {
        ArrayList<SimCard> needActionList = new ArrayList<>();
        // Обращается к базе и проверяет кого пора реактивировать.
        return needActionList;
    }

    public SimCard createReactivationReport(SimCard simCard) {
        SimCard updatedSim = SimCard.deepCopy(simCard);
        updatedSim.setBalance(updatedSim.getBalance() - 1);
        updatedSim.setLastUsedDate(new Date());
        notify(updatedSim);
        return updatedSim;
    }


}
