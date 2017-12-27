<#import "page.ftl" as page>

<@page.page title="Transaction details">
    <#if transaction.isDraft()>
        <form method="POST">
            <label>Transaction number:
                <input name="transaction_number" id="transaction_number"
                       type="number" value="${transaction.getTransactionNumber()?c}" />
            </label>
            <label>Quantity:
                <input name="quantity" id="quantity"
                       type="number" value="${transaction.getQuantity()}" />
            </label>
            <label>Customer:
                <select name="customer" id="customer">
                    <option>- Select customer -</option>
                    <#list customers as customer>
                        <option value="${customer.getDbId()}">${customer.getCompanyName()}</option>
                    </#list>
                </select>
            </label>
            <input type="submit" class="button" value="Finish transaction" />
        </form>
    <#else>
        <table>
            <tbody>
            <tr>
                <td>Transaction number:</td>
                <td>${transaction.getTransactionNumber()}</td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td>${transaction.getQuantity()}</td>
            </tr>
            <tr>
                <td>Customer:</td>
                <td>${transaction.getCustomer().getCompanyName()}</td>
            </tr>
            </tbody>
        </table>
    </#if>

    <div class="callout">
        <h3>Products</h3>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Category</th>
                <th>Supplier</th>
            </tr>
            </thead>
            <tbody>
                <#list transaction.getProducts() as product>
                <tr>
                    <td>${product.getProductName()}</td>
                    <td>${product.getCategory().getName()}</td>
                    <td>${product.getSupplier().getCompanyName()}</td>
                </tr>
                </#list>
            </tbody>
        </table>
        <#if transaction.isDraft()>
            <h5>Add product</h5>
            <form action="/transactions/${transaction.getTransactionId()}/addProduct" method="POST">
                <label>Product:
                    <select id="product" name="product">
                        <option>- Select product -</option>
                        <#list products as product>
                            <option value="${product.getDbId()}">
                                ${product.getProductName()}
                            </option>
                        </#list>
                    </select>
                </label>
                <input type="submit" class="button" value="Add product" />
            </form>
        </#if>
    </div>

</@page.page>