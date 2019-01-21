import java.util.Date;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Hello, Sim!");
        SimCard testCard = new SimCard.Builder().phoneNumber("+79281800000").nickName("18-01").operatorName("Мегафон").ownerName("Алекс").balance(100.0).tariffName("Страна").lastUsedDate(new Date()).build();

        System.out.println(testCard.toString());




    }
}
