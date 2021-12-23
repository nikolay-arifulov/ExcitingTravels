<!doctype html>
<#import "/spring.ftl" as spring>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><@spring.message 'search.title.searchFriends'/></title>
</head>
<body>
<form method="post" action="/search">
    <label><@spring.message 'search.form.label.enterFirstNameOrLastName'/>:
        <br>
        <br>
        <input name="name" placeholder="<@spring.message 'search.form.label.input.firstNameOrLastName'/>">
    </label>
    <input type="submit" value="<@spring.message 'search.form.input.search'/>">
</form>
<br>
<br>
<#if users??>
    <#if users?size == 0>
        <@spring.message 'search.if.nothingFound'/>
    <#else>
        <table>
            <tr>
                <th><@spring.message 'search.table.header.firstName'/></th>
                <th><@spring.message 'search.table.header.lastName'/></th>
                <th><@spring.message 'search.table.header.action'/></th>
            </tr>
            <#list users as user>
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>
                        <#if !currentUser.friends?seq_contains(user)>
                            <form method="post" action="/search/add/${user.id}">
                                <input type="submit" value="<@spring.message 'search.table.list.form.input.add'/>">
                            </form>
                        </#if>
                    </td>
                </tr>
            </#list>
        </table>
    </#if>
</#if>
</body>
</html>