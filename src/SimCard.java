import java.util.Date;

public class SimCard {
    private String phoneNumber;
    private String nickName;
    private String operatorName;
    private String ownerName;
    private double balance;
    private String tariffName;
    private Date lastUsedDate;

    private SimCard(Builder builder) {
        setPhoneNumber(builder.phoneNumber);
        setNickName(builder.nickName);
        setOperatorName(builder.operatorName);
        setOwnerName(builder.ownerName);
        setBalance(builder.balance);
        setTariffName(builder.tariffName);
        setLastUsedDate(builder.lastUsedDate);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public Date getLastUsedDate() {
        return lastUsedDate;
    }

    public void setLastUsedDate(Date lastUsedDate) {
        this.lastUsedDate = lastUsedDate;
    }


    public static final class Builder {
        private String phoneNumber;
        private String nickName;
        private String operatorName;
        private String ownerName;
        private double balance;
        private String tariffName;
        private Date lastUsedDate;

        Builder() {
        }

        Builder phoneNumber(String val) {
            phoneNumber = val;
            return this;
        }

        Builder nickName(String val) {
            nickName = val;
            return this;
        }

        Builder operatorName(String val) {
            operatorName = val;
            return this;
        }

        Builder ownerName(String val) {
            ownerName = val;
            return this;
        }

        Builder balance(double val) {
            balance = val;
            return this;
        }

        Builder tariffName(String val) {
            tariffName = val;
            return this;
        }

        Builder lastUsedDate(Date val) {
            lastUsedDate = val;
            return this;
        }

        SimCard build() {
            return new SimCard(this);
        }
    }

    @Override
    public String toString() {
        return "SimCard{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", nickName='" + nickName + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                ", tariffName='" + tariffName + '\'' +
                ", lastUsedDate=" + lastUsedDate +
                '}';
    }
}
