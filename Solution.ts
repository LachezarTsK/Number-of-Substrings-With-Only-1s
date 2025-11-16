
function numSub(input: string): number {
    const MODULO_VALUE = Math.pow(10, 9) + 7;
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

    return numberOfSubstringsContainingOnlyOnes;
};

function sumMembersOfArithmeticProgressionWithFirstMemberOfOneAndStepOfOne(totalMembers: number): number {
    return ((totalMembers + 1) * totalMembers) / 2;
}
