package loader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import repository.Model;
import repository.SimCard;
import utils.StringUtils;

public class Controller {


    private Model model;
    private boolean waitNew;

    @FXML
    public TextArea commentAres;
    @FXML
    private TextField tfNumber;
    @FXML
    private TextField tfNickname;
    @FXML
    private TextField tfOperator;
    @FXML
    private TextField tfOwner;
    @FXML
    private TextField tfBalance;
    @FXML
    private TextField tfTariff;
    @FXML
    private TextField tfLastDate;

    @FXML
    public Button btnAddNew;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnDel;

    @FXML
    private void initialize() {
        System.out.println("initialize()");
        tfNumber.setDisable(true);
    }

    @FXML
    public void createNewAction(ActionEvent event) {
        waitNew = true;
        tfNumber.setDisable(false);
        btnAddNew.setDisable(true);
        commentAres.setText("Введите новые данные и нажмите \"Save\"");
    }

    @FXML
    private void saveData(ActionEvent event) {
        SimCard newSim = new SimCard.Builder().phoneNumber(tfNumber.getText()).
                nickName(tfNickname.getText()).operatorName(tfOperator.getText()).
                ownerName(tfOwner.getText()).balance(Double.parseDouble(tfBalance.getText())).
                tariffName(tfTariff.getText()).
                lastUsedDate(StringUtils.intToDataConverter(Integer.parseInt(tfLastDate.getText()))).build();
        if (waitNew) {
            tfNumber.setDisable(true);
            btnAddNew.setDisable(false);
            model.addNewSim(newSim);
            commentAres.setText("Новая запись добавлена");
            waitNew = false;
        } else {
            model.updateSim(newSim);
            commentAres.setText("Запись обновлена");
        }
    }

    @FXML
    public void deleteSim(ActionEvent event) {
        String simToDelete = tfNumber.getText();
        model.deleteSimByNumber(simToDelete);
    }

    void updateSimcardInfo() {
        System.out.println("updateSimcardInfo()");
        SimCard card = model.getRandomSim();
        tfNumber.setText(card.getPhoneNumber());
        tfNickname.setText(card.getNickName());
        tfOperator.setText(card.getOperatorName());
        tfOwner.setText(card.getOwnerName());
        tfBalance.setText(String.valueOf(card.getBalance()));
        tfTariff.setText(card.getTariffName());
        tfLastDate.setText(String.valueOf(StringUtils.dataToIntConverter(card.getLastUsedDate())));
//        tfNumber.setDisable(true);
    }


    void setModel(Model model) {
        this.model = model;
    }

}
