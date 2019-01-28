package control;

import repository.SimCard;

import java.util.Date;

import static utils.MobileConstantsRussian.*;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Hello, Sim!");
        SimCard testCard = new SimCard.Builder().phoneNumber("+79281800000").nickName("18-01").operatorName(OPERATOR_NAME_MEGAFON).ownerName("Алекс").balance(100.0).tariffName("Страна").lastUsedDate(new Date()).build();

        System.out.println(testCard.toString());

        double currentBalance = new BalanceChecker(testCard).checkBalance();
        System.out.println("Баланс равен: " + currentBalance);

    }
}
