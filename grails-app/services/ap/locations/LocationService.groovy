package ap.locations

@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.5.0-RC2' )
import com.ml.exceptions.NotFoundException
import org.apache.http.HttpStatus
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication
import grails.util.Environment
import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

class LocationService {

	def URLAPILocations	= "https://api.mercadolibre.com/classified_locations/neighborhoods/"
	
    def serviceMethod() {

    }
	
	def getLocationsMeli(String idCountry, String postcode) {
		if (postcode == null){
			throw new NotFoundException("Postcode doesn't exists", "not_found")
		}
		
		def relations		= Location.findAll("FROM Location AS L where L.idCountry=:idCountry AND L.postcode=:postcode", [idCountry: idCountry, postcode:postcode])
		def locationsMeli	= []
		def locationMeli
		def idMeLi
		
		if (relations == null){
			throw new NotFoundException("Postcode doesn't exists!", "not_found")
		}
		
		relations.each {
			idMeLi = it.idMeLi
			
			//idMeLi = "TUxNQkFCRTI5MTU"
			
			locationMeli = getData(URLAPILocations + idMeLi)
			
			if (locationMeli == null){
				throw new NotFoundException("Postcode doesn't exists", "not_found")
			}
			
			locationsMeli.add(locationMeli)
		}
		
		return [paging: [total: locationsMeli.size(), offset: 1, limit: 10], results: locationsMeli, sort: null, available_sorts: null]
		//return locationsMeli
	}
	
	def getLocationsRelations(String idCountry, String postcode) {
		def relationsObtained	= Location.findAll("FROM Location AS L where L.idCountry=:idCountry AND L.postcode=:postcode", [idCountry: idCountry, postcode:postcode])
		
		if (relationsObtained == null){
			throw new NotFoundException("Postcode doesn't exists!", "not_found")
		}
				
		return relationsObtained
	}
	
	def insertLocations(String idCountry, def JSONLocation) {

		def newLocations	= []
		def result			= JSONLocation		
		
		result.each {
			Location location = new Location(
				name:		it.name,
				postcode:	it.postcode,
				idMeLi:		it.idMeLi,
				idCountry:	idCountry
			)

			location.save()

			newLocations.add(location)
		}

		return newLocations
	}
	
	def getData(String source) {
			
		def result = ''
		int status
			
		def http = new  HTTPBuilder(source)

		http.request( GET, JSON ) {

			response.success = { resp, json ->
				status =  resp.statusLine.statusCode
				result = json
			}

			response.failure = { resp ->
				status = resp.statusLine.statusCode
				result = "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
			}
					
		}
			
		return result		
	}
}
