package com.klaus.ecommerBack.services.admin.category;

import com.klaus.ecommerBack.dto.CategoryDto;
import com.klaus.ecommerBack.entity.Category;
import com.klaus.ecommerBack.repository.CategoryRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl  implements  CategoryService{

    private final CategoryRespository categoryRespository;

    public Category createcategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return  categoryRespository.save(category);
    }

}
