package ap.locations

class Postcode {
	String postcode
	String idMeLi

    static constraints = {
		postcode blank: false, size:4..10
    }
	
	static hasMany = [neighborhoods: Neighborhood]
	static belongsTo = [municipality:Municipality]
	
	//static mapping = {
	//	table "Postcode"
	//	id column: "idPostcode"
	//}
}
