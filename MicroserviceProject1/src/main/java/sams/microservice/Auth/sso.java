package sams.microservice.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class sso {
    String link="http://localhost:3000/";


    @Autowired
    @GetMapping("/")
        public String welcome() {
            return "index";
        }

        @GetMapping("/user")
        public Principal user(Principal principal) {


            //System.out.println("username : " + principal.getName());
            return principal;
        }

}
