if (urjc.geoprocessing.map === undefined) {
    urjc.geoprocessing.map = {
        projectAoiLayerUrl: webroot + "/geoserver/wfs?service=wfs&version=2.0.0&request=GetFeature&typeName=geoprocessing:project-aoi&outputFormat=application/json",
        projectFlightsLayerUrl: webroot + "/geoserver/wfs?service=wfs&version=2.0.0&request=GetFeature&typeName=geoprocessing:project-flights&outputFormat=application/json",
        flightRunsLayerUrl: webroot + "/geoserver/wfs?service=wfs&version=2.0.0&request=GetFeature&typeName=geoprocessing:flight-runs&outputFormat=application/json"
    };
}

urjc.geoprocessing.map.initMap = function() {
    urjc.geoprocessing.map.map = new ol.Map({
        target: "map",
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM(),
                type: "tile"
            })
        ],
        view: new ol.View({
            center: ol.proj.fromLonLat([-97, 38]),
            zoom: 4
        })
    });
};

urjc.geoprocessing.map.createProjectAoiLayer = function(idProject, fit) {
    let url = urjc.geoprocessing.map.projectAoiLayerUrl + "&viewParams=id_project:" + idProject;

    let style = new ol.style.Style({
        fill: new ol.style.Fill({
            color: "rgba(0, 0, 0, 0.1)"
        }),
        stroke: new ol.style.Stroke({
            color: "rgba(0, 0, 0, 0.5)",
            width: 3
        })
    });

    urjc.geoprocessing.map.createVectorLayer("project-aoi", url, style, fit);
};

urjc.geoprocessing.map.createProjectFlightsLayer = function(idProject, fit) {
    let url = urjc.geoprocessing.map.projectFlightsLayerUrl + "&viewParams=id_project:" + idProject;

    let style = new ol.style.Style({
        fill: new ol.style.Fill({
            color: "rgba(15, 95, 255, 1)"
        }),
        stroke: new ol.style.Stroke({
            color: "rgba(15, 95, 255, 1)",
            width: 2
        })
    });

    urjc.geoprocessing.map.createVectorLayer("project-flights", url, style, fit);
};

urjc.geoprocessing.map.createFlightRunsLayer = function(idFlight, fit) {
    let url = urjc.geoprocessing.map.flightRunsLayerUrl + "&viewParams=id_flight:" + idFlight;

    let style = new ol.style.Style({
        fill: new ol.style.Fill({
            color: "rgba(15, 95, 255, 1)"
        }),
        stroke: new ol.style.Stroke({
            color: "rgba(15, 95, 255, 1)",
            width: 2
        })
    });

    urjc.geoprocessing.map.createVectorLayer("flight-runs", url, style, fit);
};

urjc.geoprocessing.map.createVectorLayer = function(name, url, style, fit) {
    let source = new ol.source.Vector({
        format: new ol.format.GeoJSON(),
        url: url
    });

    let layer = new ol.layer.Vector({
        source: source,
        style: style,
        name: name,
        type: "vector"
    });

    urjc.geoprocessing.map.map.addLayer(layer);

    if (fit) {
        layer.getSource().on("featuresloadend", function() {
            urjc.geoprocessing.map.fitMapToVectorLayer(layer);
        });
    }
};

urjc.geoprocessing.map.fitMapToVectorLayer = function(layer) {
    urjc.geoprocessing.map.map.getView().fit(layer.getSource().getExtent(), urjc.geoprocessing.map.map.getSize());
    urjc.geoprocessing.map.map.getView().setZoom(parseInt(urjc.geoprocessing.map.map.getView().getZoom()));
};