<!doctype html>
<#import "/spring.ftl" as spring>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><@spring.message 'signIn.title.signIn'/></title>
</head>
<body>
<form method="post" action="/signIn">
    <label><@spring.message 'signIn.form.label.username'/>:
        <br>
        <input size="30" name="username" placeholder="<@spring.message 'signIn.form.label.username'/>">
    </label>
    <br>
    <br>
    <label><@spring.message 'signIn.form.label.password'/>:
        <br>
        <input size="30" type="password" name="password" placeholder="<@spring.message 'signIn.form.label.password'/>">
    </label>
    <br>
    <br>
    <input type="submit" value="<@spring.message 'signIn.form.input.submit'/>">
</form>
</body>
</html>