$(document).ready(function () {
    getWritings();

    function getWritings() {
        $.ajax({
            type: "GET",
            url: "http://172.30.1.60:8080/writing/all",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            success: function (json) {
                $('#demian_body').html("");
                var list = json;
                var listLen = json.length;

                for (var i = 0; i < listLen; i++) {
                    var str = "<tr>" +
                        "<td id='name'>" + list[i].name + "</td>" +
                        "<td id='title'>" + list[i].title + "</td>" +
                        '<td class="td-actions text-right"><a href="#" rel="tooltip" title="Edit" class="btn btn-success btn-simple btn-xs"><i class="ti-pencil-alt"></i></a><a href="#" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs"><i class="ti-close"></i></a></td>'
                    "</tr>";
                    $('#demian_body').append(str);
                }
            }
        })
    }

})