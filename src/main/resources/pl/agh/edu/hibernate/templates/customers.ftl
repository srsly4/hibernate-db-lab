<#import "page.ftl" as page>

<@page.page title="Customers">
    <div class="callout">
        <a href="/customers/add" class="button">Add customer</a>
    </div>
    <table class="hover">
        <thead>
        <tr>
            <th>Company name</th>
            <th>City</th>
            <th>Zipcode</th>
            <th>Street</th>
            <th>Discount</th>
        </tr>
        </thead>
        <tbody>
        <#list customers as customer>
            <tr>
                <td>${customer.getCompanyName()}</td>
                <td>${customer.getCity()}</td>
                <td>${customer.getZipcode()}</td>
                <td>${customer.getStreet()}</td>
                <td>${customer.getDiscount()}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@page.page>