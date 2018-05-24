<%-- 
    Document   : Creditosjsp
    Created on : 23/05/2018, 07:57:51 PM
    Author     : yypv2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../../../favicon.ico">

        <title>Menu</title>

        <!-- Bootstrap core CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.servletContext.contextPath}/css/jumbotron.css" rel="stylesheet">
    </head>

    <body>

        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <a class="navbar-brand" href="#">CRÉDITOS</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.servletContext.contextPath}/view/Creditos.jsp">Créditos<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main">

            <!-- Main jumbotron for a primary marketing message or call to action -->
            <div class="jumbotron">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 order-md-1">

                            <form action="${pageContext.servletContext.contextPath}/CreditosServlet" method="post">
                                <div class="form-row">
                                    <div class="col">
                                        <input name="txtnumerocredito" type="text" class="form-control" placeholder="Número de crédito">
                                    </div>

                                </div>
                                <div class="form-row">
                                    <div class="col">
                                        <input name="txtdocumento" type="text" class="form-control" placeholder="Documento">
                                    </div>

                                </div>
                                <div class="form-row">
                                    <div class="col">
                                        <input name="txtnombres" type="text" class="form-control" placeholder="Nombres">
                                    </div>                
                                    <div class="col">
                                        <input name="txtapellidos" type="text" class="form-control" placeholder="Apellidos">
                                    </div>

                                </div>
                                <div class="form-row">
                                    <div class="col">
                                        <input name="txtMontoPrestar" type="text" class="form-control" placeholder="Monto a prestar">
                                    </div>               
                                </div>
                                <div class="form-row">
                                    <div class="col">
                                        <select name="txttipotrabajador" >
                                            <option selected value="0"> Elige una opción </option>
                                                <option value="1">Independiente</option> 
                                                <option value="2">Dependiente</option> 
                                        </select>
                                    </div>               
                                    <div class="col">
                                        <select name="txtipocredito" >
                                            <option selected value="0"> Elige una opción </option>
                                                <option value="1">Vivienda</option> 
                                                <option value="2">Estudio</option> 
                                                <option value="3">Libre Inversión</option> 
                                        </select>

                                    </div>
                                     <div class="col">
                                        <select name="txttrabajaempresa" >
                                            <option selected value="0"> Elige una opción </option>
                                                <option value="1">SI</option> 
                                                <option value="2">NO</option> 
                                        </select>

                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="col">
                                        <button name="accion" value="crear" type="submit" class="btn btn-primary">Registrar credito</button>
                                    </div>
                                    <div class="col">
                                        <button name="accion" value="listar" type="submit" class="btn btn-primary">Listar</button>
                                    </div>    
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="container">

                    <!-- Example row of columns -->
                </div> <!-- /container -->
            </div>
        </main>

        <footer class="container">
            <p>&copy; Company 2017-2018</p>
        </footer>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    </body>
</html>
