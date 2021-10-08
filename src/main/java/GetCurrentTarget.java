import java.math.BigDecimal;

public class GetCurrentTarget {
    public static void main(String[] args) {
        // là trường dữ liệu bits trong block
        int bitTarget = 386803250;
        String hexadecimalBitTarget = Integer.toHexString(bitTarget);

        int index = Integer.parseInt(hexadecimalBitTarget.substring(0, 2), 16);
        int number = Integer.parseInt(hexadecimalBitTarget.substring(2, hexadecimalBitTarget.length()), 16);

        int temp = (8 * (index - 3));

        BigDecimal bigDecimal = new BigDecimal(number);
        BigDecimal currentTarget = bigDecimal.multiply(new BigDecimal(2).pow(temp));
        System.out.println("current target: " + currentTarget);

        String hexadecimalCurrentTarget = currentTarget.toBigInteger().toString(16);
        System.out.println("hexadecimalCurrentTarget: " + hexadecimalCurrentTarget);

    }

}
