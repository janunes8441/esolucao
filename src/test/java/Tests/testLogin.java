package Tests;

import Actions.actLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testLogin {

    private WebDriver driver;
    private actLogin login;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.esolucao.com/");
        login = new actLogin(driver);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void loginSemUsuarioESenha() {
        login.clicarEntrar();
        login.validarUsuarioSenhaVazios();
    }

    @Test
    public void loginSomenteUsuario() {
        login.preencherUsuario("Alcides");
        login.clicarEntrar();
        login.validarUsuarioVazio();
    }

    @Test
    public void loginSomenteSenha() {
        login.preencherSenha("123");
        login.clicarEntrar();
        login.validarSenhaVazia();
    }

    @Test
    public void loginUsuarioESenhaInvalidos() {
        login.preencherUsuario("Alcides");
        login.preencherSenha("123");
        login.clicarEntrar();
        login.validarCredenciaisInvalidas();
    }
}
