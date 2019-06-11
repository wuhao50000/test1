<html>
    <head>
        <meta charset="utf-8">
        <title>Freemarker入门</title>
    </head>


    <body>
        <#--注释 不会输出 不会显示在源码中 -->
        ${name},你好.${message}
        <br>
        <#assign info={"key1":"value1","key2":"value2"}>
        自定义对象测试: info.key1:${info.key1} &nbsp;&nbsp;&nbsp;info.key2:${info.key2}

        <br>
        <#if flag=true>
            flag为true
            <#else >
            flag为false
        </#if>
    </body>
</html>