<!DOCTYPE html>

<html lang="en">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome</title>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<link href="/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/custom.css" />
<body>
<ul class="nav nav-tabs">
  <#list data?keys as k>
    <#if k?index == 0>
        <li class="col-xs-4 active">
    <#else>
        <li class="col-xs-4">
    </#if>
    <a href="#${k}" data-toggle="tab">
    <p style="font-size:28px; margin-bottom:5px;"><i class="fa fa-${k}"></i></p>
    <p style="margin:0">${k}</p>
    </a></li>
  </#list>
</ul>
<div id="myTabContent" class="tab-content">
  <#list data?keys as k>
    <#if k?index == 0>
        <div class="tab-pane fade active in" id="${k}">
    <#else>
        <div class="tab-pane fade" id="${k}">
    </#if>
    <#assign value = data[k]>
      <#list value as x>
          <p>${x.name_en}, ${x.name_cn}</p>
      </#list>
    </div>
  </#list>
</div>

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>

</html>
