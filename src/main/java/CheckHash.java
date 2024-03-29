import java.math.BigDecimal;
import java.math.BigInteger;

public class CheckHash {
    public static void main(String[] args) {
        //2 điều kiện đểu 1 hash đc chấp nhận
        //1: Số lượng số 0 ở đầu phải nhiều hơn hoặc = với target
        //2: DecimalData của hash phải nhỏ hơn hoặc = DecimalData của target
        int bitTarget = 386803250;
        String hashCheck = "0000000000000000000193d0666a165edb6dacdc64fdeb6f752a13e532c5509e";

        String hex = Integer.toHexString(bitTarget);
        int index = Integer.parseInt(hex.substring(0, 2), 16);
        int number = Integer.parseInt(hex.substring(2, hex.length()), 16);

        int temp = (8 * (index - 3));

        BigDecimal bigDecimal = new BigDecimal(number);
        BigDecimal currentTarget = bigDecimal.multiply(new BigDecimal(2).pow(temp));
        System.out.println("current target: " + currentTarget);

        String hexadecimalCurrentTarget = currentTarget.toBigInteger().toString(16);
        System.out.println("hexadecimalCurrentTarget: " + hexadecimalCurrentTarget);

        // -1 , 0 là nhỏ hơn hoặc =
        // 1 là lớn hơn
        BigDecimal bigDecimalHashCheck = new BigDecimal(new BigInteger(hashCheck, 16));
        System.out.println("hashData:       "+bigDecimalHashCheck);
        System.out.println("hashData check với độ khó là: " + (currentTarget.compareTo(bigDecimalHashCheck) >= 0));
    }
}
