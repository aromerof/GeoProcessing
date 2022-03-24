if (urjc.geoprocessing.index === undefined) {
    urjc.geoprocessing.index = {};
}

$(function() {
    urjc.geoprocessing.index.init();
});

urjc.geoprocessing.index.init = function() {
    urjc.geoprocessing.index.initDataTable();
};

urjc.geoprocessing.index.initDataTable = function() {
    $("#projects-table").DataTable({
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