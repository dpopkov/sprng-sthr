package learn.sprng.sthr.c09e01scopes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class LoginControllerUnitTest {

    @Mock
    Model model;
    @Mock
    LoginProcessor loginProcessor;
    @InjectMocks
    LoginController loginController;

    @Test
    void loginSucceeds() {
        given(loginProcessor.login()).willReturn(true);

        String view = loginController.login("username", "password", model);
        assertEquals("redirect:/main", view);
    }

    @Test
    void loginFails() {
        given(loginProcessor.login()).willReturn(false);

        String view = loginController.login("username", "password", model);
        assertEquals("login", view);

        then(model).should().addAttribute("message", "Login failed.");
    }
}
