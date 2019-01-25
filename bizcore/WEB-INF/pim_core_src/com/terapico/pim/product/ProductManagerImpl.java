
package com.terapico.pim.product;

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
import com.terapico.pim.sku.Sku;
import com.terapico.pim.catalog.Catalog;
import com.terapico.pim.brand.Brand;
import com.terapico.pim.platform.Platform;

import com.terapico.pim.levelncategory.CandidateLevelNCategory;
import com.terapico.pim.catalog.CandidateCatalog;
import com.terapico.pim.brand.CandidateBrand;
import com.terapico.pim.platform.CandidatePlatform;

import com.terapico.pim.product.Product;






public class ProductManagerImpl extends CustomPimCheckerManager implements ProductManager {
	
	private static final String SERVICE_TYPE = "Product";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProductManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProductManagerException(message);

	}
	
	

 	protected Product saveProduct(PimUserContext userContext, Product product, String [] tokensExpr) throws Exception{	
 		//return getProductDAO().save(product, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProduct(userContext, product, tokens);
 	}
 	
 	protected Product saveProductDetail(PimUserContext userContext, Product product) throws Exception{	

 		
 		return saveProduct(userContext, product, allTokens());
 	}
 	
 	public Product loadProduct(PimUserContext userContext, String productId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Product product = loadProduct( userContext, productId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,product, tokens);
 	}
 	
 	
 	 public Product searchProduct(PimUserContext userContext, String productId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Product product = loadProduct( userContext, productId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,product, tokens);
 	}
 	
 	

 	protected Product present(PimUserContext userContext, Product product, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,product,tokens);
		
		
		Product  productToPresent = userContext.getDAOGroup().getProductDAO().present(product, tokens);
		
		List<BaseEntity> entityListToNaming = productToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProductDAO().alias(entityListToNaming);
		
		return  productToPresent;
		
		
	}
 
 	
 	
 	public Product loadProductDetail(PimUserContext userContext, String productId) throws Exception{	
 		Product product = loadProduct( userContext, productId, allTokens());
 		return present(userContext,product, allTokens());
		
 	}
 	
 	public Object view(PimUserContext userContext, String productId) throws Exception{	
 		Product product = loadProduct( userContext, productId, viewTokens());
 		return present(userContext,product, allTokens());
		
 	}
 	protected Product saveProduct(PimUserContext userContext, Product product, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProductDAO().save(product, tokens);
 	}
 	protected Product loadProduct(PimUserContext userContext, String productId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductManagerException.class);

 
 		return userContext.getDAOGroup().getProductDAO().load(productId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(PimUserContext userContext, Product product, Map<String, Object> tokens){
		super.addActions(userContext, product, tokens);
		
		addAction(userContext, product, tokens,"@create","createProduct","createProduct/","main","primary");
		addAction(userContext, product, tokens,"@update","updateProduct","updateProduct/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"@copy","cloneProduct","cloneProduct/"+product.getId()+"/","main","primary");
		
		addAction(userContext, product, tokens,"product.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"product.transfer_to_brand","transferToAnotherBrand","transferToAnotherBrand/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"product.transfer_to_catalog","transferToAnotherCatalog","transferToAnotherCatalog/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"product.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"product.addSku","addSku","addSku/"+product.getId()+"/","skuList","primary");
		addAction(userContext, product, tokens,"product.removeSku","removeSku","removeSku/"+product.getId()+"/","skuList","primary");
		addAction(userContext, product, tokens,"product.updateSku","updateSku","updateSku/"+product.getId()+"/","skuList","primary");
		addAction(userContext, product, tokens,"product.copySkuFrom","copySkuFrom","copySkuFrom/"+product.getId()+"/","skuList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(PimUserContext userContext, Product product, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Product createProduct(PimUserContext userContext,String name, String parentCategoryId, String brandId, String origin, String catalogId, String remark, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfProduct(name);
		userContext.getChecker().checkOriginOfProduct(origin);
		userContext.getChecker().checkRemarkOfProduct(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);


		Product product=createNewProduct();	

		product.setName(name);
			
		LevelNCategory parentCategory = loadLevelNCategory(userContext, parentCategoryId,emptyOptions());
		product.setParentCategory(parentCategory);
		
		
			
		Brand brand = loadBrand(userContext, brandId,emptyOptions());
		product.setBrand(brand);
		
		
		product.setOrigin(origin);
			
		Catalog catalog = loadCatalog(userContext, catalogId,emptyOptions());
		product.setCatalog(catalog);
		
		
		product.setRemark(remark);
		product.setLastUpdateTime(userContext.now());
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		product.setPlatform(platform);
		
		

		product = saveProduct(userContext, product, emptyOptions());
		
		onNewInstanceCreated(userContext, product);
		return product;

		
	}
	protected Product createNewProduct() 
	{
		
		return new Product();		
	}
	
	protected void checkParamsForUpdatingProduct(PimUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct( productVersion);
		

		if(Product.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProduct(parseString(newValueExpr));
		}		

				

		
		if(Product.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfProduct(parseString(newValueExpr));
		}		

		
		if(Product.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfProduct(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
		
	}
	
	
	
	public Product clone(PimUserContext userContext, String fromProductId) throws Exception{
		
		return userContext.getDAOGroup().getProductDAO().clone(fromProductId, this.allTokens());
	}
	
	public Product internalSaveProduct(PimUserContext userContext, Product product) throws Exception 
	{
		return internalSaveProduct(userContext, product, allTokens());

	}
	public Product internalSaveProduct(PimUserContext userContext, Product product, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(product){ 
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			
			
			product = saveProduct(userContext, product, options);
			return product;
			
		}

	}
	
	public Product updateProduct(PimUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		
		
		Product product = loadProduct(userContext, productId, allTokens());
		if(product.getVersion() != productVersion){
			String message = "The target version("+product.getVersion()+") is not equals to version("+productVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(product){ 
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			product.updateLastUpdateTime(userContext.now());
			product.changeProperty(property, newValueExpr);
			product = saveProduct(userContext, product, tokens().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
			//return saveProduct(userContext, product, tokens().done());
		}

	}
	
	public Product updateProductProperty(PimUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		Product product = loadProduct(userContext, productId, allTokens());
		if(product.getVersion() != productVersion){
			String message = "The target version("+product.getVersion()+") is not equals to version("+productVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(product){ 
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			
			product.changeProperty(property, newValueExpr);
			product.updateLastUpdateTime(userContext.now());
			product = saveProduct(userContext, product, tokens().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
			//return saveProduct(userContext, product, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProductTokens tokens(){
		return ProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProductTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortSkuListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProductTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(PimUserContext userContext, String productId, String anotherParentCategoryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProduct(productId);
 		userContext.getChecker().checkIdOfLevelNCategory(anotherParentCategoryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
 		
 	}
 	public Product transferToAnotherParentCategory(PimUserContext userContext, String productId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, productId,anotherParentCategoryId);
 
		Product product = loadProduct(userContext, productId, allTokens());	
		synchronized(product){
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelNCategory parentCategory = loadLevelNCategory(userContext, anotherParentCategoryId, emptyOptions());		
			product.updateParentCategory(parentCategory);		
			product = saveProduct(userContext, product, emptyOptions());
			
			return present(userContext,product, allTokens());
			
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
		SmartList<LevelNCategory> candidateList = userContext.getDAOGroup().getLevelNCategoryDAO().requestCandidateLevelNCategoryForProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherBrand(PimUserContext userContext, String productId, String anotherBrandId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProduct(productId);
 		userContext.getChecker().checkIdOfBrand(anotherBrandId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
 		
 	}
 	public Product transferToAnotherBrand(PimUserContext userContext, String productId, String anotherBrandId) throws Exception
 	{
 		checkParamsForTransferingAnotherBrand(userContext, productId,anotherBrandId);
 
		Product product = loadProduct(userContext, productId, allTokens());	
		synchronized(product){
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Brand brand = loadBrand(userContext, anotherBrandId, emptyOptions());		
			product.updateBrand(brand);		
			product = saveProduct(userContext, product, emptyOptions());
			
			return present(userContext,product, allTokens());
			
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
		SmartList<Brand> candidateList = userContext.getDAOGroup().getBrandDAO().requestCandidateBrandForProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherCatalog(PimUserContext userContext, String productId, String anotherCatalogId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProduct(productId);
 		userContext.getChecker().checkIdOfCatalog(anotherCatalogId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
 		
 	}
 	public Product transferToAnotherCatalog(PimUserContext userContext, String productId, String anotherCatalogId) throws Exception
 	{
 		checkParamsForTransferingAnotherCatalog(userContext, productId,anotherCatalogId);
 
		Product product = loadProduct(userContext, productId, allTokens());	
		synchronized(product){
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Catalog catalog = loadCatalog(userContext, anotherCatalogId, emptyOptions());		
			product.updateCatalog(catalog);		
			product = saveProduct(userContext, product, emptyOptions());
			
			return present(userContext,product, allTokens());
			
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
		SmartList<Catalog> candidateList = userContext.getDAOGroup().getCatalogDAO().requestCandidateCatalogForProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(PimUserContext userContext, String productId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProduct(productId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
 		
 	}
 	public Product transferToAnotherPlatform(PimUserContext userContext, String productId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, productId,anotherPlatformId);
 
		Product product = loadProduct(userContext, productId, allTokens());	
		synchronized(product){
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			product.updatePlatform(platform);		
			product = saveProduct(userContext, product, emptyOptions());
			
			return present(userContext,product, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	 	
 	protected Brand loadBrand(PimUserContext userContext, String newBrandId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getBrandDAO().load(newBrandId, options);
 	}
 	
 	
 	
	
	 	
 	protected Platform loadPlatform(PimUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(PimUserContext userContext, String productId, int productVersion) throws Exception {
		//deleteInternal(userContext, productId, productVersion);		
	}
	protected void deleteInternal(PimUserContext userContext,
			String productId, int productVersion) throws Exception{
			
		userContext.getDAOGroup().getProductDAO().delete(productId, productVersion);
	}
	
	public Product forgetByAll(PimUserContext userContext, String productId, int productVersion) throws Exception {
		return forgetByAllInternal(userContext, productId, productVersion);		
	}
	protected Product forgetByAllInternal(PimUserContext userContext,
			String productId, int productVersion) throws Exception{
			
		return userContext.getDAOGroup().getProductDAO().disconnectFromAll(productId, productVersion);
	}
	

	
	public int deleteAll(PimUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(PimUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProductDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingSku(PimUserContext userContext, String productId, String name, String size, boolean active, BigDecimal basePrice,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProduct(productId);

		
		userContext.getChecker().checkNameOfSku(name);
		
		userContext.getChecker().checkSizeOfSku(size);
		
		userContext.getChecker().checkActiveOfSku(active);
		
		userContext.getChecker().checkBasePriceOfSku(basePrice);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);

	
	}
	public  Product addSku(PimUserContext userContext, String productId, String name, String size, boolean active, BigDecimal basePrice, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSku(userContext,productId,name, size, active, basePrice,tokensExpr);
		
		Sku sku = createSku(userContext,name, size, active, basePrice);
		
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.addSku( sku );		
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			
			userContext.getManagerGroup().getSkuManager().onNewInstanceCreated(userContext, sku);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSkuProperties(PimUserContext userContext, String productId,String id,String name,String size,boolean active,BigDecimal basePrice,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfSku(id);
		
		userContext.getChecker().checkNameOfSku( name);
		userContext.getChecker().checkSizeOfSku( size);
		userContext.getChecker().checkActiveOfSku( active);
		userContext.getChecker().checkBasePriceOfSku( basePrice);

		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product updateSkuProperties(PimUserContext userContext, String productId, String id,String name,String size,boolean active,BigDecimal basePrice, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSkuProperties(userContext,productId,id,name,size,active,basePrice,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSkuListList()
				.searchSkuListWith(Sku.ID_PROPERTY, "is", id).done();
		
		Product productToUpdate = loadProduct(userContext, productId, options);
		
		if(productToUpdate.getSkuList().isEmpty()){
			throw new ProductManagerException("Sku is NOT FOUND with id: '"+id+"'");
		}
		
		Sku item = productToUpdate.getSkuList().first();
		
		item.updateName( name );
		item.updateSize( size );
		item.updateActive( active );
		item.updateBasePrice( basePrice );

		
		//checkParamsForAddingSku(userContext,productId,name, code, used,tokensExpr);
		Product product = saveProduct(userContext, productToUpdate, tokens().withSkuList().done());
		synchronized(product){ 
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Sku createSku(PimUserContext userContext, String name, String size, boolean active, BigDecimal basePrice) throws Exception{

		Sku sku = new Sku();
		
		
		sku.setName(name);		
		sku.setSize(size);		
		sku.setActive(active);		
		sku.setBasePrice(basePrice);		
		sku.setLastUpdateTime(userContext.now());
	
		
		return sku;
	
		
	}
	
	protected Sku createIndexedSku(String id, int version){

		Sku sku = new Sku();
		sku.setId(id);
		sku.setVersion(version);
		return sku;			
		
	}
	
	protected void checkParamsForRemovingSkuList(PimUserContext userContext, String productId, 
			String skuIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		for(String skuId: skuIds){
			userContext.getChecker().checkIdOfSku(skuId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product removeSkuList(PimUserContext userContext, String productId, 
			String skuIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSkuList(userContext, productId,  skuIds, tokensExpr);
			
			
			Product product = loadProduct(userContext, productId, allTokens());
			synchronized(product){ 
				//Will be good when the product loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProductDAO().planToRemoveSkuList(product, skuIds, allTokens());
				product = saveProduct(userContext, product, tokens().withSkuList().done());
				deleteRelationListInGraph(userContext, product.getSkuList());
				return present(userContext,product, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSku(PimUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkVersionOfSku(skuVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product removeSku(PimUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSku(userContext,productId, skuId, skuVersion,tokensExpr);
		
		Sku sku = createIndexedSku(skuId, skuVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.removeSku( sku );		
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			deleteRelationInGraph(userContext, sku);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSku(PimUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkVersionOfSku(skuVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product copySkuFrom(PimUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSku(userContext,productId, skuId, skuVersion,tokensExpr);
		
		Sku sku = createIndexedSku(skuId, skuVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			sku.updateLastUpdateTime(userContext.now());
			
			product.copySkuFrom( sku );		
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			
			userContext.getManagerGroup().getSkuManager().onNewInstanceCreated(userContext, (Sku)product.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSku(PimUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkVersionOfSku(skuVersion);
		

		if(Sku.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfSku(parseString(newValueExpr));
		}
		
		if(Sku.SIZE_PROPERTY.equals(property)){
			userContext.getChecker().checkSizeOfSku(parseString(newValueExpr));
		}
		
		if(Sku.ACTIVE_PROPERTY.equals(property)){
			userContext.getChecker().checkActiveOfSku(parseBoolean(newValueExpr));
		}
		
		if(Sku.BASE_PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkBasePriceOfSku(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	
	public  Product updateSku(PimUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSku(userContext, productId, skuId, skuVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSkuList().searchSkuListWith(Sku.ID_PROPERTY, "eq", skuId).done();
		
		
		
		Product product = loadProduct(userContext, productId, loadTokens);
		
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//product.removeSku( sku );	
			//make changes to AcceleraterAccount.
			Sku skuIndex = createIndexedSku(skuId, skuVersion);
		
			Sku sku = product.findTheSku(skuIndex);
			if(sku == null){
				throw new ProductManagerException(sku+" is NOT FOUND" );
			}
			
			sku.changeProperty(property, newValueExpr);
			sku.updateLastUpdateTime(userContext.now());
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(PimUserContext userContext, Product newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


