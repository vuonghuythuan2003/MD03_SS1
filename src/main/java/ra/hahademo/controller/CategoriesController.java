package ra.hahademo.controller;

import ra.hahademo.entity.Categories;
import ra.hahademo.service.CategoriesService;
import ra.hahademo.service.imp.CategoriesServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoriesController", value = "/CategoriesController")
public class CategoriesController extends HttpServlet {
    private CategoriesService categoriesService;

    public CategoriesController() {
        this.categoriesService = new CategoriesServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("findAll")) {
            List<Categories> categoriesList = categoriesService.findAll();
            request.setAttribute("categories", categoriesList);
            request.getRequestDispatcher("/views/categories.jsp").forward(request, response);
        } else if(action != null && action.equals("create")){
            request.getRequestDispatcher("/views/addCategory.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("create")) {
            String categoryName = request.getParameter("categoryName");
            String categoryDescription = request.getParameter("categoryDescription");
            boolean categoryStatus = Boolean.parseBoolean(request.getParameter("categoryStatus"));

            Categories newCategories = new Categories();
            newCategories.setCategoryName(categoryName);
            newCategories.setCategoryDescription(categoryDescription);
            newCategories.setCategoryStatus(categoryStatus);
            categoriesService.create(newCategories);
            response.sendRedirect("CategoriesController?action=findAll");
        }
    }
}
