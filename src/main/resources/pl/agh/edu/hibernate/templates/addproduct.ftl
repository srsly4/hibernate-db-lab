<#import "page.ftl" as page>

<@page.page title="Add product">
    <form method="POST" action="/products/add">
        <label>Product name
            <input name="product_name" id="product_name" type="text" placeholder="Enter product name..." required />
        </label>
        <label>Units on stock
            <input name="units_on_stock" id="units_on_stock"
                   type="number" value="1" required>
        </label>
        <label>
            Category:
            <select name="category" id="category" required>
                <option>- Select category -</option>
                <#list categories as category>
                    <option value="${category.getCategoryId()}">${category.getName()}</option>
                </#list>
            </select>
        </label>
        <label>
            Supplier:
            <select name="supplier" id="supplier" required>
                <option>- Select supplier -</option>
                <#list suppliers as supplier>
                    <option value="${supplier.getDbId()}">${supplier.getCompanyName()}</option>
                </#list>
            </select>
        </label>
        <input type="submit" value="Add" class="button">
    </form>
</@page.page>