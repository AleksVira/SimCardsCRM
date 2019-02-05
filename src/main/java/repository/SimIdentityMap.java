package repository;

import java.util.HashMap;
import java.util.Map;

public class SimIdentityMap {

    private Map<String, SimCard> simcardsMap;
    private DbManager dbManager;


    private static SimIdentityMap ourInstance = new SimIdentityMap();

    public static SimIdentityMap getInstance() {
        return ourInstance;
    }

    public SimIdentityMap() {
        dbManager = new ConcreteDbManager();
        simcardsMap = new HashMap<>();
        // Можно добавить принудительное считывание всей базы в кэш
    }

    public SimCard readSimFromMapByPhone(String phoneNumber) {
        SimCard nextSim = simcardsMap.get(phoneNumber);
        if (nextSim == null) {
            nextSim = dbManager.readRecordByPhoneNumber(phoneNumber);
            addSimToMap(nextSim);
        }
        return nextSim;
    }

    private void addSimToMap(SimCard simToAdd) {
        simcardsMap.put(simToAdd.getPhoneNumber(), simToAdd);
    }

}
