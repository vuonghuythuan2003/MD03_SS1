package ra.hahademo.service.imp;

import ra.hahademo.entity.Categories;
import ra.hahademo.reposistory.CategoriesRepository;
import ra.hahademo.reposistory.imp.CategoriesRepostoryImp;
import ra.hahademo.service.CategoriesService;

import java.util.List;

public class CategoriesServiceImp implements CategoriesService {
    private CategoriesRepository categoriesRepository;

    public CategoriesServiceImp() {
        this.categoriesRepository = new CategoriesRepostoryImp();
    }

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public boolean create(Categories categories) {
        return categoriesRepository.create(categories);
    }
}
