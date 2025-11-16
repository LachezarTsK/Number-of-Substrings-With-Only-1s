
public class Solution {

    private static final int MODULO_VALUE = (int) Math.pow(10, 9) + 7;

    public int numSub(String input) {
        long countOnes = 0;
        long numberOfSubstringsContainingOnlyOnes = 0;

        for (char digit : input.toCharArray()) {
            if (digit == '1') {
                ++countOnes;
                continue;
            }

            numberOfSubstringsContainingOnlyOnes
                    = (numberOfSubstringsContainingOnlyOnes
                    + sumMembersOfArithmeticProgressionWithFirstMemberOfOneAndStepOfOne(countOnes))
                    % MODULO_VALUE;
            countOnes = 0;
        }

        numberOfSubstringsContainingOnlyOnes
                = (numberOfSubstringsContainingOnlyOnes
                + sumMembersOfArithmeticProgressionWithFirstMemberOfOneAndStepOfOne(countOnes))
                % MODULO_VALUE;

        return (int) numberOfSubstringsContainingOnlyOnes;
    }

    private long sumMembersOfArithmeticProgressionWithFirstMemberOfOneAndStepOfOne(long totalMembers) {
        return ((totalMembers + 1) * totalMembers) / 2;
    }
}
