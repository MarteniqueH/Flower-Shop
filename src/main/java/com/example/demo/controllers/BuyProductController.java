package com.example.demo.controllers;

import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.domain.Product;
import org.springframework.ui.Model;
import com.example.demo.domain.Part;

import java.util.Optional;

@Controller
public class BuyProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") long productId, Model model) {


        Optional<Product> optProduct = productRepository.findById(productId);

        if (optProduct.isEmpty()) {
            return "error";
        }

        Product product = optProduct.get();


        if (product.getInv() < 1) {
            return "error";
        }
        for (Part part : product.getParts()){


            if(part.getInv()-1 < part.getMinInventory()){

                return "error";
            }
        }

        product.setInv(product.getInv() - 1);


        productRepository.save(product);


        return "success";
    }
}