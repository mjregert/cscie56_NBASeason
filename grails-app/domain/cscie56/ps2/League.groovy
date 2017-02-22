package cscie56.ps2

class League {
    static hasMany = [conferences : Conference]

    static belongsTo = [season : Season]

    static constraints = {
        conferences minSize: 2, maxSize: 2 // Max is for NBA Conferences only
    }

}
