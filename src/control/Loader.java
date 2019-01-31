package control;

import notifications.NotificationManager;
import repository.SimCard;
import repository.SimCardRepository;

import java.util.Date;

import static utils.MobileConstantsRussian.*;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Hello, Sim!");
        SimCard testCard = new SimCard.Builder().phoneNumber("+79281800000").nickName("18-01").operatorName(OPERATOR_NAME_MEGAFON).ownerName("Алекс").balance(100.0).tariffName("Страна").lastUsedDate(new Date()).build();

        System.out.println(testCard.toString());

        double currentBalance = new BalanceChecker(testCard).checkBalance();
        System.out.println("Баланс равен: " + currentBalance);


        Agent agent = new Agent();
        SimCardRepository repository = new SimCardRepository();
        repository.addSim(testCard);
        agent.attach(repository);

        NotificationManager manager = new NotificationManager(agent.startSimCheck());
        agent.attach(manager);


        System.out.println("Баланс был равен: " + testCard.getBalance());

        agent.createReactivationReport(testCard);

        System.out.println("Теперь баланс равен: " + repository.findSimByPhoneNumber(testCard.getPhoneNumber()).getBalance());

    }
}
