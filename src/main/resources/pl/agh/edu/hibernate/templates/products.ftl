<#import "page.ftl" as page>

<@page.page title="Products">
    <div class="callout">
        <a href="/products/add" class="button">Add product</a>
    </div>
    <table class="hover">
        <thead>
        <tr>
            <th>Name</th>
            <th>Units on stock</th>
            <th>Category</th>
            <th>Supplier</th>
        </tr>
        </thead>
        <tbody>
        <#list products as product>
            <tr>
                <td>${product.getProductName()}</td>
                <td>${product.getUnitsOnStock()}</td>
                <td>${product.getCategory().getName()}</td>
                <td>${product.getSupplier().getCompanyName()}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@page.page>