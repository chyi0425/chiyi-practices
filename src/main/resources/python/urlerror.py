import urllib2

request = urllib2.Request('http://www.xxxxxx.com')
try:
	urllib2.urlopen(request)
	print 'ttttt'
except urllib2.URLError, e:
	print e.reason