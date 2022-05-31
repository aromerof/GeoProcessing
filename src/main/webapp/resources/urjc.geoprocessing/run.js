if (urjc.geoprocessing.run === undefined) {
    urjc.geoprocessing.run = {};
}

$(function() {
    urjc.geoprocessing.run.init();
});

urjc.geoprocessing.run.init = function() {
    let idProject = $("#idProject").val();
    let idFlight = $("#idFlight").val();

    urjc.geoprocessing.run.initDataTable();

    urjc.geoprocessing.map.initMap();
    urjc.geoprocessing.map.createProjectAoiLayer(idProject, true);
    urjc.geoprocessing.map.createFlightRunsLayer(idFlight, false);
};

urjc.geoprocessing.run.initDataTable = function() {
    $("#runs-table").DataTable({
        lengthChange: true,
        searching: true,
        info: true,
        paging: true,
        order: [[0, "asc"]],
        columnDefs: [{
            targets: "no-sort",
            orderable: false
        }]
    });
};