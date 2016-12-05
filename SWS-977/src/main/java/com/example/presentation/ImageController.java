package com.example.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Provides access to the images from the database
 */
@RequestMapping("/images")
@RestController
public class ImageController {
    @RequestMapping(value = "/upload", method = RequestMethod.PUT)
    public void uploadImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getInputStream(); // This would ordinarily be written to the database
        response.setStatus(200);
    }
}
