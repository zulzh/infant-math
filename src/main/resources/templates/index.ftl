<!DOCTYPE html>
<html lang="en" xmlns:display="http://www.w3.org/1999/xhtml">
<head>
    <title>幼儿园中班数学试卷-心月</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <style>
        html {
            font-size: 14px;
            font-weight: 400;
        }
        .exp {
            font-size: 12px;
            color: lightgray;
        }
    </style>
</head>
<body>
<br>
        <#list questionList as item>
            <span style="width:160px;height:50px;display:inline-block;font-size: 20px" >${item!}</span>
            <#if (item_index+1)%4=0>
                </br>
            </#if>
        </#list>

<br>
</body>
</html>