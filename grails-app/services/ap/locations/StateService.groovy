package ap.locations

import com.ml.exceptions.BadRequestException
import com.ml.exceptions.NotFoundException

class StateService {

    def serviceMethod() {

    }

	def getState(def idState) {
		
		def stateObtained = State.findById(idState)
					
		if (stateObtained == null) {
			throw new NotFoundException("State doesn't exists", "not_found")
		}
				
		return stateObtained
	}
	
	def insertState(def JSONState) {

		def responseMessage = ""
		def result

		State newState = new State(
			name: JSONState?.name,
			idMeLi: JSONState?.idMeLi,
			country:JSONState?.country
		)
		
		if (!newState.validate()) {
			newState.errors.allErrors.each {responseMessage += MessageFormat.format(it.defaultMessage, it.arguments) + " "}
			throw new BadRequestException("Invalid user data", "bad_request", responseMessage)
		}
		
		newState.save()
		
		return newState
	}
}
