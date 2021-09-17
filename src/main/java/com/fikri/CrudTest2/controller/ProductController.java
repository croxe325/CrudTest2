package com.fikri.CrudTest2.controller;

import com.fikri.CrudTest2.model.Product;
import com.fikri.CrudTest2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping ("/product")
    public String ProductList(Model model){
        model.addAttribute("product",productService.listProduct() );
        return "product";
    }
    @RequestMapping(value = "/product/create", method = RequestMethod.GET)
    public String tampilkanForm(Model model){
        model.addAttribute("product", new Product());
        return "formProduct";

    }
    @RequestMapping(value = "/product/create", method = RequestMethod.POST)
        public String simpanDataMahasiswa(Model model, Product mahasiswa){

        model.addAttribute("product",productService.saveOrUpdate(mahasiswa));
        return "redirect:/product";
    }
    @RequestMapping(value = "/product/edit/{id}", method = RequestMethod.GET)
    public String editData(@PathVariable Integer id, Model model){
        model.addAttribute("product",productService.getIdProduct(id));
        return "formProduct";
    }
    @RequestMapping(value = "/product/hapus/{id}")
    public String hapus(@PathVariable Integer id){
        productService.hapus(id);
        return "redirect:/product";
    }

}