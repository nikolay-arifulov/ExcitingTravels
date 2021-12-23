<!doctype html>
<#import "/spring.ftl" as spring>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${user.firstName} ${user.lastName}</title>
</head>
<body>
<h2>${user.firstName} ${user.lastName}</h2>
<h3><@spring.message 'friend.header.age'/>: ${userAge}</h3>
<h2><@spring.message 'friend.header.travels'/>:</h2>
<table>
    <tr>
        <th><@spring.message 'friend.table.header.header'/></th>
        <th><@spring.message 'friend.table.header.description'/></th>
        <th><@spring.message 'friend.table.header.country'/></th>
        <th><@spring.message 'friend.table.header.location'/></th>
        <th><@spring.message 'friend.table.header.startDate'/></th>
        <th><@spring.message 'friend.table.header.endDate'/></th>
    </tr>
    <#list user.travels as travel>
        <tr>
            <td>${travel.header}</td>
            <td>${travel.description}</td>
            <td>${travel.country}</td>
            <td>${travel.location}</td>
            <td>${travel.startDate}</td>
            <td>${travel.endDate}</td>
        </tr>
    </#list>
</table>
</body>
</html>