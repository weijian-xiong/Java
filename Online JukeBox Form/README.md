# Description:
1: Implemented a online JukeBox form to get user's song selection and payment information, store into MySQL database.<br>
2: Implemented shell script to conduct DOS Attack a web form with/without reCAPTCHA.<br>
3: Do a cron job to run DOS attack shell script automatically.<br>
4: Conduct DOS attack by using Selenium IDE and Google WebDriver.

## How to run
1. First of all, create a directory called "html"<br>
2. Open terminal to create a local python server
<img width="598" alt="1" src="https://user-images.githubusercontent.com/24274444/101846273-3e91e480-3b16-11eb-81e3-b1d02da65c6f.png">

3. Open another terminal to access mysql database
4. Type this command: 
```
mysql -u root -p
```

5. After you login as root, create a database called "JUKEBOX",
```
CREATE DATABASE JUKEBOX;
```

6. And create a table called "TRANSACTION",
```
CREATE TABLE `TRANSACTION` (
  `song` varchar(10) DEFAULT NULL,
  `cc_number` varchar(20) DEFAULT NULL);
  ```

7. Now we have an empty table
<img width="682" alt="2" src="https://user-images.githubusercontent.com/24274444/101846276-3fc31180-3b16-11eb-8042-704df1dc2472.png">

8. Then go to your browser to the URL”127.0.0.1:8000”, you will see this page
<img width="623" alt="3" src="https://user-images.githubusercontent.com/24274444/101846278-405ba800-3b16-11eb-992a-d75edb64e4fd.png">

9. Click jukebox_without_reCAPTCHA.html file, you will see the jukebox form.
<img width="949" alt="4" src="https://user-images.githubusercontent.com/24274444/101846280-40f43e80-3b16-11eb-8f94-e62a4ab97679.png">

10. After you select song number, type your credit card number and press submit, it will display your information like this.
<img width="1172" alt="5" src="https://user-images.githubusercontent.com/24274444/101846281-40f43e80-3b16-11eb-9531-56c13dd97e25.png">

11. Now go to your database, your information stored successfully.
<img width="682" alt="6" src="https://user-images.githubusercontent.com/24274444/101846282-418cd500-3b16-11eb-8afd-efa0ff7324f7.png">

12. Run “bash dos_without_reCAPTCHA.sh” to conduct a DOS Attack.
<img width="1060" alt="7" src="https://user-images.githubusercontent.com/24274444/101846283-418cd500-3b16-11eb-995b-8888b017f64a.png">

13. Shell script automatically read song number and credit card number from info.txt and fill this jukebox form.
<img width="317" alt="17" src="https://user-images.githubusercontent.com/24274444/101846301-46518900-3b16-11eb-8332-06aea69f6ac8.png">

It's clearly to see it’s easy to be DOS attacked for some simple web forms.
<img width="682" alt="8" src="https://user-images.githubusercontent.com/24274444/101846285-42be0200-3b16-11eb-8ec7-4431dc2468fb.png">

14. Let's add reCAPTCHA to prevent from DOS Attack:
<img width="1061" alt="9" src="https://user-images.githubusercontent.com/24274444/101846286-42be0200-3b16-11eb-9e88-44582914873e.png">

15. You have to pass the reCAPTCHA verification to make sure you are not a robot.
<img width="1061" alt="10" src="https://user-images.githubusercontent.com/24274444/101846287-43569880-3b16-11eb-8c39-4c2e8de52a07.png">

<img width="1061" alt="11" src="https://user-images.githubusercontent.com/24274444/101846288-43ef2f00-3b16-11eb-9a9b-e67ad79d70da.png">

16. It tells you reCAPTCHA succeed. Now your form has been stored to database.
<img width="1361" alt="12" src="https://user-images.githubusercontent.com/24274444/101846292-4487c580-3b16-11eb-9e9f-c10e1a22e4c8.png">

<img width="682" alt="13" src="https://user-images.githubusercontent.com/24274444/101846293-4487c580-3b16-11eb-9bf4-20c4f7254500.png">

17. Now, let’s try DOS attack one more time.
<img width="1032" alt="14" src="https://user-images.githubusercontent.com/24274444/101846297-45205c00-3b16-11eb-9d33-0543b203e061.png">

18. It tells you reCAPTCHA failed.
<img width="808" alt="16" src="https://user-images.githubusercontent.com/24274444/101846300-46518900-3b16-11eb-8da5-5817d4e05d99.png">

19. And database didn’t allow any new data modification from DOS attack
<img width="458" alt="15" src="https://user-images.githubusercontent.com/24274444/101846298-45b8f280-3b16-11eb-8d13-84f9be8a9f2f.png">

20.reCAPTCHA prevents you from DOS attack !!!

## Register reCAPTCHA:
https://www.google.com/recaptcha/admin/create<br>
If you use local server, add “127.0.0.1” and “localhost” to your domains.

## Cron Job
Open terminal and type this to schedule a cron job.<br>
```
crontab -e
```
Add this to the opening window
```
*/10 * * * * sh ~/path/to/dos_without_reCAPTCHA.sh
```
In my case, cron job will run "dos_without_reCAPTCHA.sh" every 1o mins every day.

[Cron job format](https://support.acquia.com/hc/en-us/articles/360004224494-Cron-time-string-format)<br>

Remove cron job.
```
crontab -r
````

## Selenium IDE
Download Selenium IDE for Chrome from this [URL](https://chrome.google.com/webstore/detail/selenium-ide/mooikfkahbdckldjjndioackbalphokd?hl=en)<br>

Let's open terminal and start python server first:
```
python3 -m http.server --cgi
```

Then click extension on Chrome browser:
<img width="898" alt="1" src="https://user-images.githubusercontent.com/24274444/101849933-58cfc080-3b1e-11eb-80c6-40b04c807fe0.png">

Let’s record a new project and name it "DOS-Attack":
<img width="898" alt="2" src="https://user-images.githubusercontent.com/24274444/101849937-5a00ed80-3b1e-11eb-9eb6-dae7272702c4.png">

Next create a new test case:
<img width="898" alt="3" src="https://user-images.githubusercontent.com/24274444/101849940-5a998400-3b1e-11eb-956e-62a1e0e786be.png">

Next, it will ask you a test URL, in my case is "http://localhost:8000/jukebox_without_reCAPTCHA.html"<br>
<img width="956" alt="4" src="https://user-images.githubusercontent.com/24274444/101849942-5a998400-3b1e-11eb-8394-285b87f9868b.png">

It will jump a new window like this, on the right corner it says Selenium IDE is recording... <br>
<img width="1011" alt="5" src="https://user-images.githubusercontent.com/24274444/101849944-5b321a80-3b1e-11eb-8f9f-5a7103db5d62.png">
<img width="1226" alt="6" src="https://user-images.githubusercontent.com/24274444/101849945-5bcab100-3b1e-11eb-858d-8d4d5c4bb6a8.png">

Go back to Selenium IDE extension to stop recording.<br>
<img width="956" alt="7" src="https://user-images.githubusercontent.com/24274444/101849949-5bcab100-3b1e-11eb-8625-418d597c2e63.png">

You will see something like this which is your click steps.<br>

Now click "Run test" to replay your click on your page. <br>
<img width="956" alt="8" src="https://user-images.githubusercontent.com/24274444/101849951-5c634780-3b1e-11eb-84b3-e98f920ed023.png">

After we run test case several times, we can see that database adds 4 records due to our DOS attack by using Selenium.<br>
<img width="242" alt="9" src="https://user-images.githubusercontent.com/24274444/101849954-5c634780-3b1e-11eb-8f45-045a1af03efd.png">

