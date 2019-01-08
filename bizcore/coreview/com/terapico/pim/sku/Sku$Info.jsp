
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty sku}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A Sku">${userContext.localeMap['sku']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./skuManager/view/${sku.id}/"> ${sku.id}</a></li>
<li><span>${userContext.localeMap['sku.display_name']}</span> ${sku.displayName}</li>
<li><span>${userContext.localeMap['sku.size']}</span> ${sku.size}</li>
<li><span>${userContext.localeMap['sku.active']}</span> ${sku.active}</li>
<li><span>${userContext.localeMap['sku.base_price']}</span> <fmt:formatNumber type="currency"  value="${sku.basePrice}" /></li>
<li><span>${userContext.localeMap['sku.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${sku.lastUpdateTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




