package repository;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcreteDbManager implements DbManager {

    private Connection connection() {
        Connection connection = null;
        String url = "jdbc:sqlite:SimCardsBase.db";
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    private int dataToIntConverter(Date lastUsedDate) {
        String strDate = new SimpleDateFormat("yyyyMMdd").format(lastUsedDate);
        return Integer.parseInt(strDate);
    }

    private Date intToDataConverter(int lastUsedDate) {
        String formattedDate = String.valueOf(lastUsedDate);
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean createNewRecord(SimCard card) {
        String sql = "INSERT INTO simcards(nickname, phone_number, operator_name, owner_name, balance, tariff_name, last_used_date) VALUES(?,?,?,?,?,?,?)";
        try (Connection connection = this.connection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, card.getNickName());
            pstmt.setString(2, card.getPhoneNumber());
            pstmt.setString(3, card.getOperatorName());
            pstmt.setString(4, card.getOwnerName());
            pstmt.setDouble(5, card.getBalance());
            pstmt.setString(6, card.getOwnerName());
            pstmt.setInt(7, dataToIntConverter(card.getLastUsedDate()));
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override
    public SimCard readRecordByPhoneNumber(String testPhoneNumber) {
        String sql = "SELECT nickname, phone_number, operator_name, owner_name, balance, tariff_name, last_used_date FROM simcards WHERE phone_number = ?";
        try (Connection connection = this.connection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, testPhoneNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String nickName = rs.getString("nickname");
                String operatorName = rs.getString("operator_name");
                String ownerName = rs.getString("owner_name");
                double balance = rs.getDouble("balance");
                String tariffName = rs.getString("tariff_name");
                int lastUsedDate = rs.getInt("last_used_date");
                SimCard myCard = new SimCard.Builder().phoneNumber(testPhoneNumber).
                        nickName(nickName).operatorName(operatorName).
                        ownerName(ownerName).balance(balance).
                        tariffName(tariffName).lastUsedDate(intToDataConverter(lastUsedDate)).build();
                return myCard;
            } else {
                System.out.println("Не нашел записи в БД");
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public SimCard readRecordByNickname(String nickname) {
        String sql = "SELECT nickname, phone_number, operator_name, owner_name, balance, tariff_name, last_used_date FROM simcards WHERE nickname = ?";
        try (Connection connection = this.connection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nickname);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String phoneNumber = rs.getString("phone_number");
                String operatorName = rs.getString("operator_name");
                String ownerName = rs.getString("owner_name");
                double balance = rs.getDouble("balance");
                String tariffName = rs.getString("tariff_name");
                int lastUsedDate = rs.getInt("last_used_date");
                SimCard myCard = new SimCard.Builder().phoneNumber(phoneNumber).
                        nickName(nickname).operatorName(operatorName).
                        ownerName(ownerName).balance(balance).
                        tariffName(tariffName).lastUsedDate(intToDataConverter(lastUsedDate)).build();
                return myCard;
            } else {
                System.out.println("Не нашел записи в БД");
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateRecordByPhoneNumber(SimCard simCard) {
        String sql = "UPDATE simcards SET operator_name = ?, owner_name = ?, balance = ?, tariff_name = ?, last_used_date = ? WHERE phone_number = ?";
        try (Connection connection = this.connection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, simCard.getOperatorName());
            pstmt.setString(2, simCard.getOwnerName());
            pstmt.setDouble(3, simCard.getBalance());
            pstmt.setString(4, simCard.getTariffName());
            pstmt.setInt(5, dataToIntConverter(simCard.getLastUsedDate()));
            pstmt.setString(6, simCard.getPhoneNumber());
            pstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override
    public boolean deleteRecordByPhoneNumber(String phoneNumber) {
        //Методы аналогичны, допишу
        return false;
    }

    @Override
    public boolean deleteRecordByNickname(String Nickname) {
        //Методы аналогичны, допишу
        return false;
    }
}
