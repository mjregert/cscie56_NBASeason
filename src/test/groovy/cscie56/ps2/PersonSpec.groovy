package cscie56.ps2

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Person)
class PersonSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that a Person created with no attributes is invalid" () {
        when:
        Person p1 = new Person()
        p1.save(flush: true)
        then:
        !p1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that a Person created with no first name is invalid" () {
        when:
        Person p1 = new Person(lastName: 'Bird', role: 'Player', team: new Team())
        p1.save(flush:true)
        then:
        !p1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that a Person created with no last name is invalid" () {
        when:
        Person p1 = new Person(firstName: 'Larry', role: 'Player', team: new Team())
        p1.save(flush:true)
        then:
        !p1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that a Person created with no role is invalid" () {
        when:
        Person p1 = new Person(firstName: 'Larry', lastName: 'Bird', team: new Team())
        p1.save(flush:true)
        then:
        !p1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that a Person created with no team is invalid" () {
        when:
        Person p1 = new Person(firstName: 'Larry', lastName: 'Bird',  role: 'PLAYER')
        p1.save(flush:true)
        then:
        !p1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that 'Player' is a valid role" () {
        when:
        Person p1 = new Person(firstName: 'Larry', lastName: 'Bird', role: 'PLAYER', team: new Team())
        p1.save(flush:true)
        then:
        p1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that 'Coach' is a valid role" () {
        when:
        Person p1 = new Person(firstName: 'Larry', lastName: 'Brown', role: 'COACH', team: new Team())
        p1.save(flush:true)
        then:
        p1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that 'Ref' is an invalid valid role" () {
        when:
        Person p1 = new Person(firstName: 'Larry', lastName: 'Smith', role: 'REF', team: new Team())
        p1.save(flush:true)
        then:
        !p1.validate()
    }
}
