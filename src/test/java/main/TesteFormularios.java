package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import auxiliar.ClasseAuxiliar;

public class TesteFormularios{
	private WebDriver driver;
	private ClasseAuxiliar dsl;
 
	public static void main(String args[]) {
		  JUnitCore junit = new JUnitCore();
		  junit.addListener(new TextListener(System.out));
		  Result result = junit.run(TesteFormularios.class); 
		  if (result.getFailureCount() > 0) {
		    System.out.println("Teste falhou!");
		    System.exit(1);
		  } else {
		    System.out.println("Teste executado com sucesso.");
		    System.exit(0);
		  }
		}
	
	@Before
	public void abrirBrowser() {
		//Inicia o Chrome Driver
		System.setProperty("webdriver.chrome.driver", "..\\AccentureTest\\Drivers\\chromedriver_v93.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
				
		//Abre o site
		driver.get("http://sampleapp.tricentis.com/101/app.php");
		dsl = new ClasseAuxiliar(driver);
	}
	
	@Test
	public void teste() {
		
		
		/********* Preenche o 1º formulário ("Enter Vehicle Data") *********/ 
		
		
		dsl.validaMsg(By.className("counter"), "12");		
		dsl.selectOptCombo(By.id("make"), "BMW");
		dsl.validaMsg(By.className("counter"), "11");	
		dsl.selectOptCombo(By.id("model"), "Scooter");
		dsl.validaMsg(By.className("counter"), "10");	
		dsl.inserirTexto(By.id("cylindercapacity"), "1000");
		dsl.validaMsg(By.className("counter"), "9");	
		dsl.inserirTexto(By.id("engineperformance"), "500");
		dsl.validaMsg(By.className("counter"), "8");
		dsl.inserirTexto(By.id("dateofmanufacture"), "09/01/2021");
		dsl.validaMsg(By.className("counter"), "7");	
		dsl.selectOptCombo(By.id("numberofseats"), "2");
		
		//RADIO BUTTON
		WebElement form1radio1 = driver.findElement(By.className("ideal-radio"));
		form1radio1.click();
		form1radio1.isSelected();
		
		dsl.validaMsg(By.className("counter"), "6");
		dsl.selectOptCombo(By.id("numberofseatsmotorcycle"), "2");
		dsl.validaMsg(By.className("counter"), "5");
		dsl.selectOptCombo(By.id("fuel"), "Gas");
		dsl.validaMsg(By.className("counter"), "4");
		dsl.inserirTexto(By.id("payload"), "120");
		dsl.validaMsg(By.className("counter"), "3");
		dsl.inserirTexto(By.id("totalweight"), "300");
		dsl.validaMsg(By.className("counter"), "2");
		dsl.inserirTexto(By.id("listprice"), "15000");
		dsl.validaMsg(By.className("counter"), "1");
		dsl.inserirTexto(By.id("licenseplatenumber"), "1111111111");
		dsl.inserirTexto(By.id("annualmileage"), "50000");
		dsl.validaMsg(By.className("counter"), "0");
		
		//Clica no botão "Next"
		dsl.clicarObjeto(By.id("nextenterinsurantdata"));
		
		
		/********* Preenche o 2º formulário ("Enter Insurant Data") ************/
		
		
		// Altera para a janela "Enter Insurant Data");
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		System.out.println((String)driver.getWindowHandles().toArray()[0]);
		
		//dsl.entrarFrame(By.className("idealsteps-step-active"));
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "7");
		dsl.inserirTexto(By.id("firstname"), "Maydson");
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "6");
		dsl.inserirTexto(By.id("lastname"), "Ribeiro");
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "5");
		dsl.inserirTexto(By.id("birthdate"), "09/27/1991");
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "4");
		
		//RADIO
		WebElement oRadioBtn = driver.findElement(By.xpath("//form[@id='insurance-form']/div/section[2]/div[4]/p/label/span")); 
		System.out.println(oRadioBtn);
		oRadioBtn.click();
		
		dsl.inserirTexto(By.id("streetaddress"), "Q 09 Casa 115, Setor Oeste, Gama");
		dsl.selectOptCombo(By.id("country"), "Brazil");
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "3");
		dsl.inserirTexto(By.id("zipcode"), "72425090");
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "2");
		dsl.inserirTexto(By.id("city"), "Brasilia");
		dsl.selectOptCombo(By.id("occupation"), "Employee");
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "1");
		
		// HOBBIES
		dsl.clicarObjeto(By.xpath("//form[@id='insurance-form']/div/section[2]/div[10]/p/label/span"));
		dsl.clicarObjeto(By.xpath("//form[@id='insurance-form']/div/section[2]/div[10]/p/label[3]/span"));
		dsl.clicarObjeto(By.xpath("//form[@id='insurance-form']/div/section[2]/div[10]/p/label[4]/span"));
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "0");
		
		dsl.inserirTexto(By.id("website"), "https://www.accenture.com/br-pt");
		
		//Clica no botão "Next"
		dsl.clicarObjeto(By.id("nextenterproductdata"));
		
		
		/************ Preenche o 3º formulário ("Enter Product Data") ************/
		
		
		// Altera para a aba "Enter Product Data"
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		System.out.println((String)driver.getWindowHandles().toArray()[0]);
		
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "6");
		dsl.inserirTexto(By.id("startdate"), "01/06/2022");
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "5");
		dsl.selectOptCombo(By.id("insurancesum"), "3.000.000,00");
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "4");
		dsl.selectOptCombo(By.id("meritrating"), "Bonus 6");
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "3");
		dsl.selectOptCombo(By.id("damageinsurance"), "Full Coverage");
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "2");
		
		//RADIO
		dsl.clicarObjeto(By.xpath("//form[@id='insurance-form']/div/section[3]/div[5]/p/label/span"));
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "1");

		dsl.selectOptCombo(By.id("courtesycar"), "Yes");
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "0");
		
		// Clica no botão "Next"
		dsl.clicarObjeto(By.id("nextselectpriceoption"));
		
		
		/************ Preenche o 4º formulário ("Select Price Option") ************/
		
		
		// Altera para a aba "Select Price Option"
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		System.out.println((String)driver.getWindowHandles().toArray()[0]);
		
		dsl.validaMsg(By.xpath("//a[@id='selectpriceoption']/span"), "1");
		
		// Valida a grid com as opções de  seguro:
		// Títulos
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr/td"), "Price per Year ($)");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td"), "Online Claim");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td"), "Claims Discount (%)");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td"), "Worldwide Cover");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tfoot/tr/th"), "Select Option");
		// SILVER
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/thead/tr/th[2]"), "Silver");
		dsl.validaMsg(By.xpath("//span[@id='selectsilver_price']"), "296.00");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td[2]"), "No");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td[2]"), "No");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td[2]"), "No");
		//GOLD
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/thead/tr/th[3]"), "Gold");
		dsl.validaMsg(By.xpath("//span[@id='selectgold_price']"), "872.00");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td[3]"), "Submit");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td[3]"), "2");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td[3]"), "Limited");
		//PLATINUM
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/thead/tr/th[4]"), "Platinum");
		dsl.validaMsg(By.xpath("//span[@id='selectplatinum_price']"), "1,712.00");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td[4]"), "Submit");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td[4]"), "5");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td[4]"), "Limited");
		//ULTIMATE
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/thead/tr/th[5]"), "Ultimate");
		dsl.validaMsg(By.xpath("//span[@id='selectultimate_price']"), "3,262.00");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td[5]"), "Submit");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td[5]"), "10");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td[5]"), "Unlimited");
		
		// Seleciona a opção de seguro
		dsl.clicarObjeto(By.xpath("//table[@id='priceTable']/tfoot/tr/th[2]/label[3]/span"));
		dsl.validaMsg(By.xpath("//a[@id='selectpriceoption']/span"), "0");
		
		// Clica no botão "Download Quote"
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("downloadquote")));
		dsl.clicarObjeto(By.id("downloadquote"));
		System.out.println("Realizou o download!");
		
		
		/************ Preenche o 5º formulário ("Send Quote") ************/
		
		
		// Altera para a aba "Send Quote"
		WebDriverWait wait2 = new WebDriverWait(driver, 35);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("xLoaderQuote")));
		dsl.validaMsg(By.id("xLoaderQuote"), "Please, select a price option to send the quote.");
		dsl.clicarObjeto(By.xpath("//a[@id='selectpriceoption']"));
		dsl.clicarObjeto(By.xpath("//a[@id='sendquote']"));
		
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		System.out.println((String)driver.getWindowHandles().toArray()[0]);
		
		dsl.validaMsg(By.xpath("//a[@id='sendquote']/span"), "4");
		dsl.inserirTexto(By.id("email"), "teste@teste.com.br");
		dsl.inserirTexto(By.id("phone"), "61999999999");
		dsl.validaMsg(By.xpath("//a[@id='sendquote']/span"), "3");
		dsl.inserirTexto(By.id("username"), "maydson");
		dsl.validaMsg(By.xpath("//a[@id='sendquote']/span"), "2");
		dsl.inserirTexto(By.id("password"), "123456@aA");
		dsl.validaMsg(By.xpath("//a[@id='sendquote']/span"), "1");
		dsl.inserirTexto(By.id("confirmpassword"), "123456@aA");
		dsl.validaMsg(By.xpath("//a[@id='sendquote']/span"), "0");
		dsl.inserirTexto(By.id("Comments"), "Teste de preenchimento de formulários com Selenium e Cucumber.");
		
		//Clica no botão "Send"
		dsl.clicarObjeto(By.id("sendemail"));
		
		
		/************ Frame confirmação ************/
		
		// Valida o frame de envio do formulário
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[7]/div/button")));
		dsl.validaMsg(By.xpath("//h2"), "Sending e-mail success!");
		driver.findElement(By.xpath("//div[7]/div/button")).click();
		
		// Fecha o navegador
		driver.close();
	}
			
}
