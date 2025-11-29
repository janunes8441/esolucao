package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class objLogin {

    private WebDriver driver;
    private WebDriverWait wait;

    public objLogin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement inputUsuario;

    @FindBy(id = "password")
    private WebElement inputSenha;

    @FindBy(css = "button[type='submit']")
    private WebElement btnEntrar;

    public WebElement getInputUsuario() {
        return inputUsuario;
    }

    public WebElement getInputSenha() {
        return inputSenha;
    }

    public WebElement getBtnEntrar() {
        return btnEntrar;
    }

    /**
     * Captura a mensagem de toast mais recente e fecha se solicitado
     */
    public String obterMensagemToast(boolean fecharToast) {
        List<WebElement> toasts = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.cssSelector(".Toastify__toast")
                )
        );

        WebElement ultimoToast = toasts.get(toasts.size() - 1);
        String mensagem = ultimoToast.getText();

        if (fecharToast) {
            try {
                WebElement closeBtn = ultimoToast.findElement(By.cssSelector(".Toastify__close-button"));
                wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
            } catch (Exception e) {
                // Ignora se não conseguir fechar
            }
        }

        return mensagem;
    }

    public String obterMensagemToast() {
        return obterMensagemToast(false);
    }
}
