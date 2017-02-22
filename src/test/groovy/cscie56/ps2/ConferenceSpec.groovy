package cscie56.ps2

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Conference)
@Mock(League)
class ConferenceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that a Conference created with all attributes is valid" () {
        when:
        Conference c1 = new Conference(name: 'Western Conference', league: new League())
        c1.save(flush: true)
        then:
        c1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that a Conference created with no attributes is invalid" () {
        when:
        Conference c1 = new Conference()
        c1.save(flush: true)
        then:
        !c1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that a Conference created with no name is invalid" () {
        when:
        Conference c1 = new Conference(league: new League())
        c1.save(flush: true)
        then:
        !c1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that a Conference created with no league is invalid" () {
        when:
        Conference c1 = new Conference(name: 'Western Conference')
        c1.save(flush: true)
        then:
        !c1.validate()
    }
}
