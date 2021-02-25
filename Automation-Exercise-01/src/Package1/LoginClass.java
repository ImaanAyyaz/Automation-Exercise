package Package1;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginClass {

	public static void main(String[] args) throws InterruptedException {
		
		        // Create Driver Object first
		
				System.setProperty("webdriver.chrome.driver","D:\\OLD_PC_DATA\\libs\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
				driver.manage().window().maximize();
		
				// 01-Sign in with credentials
				
				driver.findElement(By.xpath("//input[@id = 'txtUsername']")).sendKeys("Admin");
				driver.findElement(By.xpath("//input[@id = 'txtPassword']")).sendKeys("admin123");
				driver.findElement(By.xpath("//input[@id = 'btnLogin']")).click();
				System.out.println("Login Successfully");
				Thread.sleep(2000);
				
				//02-Create an Employee
				
				driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
				driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
				
				driver.findElement(By.cssSelector("input[id = 'firstName']")).sendKeys("Imaan");
				driver.findElement(By.cssSelector("input[id = 'lastName']")).sendKeys("Ayyaz");
				driver.findElement(By.xpath("//input[@id = 'employeeId']")).sendKeys("252");
				
			
				//WebElement upload= driver.findElement(By.xpath("//input[@id = 'photofile']"));
				//upload.click();
				//upload.sendKeys("C:\\Users\\ayyazi\\Pictures\\profilepic"); //Uploading the file using sendKeys
				//System.out.println("File is Uploaded Successfully");
				
				driver.findElement(By.cssSelector("input[id='chkLogin']")).click();
				System.out.println(driver.findElement(By.cssSelector("input[id='chkLogin']")).isSelected());
				driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("adminimaanayyaz2");
				driver.findElement(By.xpath("//input[@id = 'user_password']")).sendKeys("R@90W@UBBfq@");
				driver.findElement(By.xpath("//input[@id = 're_password']")).sendKeys("R@90W@UBBfq@");
				WebElement staticdropdown = driver.findElement(By.id("status"));
			    Select dropdown = new Select(staticdropdown);
			    dropdown.selectByIndex(0);
			    System.out.println(dropdown.getFirstSelectedOption().getText());
			    dropdown.selectByVisibleText("Enabled");
			    driver.findElement(By.cssSelector("input[id='btnSave']")).click();
			    System.out.println("Employee created successfully");
				
				//03-Verify Employee is created and it shows in Employee list
				
			    driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
			    driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
			    driver.findElement(By.xpath("//input[@id='empsearch_id']")).sendKeys("031252");
			    driver.findElement(By.cssSelector("input[id='searchBtn']")).click();
			    System.out.println("Employee Found successfully");
			    
			    //04-Delete the Employee
			    
			    driver.findElement(By.cssSelector("input[id='ohrmList_chkSelectRecord_94']")).click();
				System.out.println(driver.findElement(By.cssSelector("input[id='ohrmList_chkSelectRecord_94']")).isSelected());
				driver.findElement(By.cssSelector("input[id='btnDelete']")).click();
			    driver.findElement(By.cssSelector("input[id='dialogDeleteBtn']")).click();
				System.out.println("Employee Deleted successfully");
				
				//05-Verify Employee deleted from Employee List
				
			    driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
			    driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
				driver.findElement(By.xpath("//input[@id='empsearch_id']")).sendKeys("031252");
			    driver.findElement(By.cssSelector("input[id='searchBtn']")).click();
			    Thread.sleep(2000);
			    WebElement message = driver.findElement(By.xpath("//td[contains(text(),'No Records Found')]"));
			    message.getText();
			    System.out.println("Deleted user is not Found");
			    
		       
				
	}

}
