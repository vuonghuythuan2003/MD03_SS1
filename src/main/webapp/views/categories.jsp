<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Categories</title>
</head>
<body>
<h3>Category List</h3>
<table>
    <thead>
    <tr>
        <th>No</th>
        <th>Catalog ID</th>
        <th>Catalog Name</th>
        <th>Catalog Description</th>
        <th>Catalog Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${category.categoryId}</td>
            <td>${category.categoryName}</td>
            <td>${category.categoryDescription}</td>
            <td>${category.categoryStatus ? "Active" : "Inactive"}</td>
            <td>Actions</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="CategoriesController?action=create">Add New Category</a>
</body>
</html>
