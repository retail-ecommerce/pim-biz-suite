
package com.terapico.pim.brand;

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

import com.terapico.pim.product.Product;


import com.terapico.pim.levelncategory.LevelNCategory;
import com.terapico.pim.catalog.Catalog;
import com.terapico.pim.brand.Brand;






public class BrandManagerImpl extends CustomPimCheckerManager implements BrandManager {
	
	private static final String SERVICE_TYPE = "Brand";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws BrandManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new BrandManagerException(message);

	}
	
	

 	protected Brand saveBrand(PimUserContext userContext, Brand brand, String [] tokensExpr) throws Exception{	
 		//return getBrandDAO().save(brand, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveBrand(userContext, brand, tokens);
 	}
 	
 	protected Brand saveBrandDetail(PimUserContext userContext, Brand brand) throws Exception{	

 		
 		return saveBrand(userContext, brand, allTokens());
 	}
 	
 	public Brand loadBrand(PimUserContext userContext, String brandId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Brand brand = loadBrand( userContext, brandId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,brand, tokens);
 	}
 	
 	
 	 public Brand searchBrand(PimUserContext userContext, String brandId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Brand brand = loadBrand( userContext, brandId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,brand, tokens);
 	}
 	
 	

 	protected Brand present(PimUserContext userContext, Brand brand, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,brand,tokens);
		
		
		Brand  brandToPresent = userContext.getDAOGroup().getBrandDAO().present(brand, tokens);
		
		List<BaseEntity> entityListToNaming = brandToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getBrandDAO().alias(entityListToNaming);
		
		return  brandToPresent;
		
		
	}
 
 	
 	
 	public Brand loadBrandDetail(PimUserContext userContext, String brandId) throws Exception{	
 		Brand brand = loadBrand( userContext, brandId, allTokens());
 		return present(userContext,brand, allTokens());
		
 	}
 	
 	public Object view(PimUserContext userContext, String brandId) throws Exception{	
 		Brand brand = loadBrand( userContext, brandId, viewTokens());
 		return present(userContext,brand, allTokens());
		
 	}
 	protected Brand saveBrand(PimUserContext userContext, Brand brand, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getBrandDAO().save(brand, tokens);
 	}
 	protected Brand loadBrand(PimUserContext userContext, String brandId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandManagerException.class);

 
 		return userContext.getDAOGroup().getBrandDAO().load(brandId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(PimUserContext userContext, Brand brand, Map<String, Object> tokens){
		super.addActions(userContext, brand, tokens);
		
		addAction(userContext, brand, tokens,"@create","createBrand","createBrand/","main","primary");
		addAction(userContext, brand, tokens,"@update","updateBrand","updateBrand/"+brand.getId()+"/","main","primary");
		addAction(userContext, brand, tokens,"@copy","cloneBrand","cloneBrand/"+brand.getId()+"/","main","primary");
		
		addAction(userContext, brand, tokens,"brand.addProduct","addProduct","addProduct/"+brand.getId()+"/","productList","primary");
		addAction(userContext, brand, tokens,"brand.removeProduct","removeProduct","removeProduct/"+brand.getId()+"/","productList","primary");
		addAction(userContext, brand, tokens,"brand.updateProduct","updateProduct","updateProduct/"+brand.getId()+"/","productList","primary");
		addAction(userContext, brand, tokens,"brand.copyProductFrom","copyProductFrom","copyProductFrom/"+brand.getId()+"/","productList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(PimUserContext userContext, Brand brand, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Brand createBrand(PimUserContext userContext,String brandName, String logo, String remark) throws Exception
	{
		
		

		

		userContext.getChecker().checkBrandNameOfBrand(brandName);
		userContext.getChecker().checkLogoOfBrand(logo);
		userContext.getChecker().checkRemarkOfBrand(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);


		Brand brand=createNewBrand();	

		brand.setBrandName(brandName);
		brand.setLogo(logo);
		brand.setRemark(remark);

		brand = saveBrand(userContext, brand, emptyOptions());
		
		onNewInstanceCreated(userContext, brand);
		return brand;

		
	}
	protected Brand createNewBrand() 
	{
		
		return new Brand();		
	}
	
	protected void checkParamsForUpdatingBrand(PimUserContext userContext,String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkVersionOfBrand( brandVersion);
		

		if(Brand.BRAND_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkBrandNameOfBrand(parseString(newValueExpr));
		}
		if(Brand.LOGO_PROPERTY.equals(property)){
			userContext.getChecker().checkLogoOfBrand(parseString(newValueExpr));
		}
		if(Brand.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfBrand(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
		
	}
	
	
	
	public Brand clone(PimUserContext userContext, String fromBrandId) throws Exception{
		
		return userContext.getDAOGroup().getBrandDAO().clone(fromBrandId, this.allTokens());
	}
	
	public Brand internalSaveBrand(PimUserContext userContext, Brand brand) throws Exception 
	{
		return internalSaveBrand(userContext, brand, allTokens());

	}
	public Brand internalSaveBrand(PimUserContext userContext, Brand brand, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingBrand(userContext, brandId, brandVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(brand){ 
			//will be good when the brand loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Brand.
			
			
			brand = saveBrand(userContext, brand, options);
			return brand;
			
		}

	}
	
	public Brand updateBrand(PimUserContext userContext,String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBrand(userContext, brandId, brandVersion, property, newValueExpr, tokensExpr);
		
		
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		if(brand.getVersion() != brandVersion){
			String message = "The target version("+brand.getVersion()+") is not equals to version("+brandVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(brand){ 
			//will be good when the brand loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Brand.
			
			brand.changeProperty(property, newValueExpr);
			brand = saveBrand(userContext, brand, tokens().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
			//return saveBrand(userContext, brand, tokens().done());
		}

	}
	
	public Brand updateBrandProperty(PimUserContext userContext,String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBrand(userContext, brandId, brandVersion, property, newValueExpr, tokensExpr);
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		if(brand.getVersion() != brandVersion){
			String message = "The target version("+brand.getVersion()+") is not equals to version("+brandVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(brand){ 
			//will be good when the brand loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Brand.
			
			brand.changeProperty(property, newValueExpr);
			
			brand = saveBrand(userContext, brand, tokens().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
			//return saveBrand(userContext, brand, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected BrandTokens tokens(){
		return BrandTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return BrandTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProductListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return BrandTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(PimUserContext userContext, String brandId, int brandVersion) throws Exception {
		//deleteInternal(userContext, brandId, brandVersion);		
	}
	protected void deleteInternal(PimUserContext userContext,
			String brandId, int brandVersion) throws Exception{
			
		userContext.getDAOGroup().getBrandDAO().delete(brandId, brandVersion);
	}
	
	public Brand forgetByAll(PimUserContext userContext, String brandId, int brandVersion) throws Exception {
		return forgetByAllInternal(userContext, brandId, brandVersion);		
	}
	protected Brand forgetByAllInternal(PimUserContext userContext,
			String brandId, int brandVersion) throws Exception{
			
		return userContext.getDAOGroup().getBrandDAO().disconnectFromAll(brandId, brandVersion);
	}
	

	
	public int deleteAll(PimUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new BrandManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(PimUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getBrandDAO().deleteAll();
	}


	//disconnect Brand with parent_category in Product
	protected Brand breakWithProductByParentCategory(PimUserContext userContext, String brandId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveProductListWithParentCategory(brand, parentCategoryId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withProductList().done());
				return brand;
			}
	}
	//disconnect Brand with catalog in Product
	protected Brand breakWithProductByCatalog(PimUserContext userContext, String brandId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveProductListWithCatalog(brand, catalogId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withProductList().done());
				return brand;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingProduct(PimUserContext userContext, String brandId, String name, String parentCategoryId, String origin, String catalogId, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfBrand(brandId);

		
		userContext.getChecker().checkNameOfProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfProduct(parentCategoryId);
		
		userContext.getChecker().checkOriginOfProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfProduct(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);

	
	}
	public  Brand addProduct(PimUserContext userContext, String brandId, String name, String parentCategoryId, String origin, String catalogId, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProduct(userContext,brandId,name, parentCategoryId, origin, catalogId, remark,tokensExpr);
		
		Product product = createProduct(userContext,name, parentCategoryId, origin, catalogId, remark);
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.addProduct( product );		
			brand = saveBrand(userContext, brand, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, product);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductProperties(PimUserContext userContext, String brandId,String id,String name,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfProduct(id);
		
		userContext.getChecker().checkNameOfProduct( name);
		userContext.getChecker().checkOriginOfProduct( origin);
		userContext.getChecker().checkRemarkOfProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand updateProductProperties(PimUserContext userContext, String brandId, String id,String name,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductProperties(userContext,brandId,id,name,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductListList()
				.searchProductListWith(Product.ID_PROPERTY, "is", id).done();
		
		Brand brandToUpdate = loadBrand(userContext, brandId, options);
		
		if(brandToUpdate.getProductList().isEmpty()){
			throw new BrandManagerException("Product is NOT FOUND with id: '"+id+"'");
		}
		
		Product item = brandToUpdate.getProductList().first();
		
		item.updateName( name );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingProduct(userContext,brandId,name, code, used,tokensExpr);
		Brand brand = saveBrand(userContext, brandToUpdate, tokens().withProductList().done());
		synchronized(brand){ 
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Product createProduct(PimUserContext userContext, String name, String parentCategoryId, String origin, String catalogId, String remark) throws Exception{

		Product product = new Product();
		
		
		product.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		product.setParentCategory(parentCategory);		
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
	
	protected void checkParamsForRemovingProductList(PimUserContext userContext, String brandId, 
			String productIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		for(String productId: productIds){
			userContext.getChecker().checkIdOfProduct(productId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand removeProductList(PimUserContext userContext, String brandId, 
			String productIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProductList(userContext, brandId,  productIds, tokensExpr);
			
			
			Brand brand = loadBrand(userContext, brandId, allTokens());
			synchronized(brand){ 
				//Will be good when the brand loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getBrandDAO().planToRemoveProductList(brand, productIds, allTokens());
				brand = saveBrand(userContext, brand, tokens().withProductList().done());
				deleteRelationListInGraph(userContext, brand.getProductList());
				return present(userContext,brand, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProduct(PimUserContext userContext, String brandId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand removeProduct(PimUserContext userContext, String brandId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProduct(userContext,brandId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.removeProduct( product );		
			brand = saveBrand(userContext, brand, tokens().withProductList().done());
			deleteRelationInGraph(userContext, product);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProduct(PimUserContext userContext, String brandId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand copyProductFrom(PimUserContext userContext, String brandId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProduct(userContext,brandId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			product.updateLastUpdateTime(userContext.now());
			
			brand.copyProductFrom( product );		
			brand = saveBrand(userContext, brand, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, (Product)brand.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProduct(PimUserContext userContext, String brandId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfBrand(brandId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	
	public  Brand updateProduct(PimUserContext userContext, String brandId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProduct(userContext, brandId, productId, productVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProductList().searchProductListWith(Product.ID_PROPERTY, "eq", productId).done();
		
		
		
		Brand brand = loadBrand(userContext, brandId, loadTokens);
		
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//brand.removeProduct( product );	
			//make changes to AcceleraterAccount.
			Product productIndex = createIndexedProduct(productId, productVersion);
		
			Product product = brand.findTheProduct(productIndex);
			if(product == null){
				throw new BrandManagerException(product+" is NOT FOUND" );
			}
			
			product.changeProperty(property, newValueExpr);
			product.updateLastUpdateTime(userContext.now());
			brand = saveBrand(userContext, brand, tokens().withProductList().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(PimUserContext userContext, Brand newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


