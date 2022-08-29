package learn.sprng.sthr.c08e01mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("username", "James");
        String[] colors = {"red", "green", "blue"};
        model.addAttribute("color", colors[(int) (Math.random() * colors.length)]);
        return "home";
    }
}
