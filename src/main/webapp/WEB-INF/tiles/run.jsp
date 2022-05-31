<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>GeoProcessing</title>

    <link type="text/css" rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/resources/font-awesome/css/font-awesome.min.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/resources/datatables-bs/css/dataTables.bootstrap.min.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/resources/adminlte/css/AdminLTE.min.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/resources/adminlte/css/skins/skin-blue.min.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/resources/fonts/sourcesanspro-font.min.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/resources/ol/css/ol.css'/>">
</head>

<body class="hold-transition skin-blue layout-top-nav">
<input type="hidden" id="idProject" value="${flight.getProject().getIdProject()}">
<input type="hidden" id="idFlight" value="${flight.getIdFlight()}">

<div class="wrapper">
    <header class="main-header">
        <nav class="navbar navbar-static-top">
            <div class="container">
            </div>
        </nav>
    </header>

    <div class="content-wrapper">
        <div class="container" style="width: 1400px;">
            <section class="content-header">
                <h1>${flight.getCode()} - Runs</h1>
                <ol class="breadcrumb">
                    <li><a href="<c:url value='/'/>"><i class="fa fa-home"></i> Home</a></li>
                    <li><a href="<c:url value='/project/${flight.getProject().getIdProject()}'/>">Project</a></li>
                    <li><a href="<c:url value='/flight/${flight.getProject().getIdProject()}'/>">Flights</a></li>
                    <li class="active">Runs</li>
                </ol>
            </section>

            <section class="content">
                <div class="box box-default">
                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-5">
                                <table id="runs-table" class="table table-bordered table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>Code</th>
                                        <th class="no-sort text-center">Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="run" items="${runs}">
                                        <tr>
                                            <td>${run.getCode()}</td>

                                            <td>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div id="map" class="col-md-7" style="height: 450px;"></div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value='/resources/jquery/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/datatables/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/datatables-bs/js/dataTables.bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/adminlte/js/adminlte.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/ol/js/ol.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/urjc.geoprocessing/init.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/urjc.geoprocessing/map.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/urjc.geoprocessing/run.js'/>"></script>
</body>
</html>