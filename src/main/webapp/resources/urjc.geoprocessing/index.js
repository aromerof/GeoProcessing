if (urjc.geoprocessing.index === undefined) {
    urjc.geoprocessing.index = {};
}

$(function() {
    urjc.geoprocessing.index.init();
});

urjc.geoprocessing.index.init = function() {
    urjc.geoprocessing.index.initDataTable();

    $("#create-project-button").click(function() {
        urjc.geoprocessing.utils.loadingButton(this);
        urjc.geoprocessing.index.createProject();
    });
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

urjc.geoprocessing.index.createProject = function() {
    let url = webroot + "/create-project";

    let xhr = new XMLHttpRequest();
    xhr.open("POST", url);
    xhr.setRequestHeader("Content-Type", "application/json");

    let onError = function() {
        console.log("Cannot create project");
    };

    xhr.onerror = onError;

    xhr.onload = function() {
        if (xhr.status === 200) {
            try {
                location.reload();
            } catch (err) {
                onError();
            }
        } else {
            onError();
        }
    };

    xhr.send(JSON.stringify({
        code: $("#project-code").val(),
        year: $("#project-year").val(),
        country: $("#project-country").val(),
        state: $("#project-state").val(),
        city: $("#project-city").val(),
        aoiWkt: $("#project-aoi-wkt").val(),
        comment: $("#project-comment").val()
    }));
};