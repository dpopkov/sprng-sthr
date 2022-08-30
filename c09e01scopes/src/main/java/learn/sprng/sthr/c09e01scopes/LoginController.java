package learn.sprng.sthr.c09e01scopes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {

    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping
    public String loginPage() {
        return "login";
    }

    @PostMapping
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        if (loginProcessor.login()) {
            model.addAttribute("message", "You are now logged in.");
        } else {
            model.addAttribute("message", "Login failed.");
        }
        return "login";
    }
}
