
#include <cmath>
#include <string>
using namespace std;

class Solution {

    inline static int MODULO_VALUE = pow(10, 9) + 7;

public:
    int numSub(const string& input) const {
        long long countOnes = 0;
        long long numberOfSubstringsContainingOnlyOnes = 0;

        for (auto& digit : input) {
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

        return numberOfSubstringsContainingOnlyOnes;
    }

private:
    long long sumMembersOfArithmeticProgressionWithFirstMemberOfOneAndStepOfOne(long long totalMembers) const {
        return ((totalMembers + 1) * totalMembers) / 2;
    }
};
