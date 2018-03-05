package tallergrails

class Agency {

    String description
    String distance
    String agency_code
    String correspondent_id
    String disabled
    String id
    String payment_method_id
    String phone
    String site_id
    String terminal
    Address address

    static constraints = {
        description nullable: false, blank: false
        distance nullable: false, blank: false
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }

    String getDistance() {
        return distance
    }

    void setDistance(String distance) {
        this.distance = distance
    }

    String getAgency_code() {
        return agency_code
    }

    void setAgency_code(String agency_code) {
        this.agency_code = agency_code
    }

    String getCorrespondent_id() {
        return correspondent_id
    }

    void setCorrespondent_id(String correspondent_id) {
        this.correspondent_id = correspondent_id
    }

    String getDisabled() {
        return disabled
    }

    void setDisabled(String disabled) {
        this.disabled = disabled
    }

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getPayment_method_id() {
        return payment_method_id
    }

    void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id
    }

    String getPhone() {
        return phone
    }

    void setPhone(String phone) {
        this.phone = phone
    }

    String getSite_id() {
        return site_id
    }

    void setSite_id(String site_id) {
        this.site_id = site_id
    }

    String getTerminal() {
        return terminal
    }

    void setTerminal(String terminal) {
        this.terminal = terminal
    }

    Address getAddress() {
        return address
    }

    void setAddress(Address address) {
        this.address = address
    }

    @Override
    public String toString() {
        return description
    }
}
