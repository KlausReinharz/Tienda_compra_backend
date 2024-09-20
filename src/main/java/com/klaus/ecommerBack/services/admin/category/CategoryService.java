package com.klaus.ecommerBack.services.admin.category;

import com.klaus.ecommerBack.dto.CategoryDto;
import com.klaus.ecommerBack.entity.Category;

public interface CategoryService{

    Category createcategory(CategoryDto categoryDto);
}
