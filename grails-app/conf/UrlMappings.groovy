class UrlMappings {

	static mappings = {
		"/ap-locations/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		"/$idCountry/locations/$postcode?"(controller:"location"){
			action = [POST:'postLocation',GET:'getLocations', PUT:'notAllowed', DELETE:'notAllowed']
		}
		
		"/$idCountry/relations/$postcode?"(controller:"location"){
			action = [POST:'notAllowed',GET:'getRelations', PUT:'notAllowed', DELETE:'notAllowed']
		}
		
		/*"/country/$idCountry?"(controller:"Country"){
			action = [POST:'postCountry',GET:'getCountry']
		}
		
		"/state/$idState?"(controller:"State"){
			action = [POST:'postState',GET:'getState', PUT:'notAllowed', DELETE:'notAllowed']
		}*/
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		
		//"404"(controller:'error')
		//"500"(controller:'error')
		
		"500"(view:'/error')
	}
}
