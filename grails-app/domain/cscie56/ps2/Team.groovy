package cscie56.ps2

class Team {
    String name

    static hasMany = [people : Person]

    static constraints = {
        name unique: true, nullable: false, blank: false
        people minSize: 1
    }
}
