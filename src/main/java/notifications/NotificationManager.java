package notifications;

import control.Agent;
import control.MyObserver;
import repository.SimCard;

import java.util.ArrayList;

// Класс занимается работой уведомлений. Строит список из сим, которые нужно реактивировать. Сортирует его по дате.
// Показывает на экране этот список.
public class NotificationManager implements MyObserver {
    ArrayList<SimCard> waitingUpdateList;

    public NotificationManager(ArrayList<SimCard> waitingUpdateList) {
        this.waitingUpdateList = waitingUpdateList;
    }

    public void showNotificationList() {
        if (!waitingUpdateList.isEmpty()) {
            buildListOnScreen(waitingUpdateList);
        } else {
            System.out.println("На сегодня уведомлений нет!");
        }
    }

    // Показывает список на экране
    private void buildListOnScreen(ArrayList<SimCard> waitingUpdateList) {

    }

    private void sortList() {
        // Сортирует список по дате
    }

    private void updateList(SimCard simToRemove) {
        int indexToRemove = -1;
        for (int i = 0; i < waitingUpdateList.size(); i++) {
            SimCard card = waitingUpdateList.get(i);
            if (card.getPhoneNumber().equals(simToRemove.getPhoneNumber())) {
                if (goodNewDate(card, simToRemove)) {
                    indexToRemove = i;
                    break;
                }
            }
        }
        if (indexToRemove > -1) {
            waitingUpdateList.remove(indexToRemove);
            buildListOnScreen(waitingUpdateList);
        } else {
//            System.out.println("Удалять нечего!");
        }


    }

    // Проверяет чтобы дата последнего использования у simToRemove была позднее, чем у card
    private boolean goodNewDate(SimCard card, SimCard simToRemove) {
        // Сравнение двух дат, вторая должна быть больше (позже) чем первая
        return true;
    }

    @Override
    public void update(Agent agent, SimCard simCard) {
        System.out.println("Данные в списке обновлены.");
        updateList(simCard);
    }
}
