package auxiliar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClasseAuxiliar {
	private WebDriver driver;
	
	public ClasseAuxiliar(WebDriver driver) {
		this.driver = driver;
	}
	
	// Método para realizar cliques
	public void clicarObjeto(By by) {
		// Encontra o elemento em tela, necessitando passar a forma de identificação (id, xpath, cssSelector e etc)
		WebElement element = driver.findElement(by);
		
		// Verifica se o elemento está sendo demonstrado na tela
		if(element.isDisplayed()) {
				
			// Realiza o clique no elemento
			element.click();
		}
	}

	// Método para realizar a inserção de texto em um campo
	public void inserirTexto(By by, String texto) {
			
		// Seleciona o elemento em tela , necessitando passar a forma de identificação (id, xpath, cssSelector e etc)
		WebElement campo = driver.findElement(by);
			
		// Verifica se o elemento está disponível em tela
		if(campo.isDisplayed()) {
				
			// Realiza o insert no texto para o elemento desejado
			campo.sendKeys(texto);
		}
	}
		
	// Método para selecionar opção em uma combo
	public void selectOptCombo(By by, String opcao) {
		WebElement select = driver.findElement(by);
		select.click();
		select.sendKeys(opcao + Keys.TAB);
	}
	
	// Método para validar mensagens
	public void validaMsg(By by, String valText) {
			
		try {
			String texto = driver.findElement(by).getText();
			Assert.assertEquals(valText, texto);
			System.out.println("Mensagem correta!" + " Valor recebido: " + texto);
				
		} catch (Exception e) {
			String texto = driver.findElement(by).getText();
			Assert.assertEquals(valText, texto);
			System.out.println("Mensagem incorreta!" + "/n   Valor esperado: " + texto + "/n   Valor recebido: " + valText);
		}
	}

	public String obterTexto(By by) {
		String texto = driver.findElement(by).getText();
		System.out.println("Texto encontrado: "+texto);
		return texto;
	}
	
	public void entrarFrame(String id) {
		driver.switchTo().frame(id);
	}
	
	public void sairFrame(){
		driver.switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		driver.switchTo().window(id);
	}
}