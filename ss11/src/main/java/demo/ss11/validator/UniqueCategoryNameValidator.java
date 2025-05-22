package demo.ss11.validator;

import demo.ss11.model.Category;
import demo.ss11.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

@Component
public class UniqueCategoryNameValidator implements Validator {

    @Autowired
    private CategoryService categoryService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Category.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Category c = (Category) target;
        if (categoryService.existsByName(c.getCategoryName())) {
            errors.rejectValue("categoryName", "categoryName.exists", "Tên danh mục đã tồn tại");
        }
    }
}
