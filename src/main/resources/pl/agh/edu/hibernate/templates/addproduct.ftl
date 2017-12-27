<#import "page.ftl" as page>

<@page.page title="Add product">
    <form method="POST" action="/products/add">
        <label>Product name
            <input type="text" placeholder="Enter product name..." required />
        </label>
        <label>Units on stock
            <input type="number" value="1" required>
        </label>
        <input type="submit" value="Add" class="button">
    </form>
</@page.page>