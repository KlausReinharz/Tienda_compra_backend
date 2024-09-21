package com.klaus.ecommerBack.services.admin.category;

import com.klaus.ecommerBack.dto.CategoryDto;
import com.klaus.ecommerBack.entity.Category;

import java.util.List;

public interface CategoryService{

    Category createcategory(CategoryDto categoryDto);

    List<Category> getAllCategories();// se pasa al controller
}
