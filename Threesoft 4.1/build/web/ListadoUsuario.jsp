<%-- 
    Document   : ListadoUsuario
    Created on : Nov 16, 2017, 1:26:17 PM
    Author     : Max
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <jsp:useBean id="user" class="cl.duoc.threesoft.entities.SgaUsuario" scope="page"/>
            <jsp:include flush="true" page="/alluser"/>
            <div class="row-fluid">
                <div class="span12">
                    <div class="widget-box">
                        <div class="widget-title">
                            <span class="icon"><i class="icon-th"></i></span> 
                            <h5>Listado de Usuarios</h5>
                        </div>
                        <div class="widget-content nopadding">
                            <table class="table table-bordered data-table">
                                <thead>
                                    <tr>
                                        <th>ID Usuario</th>
                                        <th>Nombre</th>
                                        <th>Perfil</th>
                                        <th>Modificar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listadoUsuario}" var="user">
                                        <tr class="gradeX">
                                            <td>${user.userId}</td>
                                            <td>${user.username}</td>
                                            <td>${user.profileId.description}</td>
                                            <c:url var="update" value="/updateuser">
                                                <c:param name="user_id" value="${user.userId}"/>
                                            </c:url>
                                            <td class="center"><button <c:if test="${user.profileId.profileId == 1}">disabled</c:if> class="btn btn-primary btn-mini" onclick="window.location.href = '${update}'">Modificar</button></td>
                                            <c:url var="eliminar" value="/deleteUser">
                                                <c:param name="user_id" value="${user.userId}"/>
                                            </c:url>
                                            <td class="center"><button <c:if test="${user.profileId.profileId == 1}">disabled</c:if> class="btn btn-danger btn-mini" onclick="window.location.href = '${eliminar}'">Eliminar</button></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div><hr>
    </div>
</body>
</html>
