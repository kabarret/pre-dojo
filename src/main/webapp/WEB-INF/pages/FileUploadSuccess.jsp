<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <!-- Le styles -->
    <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">
    <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://getbootstrap.com/2.3.2/assets/js/html5shiv.js"></script>
    <![endif]-->

</head>
<body>
<div class="container">
    <h1>Ranking</h1>

    <c:forEach items="${rank.getMatchUserRank()}" var="rank">
        <div style="display: inline;">
            <h3>Match - ${rank.key} </h3>
        </div>
        <table class="table table-bordered table-striped">
            <tr>
                <th>Rank</th>
                <th>User</th>
                <th>killCount</th>
                <th>DeathCount</th>
                <th>Streak</th>
                <th>Favorite Weapon</th>
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
</div>

</body>
</html>