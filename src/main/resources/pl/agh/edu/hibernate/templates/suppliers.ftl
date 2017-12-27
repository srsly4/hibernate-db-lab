<#import "page.ftl" as page>

<@page.page title="Suppliers">
    <div class="callout">
        <a href="/suppliers/add" class="button">Add supplier</a>
    </div>
    <table class="hover">
        <thead>
        <tr>
            <th>Company name</th>
            <th>City</th>
            <th>Zipcode</th>
            <th>Street</th>
            <th>Bank account number</th>
        </tr>
        </thead>
        <tbody>
        <#list suppliers as supplier>
            <tr>
                <td>${supplier.getCompanyName()}</td>
                <td>${supplier.getCity()}</td>
                <td>${supplier.getZipcode()}</td>
                <td>${supplier.getStreet()}</td>
                <td>${supplier.getBankAccountNumber()}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@page.page>