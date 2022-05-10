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
</head>

<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper">
    <header class="main-header">
        <nav class="navbar navbar-static-top">
            <div class="container">
            </div>
        </nav>
    </header>

    <div class="content-wrapper">
        <div class="container">
            <section class="content-header">
                <h1>Projects</h1>
                <ol class="breadcrumb">
                    <li><a href="<c:url value='/'/>"><i class="fa fa-home"></i> Home</a></li>
                </ol>
            </section>

            <section class="content">
                <div class="box box-default">
                    <div class="box-header with-border">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#create-project-modal" data-backdrop="static">
                            <i class="fa fa-plus"></i> Add project
                        </button>
                    </div>
                    <div class="box-body">
                        <table id="projects-table" class="table table-bordered table-striped table-hover">
                            <thead>
                            <tr>
                                <th>Code</th>
                                <th>Country</th>
                                <th>State</th>
                                <th>City</th>
                                <th>Year</th>
                                <th>Area</th>
                                <th class="no-sort text-center">Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="project" items="${projects}">
                                <tr>
                                    <td>${project.getCode()}</td>
                                    <td>${project.getCountry()}</td>
                                    <td>${project.getState()}</td>
                                    <td>${project.getCity()}</td>
                                    <td>${project.getYear()}</td>
                                    <td>${project.getArea()}</td>

                                    <td>
                                        <a href="<c:url value='/project/${project.getIdProject()}'/>" class="btn btn-xs btn-primary" data-title="tooltip" title="View details">
                                            &nbsp;<i class="fa fa-info"></i>&nbsp;
                                        </a>

                                        <button type="button" class="btn btn-xs btn-danger" data-title="tooltip" title="Delete project" onclick="urjc.geoprocessing.index.deleteProject(${project.getIdProject()});">
                                            <i class="fa fa-trash"></i>
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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
<script type="text/javascript" src="<c:url value='/resources/urjc.geoprocessing/init.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/urjc.geoprocessing/utils.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/urjc.geoprocessing/index.js'/>"></script>

<div class="modal fade" id="create-project-modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add project</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="project-code">Code</label>
                        <input type="text" class="form-control" id="project-code">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="project-year">Year</label>
                        <input type="number" class="form-control" min="2000" max="2099" value="2022" id="project-year">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="project-country">Country</label>
                        <input type="text" class="form-control" id="project-country">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="project-state">State</label>
                        <input type="text" class="form-control" id="project-state">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="project-city">City</label>
                        <input type="text" class="form-control" id="project-city">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="project-aoi-wkt">AOI WKT</label>
                        <input type="text" class="form-control" id="project-aoi-wkt">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="project-comment">Comment</label>
                        <textarea class="form-control" rows="3" style="resize: none;" id="project-comment"></textarea>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="create-project-button">Add</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>