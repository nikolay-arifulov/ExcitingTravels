<!doctype html>
<#import "/spring.ftl" as spring>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><@spring.message 'friends.table.title.myFriends'/></title>
</head>
<body>
<a href="/"><@spring.message 'friends.a.myPage'/></a>
<br>
<h2><@spring.message 'friends.header.myFriends'/>:</h2>
<table>
    <tr>
        <th><@spring.message 'friends.table.header.firstName'/></th>
        <th><@spring.message 'friends.table.header.lastName'/></th>
        <th><@spring.message 'friends.table.header.link'/></th>
        <th><@spring.message 'friends.table.header.action'/></th>
    </tr>
    <#list friends as friend>
        <tr>
            <td>${friend.firstName}</td>
            <td>${friend.lastName}</td>
            <td>
                <a href="/${friend.username}"><@spring.message 'friends.table.list.a.follow'/></a>
            </td>
            <td>
                <form method="post" action="/friends/delete/${friend.id}">
                    <input type="submit" value="<@spring.message 'friends.table.list.form.input.delete'/>">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>