@tag
Feature:
@Addemp
Scenario Outline:
validate add em with multiple data
Given  The url is lunch with "http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login".
Then  the url is luched the login button should display in home page
When  i enter the credentials username "Admin"
And  password is "Qedge123!@#"
When i click on loginin button
When i  navigating to add emp page in pim
When user enter fname as "<FirstName>"
When user enter mname as "<MiddleName>"
When user enter lname as "<LastName>"
When user capture emp id
When  i clicked savebutton
Then verify empid in table
When i close the browser 
Examples:
|FirstName|MiddleName|LastName|
|aju|ranga8|test|
|aju1|ranga9|test|
|aju2|ranga10|test|
|akila|ranga1|test|
|akila1|ranga2|test|
|akila2|ranga3|test|
|akila3|ranga4|test|
|akila4|ranga5|test|
|akila5|ranga6|test|
|akila6|ranga7|test|