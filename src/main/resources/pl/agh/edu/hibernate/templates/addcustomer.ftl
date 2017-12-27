<#import "page.ftl" as page>

<@page.page title="Add customer">
    <form method="POST" action="/customers/add">
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
        <label>Discount (in %)
            <input name="discount" id="discount"
                type="number" required
            />
        </label>
        <input type="submit" value="Add" class="button">
    </form>
</@page.page>