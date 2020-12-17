#!/usr/bin/python

import cgi, cgitb 
import pymysql

cgitb.enable()
form = cgi.FieldStorage() 

song = form.getvalue('song')
cc_number = form.getvalue('cc_number')

print "Content-type:text/html\r\n\r\n"
print "<html>"
print "<head>"
print "<title>JukeBox Transaction</title>"
print "</head>"
print "<body>"
print "Song you select: %s" % (song)
print "<br>"
print "Credit card Number is: %s" % (cc_number)
print "</body>"
print "</html>"

db = pymysql.connect("localhost","root","password","JUKEBOX" )

cursor = db.cursor()

sql = """INSERT INTO TRANSACTION (song, cc_number) 
      VALUES (%s, %s)""" 
val = (song, cc_number)

try:
   cursor.execute(sql, val)
   db.commit()
except:
   db.rollback()

db.close()

