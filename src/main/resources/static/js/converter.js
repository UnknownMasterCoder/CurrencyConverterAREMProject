$(document).ready(function () {

    $("#divAlert").hide();
    $("#actualCurrency").val('USD');
    $("#wantedCurrency").val('COP');

    $(document).on("click", '#btnConvert', function (event) {
        $("#conversionForm").submit();
    });

    $(document).on("submit", '#conversionForm', function (event) {
        event.preventDefault();

        var $form = $(this);

        $.ajax({
            url: $('#urlConverter').val(),
            data: $form.serializeArray(),
            error: function (xhr, textStatus, error) {
                console.log(xhr.statusText);
                console.log(textStatus);
                console.log(error);
            },
            success: function (data) {
                if (data.error == null) {
                    $("#divAlert").hide();
                    $('#wantedAmount').val(data.convertedCurrency);
                    //data.

                    //var amount = $('#wantedAmount2').val(data.convertedCurrency;
                    //double res = Double.parseDouble(amount);
                    /*
                    $('#wantedAmount1').gval(data.convertedCurrency);

                    $('#wantedAmount2').val(data.convertedCurrency/$('#wantedAmount1'));

                    //$('#wantedAmount2').val(data.convertedCurrency + "4.00");
                    //$('#wantedAmount2'.val(data.convertedCurrency);*/
                } else {
                    $('#wantedAmount').val("0.00");
                    $('#divAlert').html(data.error.info);
                    $("#divAlert").show();
                }
            },
            type: 'POST'
        });

    });

});
