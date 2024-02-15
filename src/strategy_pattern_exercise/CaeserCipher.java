package strategy_pattern_exercise;

public class CaeserCipher implements CipherStrategy {

    @Override
    public String encode(String input) {
        /*
        implement a caesar cipher here - where letters are shifted along x number of values in alphabet
        x can be whatever you like
        If you go beyond the end of the alphabet, you should wrap back around to the front
        e.g. 'z' on a cipher with a shift of 2 should become 'b'
         */
        int shift = 2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isLetter(currentChar)) {
                int offset = Character.isUpperCase(currentChar) ? 65 : 97;
                char ch = (char)(((int)currentChar + shift - offset) % 26 + offset);
                result.append(ch);
            } else if (Character.isDigit(currentChar)) {
                char ch = (char)(((int)currentChar + shift - 48) % 10 + 48);
                result.append(ch);
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
}
