package ra.hahademo.reposistory.imp;

import ra.hahademo.entity.Categories;
import ra.hahademo.reposistory.CategoriesRepository;
import ra.hahademo.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesRepostoryImp implements CategoriesRepository {

    @Override
    public List<Categories> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Categories> listCategories = new ArrayList<>();
        try {
            conn = ConnectionDB.openGetConnection();
            callSt = conn.prepareCall("{CALL find_all_categories()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Categories categories = new Categories();
                categories.setCategoryId(rs.getInt("catalog_id"));
                categories.setCategoryName(rs.getString("catalog_name"));
                categories.setCategoryDescription(rs.getString("catalog_description"));
                categories.setCategoryStatus(rs.getBoolean("catalog_status"));
                listCategories.add(categories);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listCategories;
    }

    @Override
    public boolean create(Categories categories) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openGetConnection();
            callSt = conn.prepareCall("{CALL create_categories(?, ?, ?)}");
            callSt.setString(1, categories.getCategoryName());
            callSt.setString(2, categories.getCategoryDescription());
            callSt.setBoolean(3, categories.isCategoryStatus());
            callSt.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public Categories findById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Categories categories = null;
        try {
            conn = ConnectionDB.openGetConnection();
            callSt = conn.prepareCall("{Call search_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                categories = new Categories();
                categories.setCategoryId(rs.getInt("catalog_id"));
                categories.setCategoryName(rs.getString("catalog_name"));
                categories.setCategoryDescription(rs.getString("catalog_description"));
                categories.setCategoryStatus(rs.getBoolean("catalog_status"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return categories;
    }

    @Override
    public boolean update(Categories categories) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openGetConnection();
            callSt = conn.prepareCall("{call update_categories(?, ?, ?)}");
            callSt.setInt(1, categories.getCategoryId());
            callSt.setString(2, categories.getCategoryName());
            callSt.setString(3, categories.getCategoryDescription());
            callSt.executeUpdate();
            result = true;
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openGetConnection();
            callSt = conn.prepareCall("{call delete_categories(?)}");
            callSt.setInt(1, id);
            callSt.executeQuery();
            result = true;
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
