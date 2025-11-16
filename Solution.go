
package main
import "math"

var MODULO_VALUE = int64(math.Pow(10.0, 9.0)) + 7

func numSub(input string) int {
    var countOnes int64 = 0
    var numberOfSubstringsContainingOnlyOnes int64 = 0

    for _, digit := range input {
            if digit == '1' {
                countOnes++
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

    return int(numberOfSubstringsContainingOnlyOnes)
}

func sumMembersOfArithmeticProgressionWithFirstMemberOfOneAndStepOfOne(totalMembers int64) int64 {
    return ((totalMembers + 1) * totalMembers) / 2
}
