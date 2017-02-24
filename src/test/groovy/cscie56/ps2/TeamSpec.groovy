package cscie56.ps2

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Team)
@Mock([Game, Person])
class TeamSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that a Team created with all attributes is valid" () {
        when:
        Team t1 = new Team(name: 'Jazz', people: [new Person(firstName: 'first', lastName: 'last', role: 'Player')])
        t1.save(flush: true)
        then:
        t1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that a Team created with no attributes is invalid" () {
        when:
        Team t1 = new Team()
        t1.save(flush: true)
        then:
        !t1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that a Team cannot have more than 82 games" () {
        when:
        def games = []
        for (int i=0; i<90; i++) {
            games << new Game()
        }
        Team t1 = new Team(name: 'Jazz', people: [new Person(firstName: 'first', lastName: 'last', role: 'Player')], games: games)
        t1.save(flush: true)
        then:
        !t1.validate()
    }
}
