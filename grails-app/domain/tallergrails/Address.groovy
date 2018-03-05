package tallergrails

class Address {

    String address_line
    String city
    String country
    String location
    String other_info
    String state
    String zip_code

    static constraints = {
    }

    String getAddress_line() {
        return address_line
    }

    void setAddress_line(String address_line) {
        this.address_line = address_line
    }

    String getCity() {
        return city
    }

    void setCity(String city) {
        this.city = city
    }

    String getCountry() {
        return country
    }

    void setCountry(String country) {
        this.country = country
    }

    String getLocation() {
        return location
    }

    void setLocation(String location) {
        this.location = location
    }

    String getOther_info() {
        return other_info
    }

    void setOther_info(String other_info) {
        this.other_info = other_info
    }

    String getState() {
        return state
    }

    void setState(String state) {
        this.state = state
    }

    String getZip_code() {
        return zip_code
    }

    void setZip_code(String zip_code) {
        this.zip_code = zip_code
    }

}
