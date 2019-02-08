package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
    public static int dataToIntConverter(Date lastUsedDate) {
        String strDate = new SimpleDateFormat("yyyyMMdd").format(lastUsedDate);
        return Integer.parseInt(strDate);
    }

    public static Date intToDataConverter(int lastUsedDate) {
        String formattedDate = String.valueOf(lastUsedDate);
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
