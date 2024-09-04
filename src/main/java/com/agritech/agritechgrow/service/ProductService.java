package com.agritech.agritechgrow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.agritech.agritechgrow.dao.ProductRepository;
import com.agritech.agritechgrow.entities.Product;
import com.agritech.agritechgrow.helper.FileUploadHelper;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FileUploadHelper fileUploadHelper;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public boolean addProduct(MultipartFile file,Product product){
        String url = fileUploadHelper.uploadFile(file);
        product.setRating(5.0);
        product.setProduct_image(url);
        System.out.println(product);
        productRepository.save(product);
        return true;
    }

   
}
