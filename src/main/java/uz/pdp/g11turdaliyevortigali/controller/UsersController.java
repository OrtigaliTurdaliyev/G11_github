package uz.pdp.g11turdaliyevortigali.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    @GetMapping
    private String getAllUsers(){
        return "show-users";
    }

}
