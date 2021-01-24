package com.example.demo.onlineshop.categories.validation;

import com.example.demo.onlineshop.categories.Categories;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoriesValidator.class)
@Documented
public @interface ValidCategories {
    String message () default "Category already exists";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
