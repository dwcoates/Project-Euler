# If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
# Find the sum of all the multiples of 3 or 5 below 1000.


multi5 = []
multi3 = []


for i in range(1000/3):
    multi3.append(i*3)
for i in range(1000/5):
    multi3.append(i*5)

for i in range(multi3):
    if(multi3[i] != multi5[i]):
print sum
