package ra.hahademo.service;

import ra.hahademo.entity.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> findAll();
    boolean create(Categories categories);

}
