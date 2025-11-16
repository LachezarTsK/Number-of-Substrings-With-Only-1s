
import kotlin.math.pow

class Solution {

    private companion object {
        val MODULO_VALUE = (10.0).pow(9).toInt() + 7
    }

    fun numSub(input: String): Int {
        var countOnes: Long = 0
        var numberOfSubstringsContainingOnlyOnes: Long = 0

        for (digit in input) {
            if (digit == '1') {
                ++countOnes
                continue
            }

            numberOfSubstringsContainingOnlyOnes =
                        (numberOfSubstringsContainingOnlyOnes +
                        sumMembersOfArithmeticProgressionWithFirstMemberOfOneAndStepOfOne(countOnes)) %
                        MODULO_VALUE
            countOnes = 0
        }

        numberOfSubstringsContainingOnlyOnes =
                    (numberOfSubstringsContainingOnlyOnes +
                    sumMembersOfArithmeticProgressionWithFirstMemberOfOneAndStepOfOne(countOnes)) %
                    MODULO_VALUE

        return numberOfSubstringsContainingOnlyOnes.toInt()
    }

    private fun sumMembersOfArithmeticProgressionWithFirstMemberOfOneAndStepOfOne(totalMembers: Long): Long {
        return ((totalMembers + 1) * totalMembers) / 2
    }
}
