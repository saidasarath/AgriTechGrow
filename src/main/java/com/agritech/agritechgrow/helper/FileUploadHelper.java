package com.agritech.agritechgrow.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR = "C:\\Users\\SAI DASARATH\\Documents\\spring boot\\agritechgrow\\src\\main\\resources\\static\\img\\products";
    public FileUploadHelper() throws Exception{

    }
    public String uploadFile(MultipartFile file){
        String image = "";
        try{
            
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            image = file.getOriginalFilename();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return image;
    }
}
