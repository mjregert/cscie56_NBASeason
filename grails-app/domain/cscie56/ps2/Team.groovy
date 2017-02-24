package cscie56.ps2

class Team {
    String name

    static hasMany = [games : Game, people : Person]

    static constraints = {
        name unique: true, nullable: false, blank: false
        people minSize: 1
        games minSize: 0, maxSize: 82 // 0 if season hasn't started yet, max 82 for NBA Season only
    }
}
