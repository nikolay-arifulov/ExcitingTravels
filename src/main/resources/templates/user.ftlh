<!doctype html>
<#import "/spring.ftl" as spring>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${firstName} ${lastName}</title>
</head>
<body>
<form method="post" action="/search">
    <label><@spring.message 'user.form.label.searchFriends'/>:
        <br>
        <input name="name" placeholder="<@spring.message 'user.form.label.form.firstNameOrLastName'/>">
    </label>
    <input type="submit" value="<@spring.message 'user.form.form.input.search'/>">
</form>
<br>
<a href="/friends"><@spring.message 'user.a.myFriends'/></a>
<br>
<h2><@spring.message 'user.header.addNewTravel'/></h2>
<form method="post" action="/">
    <label><@spring.message 'user.form.label.country'/>:
        <br>
        <input name="country">
    </label>
    <br>
    <br>
    <label><@spring.message 'user.form.label.location'/>:
        <br>
        <input name="location">
    </label>
    <br>
    <br>
    <label><@spring.message 'user.form.label.startDate'/>:
        <br>
        <input type="date" name="startDate">
    </label>
    <br>
    <br>
    <label><@spring.message 'user.form.label.endDate'/>:
        <br>
        <input type="date" name="endDate">
    </label>
    <br>
    <br>
    <label><@spring.message 'user.form.label.header'/>:
        <br>
        <input name="header">
    </label>
    <br>
    <br>
    <label><@spring.message 'user.form.label.description'/>:
        <br>
        <textarea name="description"></textarea>
    </label>
    <br>
    <br>
    <input type="submit" value="<@spring.message 'user.form.input.submit'/>">
</form>
<br>
<h2><@spring.message 'user.header.myTravels'/>:</h2>
<table>
    <tr>
        <th><@spring.message 'user.table.header.header'/></th>
        <th><@spring.message 'user.table.header.description'/></th>
        <th><@spring.message 'user.table.header.country'/></th>
        <th><@spring.message 'user.table.header.location'/></th>
        <th><@spring.message 'user.table.header.startDate'/></th>
        <th><@spring.message 'user.table.header.endDate'/></th>
        <th><@spring.message 'user.table.header.actions'/></th>
    </tr>
    <#list travels as travel>
        <tr>
            <td>${travel.header}</td>
            <td>${travel.description}</td>
            <td>${travel.country}</td>
            <td>${travel.location}</td>
            <td>${travel.startDate}</td>
            <td>${travel.endDate}</td>
            <td>
                <form method="post" action="/travel/delete/${travel.id}">
                    <input type="submit" value="<@spring.message 'user.table.list.form.input.delete'/>">
                </form>
                <a href="/edit/travel/${travel.id}"><@spring.message 'user.table.list.a.edit'/></a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>