<#import "page.ftl" as page>

<@page.page title="Add category">
    <form method="POST" action="/categories/add">
        <label>Product name
            <input name="category_name" id="category_name"
                   type="text" placeholder="Enter category name..." required />
        </label>
        <input type="submit" value="Add" class="button">
    </form>
</@page.page>