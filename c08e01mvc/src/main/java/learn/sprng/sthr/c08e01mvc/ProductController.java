package learn.sprng.sthr.c08e01mvc;

import learn.sprng.sthr.c08e01mvc.model.Product;
import learn.sprng.sthr.c08e01mvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String viewAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @PostMapping
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             Model model) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.add(p);

        model.addAttribute("products", productService.findAll());
        return "products";
    }
}
