package cscie56.ps2

class Season {

    String name
    Date startDate
    Date endDate

    static hasMany = [leagues : League]

    static constraints = {
        name nullable: false, unique: true
        leagues minSize: 1
        startDate nullable: false
        endDate nullable: false
    }
}
