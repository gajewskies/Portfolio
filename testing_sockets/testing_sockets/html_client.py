import httplib

conn = httplib.HTTPConnection("127.0.0.1", 3000)
conn.request("GET", "/")
r1 = conn.getresponse()
data1 = r1.read()
print data1
print(r1.status, r1.reason)

conn.close()
