import java.math.BigDecimal;
import java.math.RoundingMode;

public class GetDifficulty {
    public static void main(String[] args) {

        int bitTargetStart = 486604799;
        BigDecimal hexadecimalStartTarget = getHexaTargetBigDecimal(bitTargetStart);

        int bitCurrentTarget = 386803250;
        BigDecimal hexadecimalCurrentTarget = getHexaTargetBigDecimal(bitCurrentTarget);

        System.out.println(hexadecimalStartTarget.divide(hexadecimalCurrentTarget,2, RoundingMode.HALF_UP));

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
