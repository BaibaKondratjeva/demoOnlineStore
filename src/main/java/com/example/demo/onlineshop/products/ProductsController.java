package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.categories.Categories;
import com.example.demo.onlineshop.categories.CategoriesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;

//@RequestMapping("/products")
@Controller
public class ProductsController {

    private final ProductsRepository repository;
    private final CategoriesRepository categoriesRepository;


    public ProductsController(ProductsRepository repository, CategoriesRepository categoriesRepository) {
        this.repository = repository;
        this.categoriesRepository = categoriesRepository;
    }

    @GetMapping("/admin/products/{name}")
    public Products findByName (@PathVariable String name) {
        return repository.findByName(name);
    }

    @GetMapping("/admin/products/{id}")
    public Products findById (@PathVariable Long id) {
        return repository.findOne(id);
    }

    @GetMapping ("/admin/products")
    public String getProducts(Model model) {
        List<Products> allProducts = repository.findAll();
        model.addAttribute("allProducts", allProducts);
        List<Categories> allCategories = categoriesRepository.findAll();
        model.addAttribute("categories", allCategories);
        return "cms/products/products";
    }

    @GetMapping ("/admin/products/new")
    public String showCreateProductsForm (Model model) {
        model.addAttribute("productRequest", new ProductRequest());
        model.addAttribute("categories", categoriesRepository.findAll());
        return "cms/products/create-edit-product.html";
    }

    @PostMapping ("/admin/products/new")
    public String createProduct (ProductRequest product, Model model) {
        repository.create(product);
        repository.insertProductCategories(product.getId(), product.getCategoryIds());
        model.addAttribute("category", product.getCategoryIds());
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products/update/{id}")
    public String showUpdateProductForm (@PathVariable("id") Long id, Model model) {
        Products product = repository.findOne(id);
        model.addAttribute("products", product);
        model.addAttribute("categories", categoriesRepository.findAll());
        return "cms/products/update-products.html";
    }

//    //Here we will display the form for creating product
//    @GetMapping("/admin/products/edit/{productId}")
//    public String showEditForm(@PathVariable Long productId, Model model) {
//        //TODO search product and it's categories in database
//        //and create ProductForm object (here you need to set all properties)
//        ProductForm product = new ProductForm();
//        product.setId(1L);
//        product.setName("Test product");
//
//
//        // add product list of categories to model
//        model.addAttribute("productForm", product);
//        model.addAttribute("categories", getCategories());
//        return "cms/products/create-edit-product";
//    }

    @PostMapping ("/admin/products/update/{id}")
    public String update(@PathVariable ("id") Long id, ProductRequest product) {
        repository.update(id, product);
        return "redirect:/admin/products";
    }


//    //This method will be called when user fills the form and clicks the submit button
//    //for editing product
//    @PostMapping("/admin/products/edit/{productId}")
//    public String update(@PathVariable Long productId,
//                         ProductForm form, Model model) {
//        System.out.println("product update form: " + form);
//        //TODO here you can run SQL query which will update existing
//        //product in database
//        //TODO you also have to update how this product is mapped to categories
//        return "redirect:/admin/products";
//    }



    @GetMapping("/admin/products/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repository.delete(id);
        return "redirect:/admin/products";
    }


    @GetMapping ("/{id}, {id}")
    public Products categoryValidation (@PathVariable long id1, long id2) {
        return repository.categoriesValidation(id1, id2);
    }

}
