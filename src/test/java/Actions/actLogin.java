package Actions;

import PageObjects.objLogin;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class actLogin {

    private objLogin page;

    public actLogin(WebDriver driver) {
        this.page = new objLogin(driver);
    }

    public void preencherUsuario(String usuario) {
        page.getInputUsuario().sendKeys(usuario);
    }

    public void preencherSenha(String senha) {
        page.getInputSenha().sendKeys(senha);
    }

    public void clicarEntrar() {
        page.getBtnEntrar().click();
    }

    public void validarMensagem(String mensagemEsperada) {
        String toast = page.obterMensagemToast(true);
        assertEquals(mensagemEsperada, toast, "Mensagem exibida não corresponde à esperada.");
    }

    public void validarUsuarioSenhaVazios() {
        validarMensagem("Por favor, preencha o usuário e a senha.");
    }

    public void validarUsuarioVazio() {
        validarMensagem("Por favor, preencha o usuário e a senha.");
    }

    public void validarSenhaVazia() {
        validarMensagem("Por favor, preencha o usuário e a senha.");
    }

    public void validarCredenciaisInvalidas() {
        validarMensagem("Falha na autenticação. Verifique suas credenciais.");
    }
}
