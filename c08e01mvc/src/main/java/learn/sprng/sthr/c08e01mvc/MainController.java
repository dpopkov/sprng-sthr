package learn.sprng.sthr.c08e01mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home(@RequestParam(required = false) String name,
                       @RequestParam(required = false) String color,
                       Model model) {
        model.addAttribute("username", name != null ? name : "James");
        String[] colors = {"red", "green", "blue"};
        model.addAttribute("color", color != null ? color : colors[(int) (Math.random() * colors.length)]);
        return "home";
    }

    @GetMapping("/home/{color}")
    public String homeColored(@PathVariable String color,
                              Model model) {
        model.addAttribute("username", "Durer");
        model.addAttribute("color", color);
        return "home";
    }
}
