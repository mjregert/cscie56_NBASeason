package cscie56.ps2

class Season {

    String name
    Date startDate
    Date endDate

    static hasMany = [games : Game, leagues : League]

    static constraints = {
        name nullable: false, unique: true
        games minSize: 0, maxSize: 82 // 0 if season hasn't started yet, max 82 for NBA Season only
        leagues minSize: 1
        startDate nullable: false
        endDate nullable: false
    }
}
