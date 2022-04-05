if (urjc.geoprocessing.utils === undefined) {
    urjc.geoprocessing.utils = {};
}

urjc.geoprocessing.utils.loadingButton = function(buttonElement) {
    $(buttonElement).prop("disabled", true);
    $(buttonElement).html("<i class='fa fa-refresh fa-spin'></i>");
};

urjc.geoprocessing.utils.confirmModal = function(message, yesCallback) {
    $("#confirm-modal").remove();

    $("body").append(
        "<div class='modal fade' id='confirm-modal'>" +
            "<div class='modal-dialog'>" +
                "<div class='modal-content'>" +
                    "<div class='modal-header'>" +
                        "<h4 class='modal-title'>Confirm</h4>" +
                    "</div>" +
                    "<div class='modal-body'>" + (message ? message : "Are you sure?") + "</div>" +
                    "<div class='modal-footer'>" +
                        "<button type='button' class='btn btn-primary' id='yes-confirm-button'>Yes</button>" +
                        "<button type='button' class='btn btn-default' data-dismiss='modal'>No</button>" +
                    "</div>" +
                "</div>" +
            "</div>" +
        "</div>"
    );

    if (yesCallback) {
        $("#yes-confirm-button").click(function() {
            urjc.geoprocessing.utils.loadingButton(this);

            yesCallback();
        });
    }

    $("#confirm-modal").modal({
        backdrop: "static"
    });
};