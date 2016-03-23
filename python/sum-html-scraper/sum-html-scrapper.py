# HW4 - Scraping Numbers from HTML using BeautifulSoup
#Sample data: http://python-data.dr-chuck.net/comments_42.html (Sum=2553)
#Actual data: http://python-data.dr-chuck.net/comments_256889.html (Sum ends with 84)

import urllib
from BeautifulSoup import *

url = raw_input('Enter - ')

print 'Long Version - readable'
print '-----------------------'
html = urllib.urlopen(url).read()
soup = BeautifulSoup(html)
# Retrieve the content of the span tags
tags = soup('span')
list = list()
for tag in tags:
    # Look at the parts of a tag
    list.append(int(tag.contents[0]))
print 'Count', len(list)
print 'Sum', sum(list)

print '\nCompact Version - not very readable'
print '-----------------------------------'
print 'Count', len( [int(tag.contents[0]) for tag in BeautifulSoup(urllib.urlopen(url).read())('span')] )
print 'Sum', sum( [int(tag.contents[0]) for tag in BeautifulSoup(urllib.urlopen(url).read())('span')] )