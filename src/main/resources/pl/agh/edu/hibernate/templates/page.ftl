<#macro page title>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title} - Sales Web App</title>
    <link rel="stylesheet" href="/css/foundation.min.css">
    <link rel="stylesheet" href="/css/app.css">
</head>
<body>
<div class="top-bar">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <li class="menu-text">Sales</li>
            <li><a href="/products">Products</a></li>
            <li><a href="/transactions">Transactions</a></li>
            <li><a href="/customers">Customers</a></li>
            <li><a href="/suppliers">Suppliers</a></li>
            <li><a href="/categories">Categories</a></li>
        </ul>
    </div>
</div>
<div class="grid-container">
    <div class="grid-x">
        <div class="cell">
            <h1>${title}</h1>
            <#nested>
        </div>
    </div>
</div>

<script src="/js/vendor/jquery.js"></script>
<script src="/js/vendor/what-input.js"></script>
<script src="/js/vendor/foundation.js"></script>
<script src="/js/app.js"></script>
</body>
</html>
</#macro>