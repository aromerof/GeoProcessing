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
                <h1>${project.getCode()}</h1>
                <ol class="breadcrumb">
                    <li><a href="<c:url value='/'/>"><i class="fa fa-home"></i> Home</a></li>
                    <li class="active">Project</li>
                </ol>
            </section>

            <section class="content">
                <div class="box box-default">
                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="form-group col-md-4">
                                        <label for="project-code">Code</label>
                                        <input type="text" class="form-control" id="project-code" value="${project.getCode()}" disabled>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="project-year">Year</label>
                                        <input type="text" class="form-control" id="project-year" value="${project.getYear()}" disabled>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="project-area">Area</label>
                                        <input type="text" class="form-control" id="project-area" value="${project.getArea()}" disabled>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-4">
                                        <label for="project-country">Country</label>
                                        <input type="text" class="form-control" id="project-country" value="${project.getCountry()}" disabled>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="project-state">State</label>
                                        <input type="text" class="form-control" id="project-state" value="${project.getState()}" disabled>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="project-city">City</label>
                                        <input type="text" class="form-control" id="project-city" value="${project.getCity()}" disabled>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-12">
                                        <label for="project-aoi-wkt">AOI WKT</label>
                                        <textarea class="form-control" rows="3" style="resize: none;" id="project-aoi-wkt" disabled>${project.getAoi().toText()}</textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-12">
                                        <label for="project-comment">Comment</label>
                                        <textarea class="form-control" rows="3" style="resize: none;" id="project-comment" disabled>${project.getComment()}</textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value='/resources/jquery/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/adminlte/js/adminlte.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/urjc.geoprocessing/init.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/urjc.geoprocessing/project.js'/>"></script>
</body>
</html>