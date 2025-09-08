package DSA.Strings;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {

        String s = s = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(s));

    }

    public static boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        // O(n^2)
//         for (int i=n/2; i>=1; i--) {
//             if (n%i == 0 && s.substring(0, i).repeat(n/i).equals(s))
//                 return true;
//         }
//         return false;

        // O(n^2)
//        StringBuilder sb = new StringBuilder();
//
//        for (int i=n/2; i>=1; i--) {
//            if (n % i == 0) {
//                for (int j = 0; j < n / i; j++) {
//                    sb.append(s.substring(0, i));
//                }
//                if (s.equals(sb.toString()))
//                    return true;
//            }
//        }
//        return false;

        // O(n)
        String concat = s+s;
        return concat.substring(1, concat.length() - 1).contains(s);
    }
}
