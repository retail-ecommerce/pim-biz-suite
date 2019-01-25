
package com.terapico.pim.catalog;

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
import com.terapico.pim.levelonecategory.LevelOneCategory;
import com.terapico.pim.platform.Platform;

import com.terapico.pim.site.CandidateSite;
import com.terapico.pim.platform.CandidatePlatform;

import com.terapico.pim.levelncategory.LevelNCategory;
import com.terapico.pim.catalog.Catalog;
import com.terapico.pim.brand.Brand;
import com.terapico.pim.platform.Platform;






public class CatalogManagerImpl extends CustomPimCheckerManager implements CatalogManager {
	
	private static final String SERVICE_TYPE = "Catalog";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws CatalogManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new CatalogManagerException(message);

	}
	
	

 	protected Catalog saveCatalog(PimUserContext userContext, Catalog catalog, String [] tokensExpr) throws Exception{	
 		//return getCatalogDAO().save(catalog, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCatalog(userContext, catalog, tokens);
 	}
 	
 	protected Catalog saveCatalogDetail(PimUserContext userContext, Catalog catalog) throws Exception{	

 		
 		return saveCatalog(userContext, catalog, allTokens());
 	}
 	
 	public Catalog loadCatalog(PimUserContext userContext, String catalogId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().throwExceptionIfHasErrors( CatalogManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Catalog catalog = loadCatalog( userContext, catalogId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,catalog, tokens);
 	}
 	
 	
 	 public Catalog searchCatalog(PimUserContext userContext, String catalogId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().throwExceptionIfHasErrors( CatalogManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Catalog catalog = loadCatalog( userContext, catalogId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,catalog, tokens);
 	}
 	
 	

 	protected Catalog present(PimUserContext userContext, Catalog catalog, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,catalog,tokens);
		
		
		Catalog  catalogToPresent = userContext.getDAOGroup().getCatalogDAO().present(catalog, tokens);
		
		List<BaseEntity> entityListToNaming = catalogToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getCatalogDAO().alias(entityListToNaming);
		
		return  catalogToPresent;
		
		
	}
 
 	
 	
 	public Catalog loadCatalogDetail(PimUserContext userContext, String catalogId) throws Exception{	
 		Catalog catalog = loadCatalog( userContext, catalogId, allTokens());
 		return present(userContext,catalog, allTokens());
		
 	}
 	
 	public Object view(PimUserContext userContext, String catalogId) throws Exception{	
 		Catalog catalog = loadCatalog( userContext, catalogId, viewTokens());
 		return present(userContext,catalog, allTokens());
		
 	}
 	protected Catalog saveCatalog(PimUserContext userContext, Catalog catalog, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getCatalogDAO().save(catalog, tokens);
 	}
 	protected Catalog loadCatalog(PimUserContext userContext, String catalogId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().throwExceptionIfHasErrors( CatalogManagerException.class);

 
 		return userContext.getDAOGroup().getCatalogDAO().load(catalogId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(PimUserContext userContext, Catalog catalog, Map<String, Object> tokens){
		super.addActions(userContext, catalog, tokens);
		
		addAction(userContext, catalog, tokens,"@create","createCatalog","createCatalog/","main","primary");
		addAction(userContext, catalog, tokens,"@update","updateCatalog","updateCatalog/"+catalog.getId()+"/","main","primary");
		addAction(userContext, catalog, tokens,"@copy","cloneCatalog","cloneCatalog/"+catalog.getId()+"/","main","primary");
		
		addAction(userContext, catalog, tokens,"catalog.transfer_to_site","transferToAnotherSite","transferToAnotherSite/"+catalog.getId()+"/","main","primary");
		addAction(userContext, catalog, tokens,"catalog.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+catalog.getId()+"/","main","primary");
		addAction(userContext, catalog, tokens,"catalog.addLevelOneCategory","addLevelOneCategory","addLevelOneCategory/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.removeLevelOneCategory","removeLevelOneCategory","removeLevelOneCategory/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.updateLevelOneCategory","updateLevelOneCategory","updateLevelOneCategory/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.copyLevelOneCategoryFrom","copyLevelOneCategoryFrom","copyLevelOneCategoryFrom/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.addProduct","addProduct","addProduct/"+catalog.getId()+"/","productList","primary");
		addAction(userContext, catalog, tokens,"catalog.removeProduct","removeProduct","removeProduct/"+catalog.getId()+"/","productList","primary");
		addAction(userContext, catalog, tokens,"catalog.updateProduct","updateProduct","updateProduct/"+catalog.getId()+"/","productList","primary");
		addAction(userContext, catalog, tokens,"catalog.copyProductFrom","copyProductFrom","copyProductFrom/"+catalog.getId()+"/","productList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(PimUserContext userContext, Catalog catalog, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Catalog createCatalog(PimUserContext userContext,String name, String sellerId, String siteId, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfCatalog(name);
		userContext.getChecker().checkSellerIdOfCatalog(sellerId);
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);


		Catalog catalog=createNewCatalog();	

		catalog.setName(name);
		catalog.setSellerId(sellerId);
			
		Site site = loadSite(userContext, siteId,emptyOptions());
		catalog.setSite(site);
		
		
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		catalog.setPlatform(platform);
		
		

		catalog = saveCatalog(userContext, catalog, emptyOptions());
		
		onNewInstanceCreated(userContext, catalog);
		return catalog;

		
	}
	protected Catalog createNewCatalog() 
	{
		
		return new Catalog();		
	}
	
	protected void checkParamsForUpdatingCatalog(PimUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkVersionOfCatalog( catalogVersion);
		

		if(Catalog.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfCatalog(parseString(newValueExpr));
		}
		if(Catalog.SELLER_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkSellerIdOfCatalog(parseString(newValueExpr));
		}		

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
		
	}
	
	
	
	public Catalog clone(PimUserContext userContext, String fromCatalogId) throws Exception{
		
		return userContext.getDAOGroup().getCatalogDAO().clone(fromCatalogId, this.allTokens());
	}
	
	public Catalog internalSaveCatalog(PimUserContext userContext, Catalog catalog) throws Exception 
	{
		return internalSaveCatalog(userContext, catalog, allTokens());

	}
	public Catalog internalSaveCatalog(PimUserContext userContext, Catalog catalog, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingCatalog(userContext, catalogId, catalogVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(catalog){ 
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Catalog.
			
			
			catalog = saveCatalog(userContext, catalog, options);
			return catalog;
			
		}

	}
	
	public Catalog updateCatalog(PimUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCatalog(userContext, catalogId, catalogVersion, property, newValueExpr, tokensExpr);
		
		
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		if(catalog.getVersion() != catalogVersion){
			String message = "The target version("+catalog.getVersion()+") is not equals to version("+catalogVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(catalog){ 
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Catalog.
			
			catalog.changeProperty(property, newValueExpr);
			catalog = saveCatalog(userContext, catalog, tokens().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
			//return saveCatalog(userContext, catalog, tokens().done());
		}

	}
	
	public Catalog updateCatalogProperty(PimUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCatalog(userContext, catalogId, catalogVersion, property, newValueExpr, tokensExpr);
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		if(catalog.getVersion() != catalogVersion){
			String message = "The target version("+catalog.getVersion()+") is not equals to version("+catalogVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(catalog){ 
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Catalog.
			
			catalog.changeProperty(property, newValueExpr);
			
			catalog = saveCatalog(userContext, catalog, tokens().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
			//return saveCatalog(userContext, catalog, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CatalogTokens tokens(){
		return CatalogTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CatalogTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLevelOneCategoryListWith("id","desc")
		.sortProductListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CatalogTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSite(PimUserContext userContext, String catalogId, String anotherSiteId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfCatalog(catalogId);
 		userContext.getChecker().checkIdOfSite(anotherSiteId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
 		
 	}
 	public Catalog transferToAnotherSite(PimUserContext userContext, String catalogId, String anotherSiteId) throws Exception
 	{
 		checkParamsForTransferingAnotherSite(userContext, catalogId,anotherSiteId);
 
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());	
		synchronized(catalog){
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Site site = loadSite(userContext, anotherSiteId, emptyOptions());		
			catalog.updateSite(site);		
			catalog = saveCatalog(userContext, catalog, emptyOptions());
			
			return present(userContext,catalog, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSite requestCandidateSite(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSite result = new CandidateSite();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Site> candidateList = userContext.getDAOGroup().getSiteDAO().requestCandidateSiteForCatalog(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(PimUserContext userContext, String catalogId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfCatalog(catalogId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
 		
 	}
 	public Catalog transferToAnotherPlatform(PimUserContext userContext, String catalogId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, catalogId,anotherPlatformId);
 
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());	
		synchronized(catalog){
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			catalog.updatePlatform(platform);		
			catalog = saveCatalog(userContext, catalog, emptyOptions());
			
			return present(userContext,catalog, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForCatalog(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Site loadSite(PimUserContext userContext, String newSiteId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSiteDAO().load(newSiteId, options);
 	}
 	
 	
 	
	
	 	
 	protected Platform loadPlatform(PimUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(PimUserContext userContext, String catalogId, int catalogVersion) throws Exception {
		//deleteInternal(userContext, catalogId, catalogVersion);		
	}
	protected void deleteInternal(PimUserContext userContext,
			String catalogId, int catalogVersion) throws Exception{
			
		userContext.getDAOGroup().getCatalogDAO().delete(catalogId, catalogVersion);
	}
	
	public Catalog forgetByAll(PimUserContext userContext, String catalogId, int catalogVersion) throws Exception {
		return forgetByAllInternal(userContext, catalogId, catalogVersion);		
	}
	protected Catalog forgetByAllInternal(PimUserContext userContext,
			String catalogId, int catalogVersion) throws Exception{
			
		return userContext.getDAOGroup().getCatalogDAO().disconnectFromAll(catalogId, catalogVersion);
	}
	

	
	public int deleteAll(PimUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CatalogManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(PimUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getCatalogDAO().deleteAll();
	}


	//disconnect Catalog with parent_category in Product
	protected Catalog breakWithProductByParentCategory(PimUserContext userContext, String catalogId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveProductListWithParentCategory(catalog, parentCategoryId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with brand in Product
	protected Catalog breakWithProductByBrand(PimUserContext userContext, String catalogId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveProductListWithBrand(catalog, brandId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with platform in Product
	protected Catalog breakWithProductByPlatform(PimUserContext userContext, String catalogId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveProductListWithPlatform(catalog, platformId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withProductList().done());
				return catalog;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingLevelOneCategory(PimUserContext userContext, String catalogId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfCatalog(catalogId);

		
		userContext.getChecker().checkNameOfLevelOneCategory(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);

	
	}
	public  Catalog addLevelOneCategory(PimUserContext userContext, String catalogId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelOneCategory(userContext,catalogId,name,tokensExpr);
		
		LevelOneCategory levelOneCategory = createLevelOneCategory(userContext,name);
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.addLevelOneCategory( levelOneCategory );		
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			
			userContext.getManagerGroup().getLevelOneCategoryManager().onNewInstanceCreated(userContext, levelOneCategory);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelOneCategoryProperties(PimUserContext userContext, String catalogId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfLevelOneCategory(id);
		
		userContext.getChecker().checkNameOfLevelOneCategory( name);

		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog updateLevelOneCategoryProperties(PimUserContext userContext, String catalogId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingLevelOneCategoryProperties(userContext,catalogId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelOneCategoryListList()
				.searchLevelOneCategoryListWith(LevelOneCategory.ID_PROPERTY, "is", id).done();
		
		Catalog catalogToUpdate = loadCatalog(userContext, catalogId, options);
		
		if(catalogToUpdate.getLevelOneCategoryList().isEmpty()){
			throw new CatalogManagerException("LevelOneCategory is NOT FOUND with id: '"+id+"'");
		}
		
		LevelOneCategory item = catalogToUpdate.getLevelOneCategoryList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingLevelOneCategory(userContext,catalogId,name, code, used,tokensExpr);
		Catalog catalog = saveCatalog(userContext, catalogToUpdate, tokens().withLevelOneCategoryList().done());
		synchronized(catalog){ 
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected LevelOneCategory createLevelOneCategory(PimUserContext userContext, String name) throws Exception{

		LevelOneCategory levelOneCategory = new LevelOneCategory();
		
		
		levelOneCategory.setName(name);
	
		
		return levelOneCategory;
	
		
	}
	
	protected LevelOneCategory createIndexedLevelOneCategory(String id, int version){

		LevelOneCategory levelOneCategory = new LevelOneCategory();
		levelOneCategory.setId(id);
		levelOneCategory.setVersion(version);
		return levelOneCategory;			
		
	}
	
	protected void checkParamsForRemovingLevelOneCategoryList(PimUserContext userContext, String catalogId, 
			String levelOneCategoryIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		for(String levelOneCategoryId: levelOneCategoryIds){
			userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog removeLevelOneCategoryList(PimUserContext userContext, String catalogId, 
			String levelOneCategoryIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingLevelOneCategoryList(userContext, catalogId,  levelOneCategoryIds, tokensExpr);
			
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
			synchronized(catalog){ 
				//Will be good when the catalog loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getCatalogDAO().planToRemoveLevelOneCategoryList(catalog, levelOneCategoryIds, allTokens());
				catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
				deleteRelationListInGraph(userContext, catalog.getLevelOneCategoryList());
				return present(userContext,catalog, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingLevelOneCategory(PimUserContext userContext, String catalogId, 
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().checkVersionOfLevelOneCategory(levelOneCategoryVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog removeLevelOneCategory(PimUserContext userContext, String catalogId, 
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelOneCategory(userContext,catalogId, levelOneCategoryId, levelOneCategoryVersion,tokensExpr);
		
		LevelOneCategory levelOneCategory = createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.removeLevelOneCategory( levelOneCategory );		
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			deleteRelationInGraph(userContext, levelOneCategory);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingLevelOneCategory(PimUserContext userContext, String catalogId, 
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().checkVersionOfLevelOneCategory(levelOneCategoryVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog copyLevelOneCategoryFrom(PimUserContext userContext, String catalogId, 
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelOneCategory(userContext,catalogId, levelOneCategoryId, levelOneCategoryVersion,tokensExpr);
		
		LevelOneCategory levelOneCategory = createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			catalog.copyLevelOneCategoryFrom( levelOneCategory );		
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			
			userContext.getManagerGroup().getLevelOneCategoryManager().onNewInstanceCreated(userContext, (LevelOneCategory)catalog.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingLevelOneCategory(PimUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().checkVersionOfLevelOneCategory(levelOneCategoryVersion);
		

		if(LevelOneCategory.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelOneCategory(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	
	public  Catalog updateLevelOneCategory(PimUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelOneCategory(userContext, catalogId, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withLevelOneCategoryList().searchLevelOneCategoryListWith(LevelOneCategory.ID_PROPERTY, "eq", levelOneCategoryId).done();
		
		
		
		Catalog catalog = loadCatalog(userContext, catalogId, loadTokens);
		
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//catalog.removeLevelOneCategory( levelOneCategory );	
			//make changes to AcceleraterAccount.
			LevelOneCategory levelOneCategoryIndex = createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
		
			LevelOneCategory levelOneCategory = catalog.findTheLevelOneCategory(levelOneCategoryIndex);
			if(levelOneCategory == null){
				throw new CatalogManagerException(levelOneCategory+" is NOT FOUND" );
			}
			
			levelOneCategory.changeProperty(property, newValueExpr);
			
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String origin, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfCatalog(catalogId);

		
		userContext.getChecker().checkNameOfProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfProduct(brandId);
		
		userContext.getChecker().checkOriginOfProduct(origin);
		
		userContext.getChecker().checkRemarkOfProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);

	
	}
	public  Catalog addProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String origin, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProduct(userContext,catalogId,name, parentCategoryId, brandId, origin, remark, platformId,tokensExpr);
		
		Product product = createProduct(userContext,name, parentCategoryId, brandId, origin, remark, platformId);
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.addProduct( product );		
			catalog = saveCatalog(userContext, catalog, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, product);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductProperties(PimUserContext userContext, String catalogId,String id,String name,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfProduct(id);
		
		userContext.getChecker().checkNameOfProduct( name);
		userContext.getChecker().checkOriginOfProduct( origin);
		userContext.getChecker().checkRemarkOfProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog updateProductProperties(PimUserContext userContext, String catalogId, String id,String name,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductProperties(userContext,catalogId,id,name,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductListList()
				.searchProductListWith(Product.ID_PROPERTY, "is", id).done();
		
		Catalog catalogToUpdate = loadCatalog(userContext, catalogId, options);
		
		if(catalogToUpdate.getProductList().isEmpty()){
			throw new CatalogManagerException("Product is NOT FOUND with id: '"+id+"'");
		}
		
		Product item = catalogToUpdate.getProductList().first();
		
		item.updateName( name );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingProduct(userContext,catalogId,name, code, used,tokensExpr);
		Catalog catalog = saveCatalog(userContext, catalogToUpdate, tokens().withProductList().done());
		synchronized(catalog){ 
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Product createProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String origin, String remark, String platformId) throws Exception{

		Product product = new Product();
		
		
		product.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		product.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		product.setBrand(brand);		
		product.setOrigin(origin);		
		product.setRemark(remark);		
		product.setLastUpdateTime(userContext.now());		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		product.setPlatform(platform);
	
		
		return product;
	
		
	}
	
	protected Product createIndexedProduct(String id, int version){

		Product product = new Product();
		product.setId(id);
		product.setVersion(version);
		return product;			
		
	}
	
	protected void checkParamsForRemovingProductList(PimUserContext userContext, String catalogId, 
			String productIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		for(String productId: productIds){
			userContext.getChecker().checkIdOfProduct(productId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog removeProductList(PimUserContext userContext, String catalogId, 
			String productIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProductList(userContext, catalogId,  productIds, tokensExpr);
			
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
			synchronized(catalog){ 
				//Will be good when the catalog loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getCatalogDAO().planToRemoveProductList(catalog, productIds, allTokens());
				catalog = saveCatalog(userContext, catalog, tokens().withProductList().done());
				deleteRelationListInGraph(userContext, catalog.getProductList());
				return present(userContext,catalog, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProduct(PimUserContext userContext, String catalogId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog removeProduct(PimUserContext userContext, String catalogId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProduct(userContext,catalogId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.removeProduct( product );		
			catalog = saveCatalog(userContext, catalog, tokens().withProductList().done());
			deleteRelationInGraph(userContext, product);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProduct(PimUserContext userContext, String catalogId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog copyProductFrom(PimUserContext userContext, String catalogId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProduct(userContext,catalogId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			product.updateLastUpdateTime(userContext.now());
			
			catalog.copyProductFrom( product );		
			catalog = saveCatalog(userContext, catalog, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, (Product)catalog.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProduct(PimUserContext userContext, String catalogId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfCatalog(catalogId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	
	public  Catalog updateProduct(PimUserContext userContext, String catalogId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProduct(userContext, catalogId, productId, productVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProductList().searchProductListWith(Product.ID_PROPERTY, "eq", productId).done();
		
		
		
		Catalog catalog = loadCatalog(userContext, catalogId, loadTokens);
		
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//catalog.removeProduct( product );	
			//make changes to AcceleraterAccount.
			Product productIndex = createIndexedProduct(productId, productVersion);
		
			Product product = catalog.findTheProduct(productIndex);
			if(product == null){
				throw new CatalogManagerException(product+" is NOT FOUND" );
			}
			
			product.changeProperty(property, newValueExpr);
			product.updateLastUpdateTime(userContext.now());
			catalog = saveCatalog(userContext, catalog, tokens().withProductList().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(PimUserContext userContext, Catalog newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


