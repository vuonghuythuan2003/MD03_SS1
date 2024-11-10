package ra.hahademo.reposistory;

import ra.hahademo.entity.Categories;

import java.util.List;

public interface CategoriesRepository {
    List<Categories> findAll();
    boolean create(Categories categories);
    Categories findById(int id);
    boolean update(Categories categories);
    boolean delete(int id);
}
