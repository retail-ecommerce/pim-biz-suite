<%@ page import='java.util.*,com.terapico.pim.*,com.terapico.pim.brand.Brand'%>

<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<!DOCTYPE html>
<html lang="en" slick-uniqueid="3"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="${baseURL}/" />    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>  ${userContext.localeMap['@system_name']} </title>

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">
 	<link href="./bootstrap/jquery-ui.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="./bootstrap/dashboard.css" rel="stylesheet">
    <link href="./bootstrap/font-awesome.min.css" rel="stylesheet">
   
   

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./bootstrap/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
 <style type="text/css">* {
 text-shadow: transparent 0px 0px 0px, rgba(0,0,0,0.68) 0px 0px 0px !important; 
}

</style>


</head>

  <body >


    <div class="container-fluid">
      <div class="row">
      
        <div class="col-xs-12 col-sm-12  col-md-12  main">
          
          <div class="table-responsive" id="content">
          <!-- real content -->

<c:set var="ownerBeanName" value="brand" scope="request"/>
<c:set var="ownerClassName" value="Brand" scope="request"/>




<div id="msg"></div>

<div class="row">

	<div class="col-xs-12 col-md-12">
			    <c:if test="${not empty result.errorMessageList}" >
    <ul>
    	<c:forEach var="item" items="${result.errorMessageList}">
    		
    		<div class="alert alert-success">
   ${item.sourcePosition} ${item.body}
</div>
    	</c:forEach>
    	</ul>
    </c:if>
</div>



</div> <!--<div class="row">-->

<div class="row">
	
</div>

<div class="row">
	
	<div class="col-xs-12 col-md-12">

	<ul class="nav nav-tabs" id="navi-tabs">
	  <li class="active"><a data-toggle="tab" href="#summary" class="disabled"><i class="fa  fa-home"></i> ${userContext.localeMap['@summary']}</a></li>
	 
	<% Brand result = (Brand)request.getAttribute("result");  %>
			<li><a data-toggle="tab" href="#productList" class="disabled"> ${userContext.localeMap['product']}</a></li>
			<li><a data-toggle="tab" href="#newProductList" class="disabled"> ${userContext.localeMap['new_product']}</a></li>
			<li><a data-toggle="tab" href="#editorPickProductList" class="disabled"> ${userContext.localeMap['editor_pick_product']}</a></li>
			<li><a data-toggle="tab" href="#topRatedProductList" class="disabled"> ${userContext.localeMap['top_rated_product']}</a></li>
			<li><a data-toggle="tab" href="#recommandProductList" class="disabled"> ${userContext.localeMap['recommand_product']}</a></li>
 
	</ul>
	</div>
</div>
<div class="tab-content"  id='tab-content'>
<div id="summary" class="tab-pane fade in active">
<div class="row">
	
	<div class="col-xs-12 col-md-12">
	
	</div>
</div>

<div class="row" desc="show parent objects">
	
	   
	<c:set var="brand" value="${ result}" scope="request" />
<sky:include page="com/terapico/pim/brand/Brand$Summary.jsp" />

	
</div>

	
	

	<div class="row">
<c:set var="platform" value="${ result.platform}" scope="request" />
<sky:include page="com/terapico/pim/platform/Platform$Info.jsp" />

</div>








	





	</div><!-- end of <div id="summary" class="tab-pane fade in active">-->

	

		<c:if test='${not empty userContext.accessTokens["productList"] or ignoreListAccessControl}'>
		<c:set var="productList" value="${result.productList}" scope="request"/>
		<c:set var="productListName" value="productList" scope="request"/>
		<div id="productList" class="tab-pane fade sublist" refer-name="brand">
			<sky:include page="com/terapico/pim/product/Product$List.jsp"
					referName="brand"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["newProductList"] or ignoreListAccessControl}'>
		<c:set var="newProductList" value="${result.newProductList}" scope="request"/>
		<c:set var="newProductListName" value="newProductList" scope="request"/>
		<div id="newProductList" class="tab-pane fade sublist" refer-name="brand">
			<sky:include page="com/terapico/pim/newproduct/NewProduct$List.jsp"
					referName="brand"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["editorPickProductList"] or ignoreListAccessControl}'>
		<c:set var="editorPickProductList" value="${result.editorPickProductList}" scope="request"/>
		<c:set var="editorPickProductListName" value="editorPickProductList" scope="request"/>
		<div id="editorPickProductList" class="tab-pane fade sublist" refer-name="brand">
			<sky:include page="com/terapico/pim/editorpickproduct/EditorPickProduct$List.jsp"
					referName="brand"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["topRatedProductList"] or ignoreListAccessControl}'>
		<c:set var="topRatedProductList" value="${result.topRatedProductList}" scope="request"/>
		<c:set var="topRatedProductListName" value="topRatedProductList" scope="request"/>
		<div id="topRatedProductList" class="tab-pane fade sublist" refer-name="brand">
			<sky:include page="com/terapico/pim/topratedproduct/TopRatedProduct$List.jsp"
					referName="brand"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["recommandProductList"] or ignoreListAccessControl}'>
		<c:set var="recommandProductList" value="${result.recommandProductList}" scope="request"/>
		<c:set var="recommandProductListName" value="recommandProductList" scope="request"/>
		<div id="recommandProductList" class="tab-pane fade sublist" refer-name="brand">
			<sky:include page="com/terapico/pim/recommandproduct/RecommandProduct$List.jsp"
					referName="brand"/>
		</div>
	</c:if>

	

</div><!--<div class="tab-content" style="padding-top: 10px">-->




 <!-- /real content -->
          
          
          </div>
        </div><!--  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
        </div><!-- <div class="row"> -->
        </div>
        
  
<div id="footer">
  <div class="col-xs-12 navbar-inverse navbar-fixed-bottom">
  <div class="row" id="bottomNav">
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-home"></i><br/>${userContext.localeMap['@home_page']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-envelope"></i><br>${userContext.localeMap['@message']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-envelope"></i><br>${userContext.localeMap['@message']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/showlogin/">
    	<i class="glyphicon glyphicon-user"></i><br>${userContext.localeMap['@log_out']}</a>
    </div>
  </div>
  </div>
</div>   <!-- --><!-- /.footer -->
        
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./bootstrap/jquery.min.js"></script>
    <script src="./bootstrap/jquery-ui.min.js"></script>
    
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./bootstrap/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./bootstrap/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./bootstrap/ie10-viewport-bug-workaround.js"></script>
    <script src="./scripts/qrcode.js" type="text/javascript"></script>    
    <script>

 	var qrLocaleLabel = "${userContext.localeMap['@qr_code']}";
 	var scanQRTips = "${userContext.localeMap['@qr_scan_to_continue']}";
 	$("a[data-toggle='tab']").removeClass("disabled");
 	
	
</script>
     <script src="./scripts/common.js" type="text/javascript"></script>
     <script src="./bootstrap/bootstrap3-typeahead.js" type="text/javascript"></script>


</body></html>


