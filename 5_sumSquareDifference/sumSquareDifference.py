# -*- coding: utf-8 -*-
# The square of sums of of a set of nummbers, say a,b,c, and d, is equal to the sum of squares
# (call it f) plus two times the sum of all permutations of two numbers (e.g., the square of sums
# is equal to f + 2(ab + ac + ad + bc + bd + cd), so the difference is 2(ab + ac + ad + bc + bd + cd))


# for the set nums=[a,b,c,d], this method ultimately returns ((ab+ac+ad)+(bc+bd)+(cd)) =
# ((a*(b+c+d) + b*(c+d) + c*(d))
def sumCombinations(nums):
    retval = 0;
    if(len(nums) > 2):
        head = nums[0]
        tail = nums[1:]
        sum = 0
        for n in tail:
            sum += n
        return sum*head + sumPermutations(tail)
    elif(len(nums) == 2):
        return nums[0]*nums[1]
    else:
        return nums[0]

nums = []

# Build set of integers from 1 to n
for i in range(100):
    nums.append(i+1)

# Calculate sum of squares
f = 0;
for n in nums:
    f += n*n
print "sum of squares:", f

# The difference between the square of sums of a set and the sum of squares of the set is 2 times the sum of all
# permutations of any two elements of the set (see above comment).
diff = 2*sumPermutations(nums)
print "square of sums:",f+diff
print "diff:",diff
