package com.agritech.agritechgrow.controller;

import com.agritech.agritechgrow.entities.MailStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agritech.agritechgrow.entities.User;
import com.agritech.agritechgrow.helper.MessageHelper;
import com.agritech.agritechgrow.service.UserService;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Home");

        return "home";
    }

    @RequestMapping("/signup")
    public String register(Model model){
        model.addAttribute("title", "SignUp");
        MessageHelper messageHelper = new MessageHelper();
        model.addAttribute("message",messageHelper);
        return "signup";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("title", "Login");
        return "login";
    }

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About");
        return "about";
    }

    @RequestMapping("/processregister")
    public String register(@ModelAttribute("user") User user,@RequestParam("confirmPassword") String confirmPassword ,Model model){
        user.setImage("default.png");
        user.setName(user.getUsername());
        user.setRole("USER");
        MessageHelper messageHelper = new MessageHelper();
        if(userService.adduser(user)){
            messageHelper.setContent("Registered Successfylly");
            messageHelper.setType("alert alert-success");
            model.addAttribute("message", messageHelper);
            return "signup";
        }
        messageHelper.setContent("Something went wrong! Try Again");
        messageHelper.setType("alert alert-danger");
        model.addAttribute("message", messageHelper);
        return "signup";
    }

    @RequestMapping("/forgetpassword")
    public String forgetpassword(Model model){
        MessageHelper messageHelper = new MessageHelper();
        model.addAttribute("message",messageHelper);
        return "forgetpassword";
    }
    @RequestMapping("/doforgetpassword")
    public String processPassword(@RequestParam("username") String username,@RequestParam("password") String password,Model model){
        MessageHelper message = new MessageHelper();
        User user = userService.getByUsername(username);
        if(user == null){
            message.setContent("You dont have an account ! Signup");
            message.setType("alert alert-danger");
            model.addAttribute("message",message);
            return "forgetpassword";
        }
        user.setPassword(password);
        message.setContent("Password changes successfully");
        message.setType("alert alert-success");
        model.addAttribute("message",message);
        System.out.println(userService.adduser(user));
        return "forgetpassword";
    }
}
