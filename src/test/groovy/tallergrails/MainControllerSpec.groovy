package tallergrails

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import sun.applet.Main

class MainControllerSpec extends Specification implements ControllerUnitTest<MainController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    void "test index view con paymentMethods"() {
        given:
        controller.paymentMethodService = Mock(PaymentMethodService) {

            getAllPaymentMethods() >> [new PaymentMethod(id:"rapipago", name:"RapiPago", payment_type_id: "ticket")]
        }

        when: "se llama al controlador, metodo index"
        controller.index()

        then: "se muestra pagina index"
        view == "/main/index"
    }

    void "test search valido"() {
        given:
        controller.mainService = Mock(MainService) {
            getLocationDetails("Boulevard Illia 651, Cordoba") >> ["-30.70777", "-62.0031906"]
        }
        controller.agencyService = Mock(AgencyService) {
            getAgencysByLocation("rapipago", "1000", "-30.70777", "-62.0031906") >> [""]
        }

        controller.params.put("direccion", "Boulevard Illia 651, Cordoba")
        controller.params.put("radio", "1000")
        controller.params.put("paymentMethod", "rapipago")


        when: "se llama al controlador, metodo search"
        controller.search()

        then: "se muestra la pagina search"
        view == "/main/search"
    }
}
