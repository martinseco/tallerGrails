package tallergrails

import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper

@Transactional
class PaymentMethodService {

    List<PaymentMethod> getAllPaymentMethods() {

        def url = new URL('https://api.mercadolibre.com/sites/MLA/payment_methods')
        def connection = (HttpURLConnection)url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        JsonSlurper json = new JsonSlurper()

        List<PaymentMethod> paymentMethods = json.parse(connection.getInputStream())

        return paymentMethods
    }
}
