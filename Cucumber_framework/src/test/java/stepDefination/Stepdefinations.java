package stepDefination;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Stepdefinations {
	WebDriver driver;
	String emp_id ="";
	int count;
	@Before
	@Given("The url is lunch with {string}.")
	public void the_url_is_lunch_with(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url); // here we are passing the arguments
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Then("the url is luched the login button should display in home page")
	public void the_url_is_luched_the_login_button_should_display_in_home_page() {

		String loginbuttontext = driver.findElement(By.id("btnLogin")).getText();

		if(driver.findElement(By.id("btnLogin")).isDisplayed()){
			System.out.println(" the login button is displayed" + loginbuttontext);
		}
	}

	@When("i enter the credentials username {string}")
	public void i_enter_the_credentials_username(String user) {
		driver.findElement(By.name("txtUsername")).sendKeys(user);

	}

	@When("password is {string}")
	public void password_is(String password) {
		driver.findElement(By.name("txtPassword")).sendKeys(password);
	}

	@When("i click on loginin button")
	public void i_click_on_loginin_button() {
		driver.findElement(By.name("Submit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	}

	@Then("i verify the login successfully")
	public void i_verify_the_login_successfully() {

		String ExpectedURl= "dashboard";
		String Actual = driver.getCurrentUrl();

		if(Actual.contains(ExpectedURl)) {
			System.out.println("Login success");
		}
		else {
			String errormessage = driver.findElement(By.id("spanMessage")).getText();
			System.out.println(errormessage +"the login fail");
		}
	}
	@When("i  navigating to add emp page in pim")
	public void i_navigating_to_add_emp_page_in_pim() {
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
	}

	@When("user enter fname as {string}")
	public void user_enter_fname_as(String fname) {
		driver.findElement(By.name("firstName")).sendKeys(fname);
	}

	@When("user enter mname as {string}")
	public void user_enter_mname_as(String mname) {
		driver.findElement(By.name("middleName")).sendKeys(mname);
	}

	@When("user enter lname as {string}")
	public void user_enter_lname_as(String lname) {
		driver.findElement(By.name("lastName")).sendKeys(lname);
	}

	@When("user capture emp id")
	public void user_capture_emp_id() {
		emp_id= driver.findElement(By.name("employeeId")).getAttribute("value");//get attribute is for runtime value
		System.out.println(emp_id + "This is Employe id");
	}

	@When("i clicked savebutton")
	public void i_clicked_savebutton() {
		driver.findElement(By.id("btnSave")).click();
	}

	@Then("verify empid in table")
	public void verify_empid_in_table() {
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
		//wait for the element to visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empsearch_id")));

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("empsearch_id")).sendKeys(emp_id);
		driver.findElement(By.id("searchBtn")).click();
		//wait for the table to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tableWrapper")));

		WebElement webtable = driver.findElement(By.id("tableWrapper"));
		List<WebElement> rows = webtable.findElements(By.tagName("tr"));

		boolean found= false;
		for(int i=1;i<=rows.size();i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td")); //col collection

			if(cols.get(i).getText().equals(emp_id)) {
				found=true;
				break;

			}

		}
		if(found) {
			System.out.println("emp id found in table");
		}
		else {
			System.out.println("emp id NOTfound in table");
		}

	}



	@After
	@When("i close the browser")
	public void i_close_the_browser() {
		driver.quit();
	}



}
