package com.klaus.ecommerBack.services.admin.category;

import com.klaus.ecommerBack.dto.CategoryDto;
import com.klaus.ecommerBack.entity.Category;
import com.klaus.ecommerBack.repository.CategoryRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Category> getAllCategories(){//esto se pasa al servicios
        return categoryRespository.findAll();
    }

}
