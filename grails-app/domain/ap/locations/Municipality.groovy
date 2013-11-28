package ap.locations

class Municipality {
	String name
	String idMeLi

    static constraints = {
		name blank: false, size: 4..40
    }
	
	static hasMany = [postcode: Postcode]
	static belongsTo = [state:State]
	
	//static mapping = {
	//	table "Municipality"
	//	id column: "idMunicipality"
	//}
}
