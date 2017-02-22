package cscie56_ps2

import cscie56.ps2.Conference
import cscie56.ps2.League
import cscie56.ps2.Season

class BootStrap {

    def init = { servletContext ->
        // Crate a new Season
        def startDate = Date.parse("yyyy-MM-dd", "2017-01-01")
        def endDate =  Date.parse("yyyy-MM-dd", "2017-06-01")
        def s = new Season(name: '2017', startDate: startDate, endDate: endDate)
        s.save(flush: true)

        // Create two new Conferences
        Conference c1 = new Conference(name: 'Western Conference')
        Conference c2 = new Conference(name: 'Eastern Conference')
        c1.save()
        c2.save()

        // Create a new League
        League l = new League(season: s, conferences: [c1, c2])
        l.save(flush: true)
    }

    def destroy = {
    }
}
