package cscie56.ps2

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(League)
@Mock([Season, Conference])
class LeagueSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that there are only 2 conferences"() {
        when:
        def s1 = new Season(name: '2017')
        def c1 = new Conference(name: 'Western Conference')
        def c2 = new Conference(name: 'Eastern Conference')
        League l1 = new League(season: s1, conferences: [c1, c2])
        l1.save(flush: true)
        then:
        l1.validate()
    }

    //-------------------------------------------------------------------
    void "Test that more than 2 conferences is invalid"() {
        when:
        def s1 = new Season(name: '2017')
        def c1 = new Conference(name: 'Western Conference')
        def c2 = new Conference(name: 'Eastern Conference')
        def c3 = new Conference(name: 'Other Conference')
        League l1 = new League(season: s1, conferences: [c1, c2, c3])
        l1.save(flush: true)
        then:
        !l1.validate()
    }

    //-------------------------------------------------------------------
    void "Test that only 1 conference is invalid"() {
        when:
        def s1 = new Season(name: '2017')
        def c1 = new Conference(name: 'Western Conference')
        League l1 = new League(season: s1, conferences: [c1])
        then:
        !l1.validate()
    }
}
