
using System;

public class Solution
{
    private static readonly int MODULO_VALUE = (int)Math.Pow(10, 9) + 7;
    public int NumSub(string input)
    {
        long countOnes = 0;
        long numberOfSubstringsContainingOnlyOnes = 0;

        foreach (char digit in input)
        {
            if (digit == '1')
            {
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

        return (int)numberOfSubstringsContainingOnlyOnes;
    }

    private long sumMembersOfArithmeticProgressionWithFirstMemberOfOneAndStepOfOne(long totalMembers)
    {
        return ((totalMembers + 1) * totalMembers) / 2;
    }
}
