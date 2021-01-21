package HUFS.LungnahaSpring.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @GetMapping("search")
    public String SearchMVC(@RequestParam("search") String search, Model model){
        model.addAttribute("search", search);
        return "mvcresult";
    }
}
