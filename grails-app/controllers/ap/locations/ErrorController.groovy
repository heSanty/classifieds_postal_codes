package ap.locations

import com.ml.exceptions.MercadoLibreAPIException

class ErrorController {

    def index = {
		
		println request.exception
		def exception = request.exception.cause
		def status
		def message
		def error
		if ( exception in MercadoLibreAPIException ){
			status = exception.status
			error = exception.error
			message = exception.message
			if ( status == 500 ){
				log.error message
				message = "Oops, something went wrong"
			}
		}else{
			status = 500
			message = "Oops, something went wrong"
			error = "internal_error" 
			log.error exception
		}
		
		Map jsonResponse = [:]
		jsonResponse.status = status
		jsonResponse.error = error
		jsonResponse.errorMessage = message
		
		[response: jsonResponse, status: jsonResponse.status]	
	}
}