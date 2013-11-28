package ap.locations

class State {

    String name
	String idMeLi

    static constraints = {
		name blank: false, size: 4..40
    }
	
	static hasMany = [municipalities: Municipality]
	static belongsTo = [country:Country]
	
	//static mapping = {
	//	table "State"
	//	id column: "idState"
	//}
}
