package cscie56_ps2

import cscie56.ps2.Season

class BootStrap {

    def init = { servletContext ->
        // Crate a new Season
        def startDate = Date.parse("yyyy-MM-dd", "2017-01-01")
        def endDate =  Date.parse("yyyy-MM-dd", "2017-06-01")
        Season s = new Season(name: '2017', startDate: startDate, endDate: endDate)
        s.save(flush: true)
    }
    def destroy = {
    }
}
