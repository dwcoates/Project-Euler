# If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
# Find the sum of all the multiples of 3 or 5 below 1000.

sum = 0

for i in range(1000/3):
    multi5 = 0
    multi3 = 0

    if i <= 1000/5:
        multi5 = i*5

    if multi5 != multi3:
        sum += multi5
    sum += multi3

print sum
