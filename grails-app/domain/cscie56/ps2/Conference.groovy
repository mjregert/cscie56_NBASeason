package cscie56.ps2

class Conference {
    String name

    static belongsTo = [league : League]

    static hasMany = [teams : Team]

    static constraints = {
        name unique: true, nullable: false, blank: false
        league nullable: false
    }
}
