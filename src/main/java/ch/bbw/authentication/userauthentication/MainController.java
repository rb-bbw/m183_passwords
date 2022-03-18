package ch.bbw.authentication.userauthentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("authenticationData", new AuthenticationData());
        model.addAttribute("message", "");
        return "index";
    }

    @PostMapping("/signIn")
    public String signIn(@ModelAttribute AuthenticationData authenticationData, Model model) {
        String localUsername = "admin";
        String localPassword = "de1e0b5f43273c95f6c8206694948f578566e9dfb0c3b8be75ce9ef8bc616d74ed8e0356ddac384b4c70f5098b76e3886bf5912d433bea7c20150c1fddb208b2";
        // GH5&7Uh6*4g

        HashGenerator hasher = new HashGenerator();
        String uname = authenticationData.getUsername();
        String pw = hasher.generateSHA512Hash(authenticationData.getPassword());

        if(pw.equals(localPassword) && uname.equals(localUsername)) {
            model.addAttribute("authenticationData", new AuthenticationData());
            model.addAttribute("message", "");
            return "success";
        }

        // im Fehlerfall
        model.addAttribute("authenticationData", new AuthenticationData());
        model.addAttribute("message", "authentication failed");
        return "index";
    }
}
