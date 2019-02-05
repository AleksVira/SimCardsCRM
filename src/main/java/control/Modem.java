package control;

class Modem {

    Modem(String modemName) {
        this.modemName = modemName;
    }

    private String modemName;

    String sendRequest(String command) {
        return "test_string";
    }
}
