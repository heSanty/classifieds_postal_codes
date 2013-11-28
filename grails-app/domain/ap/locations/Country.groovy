package ap.locations

class Country {
	String name
	String idMeLi

    static constraints = {
		name blank: false, unique: true,size: 4..40
    }
	
	static hasMany = [states: State]
	
	//static mapping = {
	//	table "Country"
	//	id column: "idCountry"
	//}
}
