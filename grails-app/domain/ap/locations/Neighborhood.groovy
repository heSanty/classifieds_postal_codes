package ap.locations

class Neighborhood {
	String name
	String idMeLi

    static constraints = {
		name blank: false, size: 4..80
    }
	
	static belongsTo = [postcode:Postcode]
	
	//static mapping = {
	//	table "Neighborhood"
	//	id column: "idNeighborhood"
	//}
}
