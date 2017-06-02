package com.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class TestController {

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("time", "123");
        return "home";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity uploadFile(HttpServletRequest request,MultipartFile file) throws IOException {
        String mimeType = file.getContentType();
        String filename = file.getOriginalFilename();
        byte[] bytes = file.getBytes();
        String last=filename.substring(filename.lastIndexOf("."));
        String uploads = request.getSession().getServletContext().getRealPath("uploads");
        FileOutputStream out = new FileOutputStream(new File(uploads + File.separator + file.getName()+System.currentTimeMillis()+ last));
        FileCopyUtils.copy(bytes, out);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
