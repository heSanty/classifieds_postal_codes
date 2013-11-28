package ap.locations

import javax.servlet.http.HttpServletResponse

class LocationController {

	def locationService
	
    def index() { }
	
	def notAllowed() {	
		def method = request.method
		[response: [message: "Method $method not allowed.", error: "method_not_allowed", status: HttpServletResponse.SC_METHOD_NOT_ALLOWED, cause: []], status: HttpServletResponse.SC_METHOD_NOT_ALLOWED]
	}
	
	def getLocations() {
		def idCountry = params.idCountry
		def postcode = params.postcode
		
		try {
			def locationsObtained = locationService.getLocationsMeli(idCountry,postcode)
			
			render locationsObtained
			
			//[response: [message: locationsObtained, error: "method_not_allowed", status: HttpServletResponse.SC_METHOD_NOT_ALLOWED, cause: []], status: HttpServletResponse.SC_METHOD_NOT_ALLOWED]
			
			//return [paging: [total: locationsObtained.size(), offset: 1, limit: 10], results: locationsObtained, sort: null, available_sorts: null]
			//[response: locationsObtained, status: HttpServletResponse.SC_CREATED]
			
			//render ([paging: [total: locationsMeli.size(), offset: 1, limit: 10], results: locationsMeli, sort: null, available_sorts: null])
		}
		catch (Exception exception) {
			[response: [message: "System Error", error: "system_error", status: HttpServletResponse.SC_INTERNAL_SERVER_ERROR, cause: exception.message], status: HttpServletResponse.SC_INTERNAL_SERVER_ERROR]
		}		
	}
	
	def getRelations() {
		def idCountry = params.idCountry
		def postcode = params.postcode
		
		try {
			def relationsObtained = locationService.getLocationsRelations(idCountry,postcode)
			
			[response: relationsObtained, status: HttpServletResponse.SC_CREATED]
		}
		catch (Exception exception) {
			[response: [message: "System Error", error: "system_error", status: HttpServletResponse.SC_INTERNAL_SERVER_ERROR, cause: exception.message], status: HttpServletResponse.SC_INTERNAL_SERVER_ERROR]
		}
	}
	
	def postLocation() {
		def idCountry = params.idCountry
		def locations = request.JSON
		
		try{
			def locationsPosted = locationService.insertLocations(idCountry, locations)
		
			[response: locationsPosted, status: HttpServletResponse.SC_CREATED]
		}
		catch (Exception exception) {
			[response: [message: "System Error", error: "system_error", status: HttpServletResponse.SC_INTERNAL_SERVER_ERROR, cause: exception.message], status: HttpServletResponse.SC_INTERNAL_SERVER_ERROR]
		}
	}
}
