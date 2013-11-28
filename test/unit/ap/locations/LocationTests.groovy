package ap.locations

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Location)
class LocationTests {

    def registeredLocation
    def sampleLocation

    @Before
    void setUp() {

        registeredLocation = new Location(
            name: 		'Santa Fe Cuajimalpa',
            postcode: 	'05348',
			idMeLi:		'TUxNQkRFUzI0NDk',
			idCountry:	'MX'
        )

        mockForConstraintsTests(Location, [registeredLocation])

        sampleLocation = new Location(
			name: 		'El Molinito',
            postcode: 	'05310',
			idMeLi:		'TUxNQkVMIDczNjRB',
			idCountry:	'MX'
        )
    }
	
	void test_LocationIsNotValid_WithBlankName() {
		sampleLocation.setName("")
		assertFalse(sampleLocation.validate())
		assertEquals('Name is blank', 'blank', sampleLocation.errors['name'])
	}

}
