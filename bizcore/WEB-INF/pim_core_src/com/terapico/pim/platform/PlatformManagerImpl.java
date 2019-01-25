
package com.terapico.pim.platform;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.pim.BaseEntity;


import com.terapico.pim.Message;
import com.terapico.pim.SmartList;
import com.terapico.pim.MultipleAccessKey;

import com.terapico.pim.PimUserContext;
//import com.terapico.pim.BaseManagerImpl;
import com.terapico.pim.PimCheckerManager;
import com.terapico.pim.CustomPimCheckerManager;

import com.terapico.pim.site.Site;
import com.terapico.pim.product.Product;
import com.terapico.pim.catalog.Catalog;
import com.terapico.pim.brand.Brand;


import com.terapico.pim.levelncategory.LevelNCategory;
import com.terapico.pim.site.Site;
import com.terapico.pim.catalog.Catalog;
import com.terapico.pim.brand.Brand;
import com.terapico.pim.platform.Platform;






public class PlatformManagerImpl extends CustomPimCheckerManager implements PlatformManager {
	
	private static final String SERVICE_TYPE = "Platform";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PlatformManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PlatformManagerException(message);

	}
	
	

 	protected Platform savePlatform(PimUserContext userContext, Platform platform, String [] tokensExpr) throws Exception{	
 		//return getPlatformDAO().save(platform, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePlatform(userContext, platform, tokens);
 	}
 	
 	protected Platform savePlatformDetail(PimUserContext userContext, Platform platform) throws Exception{	

 		
 		return savePlatform(userContext, platform, allTokens());
 	}
 	
 	public Platform loadPlatform(PimUserContext userContext, String platformId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	
 	 public Platform searchPlatform(PimUserContext userContext, String platformId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	

 	protected Platform present(PimUserContext userContext, Platform platform, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,platform,tokens);
		
		
		Platform  platformToPresent = userContext.getDAOGroup().getPlatformDAO().present(platform, tokens);
		
		List<BaseEntity> entityListToNaming = platformToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPlatformDAO().alias(entityListToNaming);
		
		return  platformToPresent;
		
		
	}
 
 	
 	
 	public Platform loadPlatformDetail(PimUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, allTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	
 	public Object view(PimUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, viewTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	protected Platform savePlatform(PimUserContext userContext, Platform platform, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPlatformDAO().save(platform, tokens);
 	}
 	protected Platform loadPlatform(PimUserContext userContext, String platformId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 
 		return userContext.getDAOGroup().getPlatformDAO().load(platformId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(PimUserContext userContext, Platform platform, Map<String, Object> tokens){
		super.addActions(userContext, platform, tokens);
		
		addAction(userContext, platform, tokens,"@create","createPlatform","createPlatform/","main","primary");
		addAction(userContext, platform, tokens,"@update","updatePlatform","updatePlatform/"+platform.getId()+"/","main","primary");
		addAction(userContext, platform, tokens,"@copy","clonePlatform","clonePlatform/"+platform.getId()+"/","main","primary");
		
		addAction(userContext, platform, tokens,"platform.addSite","addSite","addSite/"+platform.getId()+"/","siteList","primary");
		addAction(userContext, platform, tokens,"platform.removeSite","removeSite","removeSite/"+platform.getId()+"/","siteList","primary");
		addAction(userContext, platform, tokens,"platform.updateSite","updateSite","updateSite/"+platform.getId()+"/","siteList","primary");
		addAction(userContext, platform, tokens,"platform.copySiteFrom","copySiteFrom","copySiteFrom/"+platform.getId()+"/","siteList","primary");
		addAction(userContext, platform, tokens,"platform.addCatalog","addCatalog","addCatalog/"+platform.getId()+"/","catalogList","primary");
		addAction(userContext, platform, tokens,"platform.removeCatalog","removeCatalog","removeCatalog/"+platform.getId()+"/","catalogList","primary");
		addAction(userContext, platform, tokens,"platform.updateCatalog","updateCatalog","updateCatalog/"+platform.getId()+"/","catalogList","primary");
		addAction(userContext, platform, tokens,"platform.copyCatalogFrom","copyCatalogFrom","copyCatalogFrom/"+platform.getId()+"/","catalogList","primary");
		addAction(userContext, platform, tokens,"platform.addBrand","addBrand","addBrand/"+platform.getId()+"/","brandList","primary");
		addAction(userContext, platform, tokens,"platform.removeBrand","removeBrand","removeBrand/"+platform.getId()+"/","brandList","primary");
		addAction(userContext, platform, tokens,"platform.updateBrand","updateBrand","updateBrand/"+platform.getId()+"/","brandList","primary");
		addAction(userContext, platform, tokens,"platform.copyBrandFrom","copyBrandFrom","copyBrandFrom/"+platform.getId()+"/","brandList","primary");
		addAction(userContext, platform, tokens,"platform.addProduct","addProduct","addProduct/"+platform.getId()+"/","productList","primary");
		addAction(userContext, platform, tokens,"platform.removeProduct","removeProduct","removeProduct/"+platform.getId()+"/","productList","primary");
		addAction(userContext, platform, tokens,"platform.updateProduct","updateProduct","updateProduct/"+platform.getId()+"/","productList","primary");
		addAction(userContext, platform, tokens,"platform.copyProductFrom","copyProductFrom","copyProductFrom/"+platform.getId()+"/","productList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(PimUserContext userContext, Platform platform, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Platform createPlatform(PimUserContext userContext,String name, String introduction, String currentVersion) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfPlatform(name);
		userContext.getChecker().checkIntroductionOfPlatform(introduction);
		userContext.getChecker().checkCurrentVersionOfPlatform(currentVersion);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);


		Platform platform=createNewPlatform();	

		platform.setName(name);
		platform.setIntroduction(introduction);
		platform.setCurrentVersion(currentVersion);

		platform = savePlatform(userContext, platform, emptyOptions());
		
		onNewInstanceCreated(userContext, platform);
		return platform;

		
	}
	protected Platform createNewPlatform() 
	{
		
		return new Platform();		
	}
	
	protected void checkParamsForUpdatingPlatform(PimUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkVersionOfPlatform( platformVersion);
		

		if(Platform.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPlatform(parseString(newValueExpr));
		}
		if(Platform.INTRODUCTION_PROPERTY.equals(property)){
			userContext.getChecker().checkIntroductionOfPlatform(parseString(newValueExpr));
		}
		if(Platform.CURRENT_VERSION_PROPERTY.equals(property)){
			userContext.getChecker().checkCurrentVersionOfPlatform(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
		
	}
	
	
	
	public Platform clone(PimUserContext userContext, String fromPlatformId) throws Exception{
		
		return userContext.getDAOGroup().getPlatformDAO().clone(fromPlatformId, this.allTokens());
	}
	
	public Platform internalSavePlatform(PimUserContext userContext, Platform platform) throws Exception 
	{
		return internalSavePlatform(userContext, platform, allTokens());

	}
	public Platform internalSavePlatform(PimUserContext userContext, Platform platform, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			
			platform = savePlatform(userContext, platform, options);
			return platform;
			
		}

	}
	
	public Platform updatePlatform(PimUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	
	public Platform updatePlatformProperty(PimUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PlatformTokens tokens(){
		return PlatformTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PlatformTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortSiteListWith("id","desc")
		.sortCatalogListWith("id","desc")
		.sortBrandListWith("id","desc")
		.sortProductListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PlatformTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(PimUserContext userContext, String platformId, int platformVersion) throws Exception {
		//deleteInternal(userContext, platformId, platformVersion);		
	}
	protected void deleteInternal(PimUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		userContext.getDAOGroup().getPlatformDAO().delete(platformId, platformVersion);
	}
	
	public Platform forgetByAll(PimUserContext userContext, String platformId, int platformVersion) throws Exception {
		return forgetByAllInternal(userContext, platformId, platformVersion);		
	}
	protected Platform forgetByAllInternal(PimUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		return userContext.getDAOGroup().getPlatformDAO().disconnectFromAll(platformId, platformVersion);
	}
	

	
	public int deleteAll(PimUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PlatformManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(PimUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPlatformDAO().deleteAll();
	}


	//disconnect Platform with seller_id in Catalog
	protected Platform breakWithCatalogBySellerId(PimUserContext userContext, String platformId, String sellerIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveCatalogListWithSellerId(platform, sellerIdId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
				return platform;
			}
	}
	//disconnect Platform with site in Catalog
	protected Platform breakWithCatalogBySite(PimUserContext userContext, String platformId, String siteId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveCatalogListWithSite(platform, siteId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
				return platform;
			}
	}
	//disconnect Platform with parent_category in Product
	protected Platform breakWithProductByParentCategory(PimUserContext userContext, String platformId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveProductListWithParentCategory(platform, parentCategoryId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withProductList().done());
				return platform;
			}
	}
	//disconnect Platform with brand in Product
	protected Platform breakWithProductByBrand(PimUserContext userContext, String platformId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveProductListWithBrand(platform, brandId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withProductList().done());
				return platform;
			}
	}
	//disconnect Platform with catalog in Product
	protected Platform breakWithProductByCatalog(PimUserContext userContext, String platformId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveProductListWithCatalog(platform, catalogId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withProductList().done());
				return platform;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingSite(PimUserContext userContext, String platformId, String name, String introduction,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfSite(name);
		
		userContext.getChecker().checkIntroductionOfSite(introduction);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addSite(PimUserContext userContext, String platformId, String name, String introduction, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSite(userContext,platformId,name, introduction,tokensExpr);
		
		Site site = createSite(userContext,name, introduction);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addSite( site );		
			platform = savePlatform(userContext, platform, tokens().withSiteList().done());
			
			userContext.getManagerGroup().getSiteManager().onNewInstanceCreated(userContext, site);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSiteProperties(PimUserContext userContext, String platformId,String id,String name,String introduction,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfSite(id);
		
		userContext.getChecker().checkNameOfSite( name);
		userContext.getChecker().checkIntroductionOfSite( introduction);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateSiteProperties(PimUserContext userContext, String platformId, String id,String name,String introduction, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSiteProperties(userContext,platformId,id,name,introduction,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSiteListList()
				.searchSiteListWith(Site.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getSiteList().isEmpty()){
			throw new PlatformManagerException("Site is NOT FOUND with id: '"+id+"'");
		}
		
		Site item = platformToUpdate.getSiteList().first();
		
		item.updateName( name );
		item.updateIntroduction( introduction );

		
		//checkParamsForAddingSite(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withSiteList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Site createSite(PimUserContext userContext, String name, String introduction) throws Exception{

		Site site = new Site();
		
		
		site.setName(name);		
		site.setIntroduction(introduction);		
		site.setLastUpdateTime(userContext.now());
	
		
		return site;
	
		
	}
	
	protected Site createIndexedSite(String id, int version){

		Site site = new Site();
		site.setId(id);
		site.setVersion(version);
		return site;			
		
	}
	
	protected void checkParamsForRemovingSiteList(PimUserContext userContext, String platformId, 
			String siteIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String siteId: siteIds){
			userContext.getChecker().checkIdOfSite(siteId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeSiteList(PimUserContext userContext, String platformId, 
			String siteIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSiteList(userContext, platformId,  siteIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveSiteList(platform, siteIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withSiteList().done());
				deleteRelationListInGraph(userContext, platform.getSiteList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSite(PimUserContext userContext, String platformId, 
		String siteId, int siteVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfSite(siteId);
		userContext.getChecker().checkVersionOfSite(siteVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeSite(PimUserContext userContext, String platformId, 
		String siteId, int siteVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSite(userContext,platformId, siteId, siteVersion,tokensExpr);
		
		Site site = createIndexedSite(siteId, siteVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeSite( site );		
			platform = savePlatform(userContext, platform, tokens().withSiteList().done());
			deleteRelationInGraph(userContext, site);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSite(PimUserContext userContext, String platformId, 
		String siteId, int siteVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfSite(siteId);
		userContext.getChecker().checkVersionOfSite(siteVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copySiteFrom(PimUserContext userContext, String platformId, 
		String siteId, int siteVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSite(userContext,platformId, siteId, siteVersion,tokensExpr);
		
		Site site = createIndexedSite(siteId, siteVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			site.updateLastUpdateTime(userContext.now());
			
			platform.copySiteFrom( site );		
			platform = savePlatform(userContext, platform, tokens().withSiteList().done());
			
			userContext.getManagerGroup().getSiteManager().onNewInstanceCreated(userContext, (Site)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSite(PimUserContext userContext, String platformId, String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfSite(siteId);
		userContext.getChecker().checkVersionOfSite(siteVersion);
		

		if(Site.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfSite(parseString(newValueExpr));
		}
		
		if(Site.INTRODUCTION_PROPERTY.equals(property)){
			userContext.getChecker().checkIntroductionOfSite(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateSite(PimUserContext userContext, String platformId, String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSite(userContext, platformId, siteId, siteVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSiteList().searchSiteListWith(Site.ID_PROPERTY, "eq", siteId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeSite( site );	
			//make changes to AcceleraterAccount.
			Site siteIndex = createIndexedSite(siteId, siteVersion);
		
			Site site = platform.findTheSite(siteIndex);
			if(site == null){
				throw new PlatformManagerException(site+" is NOT FOUND" );
			}
			
			site.changeProperty(property, newValueExpr);
			site.updateLastUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withSiteList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingCatalog(PimUserContext userContext, String platformId, String name, String sellerId, String siteId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfCatalog(name);
		
		userContext.getChecker().checkSellerIdOfCatalog(sellerId);
		
		userContext.getChecker().checkSiteIdOfCatalog(siteId);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addCatalog(PimUserContext userContext, String platformId, String name, String sellerId, String siteId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCatalog(userContext,platformId,name, sellerId, siteId,tokensExpr);
		
		Catalog catalog = createCatalog(userContext,name, sellerId, siteId);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addCatalog( catalog );		
			platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
			
			userContext.getManagerGroup().getCatalogManager().onNewInstanceCreated(userContext, catalog);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCatalogProperties(PimUserContext userContext, String platformId,String id,String name,String sellerId,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfCatalog(id);
		
		userContext.getChecker().checkNameOfCatalog( name);
		userContext.getChecker().checkSellerIdOfCatalog( sellerId);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateCatalogProperties(PimUserContext userContext, String platformId, String id,String name,String sellerId, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingCatalogProperties(userContext,platformId,id,name,sellerId,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCatalogListList()
				.searchCatalogListWith(Catalog.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getCatalogList().isEmpty()){
			throw new PlatformManagerException("Catalog is NOT FOUND with id: '"+id+"'");
		}
		
		Catalog item = platformToUpdate.getCatalogList().first();
		
		item.updateName( name );
		item.updateSellerId( sellerId );

		
		//checkParamsForAddingCatalog(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withCatalogList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Catalog createCatalog(PimUserContext userContext, String name, String sellerId, String siteId) throws Exception{

		Catalog catalog = new Catalog();
		
		
		catalog.setName(name);		
		catalog.setSellerId(sellerId);		
		Site  site = new Site();
		site.setId(siteId);		
		catalog.setSite(site);
	
		
		return catalog;
	
		
	}
	
	protected Catalog createIndexedCatalog(String id, int version){

		Catalog catalog = new Catalog();
		catalog.setId(id);
		catalog.setVersion(version);
		return catalog;			
		
	}
	
	protected void checkParamsForRemovingCatalogList(PimUserContext userContext, String platformId, 
			String catalogIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String catalogId: catalogIds){
			userContext.getChecker().checkIdOfCatalog(catalogId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeCatalogList(PimUserContext userContext, String platformId, 
			String catalogIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingCatalogList(userContext, platformId,  catalogIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveCatalogList(platform, catalogIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
				deleteRelationListInGraph(userContext, platform.getCatalogList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingCatalog(PimUserContext userContext, String platformId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkVersionOfCatalog(catalogVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeCatalog(PimUserContext userContext, String platformId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCatalog(userContext,platformId, catalogId, catalogVersion,tokensExpr);
		
		Catalog catalog = createIndexedCatalog(catalogId, catalogVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeCatalog( catalog );		
			platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
			deleteRelationInGraph(userContext, catalog);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingCatalog(PimUserContext userContext, String platformId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkVersionOfCatalog(catalogVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyCatalogFrom(PimUserContext userContext, String platformId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCatalog(userContext,platformId, catalogId, catalogVersion,tokensExpr);
		
		Catalog catalog = createIndexedCatalog(catalogId, catalogVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyCatalogFrom( catalog );		
			platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
			
			userContext.getManagerGroup().getCatalogManager().onNewInstanceCreated(userContext, (Catalog)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingCatalog(PimUserContext userContext, String platformId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkVersionOfCatalog(catalogVersion);
		

		if(Catalog.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfCatalog(parseString(newValueExpr));
		}
		
		if(Catalog.SELLER_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkSellerIdOfCatalog(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateCatalog(PimUserContext userContext, String platformId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCatalog(userContext, platformId, catalogId, catalogVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withCatalogList().searchCatalogListWith(Catalog.ID_PROPERTY, "eq", catalogId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeCatalog( catalog );	
			//make changes to AcceleraterAccount.
			Catalog catalogIndex = createIndexedCatalog(catalogId, catalogVersion);
		
			Catalog catalog = platform.findTheCatalog(catalogIndex);
			if(catalog == null){
				throw new PlatformManagerException(catalog+" is NOT FOUND" );
			}
			
			catalog.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingBrand(PimUserContext userContext, String platformId, String brandName, String logo, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkBrandNameOfBrand(brandName);
		
		userContext.getChecker().checkLogoOfBrand(logo);
		
		userContext.getChecker().checkRemarkOfBrand(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addBrand(PimUserContext userContext, String platformId, String brandName, String logo, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingBrand(userContext,platformId,brandName, logo, remark,tokensExpr);
		
		Brand brand = createBrand(userContext,brandName, logo, remark);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addBrand( brand );		
			platform = savePlatform(userContext, platform, tokens().withBrandList().done());
			
			userContext.getManagerGroup().getBrandManager().onNewInstanceCreated(userContext, brand);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingBrandProperties(PimUserContext userContext, String platformId,String id,String brandName,String logo,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfBrand(id);
		
		userContext.getChecker().checkBrandNameOfBrand( brandName);
		userContext.getChecker().checkLogoOfBrand( logo);
		userContext.getChecker().checkRemarkOfBrand( remark);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateBrandProperties(PimUserContext userContext, String platformId, String id,String brandName,String logo,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingBrandProperties(userContext,platformId,id,brandName,logo,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withBrandListList()
				.searchBrandListWith(Brand.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getBrandList().isEmpty()){
			throw new PlatformManagerException("Brand is NOT FOUND with id: '"+id+"'");
		}
		
		Brand item = platformToUpdate.getBrandList().first();
		
		item.updateBrandName( brandName );
		item.updateLogo( logo );
		item.updateRemark( remark );

		
		//checkParamsForAddingBrand(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withBrandList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Brand createBrand(PimUserContext userContext, String brandName, String logo, String remark) throws Exception{

		Brand brand = new Brand();
		
		
		brand.setBrandName(brandName);		
		brand.setLogo(logo);		
		brand.setRemark(remark);
	
		
		return brand;
	
		
	}
	
	protected Brand createIndexedBrand(String id, int version){

		Brand brand = new Brand();
		brand.setId(id);
		brand.setVersion(version);
		return brand;			
		
	}
	
	protected void checkParamsForRemovingBrandList(PimUserContext userContext, String platformId, 
			String brandIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String brandId: brandIds){
			userContext.getChecker().checkIdOfBrand(brandId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeBrandList(PimUserContext userContext, String platformId, 
			String brandIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingBrandList(userContext, platformId,  brandIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveBrandList(platform, brandIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withBrandList().done());
				deleteRelationListInGraph(userContext, platform.getBrandList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingBrand(PimUserContext userContext, String platformId, 
		String brandId, int brandVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkVersionOfBrand(brandVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeBrand(PimUserContext userContext, String platformId, 
		String brandId, int brandVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingBrand(userContext,platformId, brandId, brandVersion,tokensExpr);
		
		Brand brand = createIndexedBrand(brandId, brandVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeBrand( brand );		
			platform = savePlatform(userContext, platform, tokens().withBrandList().done());
			deleteRelationInGraph(userContext, brand);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingBrand(PimUserContext userContext, String platformId, 
		String brandId, int brandVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkVersionOfBrand(brandVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyBrandFrom(PimUserContext userContext, String platformId, 
		String brandId, int brandVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingBrand(userContext,platformId, brandId, brandVersion,tokensExpr);
		
		Brand brand = createIndexedBrand(brandId, brandVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyBrandFrom( brand );		
			platform = savePlatform(userContext, platform, tokens().withBrandList().done());
			
			userContext.getManagerGroup().getBrandManager().onNewInstanceCreated(userContext, (Brand)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingBrand(PimUserContext userContext, String platformId, String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkVersionOfBrand(brandVersion);
		

		if(Brand.BRAND_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkBrandNameOfBrand(parseString(newValueExpr));
		}
		
		if(Brand.LOGO_PROPERTY.equals(property)){
			userContext.getChecker().checkLogoOfBrand(parseString(newValueExpr));
		}
		
		if(Brand.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfBrand(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateBrand(PimUserContext userContext, String platformId, String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingBrand(userContext, platformId, brandId, brandVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withBrandList().searchBrandListWith(Brand.ID_PROPERTY, "eq", brandId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeBrand( brand );	
			//make changes to AcceleraterAccount.
			Brand brandIndex = createIndexedBrand(brandId, brandVersion);
		
			Brand brand = platform.findTheBrand(brandIndex);
			if(brand == null){
				throw new PlatformManagerException(brand+" is NOT FOUND" );
			}
			
			brand.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withBrandList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingProduct(PimUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String origin, String catalogId, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfProduct(brandId);
		
		userContext.getChecker().checkOriginOfProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfProduct(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addProduct(PimUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String origin, String catalogId, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProduct(userContext,platformId,name, parentCategoryId, brandId, origin, catalogId, remark,tokensExpr);
		
		Product product = createProduct(userContext,name, parentCategoryId, brandId, origin, catalogId, remark);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addProduct( product );		
			platform = savePlatform(userContext, platform, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, product);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductProperties(PimUserContext userContext, String platformId,String id,String name,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfProduct(id);
		
		userContext.getChecker().checkNameOfProduct( name);
		userContext.getChecker().checkOriginOfProduct( origin);
		userContext.getChecker().checkRemarkOfProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateProductProperties(PimUserContext userContext, String platformId, String id,String name,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductProperties(userContext,platformId,id,name,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductListList()
				.searchProductListWith(Product.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getProductList().isEmpty()){
			throw new PlatformManagerException("Product is NOT FOUND with id: '"+id+"'");
		}
		
		Product item = platformToUpdate.getProductList().first();
		
		item.updateName( name );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingProduct(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withProductList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Product createProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String origin, String catalogId, String remark) throws Exception{

		Product product = new Product();
		
		
		product.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		product.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		product.setBrand(brand);		
		product.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		product.setCatalog(catalog);		
		product.setRemark(remark);		
		product.setLastUpdateTime(userContext.now());
	
		
		return product;
	
		
	}
	
	protected Product createIndexedProduct(String id, int version){

		Product product = new Product();
		product.setId(id);
		product.setVersion(version);
		return product;			
		
	}
	
	protected void checkParamsForRemovingProductList(PimUserContext userContext, String platformId, 
			String productIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String productId: productIds){
			userContext.getChecker().checkIdOfProduct(productId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeProductList(PimUserContext userContext, String platformId, 
			String productIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProductList(userContext, platformId,  productIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveProductList(platform, productIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withProductList().done());
				deleteRelationListInGraph(userContext, platform.getProductList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProduct(PimUserContext userContext, String platformId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeProduct(PimUserContext userContext, String platformId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProduct(userContext,platformId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeProduct( product );		
			platform = savePlatform(userContext, platform, tokens().withProductList().done());
			deleteRelationInGraph(userContext, product);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProduct(PimUserContext userContext, String platformId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyProductFrom(PimUserContext userContext, String platformId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProduct(userContext,platformId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			product.updateLastUpdateTime(userContext.now());
			
			platform.copyProductFrom( product );		
			platform = savePlatform(userContext, platform, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, (Product)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProduct(PimUserContext userContext, String platformId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		

		if(Product.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProduct(parseString(newValueExpr));
		}
		
		if(Product.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfProduct(parseString(newValueExpr));
		}
		
		if(Product.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateProduct(PimUserContext userContext, String platformId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProduct(userContext, platformId, productId, productVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProductList().searchProductListWith(Product.ID_PROPERTY, "eq", productId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeProduct( product );	
			//make changes to AcceleraterAccount.
			Product productIndex = createIndexedProduct(productId, productVersion);
		
			Product product = platform.findTheProduct(productIndex);
			if(product == null){
				throw new PlatformManagerException(product+" is NOT FOUND" );
			}
			
			product.changeProperty(property, newValueExpr);
			product.updateLastUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withProductList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(PimUserContext userContext, Platform newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


