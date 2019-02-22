
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

import com.terapico.pim.editorpickproduct.EditorPickProduct;
import com.terapico.pim.newproduct.NewProduct;
import com.terapico.pim.site.Site;
import com.terapico.pim.product.Product;
import com.terapico.pim.levelonecategory.LevelOneCategory;
import com.terapico.pim.topratedproduct.TopRatedProduct;
import com.terapico.pim.recommandproduct.RecommandProduct;
import com.terapico.pim.platform.Platform;

import com.terapico.pim.site.CandidateSite;
import com.terapico.pim.platform.CandidatePlatform;

import com.terapico.pim.levelncategory.LevelNCategory;
import com.terapico.pim.profile.Profile;
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
		addAction(userContext, catalog, tokens,"catalog.addNewProduct","addNewProduct","addNewProduct/"+catalog.getId()+"/","newProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.removeNewProduct","removeNewProduct","removeNewProduct/"+catalog.getId()+"/","newProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.updateNewProduct","updateNewProduct","updateNewProduct/"+catalog.getId()+"/","newProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.copyNewProductFrom","copyNewProductFrom","copyNewProductFrom/"+catalog.getId()+"/","newProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.addEditorPickProduct","addEditorPickProduct","addEditorPickProduct/"+catalog.getId()+"/","editorPickProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.removeEditorPickProduct","removeEditorPickProduct","removeEditorPickProduct/"+catalog.getId()+"/","editorPickProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.updateEditorPickProduct","updateEditorPickProduct","updateEditorPickProduct/"+catalog.getId()+"/","editorPickProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.copyEditorPickProductFrom","copyEditorPickProductFrom","copyEditorPickProductFrom/"+catalog.getId()+"/","editorPickProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.addTopRatedProduct","addTopRatedProduct","addTopRatedProduct/"+catalog.getId()+"/","topRatedProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.removeTopRatedProduct","removeTopRatedProduct","removeTopRatedProduct/"+catalog.getId()+"/","topRatedProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.updateTopRatedProduct","updateTopRatedProduct","updateTopRatedProduct/"+catalog.getId()+"/","topRatedProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.copyTopRatedProductFrom","copyTopRatedProductFrom","copyTopRatedProductFrom/"+catalog.getId()+"/","topRatedProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.addRecommandProduct","addRecommandProduct","addRecommandProduct/"+catalog.getId()+"/","recommandProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.removeRecommandProduct","removeRecommandProduct","removeRecommandProduct/"+catalog.getId()+"/","recommandProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.updateRecommandProduct","updateRecommandProduct","updateRecommandProduct/"+catalog.getId()+"/","recommandProductList","primary");
		addAction(userContext, catalog, tokens,"catalog.copyRecommandProductFrom","copyRecommandProductFrom","copyRecommandProductFrom/"+catalog.getId()+"/","recommandProductList","primary");
	
		
		
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
		.sortNewProductListWith("id","desc")
		.sortEditorPickProductListWith("id","desc")
		.sortTopRatedProductListWith("id","desc")
		.sortRecommandProductListWith("id","desc")
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
	//disconnect Catalog with parent_category in NewProduct
	protected Catalog breakWithNewProductByParentCategory(PimUserContext userContext, String catalogId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveNewProductListWithParentCategory(catalog, parentCategoryId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withNewProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with brand in NewProduct
	protected Catalog breakWithNewProductByBrand(PimUserContext userContext, String catalogId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveNewProductListWithBrand(catalog, brandId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withNewProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with profile in NewProduct
	protected Catalog breakWithNewProductByProfile(PimUserContext userContext, String catalogId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveNewProductListWithProfile(catalog, profileId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withNewProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with platform in NewProduct
	protected Catalog breakWithNewProductByPlatform(PimUserContext userContext, String catalogId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveNewProductListWithPlatform(catalog, platformId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withNewProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with parent_category in EditorPickProduct
	protected Catalog breakWithEditorPickProductByParentCategory(PimUserContext userContext, String catalogId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveEditorPickProductListWithParentCategory(catalog, parentCategoryId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withEditorPickProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with brand in EditorPickProduct
	protected Catalog breakWithEditorPickProductByBrand(PimUserContext userContext, String catalogId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveEditorPickProductListWithBrand(catalog, brandId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withEditorPickProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with profile in EditorPickProduct
	protected Catalog breakWithEditorPickProductByProfile(PimUserContext userContext, String catalogId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveEditorPickProductListWithProfile(catalog, profileId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withEditorPickProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with platform in EditorPickProduct
	protected Catalog breakWithEditorPickProductByPlatform(PimUserContext userContext, String catalogId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveEditorPickProductListWithPlatform(catalog, platformId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withEditorPickProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with parent_category in TopRatedProduct
	protected Catalog breakWithTopRatedProductByParentCategory(PimUserContext userContext, String catalogId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveTopRatedProductListWithParentCategory(catalog, parentCategoryId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withTopRatedProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with brand in TopRatedProduct
	protected Catalog breakWithTopRatedProductByBrand(PimUserContext userContext, String catalogId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveTopRatedProductListWithBrand(catalog, brandId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withTopRatedProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with profile in TopRatedProduct
	protected Catalog breakWithTopRatedProductByProfile(PimUserContext userContext, String catalogId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveTopRatedProductListWithProfile(catalog, profileId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withTopRatedProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with platform in TopRatedProduct
	protected Catalog breakWithTopRatedProductByPlatform(PimUserContext userContext, String catalogId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveTopRatedProductListWithPlatform(catalog, platformId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withTopRatedProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with parent_category in RecommandProduct
	protected Catalog breakWithRecommandProductByParentCategory(PimUserContext userContext, String catalogId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveRecommandProductListWithParentCategory(catalog, parentCategoryId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withRecommandProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with brand in RecommandProduct
	protected Catalog breakWithRecommandProductByBrand(PimUserContext userContext, String catalogId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveRecommandProductListWithBrand(catalog, brandId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withRecommandProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with profile in RecommandProduct
	protected Catalog breakWithRecommandProductByProfile(PimUserContext userContext, String catalogId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveRecommandProductListWithProfile(catalog, profileId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withRecommandProductList().done());
				return catalog;
			}
	}
	//disconnect Catalog with platform in RecommandProduct
	protected Catalog breakWithRecommandProductByPlatform(PimUserContext userContext, String catalogId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());

			synchronized(catalog){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCatalogDAO().planToRemoveRecommandProductListWithPlatform(catalog, platformId, this.emptyOptions());

				catalog = saveCatalog(userContext, catalog, tokens().withRecommandProductList().done());
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
	



	protected void checkParamsForAddingProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfCatalog(catalogId);

		
		userContext.getChecker().checkNameOfProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfProduct(origin);
		
		userContext.getChecker().checkRemarkOfProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);

	
	}
	public  Catalog addProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProduct(userContext,catalogId,name, parentCategoryId, brandId, productCoverImage, origin, remark, platformId,tokensExpr);
		
		Product product = createProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, remark, platformId);
		
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
	protected void checkParamsForUpdatingProductProperties(PimUserContext userContext, String catalogId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfProduct(id);
		
		userContext.getChecker().checkNameOfProduct( name);
		userContext.getChecker().checkProductCoverImageOfProduct( productCoverImage);
		userContext.getChecker().checkOriginOfProduct( origin);
		userContext.getChecker().checkRemarkOfProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog updateProductProperties(PimUserContext userContext, String catalogId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductProperties(userContext,catalogId,id,name,productCoverImage,origin,remark,tokensExpr);

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
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingProduct(userContext,catalogId,name, code, used,tokensExpr);
		Catalog catalog = saveCatalog(userContext, catalogToUpdate, tokens().withProductList().done());
		synchronized(catalog){ 
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Product createProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String platformId) throws Exception{

		Product product = new Product();
		
		
		product.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		product.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		product.setBrand(brand);		
		product.setProductCoverImage(productCoverImage);		
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
		
		if(Product.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfProduct(parseString(newValueExpr));
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
	



	protected void checkParamsForAddingNewProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String profileId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfCatalog(catalogId);

		
		userContext.getChecker().checkNameOfNewProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfNewProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfNewProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfNewProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfNewProduct(origin);
		
		userContext.getChecker().checkProfileIdOfNewProduct(profileId);
		
		userContext.getChecker().checkRemarkOfNewProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfNewProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);

	
	}
	public  Catalog addNewProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String profileId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingNewProduct(userContext,catalogId,name, parentCategoryId, brandId, productCoverImage, origin, profileId, remark, platformId,tokensExpr);
		
		NewProduct newProduct = createNewProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, profileId, remark, platformId);
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.addNewProduct( newProduct );		
			catalog = saveCatalog(userContext, catalog, tokens().withNewProductList().done());
			
			userContext.getManagerGroup().getNewProductManager().onNewInstanceCreated(userContext, newProduct);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingNewProductProperties(PimUserContext userContext, String catalogId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfNewProduct(id);
		
		userContext.getChecker().checkNameOfNewProduct( name);
		userContext.getChecker().checkProductCoverImageOfNewProduct( productCoverImage);
		userContext.getChecker().checkOriginOfNewProduct( origin);
		userContext.getChecker().checkRemarkOfNewProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog updateNewProductProperties(PimUserContext userContext, String catalogId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingNewProductProperties(userContext,catalogId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withNewProductListList()
				.searchNewProductListWith(NewProduct.ID_PROPERTY, "is", id).done();
		
		Catalog catalogToUpdate = loadCatalog(userContext, catalogId, options);
		
		if(catalogToUpdate.getNewProductList().isEmpty()){
			throw new CatalogManagerException("NewProduct is NOT FOUND with id: '"+id+"'");
		}
		
		NewProduct item = catalogToUpdate.getNewProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingNewProduct(userContext,catalogId,name, code, used,tokensExpr);
		Catalog catalog = saveCatalog(userContext, catalogToUpdate, tokens().withNewProductList().done());
		synchronized(catalog){ 
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected NewProduct createNewProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String profileId, String remark, String platformId) throws Exception{

		NewProduct newProduct = new NewProduct();
		
		
		newProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		newProduct.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		newProduct.setBrand(brand);		
		newProduct.setProductCoverImage(productCoverImage);		
		newProduct.setOrigin(origin);		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		newProduct.setProfile(profile);		
		newProduct.setRemark(remark);		
		newProduct.setLastUpdateTime(userContext.now());		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		newProduct.setPlatform(platform);
	
		
		return newProduct;
	
		
	}
	
	protected NewProduct createIndexedNewProduct(String id, int version){

		NewProduct newProduct = new NewProduct();
		newProduct.setId(id);
		newProduct.setVersion(version);
		return newProduct;			
		
	}
	
	protected void checkParamsForRemovingNewProductList(PimUserContext userContext, String catalogId, 
			String newProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		for(String newProductId: newProductIds){
			userContext.getChecker().checkIdOfNewProduct(newProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog removeNewProductList(PimUserContext userContext, String catalogId, 
			String newProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingNewProductList(userContext, catalogId,  newProductIds, tokensExpr);
			
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
			synchronized(catalog){ 
				//Will be good when the catalog loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getCatalogDAO().planToRemoveNewProductList(catalog, newProductIds, allTokens());
				catalog = saveCatalog(userContext, catalog, tokens().withNewProductList().done());
				deleteRelationListInGraph(userContext, catalog.getNewProductList());
				return present(userContext,catalog, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingNewProduct(PimUserContext userContext, String catalogId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog removeNewProduct(PimUserContext userContext, String catalogId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingNewProduct(userContext,catalogId, newProductId, newProductVersion,tokensExpr);
		
		NewProduct newProduct = createIndexedNewProduct(newProductId, newProductVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.removeNewProduct( newProduct );		
			catalog = saveCatalog(userContext, catalog, tokens().withNewProductList().done());
			deleteRelationInGraph(userContext, newProduct);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingNewProduct(PimUserContext userContext, String catalogId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog copyNewProductFrom(PimUserContext userContext, String catalogId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingNewProduct(userContext,catalogId, newProductId, newProductVersion,tokensExpr);
		
		NewProduct newProduct = createIndexedNewProduct(newProductId, newProductVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			newProduct.updateLastUpdateTime(userContext.now());
			
			catalog.copyNewProductFrom( newProduct );		
			catalog = saveCatalog(userContext, catalog, tokens().withNewProductList().done());
			
			userContext.getManagerGroup().getNewProductManager().onNewInstanceCreated(userContext, (NewProduct)catalog.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingNewProduct(PimUserContext userContext, String catalogId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		

		if(NewProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfNewProduct(parseString(newValueExpr));
		}
		
		if(NewProduct.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfNewProduct(parseString(newValueExpr));
		}
		
		if(NewProduct.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfNewProduct(parseString(newValueExpr));
		}
		
		if(NewProduct.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfNewProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	
	public  Catalog updateNewProduct(PimUserContext userContext, String catalogId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingNewProduct(userContext, catalogId, newProductId, newProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withNewProductList().searchNewProductListWith(NewProduct.ID_PROPERTY, "eq", newProductId).done();
		
		
		
		Catalog catalog = loadCatalog(userContext, catalogId, loadTokens);
		
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//catalog.removeNewProduct( newProduct );	
			//make changes to AcceleraterAccount.
			NewProduct newProductIndex = createIndexedNewProduct(newProductId, newProductVersion);
		
			NewProduct newProduct = catalog.findTheNewProduct(newProductIndex);
			if(newProduct == null){
				throw new CatalogManagerException(newProduct+" is NOT FOUND" );
			}
			
			newProduct.changeProperty(property, newValueExpr);
			newProduct.updateLastUpdateTime(userContext.now());
			catalog = saveCatalog(userContext, catalog, tokens().withNewProductList().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEditorPickProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String profileId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfCatalog(catalogId);

		
		userContext.getChecker().checkNameOfEditorPickProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfEditorPickProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfEditorPickProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfEditorPickProduct(origin);
		
		userContext.getChecker().checkProfileIdOfEditorPickProduct(profileId);
		
		userContext.getChecker().checkRemarkOfEditorPickProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfEditorPickProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);

	
	}
	public  Catalog addEditorPickProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String profileId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEditorPickProduct(userContext,catalogId,name, parentCategoryId, brandId, productCoverImage, origin, profileId, remark, platformId,tokensExpr);
		
		EditorPickProduct editorPickProduct = createEditorPickProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, profileId, remark, platformId);
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.addEditorPickProduct( editorPickProduct );		
			catalog = saveCatalog(userContext, catalog, tokens().withEditorPickProductList().done());
			
			userContext.getManagerGroup().getEditorPickProductManager().onNewInstanceCreated(userContext, editorPickProduct);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEditorPickProductProperties(PimUserContext userContext, String catalogId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfEditorPickProduct(id);
		
		userContext.getChecker().checkNameOfEditorPickProduct( name);
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct( productCoverImage);
		userContext.getChecker().checkOriginOfEditorPickProduct( origin);
		userContext.getChecker().checkRemarkOfEditorPickProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog updateEditorPickProductProperties(PimUserContext userContext, String catalogId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEditorPickProductProperties(userContext,catalogId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEditorPickProductListList()
				.searchEditorPickProductListWith(EditorPickProduct.ID_PROPERTY, "is", id).done();
		
		Catalog catalogToUpdate = loadCatalog(userContext, catalogId, options);
		
		if(catalogToUpdate.getEditorPickProductList().isEmpty()){
			throw new CatalogManagerException("EditorPickProduct is NOT FOUND with id: '"+id+"'");
		}
		
		EditorPickProduct item = catalogToUpdate.getEditorPickProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingEditorPickProduct(userContext,catalogId,name, code, used,tokensExpr);
		Catalog catalog = saveCatalog(userContext, catalogToUpdate, tokens().withEditorPickProductList().done());
		synchronized(catalog){ 
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EditorPickProduct createEditorPickProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String profileId, String remark, String platformId) throws Exception{

		EditorPickProduct editorPickProduct = new EditorPickProduct();
		
		
		editorPickProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		editorPickProduct.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		editorPickProduct.setBrand(brand);		
		editorPickProduct.setProductCoverImage(productCoverImage);		
		editorPickProduct.setOrigin(origin);		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		editorPickProduct.setProfile(profile);		
		editorPickProduct.setRemark(remark);		
		editorPickProduct.setLastUpdateTime(userContext.now());		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		editorPickProduct.setPlatform(platform);
	
		
		return editorPickProduct;
	
		
	}
	
	protected EditorPickProduct createIndexedEditorPickProduct(String id, int version){

		EditorPickProduct editorPickProduct = new EditorPickProduct();
		editorPickProduct.setId(id);
		editorPickProduct.setVersion(version);
		return editorPickProduct;			
		
	}
	
	protected void checkParamsForRemovingEditorPickProductList(PimUserContext userContext, String catalogId, 
			String editorPickProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		for(String editorPickProductId: editorPickProductIds){
			userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog removeEditorPickProductList(PimUserContext userContext, String catalogId, 
			String editorPickProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEditorPickProductList(userContext, catalogId,  editorPickProductIds, tokensExpr);
			
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
			synchronized(catalog){ 
				//Will be good when the catalog loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getCatalogDAO().planToRemoveEditorPickProductList(catalog, editorPickProductIds, allTokens());
				catalog = saveCatalog(userContext, catalog, tokens().withEditorPickProductList().done());
				deleteRelationListInGraph(userContext, catalog.getEditorPickProductList());
				return present(userContext,catalog, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEditorPickProduct(PimUserContext userContext, String catalogId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog removeEditorPickProduct(PimUserContext userContext, String catalogId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEditorPickProduct(userContext,catalogId, editorPickProductId, editorPickProductVersion,tokensExpr);
		
		EditorPickProduct editorPickProduct = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.removeEditorPickProduct( editorPickProduct );		
			catalog = saveCatalog(userContext, catalog, tokens().withEditorPickProductList().done());
			deleteRelationInGraph(userContext, editorPickProduct);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEditorPickProduct(PimUserContext userContext, String catalogId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog copyEditorPickProductFrom(PimUserContext userContext, String catalogId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEditorPickProduct(userContext,catalogId, editorPickProductId, editorPickProductVersion,tokensExpr);
		
		EditorPickProduct editorPickProduct = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			editorPickProduct.updateLastUpdateTime(userContext.now());
			
			catalog.copyEditorPickProductFrom( editorPickProduct );		
			catalog = saveCatalog(userContext, catalog, tokens().withEditorPickProductList().done());
			
			userContext.getManagerGroup().getEditorPickProductManager().onNewInstanceCreated(userContext, (EditorPickProduct)catalog.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEditorPickProduct(PimUserContext userContext, String catalogId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		

		if(EditorPickProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfEditorPickProduct(parseString(newValueExpr));
		}
		
		if(EditorPickProduct.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfEditorPickProduct(parseString(newValueExpr));
		}
		
		if(EditorPickProduct.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfEditorPickProduct(parseString(newValueExpr));
		}
		
		if(EditorPickProduct.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEditorPickProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	
	public  Catalog updateEditorPickProduct(PimUserContext userContext, String catalogId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEditorPickProduct(userContext, catalogId, editorPickProductId, editorPickProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEditorPickProductList().searchEditorPickProductListWith(EditorPickProduct.ID_PROPERTY, "eq", editorPickProductId).done();
		
		
		
		Catalog catalog = loadCatalog(userContext, catalogId, loadTokens);
		
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//catalog.removeEditorPickProduct( editorPickProduct );	
			//make changes to AcceleraterAccount.
			EditorPickProduct editorPickProductIndex = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		
			EditorPickProduct editorPickProduct = catalog.findTheEditorPickProduct(editorPickProductIndex);
			if(editorPickProduct == null){
				throw new CatalogManagerException(editorPickProduct+" is NOT FOUND" );
			}
			
			editorPickProduct.changeProperty(property, newValueExpr);
			editorPickProduct.updateLastUpdateTime(userContext.now());
			catalog = saveCatalog(userContext, catalog, tokens().withEditorPickProductList().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTopRatedProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String profileId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfCatalog(catalogId);

		
		userContext.getChecker().checkNameOfTopRatedProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfTopRatedProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfTopRatedProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfTopRatedProduct(origin);
		
		userContext.getChecker().checkRemarkOfTopRatedProduct(remark);
		
		userContext.getChecker().checkProfileIdOfTopRatedProduct(profileId);
		
		userContext.getChecker().checkPlatformIdOfTopRatedProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);

	
	}
	public  Catalog addTopRatedProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String profileId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTopRatedProduct(userContext,catalogId,name, parentCategoryId, brandId, productCoverImage, origin, remark, profileId, platformId,tokensExpr);
		
		TopRatedProduct topRatedProduct = createTopRatedProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, remark, profileId, platformId);
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.addTopRatedProduct( topRatedProduct );		
			catalog = saveCatalog(userContext, catalog, tokens().withTopRatedProductList().done());
			
			userContext.getManagerGroup().getTopRatedProductManager().onNewInstanceCreated(userContext, topRatedProduct);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTopRatedProductProperties(PimUserContext userContext, String catalogId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfTopRatedProduct(id);
		
		userContext.getChecker().checkNameOfTopRatedProduct( name);
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct( productCoverImage);
		userContext.getChecker().checkOriginOfTopRatedProduct( origin);
		userContext.getChecker().checkRemarkOfTopRatedProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog updateTopRatedProductProperties(PimUserContext userContext, String catalogId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTopRatedProductProperties(userContext,catalogId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTopRatedProductListList()
				.searchTopRatedProductListWith(TopRatedProduct.ID_PROPERTY, "is", id).done();
		
		Catalog catalogToUpdate = loadCatalog(userContext, catalogId, options);
		
		if(catalogToUpdate.getTopRatedProductList().isEmpty()){
			throw new CatalogManagerException("TopRatedProduct is NOT FOUND with id: '"+id+"'");
		}
		
		TopRatedProduct item = catalogToUpdate.getTopRatedProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingTopRatedProduct(userContext,catalogId,name, code, used,tokensExpr);
		Catalog catalog = saveCatalog(userContext, catalogToUpdate, tokens().withTopRatedProductList().done());
		synchronized(catalog){ 
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TopRatedProduct createTopRatedProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String profileId, String platformId) throws Exception{

		TopRatedProduct topRatedProduct = new TopRatedProduct();
		
		
		topRatedProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		topRatedProduct.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		topRatedProduct.setBrand(brand);		
		topRatedProduct.setProductCoverImage(productCoverImage);		
		topRatedProduct.setOrigin(origin);		
		topRatedProduct.setRemark(remark);		
		topRatedProduct.setLastUpdateTime(userContext.now());		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		topRatedProduct.setProfile(profile);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		topRatedProduct.setPlatform(platform);
	
		
		return topRatedProduct;
	
		
	}
	
	protected TopRatedProduct createIndexedTopRatedProduct(String id, int version){

		TopRatedProduct topRatedProduct = new TopRatedProduct();
		topRatedProduct.setId(id);
		topRatedProduct.setVersion(version);
		return topRatedProduct;			
		
	}
	
	protected void checkParamsForRemovingTopRatedProductList(PimUserContext userContext, String catalogId, 
			String topRatedProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		for(String topRatedProductId: topRatedProductIds){
			userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog removeTopRatedProductList(PimUserContext userContext, String catalogId, 
			String topRatedProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTopRatedProductList(userContext, catalogId,  topRatedProductIds, tokensExpr);
			
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
			synchronized(catalog){ 
				//Will be good when the catalog loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getCatalogDAO().planToRemoveTopRatedProductList(catalog, topRatedProductIds, allTokens());
				catalog = saveCatalog(userContext, catalog, tokens().withTopRatedProductList().done());
				deleteRelationListInGraph(userContext, catalog.getTopRatedProductList());
				return present(userContext,catalog, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTopRatedProduct(PimUserContext userContext, String catalogId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog removeTopRatedProduct(PimUserContext userContext, String catalogId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTopRatedProduct(userContext,catalogId, topRatedProductId, topRatedProductVersion,tokensExpr);
		
		TopRatedProduct topRatedProduct = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.removeTopRatedProduct( topRatedProduct );		
			catalog = saveCatalog(userContext, catalog, tokens().withTopRatedProductList().done());
			deleteRelationInGraph(userContext, topRatedProduct);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTopRatedProduct(PimUserContext userContext, String catalogId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog copyTopRatedProductFrom(PimUserContext userContext, String catalogId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTopRatedProduct(userContext,catalogId, topRatedProductId, topRatedProductVersion,tokensExpr);
		
		TopRatedProduct topRatedProduct = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			topRatedProduct.updateLastUpdateTime(userContext.now());
			
			catalog.copyTopRatedProductFrom( topRatedProduct );		
			catalog = saveCatalog(userContext, catalog, tokens().withTopRatedProductList().done());
			
			userContext.getManagerGroup().getTopRatedProductManager().onNewInstanceCreated(userContext, (TopRatedProduct)catalog.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTopRatedProduct(PimUserContext userContext, String catalogId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		

		if(TopRatedProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTopRatedProduct(parseString(newValueExpr));
		}
		
		if(TopRatedProduct.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfTopRatedProduct(parseString(newValueExpr));
		}
		
		if(TopRatedProduct.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfTopRatedProduct(parseString(newValueExpr));
		}
		
		if(TopRatedProduct.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfTopRatedProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	
	public  Catalog updateTopRatedProduct(PimUserContext userContext, String catalogId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTopRatedProduct(userContext, catalogId, topRatedProductId, topRatedProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTopRatedProductList().searchTopRatedProductListWith(TopRatedProduct.ID_PROPERTY, "eq", topRatedProductId).done();
		
		
		
		Catalog catalog = loadCatalog(userContext, catalogId, loadTokens);
		
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//catalog.removeTopRatedProduct( topRatedProduct );	
			//make changes to AcceleraterAccount.
			TopRatedProduct topRatedProductIndex = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		
			TopRatedProduct topRatedProduct = catalog.findTheTopRatedProduct(topRatedProductIndex);
			if(topRatedProduct == null){
				throw new CatalogManagerException(topRatedProduct+" is NOT FOUND" );
			}
			
			topRatedProduct.changeProperty(property, newValueExpr);
			topRatedProduct.updateLastUpdateTime(userContext.now());
			catalog = saveCatalog(userContext, catalog, tokens().withTopRatedProductList().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRecommandProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String profileId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfCatalog(catalogId);

		
		userContext.getChecker().checkNameOfRecommandProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfRecommandProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfRecommandProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfRecommandProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfRecommandProduct(origin);
		
		userContext.getChecker().checkRemarkOfRecommandProduct(remark);
		
		userContext.getChecker().checkProfileIdOfRecommandProduct(profileId);
		
		userContext.getChecker().checkPlatformIdOfRecommandProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);

	
	}
	public  Catalog addRecommandProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String profileId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRecommandProduct(userContext,catalogId,name, parentCategoryId, brandId, productCoverImage, origin, remark, profileId, platformId,tokensExpr);
		
		RecommandProduct recommandProduct = createRecommandProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, remark, profileId, platformId);
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.addRecommandProduct( recommandProduct );		
			catalog = saveCatalog(userContext, catalog, tokens().withRecommandProductList().done());
			
			userContext.getManagerGroup().getRecommandProductManager().onNewInstanceCreated(userContext, recommandProduct);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRecommandProductProperties(PimUserContext userContext, String catalogId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfRecommandProduct(id);
		
		userContext.getChecker().checkNameOfRecommandProduct( name);
		userContext.getChecker().checkProductCoverImageOfRecommandProduct( productCoverImage);
		userContext.getChecker().checkOriginOfRecommandProduct( origin);
		userContext.getChecker().checkRemarkOfRecommandProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog updateRecommandProductProperties(PimUserContext userContext, String catalogId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRecommandProductProperties(userContext,catalogId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRecommandProductListList()
				.searchRecommandProductListWith(RecommandProduct.ID_PROPERTY, "is", id).done();
		
		Catalog catalogToUpdate = loadCatalog(userContext, catalogId, options);
		
		if(catalogToUpdate.getRecommandProductList().isEmpty()){
			throw new CatalogManagerException("RecommandProduct is NOT FOUND with id: '"+id+"'");
		}
		
		RecommandProduct item = catalogToUpdate.getRecommandProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingRecommandProduct(userContext,catalogId,name, code, used,tokensExpr);
		Catalog catalog = saveCatalog(userContext, catalogToUpdate, tokens().withRecommandProductList().done());
		synchronized(catalog){ 
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RecommandProduct createRecommandProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String profileId, String platformId) throws Exception{

		RecommandProduct recommandProduct = new RecommandProduct();
		
		
		recommandProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		recommandProduct.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		recommandProduct.setBrand(brand);		
		recommandProduct.setProductCoverImage(productCoverImage);		
		recommandProduct.setOrigin(origin);		
		recommandProduct.setRemark(remark);		
		recommandProduct.setLastUpdateTime(userContext.now());		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		recommandProduct.setProfile(profile);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		recommandProduct.setPlatform(platform);
	
		
		return recommandProduct;
	
		
	}
	
	protected RecommandProduct createIndexedRecommandProduct(String id, int version){

		RecommandProduct recommandProduct = new RecommandProduct();
		recommandProduct.setId(id);
		recommandProduct.setVersion(version);
		return recommandProduct;			
		
	}
	
	protected void checkParamsForRemovingRecommandProductList(PimUserContext userContext, String catalogId, 
			String recommandProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		for(String recommandProductId: recommandProductIds){
			userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog removeRecommandProductList(PimUserContext userContext, String catalogId, 
			String recommandProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRecommandProductList(userContext, catalogId,  recommandProductIds, tokensExpr);
			
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
			synchronized(catalog){ 
				//Will be good when the catalog loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getCatalogDAO().planToRemoveRecommandProductList(catalog, recommandProductIds, allTokens());
				catalog = saveCatalog(userContext, catalog, tokens().withRecommandProductList().done());
				deleteRelationListInGraph(userContext, catalog.getRecommandProductList());
				return present(userContext,catalog, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRecommandProduct(PimUserContext userContext, String catalogId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog removeRecommandProduct(PimUserContext userContext, String catalogId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRecommandProduct(userContext,catalogId, recommandProductId, recommandProductVersion,tokensExpr);
		
		RecommandProduct recommandProduct = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.removeRecommandProduct( recommandProduct );		
			catalog = saveCatalog(userContext, catalog, tokens().withRecommandProductList().done());
			deleteRelationInGraph(userContext, recommandProduct);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRecommandProduct(PimUserContext userContext, String catalogId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog copyRecommandProductFrom(PimUserContext userContext, String catalogId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRecommandProduct(userContext,catalogId, recommandProductId, recommandProductVersion,tokensExpr);
		
		RecommandProduct recommandProduct = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			recommandProduct.updateLastUpdateTime(userContext.now());
			
			catalog.copyRecommandProductFrom( recommandProduct );		
			catalog = saveCatalog(userContext, catalog, tokens().withRecommandProductList().done());
			
			userContext.getManagerGroup().getRecommandProductManager().onNewInstanceCreated(userContext, (RecommandProduct)catalog.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRecommandProduct(PimUserContext userContext, String catalogId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		

		if(RecommandProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRecommandProduct(parseString(newValueExpr));
		}
		
		if(RecommandProduct.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfRecommandProduct(parseString(newValueExpr));
		}
		
		if(RecommandProduct.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfRecommandProduct(parseString(newValueExpr));
		}
		
		if(RecommandProduct.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfRecommandProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	
	public  Catalog updateRecommandProduct(PimUserContext userContext, String catalogId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRecommandProduct(userContext, catalogId, recommandProductId, recommandProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRecommandProductList().searchRecommandProductListWith(RecommandProduct.ID_PROPERTY, "eq", recommandProductId).done();
		
		
		
		Catalog catalog = loadCatalog(userContext, catalogId, loadTokens);
		
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//catalog.removeRecommandProduct( recommandProduct );	
			//make changes to AcceleraterAccount.
			RecommandProduct recommandProductIndex = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		
			RecommandProduct recommandProduct = catalog.findTheRecommandProduct(recommandProductIndex);
			if(recommandProduct == null){
				throw new CatalogManagerException(recommandProduct+" is NOT FOUND" );
			}
			
			recommandProduct.changeProperty(property, newValueExpr);
			recommandProduct.updateLastUpdateTime(userContext.now());
			catalog = saveCatalog(userContext, catalog, tokens().withRecommandProductList().done());
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


