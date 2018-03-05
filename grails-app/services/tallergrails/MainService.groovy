package tallergrails

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.maps.GeoApiContext
import com.google.maps.GeocodingApi
import com.google.maps.model.GeocodingResult
import exceptions.GeolocationException
import grails.gorm.transactions.Transactional

@Transactional
class MainService {

    def serviceMethod() {

    }

    def getLocationDetails(String direccion) {
        //Retorna una lista con la latitud y la longitud de la direccion pasada por parametro
        List<String> location = new ArrayList<String>()

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyBzeBbpXThIHca1sWRZR0Jb28DWDySTqjM")
                .build();
        GeocodingResult[] results =  GeocodingApi.geocode(context,direccion).await()

        if (results.size() != 0) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String latitud = gson.toJson(results[0].geometry.location.lat)
            String longitud = gson.toJson(results[0].geometry.location.lng)

            location.add(latitud)
            location.add(longitud)
        }
        else {
            throw new GeolocationException("Error al buscar la latitud y longitud de la direccion ingresada")
        }

        return location
    }
}
