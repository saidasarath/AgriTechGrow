package com.agritech.agritechgrow.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agritech.agritechgrow.entities.MailStructure;
import com.agritech.agritechgrow.entities.Order;
import com.agritech.agritechgrow.entities.Product;
import com.agritech.agritechgrow.entities.User;
import com.agritech.agritechgrow.helper.MessageHelper;
import com.agritech.agritechgrow.service.MailService;
import com.agritech.agritechgrow.service.OrderService;
import com.agritech.agritechgrow.service.ProductService;
import com.agritech.agritechgrow.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MailService mailService;

    @RequestMapping("/index")
    @Secured("USER")
    public String dashboard(Model model,Principal principal){
        String username = principal.getName();
        User user = userService.getByUsername(username);
        model.addAttribute("user", user);
        System.out.println(user);
        return "normal/user_dashboard";
    }

    @RequestMapping("/buyproducts")
    public String buyProducts(Model model){
        List<Product> products = productService.getProducts();
        System.out.println(products);
        model.addAttribute("products", products);
        return "normal/buy_products";
    }

    @RequestMapping("/about")
    public String about(){
        return "normal/about";
    }

    @RequestMapping("/orders")
    public String orders(Model model,Principal principal){
        String username = principal.getName();
        User user = userService.getByUsername(username);
        List<Order> orders = orderService.getOrdersByUsername(user);
        model.addAttribute("orders", orders);
        System.out.println(orders);
        return "normal/orders";
    }

    @RequestMapping("/contactus")
    public String contactus(Model model){
        MessageHelper msg = new MessageHelper();
        model.addAttribute("msg", msg);
        return "normal/contactus";
    }

    @RequestMapping("/processcontact")
    public String processContact(@ModelAttribute("message") MailStructure message,Model model){
        System.out.println(message);
        if(mailService.sendMail(message)){
            System.out.println("Mail sent");
            MessageHelper msg = new MessageHelper();
            msg.setContent("Mail sent successfully");
            msg.setType("alert alert-success");
            model.addAttribute("msg", msg);
        }
        return "normal/contactus";
    }
    @RequestMapping("/profile")
    public String profile(){
        return "normal/profile";
    }
}
