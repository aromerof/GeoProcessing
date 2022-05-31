if (urjc.geoprocessing.project === undefined) {
    urjc.geoprocessing.project = {};
}

$(function() {
    urjc.geoprocessing.project.init();
});

urjc.geoprocessing.project.init = function() {
    let idProject = $("#idProject").val();

    urjc.geoprocessing.map.initMap();
    urjc.geoprocessing.map.createProjectAoiLayer(idProject, true);
};