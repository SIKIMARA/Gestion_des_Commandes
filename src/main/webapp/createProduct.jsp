<%@page import="model.Categorie"%>
<%@page import="dao.CategorieDao"%>
<%@page import="model.Produit"%>
<%@page import="dao.ProduitDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
	<%
ProduitDao productDao = new ProduitDao();
CategorieDao categorieDao =new CategorieDao();
if (request.getMethod().equalsIgnoreCase("post")) {
String libelle = request.getParameter("libelle");
int prix = Integer.parseInt(request.getParameter("prix"));
int categorieId = Integer.parseInt(request.getParameter("categorie"));
Categorie categorie =categorieDao.FindCategorie(categorieId);
Produit newProduct = new Produit();
newProduct.setPrix(prix);
newProduct.setName(libelle);
newProduct.setCategorie(categorie);
categorie.setIdCat(6);
productDao.AjouterProduit(newProduct);
response.sendRedirect("Produits.jsp");
}
%>
</body>
</html>