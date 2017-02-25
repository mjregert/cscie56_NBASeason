package cscie56.ps2

import cscie56.ps3.GameStats

class Person {
    String firstName
    String lastName
    String bio
    Date birthDate
    String birthPlace
    int height
    int weight
    String universityAttended

    static hasOne = [role : PersonRole]
//    static hasMany = [gameStats : GameStats]
    static belongsTo = [team : Team]

    static transients = ['fullName']
    String getFullName() {
        "$firstName $lastName"
    }

    static constraints = {
        firstName blank: false, nullable: false
        lastName blank: false, nullable: false
        team nullable: false
        role nullable: false
        bio maxSize: 1023
    }
}
