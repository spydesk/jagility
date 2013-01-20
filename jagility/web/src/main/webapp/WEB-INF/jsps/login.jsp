<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>: login</title>
</head>
<body>
<h3>Login with Username and Password</h3>
<c:url var="formUrl" value="/doLogin.htm"/>
<form name="securityForm" action="${formUrl }" method="post">
<table><tr>
<td>User:</td>
<td><input type="text" name="j_username" value=""/></td>
</tr><tr>
<td>Password:</td>
<td><input type="password" name="j_password" value=""/></td>
</tr><tr>
<td><input name="submit" type="submit"/></td>
<td><input name="reset" type="reset"/></td>
</tr></table>
</form>
</body>
</html>