package uz.pdp.g11turdaliyevortigali.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.g11turdaliyevortigali.dao.ProductsDao;
import uz.pdp.g11turdaliyevortigali.model.Products;


@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductsDao productsDao;

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productsDao.getAllProductsFromDb());
        return "show-products";
    }

    @GetMapping("/get-form")
    public String getProductsForm() {
        return "add-products-from";
    }

    @SneakyThrows
    @PostMapping
    public String addNewProducts(Products product) {
        try {
            productsDao.addNewProducts(product);
            return "redirect:/products";
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("Xatolik yuz berdi....");
        }
    }

    @GetMapping("/edit/{id}")
    public String editProducts(@PathVariable Integer id, Model model) {

        model.addAttribute("products", productsDao.getProductsById(id));
        return "edit-products-from";
    }

    @SneakyThrows
    @PostMapping("/edit")
    public String editProducts(Products product) {
        try {
            productsDao.editProducts(product);
            return "redirect:/products";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProducts(@PathVariable Integer id)  {
        try {
            productsDao.deleteProducts(id);
            return "redirect:/products";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }



}
