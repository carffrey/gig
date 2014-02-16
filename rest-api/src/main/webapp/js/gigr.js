function getVenue(id, successCallback) {
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "http://localhost:8080/gigs/rest/venues/"+id,
        success : successCallback,
        error : function(jqXhr, data) {
            alert("Request failed: " + data);
        }
    });
}