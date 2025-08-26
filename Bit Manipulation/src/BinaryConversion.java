public class BinaryConversion {

    public static String convert2Binary(int n)
    {
        StringBuilder res = new StringBuilder();
        while(n != 0)
        {
            if(n%2==1) res.append('1');
            else res.append('0');
            n = n/2;
        }
        return res.reverse().toString();



        // if no stringBuilder   (overflows int value if no is large)
//        int ans = 0, pow = 1;
//        while (n != 0) {
//            int last = n % 2;
//            ans += last * pow;
//            pow *= 10;
//            n /= 2;
//        }
//        return ans;
    }

    public static int convert2Decimal(String s)
    {
        int num = 0, power2 = 1;

        for(int i=s.length()-1; i>=0; i--)
        {
            if(s.charAt(i) == '1') num = num+power2;
            power2 = power2 * 2;
        }
        return num;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println("Decimal to Binary : "+convert2Binary(n));
        System.out.println("Binary to Decimal : "+convert2Decimal(convert2Binary(n)));

    }
}