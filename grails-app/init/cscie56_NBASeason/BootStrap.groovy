package cscie56_NBASeason

import cscie56.ps2.Conference
import cscie56.ps2.Game
import cscie56.ps2.League
import cscie56.ps2.Person
import cscie56.ps2.Season
import cscie56.ps2.Team

class BootStrap {

    def init = { servletContext ->
        // Crate a new Season
        def startDate = Date.parse("yyyy-MM-dd", "2017-01-01")
        def endDate =  Date.parse("yyyy-MM-dd", "2017-06-01")
        def s = new Season(name: '2017', startDate: startDate, endDate: endDate)
        s.save(flush: true)

        // Create two new Conferences
        Conference wc = new Conference(name: 'Western Conference')
        Conference ec = new Conference(name: 'Eastern Conference')
        wc.save()
        ec.save()

        // Create a new League
        League l = new League(season: s, conferences: [wc, ec])
        l.save(flush: true)

        // Create each Team for the Conferences
        def westernConfTeamNames = ['Warriors', 'Spurs', 'Rockets', 'Jazz']
        def easternConfTeamNames = ['Cavaliers', 'Celtics', 'Wizards', 'Raptors']
        def westernConfTeams = []
        def easternConfTeams = []

        for (int i=0; i<westernConfTeamNames.size(); i++) {
            Team team = new Team(name: westernConfTeamNames[i], conference: wc, games: [], people: [])
            team.save(flush: true)

            for (int j=1; j< 4; j++) {
                Person p = new Person(firstName: 'Michael', lastName: 'Jones' + j, role: 'PLAYER', team: team)
                p.save(flush: true)
            }

            for (int k=1; k<=1; k++) {
                Person c = new Person(firstName: 'Bob', lastName: 'Smith' + k, role: 'COACH', team: team)
                c.save(flush: true)
            }

            westernConfTeams << team
        }

        for (int i=0; i<easternConfTeamNames.size(); i++) {
            Team team = new Team(name: easternConfTeamNames[i], conference: ec, games: [])
            team.save(flush: true)
            // Testing game here
            Game g = new Game(homeTeam: team, venue: 'HOME')
            g.save(flush: true)
            easternConfTeams << team
        }

        // Add the teams to the Conferences
        ec.teams = easternConfTeams
        wc.teams = westernConfTeams
        ec.save()
        wc.save()


/*
        // Loop through each conference
        l.conferences.each {
            for (int i=0; i<it.teams.size(); i++) {
                Team team1 = it.teams[i]
                Game game = new Game(homeTeam: team1)
                game.save(flush: true)
                games << game
                team1.games << games
            }
        }
*/
    }

    def destroy = {
    }
}
