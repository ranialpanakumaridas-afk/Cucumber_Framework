@tag
Feature: Admin login functinality as Admin is user with valid data
@Validdata
Scenario: validate with valid testdata
Given  The url is lunch with "http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login".
Then  the url is luched the login button should display in home page
When  i enter the credentials username "Admin"
And  password is "Qedge123!@#"
When i click on loginin button
Then i verify the login successfully 
When i close the browser