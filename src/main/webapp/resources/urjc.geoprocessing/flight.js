if (urjc.geoprocessing.flight === undefined) {
    urjc.geoprocessing.flight = {};
}

$(function() {
    urjc.geoprocessing.flight.init();
});

urjc.geoprocessing.flight.init = function() {
    urjc.geoprocessing.flight.initDataTable();

    $("[data-title='tooltip']").tooltip();
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