<%@page import="java.util.List"%>
<%@page import="dao.*"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html>
<head>
  <title>Product List</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css">
</head>
<body>

<%@include file="header.jsp" %>
  <h1>Product List</h1>
  <table id="product-table" class="table table-striped table-bordered table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Prix</th>
        <th>Type</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
      <%
      ProduitDao productDao = new ProduitDao();
              for (Produit product : productDao.findAll()) {
      %>
        <tr>
          <td><%= product.getIdProduit() %></td>
          <td><%= product.getName() %></td>
          <td><%= product.getPrix() %></td>
          <td><%= product.getType() %></td>
          <td ><button class="btn btn-success edit-product" onclick="editProduct(<%= product.getIdProduit() %>)" data-product-id="<%= product.getIdProduit() %>">Edit</button></td>
          <td ><button class="btn btn-danger delete-product" onclick="deleteProduct(<%= product.getIdProduit() %>)" href="Suprimer.do?id=${p.id}" data-product-id="<%= product.getIdProduit() %>">Delete</button> </td>
        </tr>
      <% } %>
    </tbody>
  </table>
  
  <button class="btn btn-primary" onclick="createProduct()">Add Product</button>
  
  <script type="text/javascript">
  function createProduct() {
	  window.location.href = "create-product.jsp";
	}
  </script>
  
  
  <script>
  $(document).ready(function() {
    $('#product-table').DataTable({
      "language": {
        "url": "https://cdn.datatables.net/plug-ins/1.11.3/i18n/en.json"
      },

    });
  });
</script>

<script>
function deleteProduct(id) {
  if (confirm("Are you sure you want to delete this product?")) {
    $.ajax({
      url: "deleteProduct.jsp?id=" + id,
      method: "POST",
      success: function(response) {
        alert("Product deleted successfully");
        window.location.reload();
      },
      error: function(xhr, status, error) {
        alert("An error occurred while deleting the product");
      }
    });
  }
}
</script>


<script>
function editProduct(id) {
	  window.location.href = "edit-product.jsp?id=" + id;
	}
</script>
</body>
</html>


