import ap.locations.Location

class BootStrap {

    def init = { servletContext ->
		development {
			
			def locationA = new Location(
				name: 		'Santa Fe Cuajimalpa',
				postcode: 	'05348',
				idMeLi:		'TUxNQkRFUzI0NDk',
				idCountry:	'MX'
			)
			
			locationA.save()
	
		
			def locationB = new Location(
				name: 		'El Molinito',
				postcode: 	'05310',
				idMeLi:		'TUxNQkVMIDczNjRB',
				idCountry:	'MX'
			)
			
			locationB.save()
		}
		
		test {}
		
		production {}
    }
	
    def destroy = {
    }
}
