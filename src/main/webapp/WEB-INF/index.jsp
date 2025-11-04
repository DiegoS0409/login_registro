<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Login y Registro</title>
    <style>
        .error { color: red; font-size: 0.9em; }
        .form-container { display: flex; gap: 50px; }
    </style>
</head>
<body>
<h1>Login y Registro</h1>
<div class="form-container">

    <div>
        <h2>Registro</h2>
        <form:form modelAttribute="usuarioRegistro" action="${pageContext.request.contextPath}/procesa/registro" method="post">
            <div>
                <form:label path="nombreUsuario">Usuario:</form:label>
                <form:input path="nombreUsuario" />
                <form:errors path="nombreUsuario" cssClass="error"/>
            </div>
            <div>
                <form:label path="contrasena">Contraseña:</form:label>
                <form:password path="contrasena"/>
                <form:errors path="contrasena" cssClass="error"/>
            </div>
            <div>
                <form:label path="confirmacionContrasena">Confirmar Contraseña:</form:label>
                <form:password path="confirmacionContrasena"/>
                <form:errors path="confirmacionContrasena" cssClass="error"/>
            </div>
            <div>
                <form:label path="nombre">Nombre:</form:label>
                <form:input path="nombre"/>
                <form:errors path="nombre" cssClass="error"/>
            </div>
            <div>
                <form:label path="apellido">Apellido:</form:label>
                <form:input path="apellido"/>
                <form:errors path="apellido" cssClass="error"/>
            </div>
            <div>
                <form:label path="fechaDeNacimiento">Fecha de Nacimiento:</form:label>
                <form:input path="fechaDeNacimiento" type="date"/>
                <form:errors path="fechaDeNacimiento" cssClass="error"/>
            </div>
            <button type="submit">Registrar</button>
        </form:form>
    </div>

    <div>
        <h2>Login</h2>
        <form:form modelAttribute="usuarioLogin" action="${pageContext.request.contextPath}/procesa/login" method="post">
            <div>
                <form:label path="nombreUsuario">Usuario:</form:label>
                <form:input path="nombreUsuario"/>
                <form:errors path="nombreUsuario" cssClass="error"/>
            </div>
            <div>
                <form:label path="contrasena">Contraseña:</form:label>
                <form:password path="contrasena"/>
                <form:errors path="contrasena" cssClass="error"/>
            </div>
            <button type="submit">Login</button>
        </form:form>
    </div>

</div>
</body>
</html>
