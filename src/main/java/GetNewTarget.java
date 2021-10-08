import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

// Tạo mới start
public class GetNewTarget {

    static int bitTargetStart = 486604799; // bitTarget start block // Đây là bits của độ khó đầu tiên
    static final BigDecimal hexadecimalStartTarget = getHexaTargetBigDecimal(bitTargetStart);

    public static void main(String[] args) {
        int bits = 403108008; // bits chung của khoảng block này
        Integer first = 1457133956;// bits = 403,108,008   block index = 401184
        Integer last  = 1457291885;// bits = 403,108,008   block index = 403199
        Integer actual = last - first; //tính số lượng seconds giữa 2 thời điểm của block
        Integer expected = 2016 * 10 * 60; // Tính số thời gian mong muốn của 2016 block

        BigDecimal currentTarget = getHexaTargetBigDecimal(bits);

        System.out.println("Difficulty old: " + hexadecimalStartTarget.divide(currentTarget, 2,
                RoundingMode.HALF_UP));

        float ratio = actual.floatValue() / expected.floatValue(); // Tỉ lệ thay đổi.
        System.out.println("Tỉ lệ thay đổi: " + ratio);
        // Tối đa 1 lần thay đổi gâp 4 lần,không thay đổi quá đột biến
        if (ratio > 4) {
            ratio = 4;
        }
        if (ratio < 0.25f) {
            ratio = 0.25f;
        }

        BigDecimal newTarget = currentTarget.multiply(new BigDecimal(ratio));
        // new difficulty = currentTarget * (actual time / expected time)

        // Nếu vượt quá max thì  = max = 1
        BigDecimal maxTarget = new BigDecimal(new BigInteger("00000000ffff0000000000000000000000000000000000000000000000000000", 16));
        if (newTarget.compareTo(maxTarget) > 0) {
            newTarget = maxTarget;
        }

        String hexadecimalCurrentTarget = newTarget.toBigInteger().toString(16);
        // Tiến hành cắt chỉ lấy 5 ký tự đầu tiên
        System.out.println(hexadecimalCurrentTarget + "   full");

        String dataKeep = hexadecimalCurrentTarget.substring(0, 5);

        String officialTarget = dataKeep + hexadecimalCurrentTarget.substring(dataKeep.length()).replaceAll("(?s).", "0");
        String newTargetFull = UtilsBlockChainBitcoin.addToHexadecimalTo64(officialTarget);

        System.out.println("new target: " + newTargetFull);

        //  Difficulty start in block 1 / CurrentTarget new
        System.out.println("Difficulty new: " + hexadecimalStartTarget.divide(new BigDecimal(new BigInteger(newTargetFull,
                        16)), 2,
                RoundingMode.HALF_UP));

    }


    private static BigDecimal getHexaTargetBigDecimal(int bitTarget) {
        String hex = Integer.toHexString(bitTarget);
        int index = Integer.parseInt(hex.substring(0, 2), 16);
        int number = Integer.parseInt(hex.substring(2, hex.length()), 16);

        int temp = (8 * (index - 3));

        BigDecimal bigDecimal = new BigDecimal(number);
        BigDecimal target = bigDecimal.multiply(new BigDecimal(2).pow(temp));
        return target;
    }
}
