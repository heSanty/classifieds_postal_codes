package ap.locations

import javax.servlet.http.HttpServletResponse

class CountryController {
	
	def countryService
	
	def notAllowed() {
		def method = request.method
		[response: [message: "Method $method not allowed.", error: "method_not_allowed", status: HttpServletResponse.SC_METHOD_NOT_ALLOWED, cause: []], status: HttpServletResponse.SC_METHOD_NOT_ALLOWED]
	}
	
	def getCountry() {
		
		def idCountry = params.idCountry
		
		def countryObtained = countryService.getCountry(idCountry)
		
		[response: countryObtained, status: HttpServletResponse.SC_CREATED]
		
	}
	
	def postCountry() {
		
		//def countryObtained = countryService.getCountry(request.JSON)
		
		//if (countryObtained.size() != 0) {
		//	println "Attribute Invalid $countryObtained \n"
			
			//log.error("Attribute Invalid $country \n")
			//throw new BadRequestException("Attribute $country already exist")
		//}
		
		def countryPosted = countryService.insertCountry(request.JSON)
		
		[response: countryPosted, status: HttpServletResponse.SC_CREATED]
	}
}
