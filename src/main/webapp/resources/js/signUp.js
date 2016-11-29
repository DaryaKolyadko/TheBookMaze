$(document).ready(function () {
    $('#birthday-picker').datepicker({
        endDate: '0d',
        orientation: "right bottom"
    }).on('changeDate', function (e) {
        // $('#sign-up-form').bootstrapValidator('revalidateField', 'birthDate');
    });
});