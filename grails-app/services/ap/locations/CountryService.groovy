package ap.locations

import com.ml.exceptions.NotFoundException

class CountryService {
	
    def serviceMethod() {
		
    }
	
	def getCountry(def idCountry) {
		
		def countryObtained = Country.findById(idCountry)
					
		if (countryObtained == null) {		
			throw new NotFoundException("User doesn't exists", "not_found")
		}
				
		return countryObtained
	}
	
	def insertCountry(def JSONCountry) {

		def responseMessage = ""
		def result

		Country newCountry = new Country(
			name: JSONCountry?.name,
			idMeLi: JSONCountry?.idMeLi
		)	
		
		/*if (!newUser.validate()) {
			newUser.errors.allErrors.each {responseMessage += MessageFormat.format(it.defaultMessage, it.arguments) + " "}
			throw new BadRequestException("Invalid user data", "bad_request", responseMessage)
		}
		else if (User.findByEmail(newUser.email) != null) {
			throw new ConflictException("Email already registered", "conflict")
		}*/
		
		newCountry.save()
		
		return newCountry
	}
}
