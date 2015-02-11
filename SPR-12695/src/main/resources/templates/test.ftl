<#import "/spring.ftl" as spring />
<html>
    <form action="" method="POST">
        Name:
        <@spring.formInput "command.name"/>
        <@spring.showErrors "<br>"/>
        <input type="submit" value="submit"/>
    </form>
</html>