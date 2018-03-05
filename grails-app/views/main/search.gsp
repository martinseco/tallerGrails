<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Taller Grails</title>
    </head>
    <body>
        <div class="container-fluid">
            <h1>Agencias Cercanas</h1>
            <h6>${address} - Radio: ${radius}</h6>
            <g:if test="${flash.error}">
                <div class="alert alert-danger" >${flash.error}</div>
            </g:if>
            <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Descripcion</th>
                    <th class="td-centered">Distancia</th>
                </tr>
                </thead>
                <tbody>
                    <g:if test="${lista.results != null && !lista.results.isEmpty()}">
                        <g:each in="${lista.results}" var="agency" status="u">
                            <tr>
                                <td>
                                    <a data-toggle="modal" data-target="#myModal${u}">${agency.description}</a>
                                </td>
                                <td class="td-centered">
                                    <g:formatNumber number="${agency.distance}" roundingMode="HALF_UP"></g:formatNumber>
                                </td>
                            </tr>
                        </g:each>
                    </g:if>
                </tbody>
            </table>

            <h3>Mapa de Agencias</h3>
            <div id="map"></div>
                <script>
                    function initMap() {
                        var locations = [];
                        var centro = {lat: ${ubicacion[0]}, lng: ${ubicacion[1]}};
                        <g:each in="${lista.results}" var="agency">

                            var loc = "${agency.address.location}".split(",");
                            loc.push("${agency.description}");
                            loc.push('http://maps.google.com/mapfiles/ms/icons/red-dot.png');

                            locations.push(loc);

                        </g:each>

                        locations.push([${ubicacion[0]}, ${ubicacion[1]}, "Tu Ubicación", 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png']);

                        var map = new google.maps.Map(document.getElementById('map'), {
                            zoom: 15,
                            center: centro
                        });

                        var infowindow = new google.maps.InfoWindow();

                        var marker, i;
                        for (i = 0; i < locations.length; i++) {
                            marker = new google.maps.Marker({
                                position: new google.maps.LatLng(locations[i][0], locations[i][1]),
                                map: map,
                                icon: locations[i][3]
                            });

                            google.maps.event.addListener(marker, 'click', (function(marker, i) {
                                return function() {
                                    infowindow.setContent(locations[i][2]);
                                    infowindow.open(map, marker);
                                }
                            })(marker, i));
                        }
                    }

                </script>

            <script async defer
                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBzeBbpXThIHca1sWRZR0Jb28DWDySTqjM&callback=initMap">
            </script>
        </div>

        <!--MODAL-->
        <g:each in="${lista.results}" var="m" status="i">
            <div class="modal fade" id='myModal${i}' role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">${m.description}</h4>
                        </div>
                        <div class="modal-body">
                            <p>Direccion: ${m.address.address_line}</p>
                            <p>Ciudad: ${m.address.city}</p>
                            <p>Codigo Postal: ${m.address.zip_code}</p>
                            <p>Provincia: ${m.address.state}</p>
                            <p>Pais: ${m.address.country}</p>
                            <p>Ubicacion: ${m.address.location}</p>

                            <!--Mapa
                            <div id="mapModal"></div>
                            <script>
                                function initMapModal() {

                                    var loc = "${m.address.location}".split(",");

                                    var map = new google.maps.Map(document.getElementById('mapModal'), {
                                        zoom: 15,
                                        center: loc
                                    });

                                    var marker = new google.maps.Marker({
                                        position: new google.maps.LatLng(loc[0], loc[1]),
                                        map: map
                                    });
                                }

                            </script>

                            <script async defer
                                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBzeBbpXThIHca1sWRZR0Jb28DWDySTqjM&callback=initMap">
                            </script>
                            -->
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
        </g:each>
    </body>
</html>


