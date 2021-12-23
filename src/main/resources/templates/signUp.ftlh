<!doctype html>
<#import "/spring.ftl" as spring>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><@spring.message 'singUp.title.registration'/></title>
</head>
<body>
<h2><@spring.message 'signUp.header.newUserRegistration'/></h2>
<form method="post" action="/signUp">
    <label><@spring.message 'signUp.form.label.firstName'/>:
        <br>
        <input name="firstName" placeholder="<@spring.message 'signUp.form.label.firstName'/>">
    </label>
    <br>
    <br>
    <label><@spring.message 'signUp.form.label.lastName'/>:
        <br>
        <input name="lastName" placeholder="<@spring.message 'signUp.form.label.lastName'/>">
    </label>
    <br>
    <br>
    <label><@spring.message 'signUp.form.label.username'/>:
        <br>
        <input name="username" placeholder="<@spring.message 'signUp.form.label.input.username'/>">
    </label>
    <br>
    <br>
    <label>Email:
        <br>
        <input type="email" name="email" placeholder="Email">
    </label>
    <br>
    <br>
    <label><@spring.message 'signUp.form.label.password'/>:
        <br>
        <input type="password" name="password" placeholder="<@spring.message 'signUp.form.label.password'/>">
    </label>
    <br>
    <br>
    <label><@spring.message 'signUp.form.label.dateOfBirth'/>:
        <br>
        <input type="date" name="dateOfBirth" placeholder="<@spring.message 'signUp.form.label.dateOfBirth'/>">
    </label>
    <br>
    <br>
    <input type="submit" value="<@spring.message 'signUp.form.input.submit'/>">
</form>
</body>
</html>