# HW2 : Find all numbers and get the sum. Expected 71 values and total ends in '77'
import re

print '\nLong Form Versions:', '\n================================='
document = open('regex_sum_256884.txt')
complete_list = list()
for line in document :
    list = re.findall('[0-9]+', line)
    if len(list) > 0 : 
        for elem in list :
            complete_list.append(int(elem))
            
print len(complete_list), 'values were found on the provided text!'
print sum(complete_list), 'is the sum of all the numbers!'

print '\nCompact Versions:', '\n================================='
print len([ int(n) for n in re.findall('[0-9]+', open('regex_sum_256884.txt').read()) ]), 'values were found on the provided text!' 
print sum([ int(n) for n in re.findall('[0-9]+', open('regex_sum_256884.txt').read()) ]), 'is the sum of all the numbers!\n'