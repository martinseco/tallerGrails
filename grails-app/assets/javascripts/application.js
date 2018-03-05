// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}


function crearMapa(locations, centro) {

    console.log(locations);
    console.log(centro);

    /*
    <g:each in="${lista.results}" var="agency">
        var loc = "${agency.address.location}".split(",");
        locations.push(loc);
    </g:each>
    console.log(locations);
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 15,
        center: centro
    });

    var marker, i;
    for (i = 0; i < locations.length; i++) {
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i][0], locations[i][1]),
            map: map
        });
    }
    */
}
