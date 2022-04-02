if (urjc.geoprocessing.utils === undefined) {
    urjc.geoprocessing.utils = {};
}

urjc.geoprocessing.utils.loadingButton = function(buttonElement) {
    $(buttonElement).prop("disabled", true);
    $(buttonElement).html("<i class='fa fa-refresh fa-spin'></i>");
};