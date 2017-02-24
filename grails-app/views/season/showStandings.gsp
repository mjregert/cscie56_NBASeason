<%--
  Created by IntelliJ IDEA.
  User: michaelregert
  Date: 2/22/17
  Time: 12:05 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Test Show Standings Page</title>
</head>

<body>
    <h1>NBA Standings</h1>
    <h2>${this.season.name} Season</h2>
    <h3>${season.leagues[0].conferences[0].name}</h3>
    <table>
        <tr>
            <th>#</th>
            <th>Team</th>
            <th>W</th>
            <th>L</th>
            <th>PCT</th>
            <th>GB</th>
            <th>HOME</th>
            <th>ROAD</th>
            <th>L10</th>
            <th>STRK</th>
        </tr>
        <g:each var="team" in="${season.leagues[0].conferences[0].teams}">
            <tr>
                <td>${team.id}</td>
                <td>${team.name}</td>
                <td>${team.getW()}</td>
                <td>${team.getL()}</td>
                <td>${team.getPCT()}</td>
                <td>${team.getGB()}</td>
                <td>${team.getHOME()}</td>
                <td>${team.getROAD()}</td>
                <td>${team.getL10()}</td>
                <td>${team.getSTRK()}</td>
            </tr>
        </g:each>
    </table>
<h3>${season.leagues[0].conferences[1].name}</h3>
<table>
    <tr>
        <th>#</th>
        <th>Team</th>
    </tr>
    <g:each var="team" in="${season.leagues[0].conferences[1].teams}">
        <tr>
            <td>${team.id}</td>
            <td>${team.name}</td>
        </tr>
    </g:each>
</table>

</body>
</html>