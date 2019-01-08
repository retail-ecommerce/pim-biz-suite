
package com.terapico.pim;
import java.util.HashMap;
import java.util.Map;

public class CustomRelation extends BaseRelation{

	protected void prepareRelation()
	{
		super.prepareRelation();
		//Uncomment to make any change to the relation type
		//replaceGenericRelation("Site"                                  , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Catalog"                               , BaseRelation.TRUST_CHAIN_ALL, "site");
		//replaceGenericRelation("LevelOneCategory"                      , BaseRelation.TRUST_CHAIN_ALL, "catalog");
		//replaceGenericRelation("LevelTwoCategory"                      , BaseRelation.TRUST_CHAIN_ALL, "parentCategory");
		//replaceGenericRelation("LevelNCategory"                        , BaseRelation.TRUST_CHAIN_ALL, "parentCategory");
		//replaceGenericRelation("Product"                               , BaseRelation.TRUST_CHAIN_ALL, "parentCategory");
		//replaceGenericRelation("Product"                               , BaseRelation.TRUST_CHAIN_ALL, "brand");
		//replaceGenericRelation("Product"                               , BaseRelation.TRUST_CHAIN_ALL, "catalog");
		//replaceGenericRelation("Sku"                                   , BaseRelation.TRUST_CHAIN_ALL, "product");
		//replaceGenericRelation("UserWhiteList"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("SecUser"                               , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("UserApp"                               , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("ListAccess"                            , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ObjectAccess"                          , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("LoginHistory"                          , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("FormMessage"                           , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormFieldMessage"                      , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormField"                             , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormAction"                            , BaseRelation.TRUST_CHAIN_ALL, "form");

	}
	
	protected void prepareRelationIndex()
	{
		super.prepareRelationIndex();
		/*
		
		Note: you could delete some of the possible relations if you do not want it.
		Just uncomment the definition line and replaceRelationIndex line to replace existing one.
		
		*/
		//String [] siteRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("Site",siteRelatedObjectNames);

		//String [] catalogRelatedObjectNames = {"site:Site"};
		//replaceRelationIndex("Catalog",catalogRelatedObjectNames);

		//String [] levelOneCategoryRelatedObjectNames = {"catalog:Catalog"};
		//replaceRelationIndex("LevelOneCategory",levelOneCategoryRelatedObjectNames);

		//String [] levelTwoCategoryRelatedObjectNames = {"parent_category:LevelOneCategory"};
		//replaceRelationIndex("LevelTwoCategory",levelTwoCategoryRelatedObjectNames);

		//String [] levelNCategoryRelatedObjectNames = {"parent_category:LevelTwoCategory"};
		//replaceRelationIndex("LevelNCategory",levelNCategoryRelatedObjectNames);

		//String [] productRelatedObjectNames = {"parent_category:LevelNCategory","brand:Brand","catalog:Catalog"};
		//replaceRelationIndex("Product",productRelatedObjectNames);

		//String [] skuRelatedObjectNames = {"product:Product"};
		//replaceRelationIndex("Sku",skuRelatedObjectNames);

		//String [] userWhiteListRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("UserWhiteList",userWhiteListRelatedObjectNames);

		//String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("SecUser",secUserRelatedObjectNames);

		//String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("UserApp",userAppRelatedObjectNames);

		//String [] listAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ListAccess",listAccessRelatedObjectNames);

		//String [] objectAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ObjectAccess",objectAccessRelatedObjectNames);

		//String [] loginHistoryRelatedObjectNam<html>
<body>
<h1>500 Servlet Exception</h1>
<code><pre>
<script language='javascript' type='text/javascript'>
function show() { document.getElementById('trace').style.display = ''; }
</script>
<a style="text-decoration" href="javascript:show();">[show]</a> java.lang.NullPointerException
<span id="trace" style="display:none">
java.lang.NullPointerException
	at com.terapico.system.ObjectCollection.getFieldByKey(ObjectCollection.java:849)
	at _jsp._javaweb._java_0user_0base_0function__jsp._jspService(javaweb/java_user_base_function.jsp:563)
	at com.caucho.jsp.JavaPage.service(JavaPage.java:61)
	at com.caucho.jsp.Page.pageservice(Page.java:578)
	at com.caucho.server.dispatch.PageFilterChain.doFilter(PageFilterChain.java:195)
	at com.caucho.server.webapp.DispatchFilterChain.doFilter(DispatchFilterChain.java:112)
	at com.caucho.server.dispatch.ServletInvocation.service(ServletInvocation.java:265)
	at com.caucho.server.webapp.RequestDispatcherImpl.include(RequestDispatcherImpl.java:504)
	at com.caucho.server.webapp.RequestDispatcherImpl.include(RequestDispatcherImpl.java:368)
	at com.caucho.jsp.PageContextImpl.include(PageContextImpl.java:1009)
	at _jsp._javaweb._java_0app_0index__jsp._jspService(javaweb/java_app_index.jsp:61)
	at com.caucho.jsp.JavaPage.service(JavaPage.java:61)
	at com.caucho.jsp.Page.pageservice(Page.java:578)
	at com.caucho.server.dispatch.PageFilterChain.doFilter(PageFilterChain.java:195)
	at com.caucho.server.webapp.WebAppFilterChain.doFilter(WebAppFilterChain.java:187)
	at com.caucho.server.dispatch.ServletInvocation.service(ServletInvocation.java:265)
	at com.caucho.server.http.HttpRequest.handleRequest(HttpRequest.java:273)
	at com.caucho.server.port.TcpConnection.run(TcpConnection.java:682)
	at com.caucho.util.ThreadPool$Item.runTasks(ThreadPool.java:743)
	at com.caucho.util.ThreadPool$Item.run(ThreadPool.java:662)
	at java.lang.Thread.run(Thread.java:745)
</span>
</pre></code>
</body></html>
