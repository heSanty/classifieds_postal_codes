package ap.locations

class StateController {

    def stateService
	
	def notAllowed() {
		def method = request.method
		[response: [message: "Method $method not allowed.", error: "method_not_allowed", status: HttpServletResponse.SC_METHOD_NOT_ALLOWED, cause: []], status: HttpServletResponse.SC_METHOD_NOT_ALLOWED]
	}
	
	def getState() {

		def idState = params.idState
		
		def stateObtained = stateService.getState(idState)
		
		[response: stateObtained, status: HttpServletResponse.SC_CREATED]
		
	}
	
	def postState() {
		
		def statePosted = stateService.insertState(request.JSON)
		
		[response: statePosted, status: HttpServletResponse.SC_CREATED]
	}
}
