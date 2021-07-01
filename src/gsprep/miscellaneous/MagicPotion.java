package gsprep.miscellaneous;
/**
 * Problem Statement:
 * Hermione is preparing a cheat-sheet for her final exam in Potions class.
 * To create a potion, one must combine ingredients in a specific order, any of which may be repeated.
 * As an example, consider the following potion which uses 4 distinct ingredients
 * (A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, D
 * Hermione realizes she can save tremendous space on her cheat-sheet by introducing a
 * special instruction, *, which means repeat from the beginning.
 * Using these optimizations, Hermione is able to encode the potion above using only 6 characters: A,B,*,C,*,D
 * Your job is to write a function that takes as input an un-encoded potion and returns the
 * minimum number of characters required to encode the potion on Hermione’s Cheat Sheet.
 * <p>
 * Signature:
 * private Integer minimalSteps(String ingredients) {
 * }
 * <p>
 * Test Case:
 * Input: ABCDABCE
 * Output:8
 * <p>
 * Input: ABCABCE
 * Output: 5
 */
public class MagicPotion {
    public static void main(String[] args) {
        MagicPotion mp = new MagicPotion();
        System.out.println(mp.minimalSteps("ABABCABABCD"));
        System.out.println(mp.minimalSteps("ABCDABCE"));
        System.out.println(mp.minimalSteps("ABCABCE"));
    }

    private Integer minimalSteps(String ingredients) {
        String resultString = ingredients;
        for (int i = ingredients.length() - 1; i > 0; i--) {
            int prefixIndex = i;
            int suffix = i;
            String prefixString = ingredients.substring(0, prefixIndex);
            String suffixString = ingredients.charAt(i) + "";

            while (prefixIndex > 0 && suffix > 0) {
                if (prefixString.equals(suffixString)) {
                    String prevSuffixResult = resultString.substring(i + 1);
                    resultString = prefixString + "*" + prevSuffixResult;
                    break;
                }
                prefixIndex--;
                suffix--;
                prefixString = ingredients.substring(0, prefixIndex);
                suffixString = ingredients.substring(suffix, i + 1);
            }
        }
        return resultString.length();
    }
}
