package ap.locations

class Location {
	String postcode
	String name
	String idMeLi
	String idCountry

    static constraints = {
		postcode blank: false, size:4..10
		name blank: false
		idCountry blank: false
    }
	
	static mapping = {
		table "Location"
		id column: "idLocation"
	}
}
