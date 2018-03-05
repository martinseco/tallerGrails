package tallergrails

import com.google.gson.Gson
import com.google.gson.JsonElement
import exceptions.GeolocationException
import grails.converters.JSON
import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper

@Transactional
class AgencyService {

    def getAgencysByLocation(String payment_method_id, String radius, String lat, String lgn) {

        def url = new URL('https://api.mercadolibre.com/sites/MLA/payment_methods/'
                            +payment_method_id+'/agencies?near_to='+lat+','+lgn+','+radius)
        def connection = (HttpURLConnection)url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        JsonSlurper json = new JsonSlurper()

        def agencies = json.parse(connection.getInputStream())

        return agencies
    }
}
