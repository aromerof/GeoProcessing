if (urjc.geoprocessing.flight === undefined) {
    urjc.geoprocessing.flight = {};
}

$(function() {
    urjc.geoprocessing.flight.init();
});

urjc.geoprocessing.flight.init = function() {
    let idProject = $("#idProject").val();

    urjc.geoprocessing.flight.initDataTable();

    $("[data-title='tooltip']").tooltip();

    urjc.geoprocessing.map.initMap();
    urjc.geoprocessing.map.createProjectAoiLayer(idProject, true);
    urjc.geoprocessing.map.createProjectFlightsLayer(idProject, false);
};

urjc.geoprocessing.flight.initDataTable = function() {
    $("#flights-table").DataTable({
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