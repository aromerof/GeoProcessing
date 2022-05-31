<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<input type="hidden" id="idProject" value="${project.getIdProject()}">

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
                <h1>${project.getCode()} - Flights</h1>
                <ol class="breadcrumb">
                    <li><a href="<c:url value='/'/>"><i class="fa fa-home"></i> Home</a></li>
                    <li><a href="<c:url value='/project/${project.getIdProject()}'/>">Project</a></li>
                    <li class="active">Flights</li>
                </ol>
            </section>

            <section class="content">
                <div class="box box-default">
                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-5">
                                <table id="flights-table" class="table table-bordered table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>Code</th>
                                        <th>Flight date</th>
                                        <th>Images</th>
                                        <th class="no-sort text-center">Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="flight" items="${flights}">
                                        <tr>
                                            <td>${flight.getCode()}</td>
                                            <td><fmt:formatDate value="${flight.getFlightDate()}" pattern="yyyy-MM-dd"/></td>
                                            <td>${flight.getNumImages()}</td>

                                            <td>
                                                <a href="<c:url value='/run/${flight.getIdFlight()}'/>" class="btn btn-xs btn-primary" data-title="tooltip" title="View runs">
                                                    <i class="fa fa-bars fa-rotate-90"></i>
                                                </a>
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
<script type="text/javascript" src="<c:url value='/resources/urjc.geoprocessing/flight.js'/>"></script>
</body>
</html>