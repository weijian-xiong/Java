#!/usr/bin/python

import cgi, cgitb 
import pymysql
import requests
import json

cgitb.enable()
form = cgi.FieldStorage() 

song = form.getvalue('song')
cc_number = form.getvalue('cc_number')
response = form.getvalue('g-recaptcha-response')

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

def is_human(captcha_response):
    """ Validating recaptcha response from google server
        Returns True captcha test passed for submitted form else returns False.
    """
    secret = "6LepDOMZAAAAALrcBRjwiXWEO_lDObuFojR0Q29z"
    payload = {'response':captcha_response, 'secret':secret}
    response = requests.post("https://www.google.com/recaptcha/api/siteverify", payload)
    response_text = json.loads(response.text)
    return response_text['success']

if is_human(response):
    print "<br>reCAPTCHA succeed!"
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
else:
    print "<br>reCAPTCHA failed!"
