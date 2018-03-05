package tallergrails

class PaymentMethod {

    String id
    String name
    String payment_type_id

    static constraints = {
        id nullable: false, blank: false
        name nullable: false, blank: false
        payment_type_id nullable: false, blank: false
    }



    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getPayment_type_id() {
        return payment_type_id
    }

    void setPayment_type_id(String payment_type_id) {
        this.payment_type_id = payment_type_id
    }

    static getConstraints() {
        return constraints
    }

    static void setConstraints(constraints) {
        PaymentMethod.constraints = constraints
    }

    @Override
    public String toString() {
        return name;
    }
}
