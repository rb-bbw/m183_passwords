package ch.bbw.authentication.userauthentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("authenticationData", new AuthenticationData());
        model.addAttribute("message", "");
        return "index";
    }

    @PostMapping("/signIn")
    public String signIn(@ModelAttribute AuthenticationData authenticationData,
                         Model model) {
        String localUsername = "admin";
        String localPassword = "BA3253876AED6BC22D4A6FF53D8406C6AD864195ED144AB5C87621B6C233B548BAEAE6956DF346EC8C17F5EA10F35EE3CBC514797ED7DDD3145464E2A0BAB413";

        // Todo: hier Zugangsdaten prüfen
        // Hash vom Passwort erzeugen und mit lokalem Hash vergleichen
        // wenn Hashes gleich auf die Seite "success" wechseln
        // sonst auf die Seite index wechseln
        System.out.println(authenticationData.getUsername());

        // Fall: Benutzer korrekt authentifiziert
        //model.addAttribute("authenticationData", new AuthenticationData());
        //model.addAttribute("message", "");
        //return "success";

        // im Fehlerfall
        model.addAttribute("authenticationData", new AuthenticationData());
        model.addAttribute("message", "authentication failed");
        return "index";
    }
}
