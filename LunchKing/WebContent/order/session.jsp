<%@page import="java.util.ArrayList"%>
<%@page import="order.OrdersDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<OrdersDetail> list = new ArrayList<OrdersDetail>();
OrdersDetail od = new OrdersDetail();
od.setCategoryId("AA");
od.setOrderCount("5");
od.setShipStartDate("17/05/05");
od.setShipEndDate("17/05/10");
od.setPrice(132000);
od.setOrderTerm("3");

list.add(od);
od = new OrdersDetail();
od.setCategoryId("AB");
od.setOrderCount("3");
od.setShipStartDate("17/05/06");
od.setShipEndDate("17/05/11");
od.setOrderTerm("4");
od.setPrice(165000);
list.add(od);

session.setAttribute("orderDetails", list);
session.setAttribute("login", "1");

%>
</body>
</html>