<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <div>
        <@l.logout/>
    </div>
    <div>
        <form method="post" >
            <input type="text" name="author" placeholder="Введите автора" />
            <input type="text" name="name" placeholder="Название">
            <input type="text" name="year" placeholder="Год выпуска">
            <input type="text" name="time" placeholder="Время">
            <input type="text" name="description" placeholder="Описание">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
    <div>Список видео</div>

    <#list videos as video>
        <div>
            <b>${video.id}</b>
            <span>${video.description}</span>
        </div>
    <#else>
        No videos
    </#list>


</@c.page>