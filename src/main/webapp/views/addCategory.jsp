<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Category</title>
</head>
<body>
<h3>Add New Category</h3>
<form action="CategoriesController" method="post">
    <input type="hidden" name="action" value="create">
    <label for="categoryName">Category Name:</label>
    <input type="text" id="categoryName" name="categoryName" required><br>
    <label for="categoryDescription">Category Description:</label>
    <input type="text" id="categoryDescription" name="categoryDescription" required><br>
    <label for="categoryStatus">Category Status:</label>
    <select id="categoryStatus" name="categoryStatus">
        <option value="true">Active</option>
        <option value="false">Inactive</option>
    </select><br>
    <button type="submit">Add Category</button>
</form>
<a href="CategoriesController?action=create">Add New Category</a>

</body>
</html>
