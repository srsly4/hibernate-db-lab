<#import "page.ftl" as page>

<@page.page title="Categories">
    <div class="callout">
        <a href="/categories/add" class="button">Add category</a>
    </div>
    <table class="hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <#list categories as category>
            <tr>
            <tr>
                <td>${category.getCategoryId()}</td>
                <td>${category.getName()}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@page.page>