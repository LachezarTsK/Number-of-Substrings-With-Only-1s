
/**
 * @param {string} input
 * @return {number}
 */
var numSub = function (input) {
    const  MODULO_VALUE = Math.pow(10, 9) + 7;
    let countOnes = 0;
    let numberOfSubstringsContainingOnlyOnes = 0;

    for (let digit of input) {
        if (digit === '1') {
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

    return  numberOfSubstringsContainingOnlyOnes;
};

/**
 * @param {string} totalMembers
 * @return {number}
 */
function sumMembersOfArithmeticProgressionWithFirstMemberOfOneAndStepOfOne(totalMembers) {
    return ((totalMembers + 1) * totalMembers) / 2;
}
