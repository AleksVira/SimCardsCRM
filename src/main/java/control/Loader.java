package control;

import notifications.NotificationManager;
import repository.*;

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

        NotificationManager notificationManager = new NotificationManager(agent.startSimCheck());
        agent.attach(notificationManager);


        System.out.println("Баланс был равен: " + testCard.getBalance());

        agent.createReactivationReport(testCard);

        System.out.println("Теперь баланс равен: " + repository.findSimByPhoneNumber(testCard.getPhoneNumber()).getBalance());


        System.out.println("--------------------------------------\n");

        DbManager dbManager = new ConcreteDbManager();
        SimCard readCard = dbManager.readRecordByPhoneNumber("8913-335-0797");
        System.out.println(readCard.toString());

        System.out.println("--------------------------------------\n");

        SimIdentityMap simMap = new SimIdentityMap();
        SimCard sim2 = simMap.readSimFromMapByPhone("8983-158-6696");
        System.out.println(sim2.toString());




    }
}
