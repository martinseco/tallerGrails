package tallergrails

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.maps.GeoApiContext
import com.google.maps.GeocodingApi
import com.google.maps.model.GeocodingResult
import exceptions.GeolocationException
import groovy.json.JsonSlurper

class MainController {

    PaymentMethodService paymentMethodService
    MainService mainService
    AgencyService agencyService

    def index() {
        List<PaymentMethod> allPaymentsMethods = paymentMethodService.getAllPaymentMethods()

        List<PaymentMethod> paymentsFiltrados = new ArrayList<PaymentMethod>()

        for(PaymentMethod p : allPaymentsMethods) {
            if(p.getPayment_type_id() == "ticket" || p.getPayment_type_id() == "atm") {
                paymentsFiltrados.add(p);
            }
        }

        render(view:"index", model: [lista: paymentsFiltrados])

    }

    def search() {
        String address = params.get("direccion")
        String radius = params.get("radio")
        String payment_method_id = params.paymentMethod

        List<String> location

        try {
             location = mainService.getLocationDetails(address)
        } catch(GeolocationException e) {
            flash.error = e.message
            redirect action: 'index'
            return
        }


        def agenciesList = agencyService.getAgencysByLocation(payment_method_id,
                                                                radius,
                                                                location.get(0),
                                                                location.get(1))

        if(agenciesList.results.size() == 0)
            flash.error = "No se encontraron agencias cercanas para los datos ingresados."

        render(view: "search", model: [lista: agenciesList,
                                       ubicacion: location,
                                       address: address,
                                       radius: radius,
                                       payment_method_id: payment_method_id])
    }
}
