<!doctype html>
<#import "/spring.ftl" as spring>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><@spring.message 'edit_travel.title.editTravel'/></title>
</head>
<body>
<form method="post" action="/edit/travel/${travel.id}">
    <label><@spring.message 'user.form.label.country'/>:
        <br>
        <input name="country" value="${travel.country}">
    </label>
    <br>
    <br>
    <label><@spring.message 'user.form.label.location'/>:
        <br>
        <input name="location" value="${travel.location}">
    </label>
    <br>
    <br>
    <label><@spring.message 'user.form.label.startDate'/>:
        <br>
        <input type="date" name="startDate" value="${travel.startDate}">
    </label>
    <br>
    <br>
    <label><@spring.message 'user.form.label.endDate'/>:
        <br>
        <input type="date" name="endDate" value="${travel.endDate}">
    </label>
    <br>
    <br>
    <label><@spring.message 'user.form.label.header'/>:
        <br>
        <input name="header" value="${travel.header}">
    </label>
    <br>
    <br>
    <label><@spring.message 'user.form.label.description'/>:
        <br>
        <textarea name="description">${travel.description}</textarea>
    </label>
    <br>
    <br>
    <input type="submit" value="<@spring.message 'user.form.input.submit'/>">
</form>
</body>
</html>