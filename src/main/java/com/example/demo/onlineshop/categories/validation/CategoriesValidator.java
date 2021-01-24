package com.example.demo.onlineshop.categories.validation;

import com.example.demo.onlineshop.categories.Categories;
import com.example.demo.onlineshop.categories.CategoriesRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoriesValidator implements ConstraintValidator<ValidCategories, Categories> {

    private final CategoriesRepository categoriesRepository;

    public CategoriesValidator(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public void initialize(ValidCategories constraintAnnotation) {

    }

    @Override
    public boolean isValid(Categories categories, ConstraintValidatorContext context) {
        if (!categoriesRepository.canCreateCategory(categories)) {
            addError("name", "Category already exists", context);
            return false;
        }

        return true;
    }


    private void addError(String field, String errorMessage, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addPropertyNode(field)
                .addConstraintViolation();
    }
}
