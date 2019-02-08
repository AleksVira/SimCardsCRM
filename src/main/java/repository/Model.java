package repository;

public class Model {
    private ConcreteDbManager dbManager;

    public Model() {
        dbManager = new ConcreteDbManager();
    }

    public SimCard getRandomSim() {
        return dbManager.getRandomSim();
    }

    public void addNewSim(SimCard newSim) {
        dbManager.createNewRecord(newSim);
    }

    public void updateSim(SimCard simToUpdate) {
        dbManager.updateRecordByPhoneNumber(simToUpdate);
    }

    public void deleteSimByNumber(String simToDelete) {
        dbManager.deleteRecordByPhoneNumber(simToDelete);
    }
}
