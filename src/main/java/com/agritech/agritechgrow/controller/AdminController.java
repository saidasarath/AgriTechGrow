package com.agritech.agritechgrow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.agritech.agritechgrow.entities.Product;
import com.agritech.agritechgrow.entities.User;
import com.agritech.agritechgrow.helper.MessageHelper;
import com.agritech.agritechgrow.service.ProductService;
import com.agritech.agritechgrow.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/index")
    @Secured("ADMIN")
    public String dashboard(){
        return "admin/admin_dashboard";
    }

    @RequestMapping("/products")
    public String products(Model model){
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "admin/products";
    }
    @RequestMapping("/users")
    public String users(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "admin/users";
    }

    @RequestMapping("/addproduct")
    public String addProduct(Model model){
        MessageHelper msg = new MessageHelper();
        model.addAttribute("msg", msg);
        return "admin/addproduct";
    }
    @RequestMapping("/doaddproduct")
    public String doAddProduct(@RequestParam("file") MultipartFile file,@ModelAttribute("product")Product product,Model model) throws Exception{
        MessageHelper msg = new MessageHelper();
        if(!file.getContentType().equals("image/jpeg"))
        {
            msg.setContent("Image should be of type jpeg");
            msg.setType("alert alert-danger");
            model.addAttribute("msg", msg);
            System.out.println(msg);
            return "admin/addproduct";
        }
        if(productService.addProduct(file,product)){
            msg.setContent("Product Added Successfully");
            msg.setType("alert alert-success");
            model.addAttribute("msg", msg);
            return "admin/addproduct";
        }
        msg.setContent("Something went wrong");
        msg.setType("alert alert-danger");
        model.addAttribute("msg", msg);
        return "admin/addproduct";
    }
}
