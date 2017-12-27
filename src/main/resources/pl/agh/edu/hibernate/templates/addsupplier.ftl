<#import "page.ftl" as page>

<@page.page title="Add supplier">
    <form method="POST" action="/suppliers/add">
        <label>Company name
            <input name="company_name" id="company_name"
                   type="text" required />
        </label>
        <label>City
            <input name="city" id="city"
                   type="text" required />
        </label>
        <label>Street
            <input name="street" id="street"
                   type="text" required />
        </label>
        <label>Zipcode
            <input name="zipcode" id="zipcode"
                   type="text" required />
        </label>
        <label>Bank account number
            <input name="bankaccountnumber" id="bankaccountnumber"
                type="text" required
            />
        </label>
        <input type="submit" value="Add" class="button">
    </form>
</@page.page>