package cscie56.ps2

class Team {
    String name

    static transients = ['W', 'L', 'PCT', 'GB', 'HOME', 'ROAD', 'L10', 'STRK']

    String getW() {
        return "W"
    }

    String getL() {
        return "L"
    }

    String getPCT() {
        return "PCT"
    }

    String getGB() {
        return "GB"
    }

    String getHOME() {
        return "HOME"
    }

    String getROAD() {
        return "ROAD"
    }

    String getL10() {
        return "L10"
    }

    String getSTRK() {
        return "STRK"
    }

    static hasMany = [games : Game, people : Person]

    static belongsTo = [conference : Conference]

    static constraints = {
        name unique: true, nullable: false, blank: false
        //people minSize: 1
        games minSize: 0, maxSize: 82 // 0 if season hasn't started yet, max 82 for NBA Season only
    }
}
