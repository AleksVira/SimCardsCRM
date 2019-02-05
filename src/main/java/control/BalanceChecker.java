package control;

import repository.SimCard;
import utils.UssdParser;

import static utils.MobileConstantsRussian.*;

class BalanceChecker {

    private SimCard simCard;


    BalanceChecker(SimCard simCard) {
        this.simCard = simCard;
    }


    double checkBalance() {
        double result = -Double.MAX_VALUE;
        PhoneManager phoneManager = new PhoneManager();
        String phoneAnswer;

        switch (simCard.getOperatorName()) {
            case OPERATOR_NAME_MTS:
                phoneAnswer = phoneManager.ussdRequest(USSD_BALANCE_MTS);
                result = new UssdParser().parserMts(phoneAnswer);
                break;
            case OPERATOR_NAME_MEGAFON:
                phoneAnswer = phoneManager.ussdRequest(USSD_BALANCE_MEGAFON);
                result = new UssdParser().parserMegafon(phoneAnswer);
                break;
            case OPERATOR_NAME_BEELINE:
                phoneAnswer = phoneManager.ussdRequest(USSD_BALANCE_BEELINE);
                result = new UssdParser().parserBeeline(phoneAnswer);
                break;
            case OPERATOR_NAME_TELE2:
                phoneAnswer = phoneManager.ussdRequest(USSD_BALANCE_TELE2);
                result = new UssdParser().parserTele2(phoneAnswer);
                break;
            default: {
                // Something wrong
            }
        }
        return result;
    }

}
