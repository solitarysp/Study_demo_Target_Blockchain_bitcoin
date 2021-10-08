public class UtilsBlockChainBitcoin {
    public static String addToHexadecimalTo64(String data) {
        int numberAdd = 64 - data.length();
        for (int i = 0; i < numberAdd; i++) {
            data = "0" + data;
        }
        return data;
    }
}
