
package com.terapico.pim.newproduct;

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

import com.terapico.pim.levelncategory.LevelNCategory;
import com.terapico.pim.profile.Profile;
import com.terapico.pim.catalog.Catalog;
import com.terapico.pim.brand.Brand;
import com.terapico.pim.platform.Platform;

import com.terapico.pim.levelncategory.CandidateLevelNCategory;
import com.terapico.pim.profile.CandidateProfile;
import com.terapico.pim.catalog.CandidateCatalog;
import com.terapico.pim.brand.CandidateBrand;
import com.terapico.pim.platform.CandidatePlatform;







public class NewProductManagerImpl extends CustomPimCheckerManager implements NewProductManager {
	
	private static final String SERVICE_TYPE = "NewProduct";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws NewProductManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new NewProductManagerException(message);

	}
	
	

 	protected NewProduct saveNewProduct(PimUserContext userContext, NewProduct newProduct, String [] tokensExpr) throws Exception{	
 		//return getNewProductDAO().save(newProduct, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveNewProduct(userContext, newProduct, tokens);
 	}
 	
 	protected NewProduct saveNewProductDetail(PimUserContext userContext, NewProduct newProduct) throws Exception{	

 		
 		return saveNewProduct(userContext, newProduct, allTokens());
 	}
 	
 	public NewProduct loadNewProduct(PimUserContext userContext, String newProductId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().throwExceptionIfHasErrors( NewProductManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		NewProduct newProduct = loadNewProduct( userContext, newProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,newProduct, tokens);
 	}
 	
 	
 	 public NewProduct searchNewProduct(PimUserContext userContext, String newProductId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().throwExceptionIfHasErrors( NewProductManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		NewProduct newProduct = loadNewProduct( userContext, newProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,newProduct, tokens);
 	}
 	
 	

 	protected NewProduct present(PimUserContext userContext, NewProduct newProduct, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,newProduct,tokens);
		
		
		NewProduct  newProductToPresent = userContext.getDAOGroup().getNewProductDAO().present(newProduct, tokens);
		
		List<BaseEntity> entityListToNaming = newProductToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getNewProductDAO().alias(entityListToNaming);
		
		return  newProductToPresent;
		
		
	}
 
 	
 	
 	public NewProduct loadNewProductDetail(PimUserContext userContext, String newProductId) throws Exception{	
 		NewProduct newProduct = loadNewProduct( userContext, newProductId, allTokens());
 		return present(userContext,newProduct, allTokens());
		
 	}
 	
 	public Object view(PimUserContext userContext, String newProductId) throws Exception{	
 		NewProduct newProduct = loadNewProduct( userContext, newProductId, viewTokens());
 		return present(userContext,newProduct, allTokens());
		
 	}
 	protected NewProduct saveNewProduct(PimUserContext userContext, NewProduct newProduct, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getNewProductDAO().save(newProduct, tokens);
 	}
 	protected NewProduct loadNewProduct(PimUserContext userContext, String newProductId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().throwExceptionIfHasErrors( NewProductManagerException.class);

 
 		return userContext.getDAOGroup().getNewProductDAO().load(newProductId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(PimUserContext userContext, NewProduct newProduct, Map<String, Object> tokens){
		super.addActions(userContext, newProduct, tokens);
		
		addAction(userContext, newProduct, tokens,"@create","createNewProduct","createNewProduct/","main","primary");
		addAction(userContext, newProduct, tokens,"@update","updateNewProduct","updateNewProduct/"+newProduct.getId()+"/","main","primary");
		addAction(userContext, newProduct, tokens,"@copy","cloneNewProduct","cloneNewProduct/"+newProduct.getId()+"/","main","primary");
		
		addAction(userContext, newProduct, tokens,"new_product.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+newProduct.getId()+"/","main","primary");
		addAction(userContext, newProduct, tokens,"new_product.transfer_to_brand","transferToAnotherBrand","transferToAnotherBrand/"+newProduct.getId()+"/","main","primary");
		addAction(userContext, newProduct, tokens,"new_product.transfer_to_catalog","transferToAnotherCatalog","transferToAnotherCatalog/"+newProduct.getId()+"/","main","primary");
		addAction(userContext, newProduct, tokens,"new_product.transfer_to_profile","transferToAnotherProfile","transferToAnotherProfile/"+newProduct.getId()+"/","main","primary");
		addAction(userContext, newProduct, tokens,"new_product.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+newProduct.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(PimUserContext userContext, NewProduct newProduct, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public NewProduct createNewProduct(PimUserContext userContext,String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfNewProduct(name);
		userContext.getChecker().checkProductCoverImageOfNewProduct(productCoverImage);
		userContext.getChecker().checkOriginOfNewProduct(origin);
		userContext.getChecker().checkRemarkOfNewProduct(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(NewProductManagerException.class);


		NewProduct newProduct=createNewNewProduct();	

		newProduct.setName(name);
			
		LevelNCategory parentCategory = loadLevelNCategory(userContext, parentCategoryId,emptyOptions());
		newProduct.setParentCategory(parentCategory);
		
		
			
		Brand brand = loadBrand(userContext, brandId,emptyOptions());
		newProduct.setBrand(brand);
		
		
		newProduct.setProductCoverImage(productCoverImage);
		newProduct.setOrigin(origin);
			
		Catalog catalog = loadCatalog(userContext, catalogId,emptyOptions());
		newProduct.setCatalog(catalog);
		
		
			
		Profile profile = loadProfile(userContext, profileId,emptyOptions());
		newProduct.setProfile(profile);
		
		
		newProduct.setRemark(remark);
		newProduct.setLastUpdateTime(userContext.now());
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		newProduct.setPlatform(platform);
		
		

		newProduct = saveNewProduct(userContext, newProduct, emptyOptions());
		
		onNewInstanceCreated(userContext, newProduct);
		return newProduct;

		
	}
	protected NewProduct createNewNewProduct() 
	{
		
		return new NewProduct();		
	}
	
	protected void checkParamsForUpdatingNewProduct(PimUserContext userContext,String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct( newProductVersion);
		

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

		
	
		userContext.getChecker().throwExceptionIfHasErrors(NewProductManagerException.class);
	
		
	}
	
	
	
	public NewProduct clone(PimUserContext userContext, String fromNewProductId) throws Exception{
		
		return userContext.getDAOGroup().getNewProductDAO().clone(fromNewProductId, this.allTokens());
	}
	
	public NewProduct internalSaveNewProduct(PimUserContext userContext, NewProduct newProduct) throws Exception 
	{
		return internalSaveNewProduct(userContext, newProduct, allTokens());

	}
	public NewProduct internalSaveNewProduct(PimUserContext userContext, NewProduct newProduct, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingNewProduct(userContext, newProductId, newProductVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(newProduct){ 
			//will be good when the newProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to NewProduct.
			
			
			newProduct = saveNewProduct(userContext, newProduct, options);
			return newProduct;
			
		}

	}
	
	public NewProduct updateNewProduct(PimUserContext userContext,String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingNewProduct(userContext, newProductId, newProductVersion, property, newValueExpr, tokensExpr);
		
		
		
		NewProduct newProduct = loadNewProduct(userContext, newProductId, allTokens());
		if(newProduct.getVersion() != newProductVersion){
			String message = "The target version("+newProduct.getVersion()+") is not equals to version("+newProductVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(newProduct){ 
			//will be good when the newProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to NewProduct.
			newProduct.updateLastUpdateTime(userContext.now());
			newProduct.changeProperty(property, newValueExpr);
			newProduct = saveNewProduct(userContext, newProduct, tokens().done());
			return present(userContext,newProduct, mergedAllTokens(tokensExpr));
			//return saveNewProduct(userContext, newProduct, tokens().done());
		}

	}
	
	public NewProduct updateNewProductProperty(PimUserContext userContext,String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingNewProduct(userContext, newProductId, newProductVersion, property, newValueExpr, tokensExpr);
		
		NewProduct newProduct = loadNewProduct(userContext, newProductId, allTokens());
		if(newProduct.getVersion() != newProductVersion){
			String message = "The target version("+newProduct.getVersion()+") is not equals to version("+newProductVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(newProduct){ 
			//will be good when the newProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to NewProduct.
			
			newProduct.changeProperty(property, newValueExpr);
			newProduct.updateLastUpdateTime(userContext.now());
			newProduct = saveNewProduct(userContext, newProduct, tokens().done());
			return present(userContext,newProduct, mergedAllTokens(tokensExpr));
			//return saveNewProduct(userContext, newProduct, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected NewProductTokens tokens(){
		return NewProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return NewProductTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return NewProductTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(PimUserContext userContext, String newProductId, String anotherParentCategoryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfNewProduct(newProductId);
 		userContext.getChecker().checkIdOfLevelNCategory(anotherParentCategoryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(NewProductManagerException.class);
 		
 	}
 	public NewProduct transferToAnotherParentCategory(PimUserContext userContext, String newProductId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, newProductId,anotherParentCategoryId);
 
		NewProduct newProduct = loadNewProduct(userContext, newProductId, allTokens());	
		synchronized(newProduct){
			//will be good when the newProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelNCategory parentCategory = loadLevelNCategory(userContext, anotherParentCategoryId, emptyOptions());		
			newProduct.updateParentCategory(parentCategory);		
			newProduct = saveNewProduct(userContext, newProduct, emptyOptions());
			
			return present(userContext,newProduct, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLevelNCategory requestCandidateParentCategory(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelNCategory result = new CandidateLevelNCategory();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("parentCategory");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelNCategory> candidateList = userContext.getDAOGroup().getLevelNCategoryDAO().requestCandidateLevelNCategoryForNewProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherBrand(PimUserContext userContext, String newProductId, String anotherBrandId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfNewProduct(newProductId);
 		userContext.getChecker().checkIdOfBrand(anotherBrandId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(NewProductManagerException.class);
 		
 	}
 	public NewProduct transferToAnotherBrand(PimUserContext userContext, String newProductId, String anotherBrandId) throws Exception
 	{
 		checkParamsForTransferingAnotherBrand(userContext, newProductId,anotherBrandId);
 
		NewProduct newProduct = loadNewProduct(userContext, newProductId, allTokens());	
		synchronized(newProduct){
			//will be good when the newProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Brand brand = loadBrand(userContext, anotherBrandId, emptyOptions());		
			newProduct.updateBrand(brand);		
			newProduct = saveNewProduct(userContext, newProduct, emptyOptions());
			
			return present(userContext,newProduct, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateBrand requestCandidateBrand(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateBrand result = new CandidateBrand();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("brandName");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Brand> candidateList = userContext.getDAOGroup().getBrandDAO().requestCandidateBrandForNewProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherCatalog(PimUserContext userContext, String newProductId, String anotherCatalogId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfNewProduct(newProductId);
 		userContext.getChecker().checkIdOfCatalog(anotherCatalogId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(NewProductManagerException.class);
 		
 	}
 	public NewProduct transferToAnotherCatalog(PimUserContext userContext, String newProductId, String anotherCatalogId) throws Exception
 	{
 		checkParamsForTransferingAnotherCatalog(userContext, newProductId,anotherCatalogId);
 
		NewProduct newProduct = loadNewProduct(userContext, newProductId, allTokens());	
		synchronized(newProduct){
			//will be good when the newProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Catalog catalog = loadCatalog(userContext, anotherCatalogId, emptyOptions());		
			newProduct.updateCatalog(catalog);		
			newProduct = saveNewProduct(userContext, newProduct, emptyOptions());
			
			return present(userContext,newProduct, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateCatalog requestCandidateCatalog(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCatalog result = new CandidateCatalog();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Catalog> candidateList = userContext.getDAOGroup().getCatalogDAO().requestCandidateCatalogForNewProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherProfile(PimUserContext userContext, String newProductId, String anotherProfileId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfNewProduct(newProductId);
 		userContext.getChecker().checkIdOfProfile(anotherProfileId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(NewProductManagerException.class);
 		
 	}
 	public NewProduct transferToAnotherProfile(PimUserContext userContext, String newProductId, String anotherProfileId) throws Exception
 	{
 		checkParamsForTransferingAnotherProfile(userContext, newProductId,anotherProfileId);
 
		NewProduct newProduct = loadNewProduct(userContext, newProductId, allTokens());	
		synchronized(newProduct){
			//will be good when the newProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile profile = loadProfile(userContext, anotherProfileId, emptyOptions());		
			newProduct.updateProfile(profile);		
			newProduct = saveNewProduct(userContext, newProduct, emptyOptions());
			
			return present(userContext,newProduct, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProfile requestCandidateProfile(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProfile result = new CandidateProfile();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForNewProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(PimUserContext userContext, String newProductId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfNewProduct(newProductId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(NewProductManagerException.class);
 		
 	}
 	public NewProduct transferToAnotherPlatform(PimUserContext userContext, String newProductId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, newProductId,anotherPlatformId);
 
		NewProduct newProduct = loadNewProduct(userContext, newProductId, allTokens());	
		synchronized(newProduct){
			//will be good when the newProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			newProduct.updatePlatform(platform);		
			newProduct = saveNewProduct(userContext, newProduct, emptyOptions());
			
			return present(userContext,newProduct, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForNewProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Catalog loadCatalog(PimUserContext userContext, String newCatalogId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getCatalogDAO().load(newCatalogId, options);
 	}
 	
 	
 	
	
	 	
 	protected LevelNCategory loadLevelNCategory(PimUserContext userContext, String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLevelNCategoryDAO().load(newParentCategoryId, options);
 	}
 	
 	
 	
	
	 	
 	protected Profile loadProfile(PimUserContext userContext, String newProfileId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProfileDAO().load(newProfileId, options);
 	}
 	
 	
 	
	
	 	
 	protected Brand loadBrand(PimUserContext userContext, String newBrandId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getBrandDAO().load(newBrandId, options);
 	}
 	
 	
 	
	
	 	
 	protected Platform loadPlatform(PimUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(PimUserContext userContext, String newProductId, int newProductVersion) throws Exception {
		//deleteInternal(userContext, newProductId, newProductVersion);		
	}
	protected void deleteInternal(PimUserContext userContext,
			String newProductId, int newProductVersion) throws Exception{
			
		userContext.getDAOGroup().getNewProductDAO().delete(newProductId, newProductVersion);
	}
	
	public NewProduct forgetByAll(PimUserContext userContext, String newProductId, int newProductVersion) throws Exception {
		return forgetByAllInternal(userContext, newProductId, newProductVersion);		
	}
	protected NewProduct forgetByAllInternal(PimUserContext userContext,
			String newProductId, int newProductVersion) throws Exception{
			
		return userContext.getDAOGroup().getNewProductDAO().disconnectFromAll(newProductId, newProductVersion);
	}
	

	
	public int deleteAll(PimUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new NewProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(PimUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getNewProductDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(PimUserContext userContext, NewProduct newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


