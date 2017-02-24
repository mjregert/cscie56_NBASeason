package cscie56.ps2

class Person {
    String firstName
    String lastName

    static transients = ['fullName']
    static hasOne = [role : PersonRole]

    String getFullName() {
        "$firstName $lastName"
    }

    static belongsTo = [team : Team]

    static constraints = {
        firstName blank: false, nullable: false
        lastName blank: false, nullable: false
        team nullable: false
        role nullable: false
    }
}
