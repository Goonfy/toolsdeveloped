package org.academiadecodigo.gnunas.controller;

import org.academiadecodigo.gnunas.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String showIndex(Model model) {
        User user = new User();
        user.setName("Eduardo Pedro");
        user.setEmail("edupedro1996@gmail.com");

        model.addAttribute("user", user);

        return "index";
    }
}
