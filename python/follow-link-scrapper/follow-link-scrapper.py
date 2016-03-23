# HW5 - Following Links in Python
#Sample problem: Start at http://python-data.dr-chuck.net/known_by_Fikret.html 
#Find the link at position 3 (the first name is 1). Follow that link. Repeat this process 4 times. The answer is the last name that you retrieve.
#Sequence of names: Fikret Montgomery Mhairade Butchi Anayah 
#Last name in sequence: Anayah

#Actual problem: Start at: http://python-data.dr-chuck.net/known_by_Kaywan.html 
#Find the link at position 18 (the first name is 1). Follow that link. Repeat this process 7 times. The answer is the last name that you retrieve.
#Hint: The first character of the name of the last page that you will load is: E


import urllib
from BeautifulSoup import *

url   = raw_input('Enter URL: ')
count = int(raw_input('Enter count: '))
pos   = int(raw_input('Enter position: '))

for index in range(0, count) :
    print 'Retrieving :', url
    url = BeautifulSoup(urllib.urlopen(url).read())('a')[pos - 1].get('href', None)
    
print 'Retrieving :', url
    
