<#import "page.ftl" as page>

<@page.page title="Transactions">
    <div class="callout">
        <a href="/transactions/create" class="button">Create transaction</a>
    </div>
    <h2>Completed transactions</h2>
    <table class="hover">
        <thead>
        <tr>
            <th>Transaction number</th>
            <th>Quantity</th>
            <th>Timestamp</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <#list transactions as transaction>
            <tr>
                <td>${transaction.getTransactionNumber()}</td>
                <td>${transaction.getQuantity()}</td>
                <td>${transaction.getTimestamp()?datetime}</td>
                <td><a href="/transactions/${transaction.getTransactionId()}">Details</a></td>
            </tr>
        </#list>
        </tbody>
    </table>

    <#if drafts?has_content>
    <h2>Drafts</h2>
    <table class="hover">
        <thead>
        <tr>
            <th>Transaction number</th>
            <th>Quantity</th>
            <th>Timestamp</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
            <#list drafts as transaction>
            <tr>
                <td>${transaction.getTransactionNumber()}</td>
                <td>${transaction.getQuantity()}</td>
                <td>${transaction.getTimestamp()?datetime}</td>
                <td><a href="/transactions/${transaction.getTransactionId()}">Details</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
    </#if>

</@page.page>