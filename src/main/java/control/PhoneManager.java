package control;

class PhoneManager {

    private Modem modem;

    PhoneManager() {
        this.modem = new Modem("Qualcomm");
    }


    String ussdRequest(String command) {
        String answer = modem.sendRequest(command);
        if (!answer.equals("")) {
            return answer;
        } else {
            return null;
        }
    }
}
