import java.math.BigDecimal;
import java.text.DecimalFormat;

public class UtilsBlockChainBitcoin {
    public static String addToHexadecimalTo64(String data) {
        int numberAdd = 64 - data.length();
        for (int i = 0; i < numberAdd; i++) {
            data = "0" + data;
        }
        return data;
    }

    public static String formatBigDecimal(BigDecimal data) {
        return new DecimalFormat("#,###.00").format(data);
    }
}
