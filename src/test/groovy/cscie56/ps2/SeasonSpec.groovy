package cscie56.ps2

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Season)
@Mock([Game, League])
class SeasonSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that a Season created with no attributes is invalid" () {
        when:
        Season s1 = new Season()
        s1.save(flush: true)
        then:
        !s1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that a Season created with no start date is invalid" () {
        when:
        Season s1 = new Season(name: '2017', endDate: new Date())
        s1.save(flush: true)
        then:
        !s1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that a Season created with no end date is invalid" () {
        when:
        Season s1 = new Season(name: '2017', startDate: new Date())
        s1.save(flush: true)
        then:
        !s1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that a Season cannot have more than 82 games" () {
        when:
        def games = []
        for (int i=0; i<90; i++) {
            games << new Game()
        }
        Season s1 = new Season(name: '2017', startDate: new Date(), games: games)
        s1.save(flush: true)
        then:
        !s1.validate()
    }

    //-------------------------------------------------------------------

    void "Test that name is unique" () {
        when:
        Season s1 = new Season(name: '2017', startDate: new Date(), endDate: new Date())
        s1.save(flush: true)
        Season s2 = new Season(name: '2017', startDate: new Date(), endDate: new Date())
        s2.save()

        then:
        s1.validate()
        !s2.validate()
    }
}
