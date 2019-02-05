package repository;

public interface DbManager {

    boolean createNewRecord(SimCard card);

    SimCard readRecordByPhoneNumber(String phoneNumber);

    SimCard readRecordByNickname(String nickname);

    boolean updateRecordByPhoneNumber(SimCard simCard);

    boolean deleteRecordByPhoneNumber(String phoneNumber);

    boolean deleteRecordByNickname(String Nickname);



}
