<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<div style="display: inline;">
<h2>Ranking</h2>
</div>
<c:forEach items="${rank.getMatchUserRank()}" var="rank">
    <div style="display: inline;">
        <h3>Match - ${rank.key} </h3>
    </div>
    <table>
        <tr>
            <th style="width: 50px">Rank</th>
            <th style="width: 100px">User</th>
            <th style="width: 100px">killCount</th>
            <th style="width: 100px">DeathCount</th>
            <th style="width: 100px">Streak</th>
            <th style="width: 100px">Favorite Weapon</th>
            <th></th>
        </tr>
        <c:forEach items="${rank.value}" var="userRank" varStatus="i">
            <tr>
                <td style="text-align: left">${i.index+1}</td>
                <td style="text-align: center">${userRank.getUser().getName()}</td>
                <td style="text-align: center">${userRank.getKillCount()}</td>
                <td style="text-align: center">${userRank.getDeathsCount()}</td>
                <td style="text-align: center">${userRank.getStreak()}</td>
                <td style="text-align: center">${userRank.getFavoriteWeapon()}</td>
                <th><c:if test="${userRank.isPerfect()}"><b>PERFECT</b></c:if></th>
            </tr>
        </c:forEach>
    </table>
    <hr/>
</c:forEach>

</body>
</html>