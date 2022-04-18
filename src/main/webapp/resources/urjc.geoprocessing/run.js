if (urjc.geoprocessing.run === undefined) {
    urjc.geoprocessing.run = {};
}

$(function() {
    urjc.geoprocessing.run.init();
});

urjc.geoprocessing.run.init = function() {
    urjc.geoprocessing.run.initDataTable();
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