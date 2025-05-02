package challenges;

public class Problem1 {

    public static String decodePassword(String encodedPassword, int luckyNumber) {
        StringBuilder decoded = new StringBuilder();

        for (char c : encodedPassword.toCharArray()) {
            if (Character.isLowerCase(c)) {
                int originalIndex = c - 'a';
                int shiftedIndex = (originalIndex + luckyNumber) % 26;

                // Handle negative wrap-around
                if (shiftedIndex < 0) {
                    shiftedIndex += 26;
                }

                char decodedChar = (char) ('a' + shiftedIndex);
                decoded.append(decodedChar);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }

}
