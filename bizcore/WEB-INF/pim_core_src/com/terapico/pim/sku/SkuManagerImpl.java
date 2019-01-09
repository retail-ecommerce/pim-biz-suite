
package com.terapico.pim.sku;

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

import com.terapico.pim.product.CandidateProduct;







public class SkuManagerImpl extends CustomPimCheckerManager implements SkuManager {
	
	private static final String SERVICE_TYPE = "Sku";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SkuManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SkuManagerException(message);

	}
	
	

 	protected Sku saveSku(PimUserContext userContext, Sku sku, String [] tokensExpr) throws Exception{	
 		//return getSkuDAO().save(sku, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSku(userContext, sku, tokens);
 	}
 	
 	protected Sku saveSkuDetail(PimUserContext userContext, Sku sku) throws Exception{	

 		
 		return saveSku(userContext, sku, allTokens());
 	}
 	
 	public Sku loadSku(PimUserContext userContext, String skuId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().throwExceptionIfHasErrors( SkuManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Sku sku = loadSku( userContext, skuId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,sku, tokens);
 	}
 	
 	
 	 public Sku searchSku(PimUserContext userContext, String skuId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().throwExceptionIfHasErrors( SkuManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Sku sku = loadSku( userContext, skuId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,sku, tokens);
 	}
 	
 	

 	protected Sku present(PimUserContext userContext, Sku sku, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,sku,tokens);
		
		
		Sku  skuToPresent = userContext.getDAOGroup().getSkuDAO().present(sku, tokens);
		
		List<BaseEntity> entityListToNaming = skuToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSkuDAO().alias(entityListToNaming);
		
		return  skuToPresent;
		
		
	}
 
 	
 	
 	public Sku loadSkuDetail(PimUserContext userContext, String skuId) throws Exception{	
 		Sku sku = loadSku( userContext, skuId, allTokens());
 		return present(userContext,sku, allTokens());
		
 	}
 	
 	public Object view(PimUserContext userContext, String skuId) throws Exception{	
 		Sku sku = loadSku( userContext, skuId, viewTokens());
 		return present(userContext,sku, allTokens());
		
 	}
 	protected Sku saveSku(PimUserContext userContext, Sku sku, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSkuDAO().save(sku, tokens);
 	}
 	protected Sku loadSku(PimUserContext userContext, String skuId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().throwExceptionIfHasErrors( SkuManagerException.class);

 
 		return userContext.getDAOGroup().getSkuDAO().load(skuId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(PimUserContext userContext, Sku sku, Map<String, Object> tokens){
		super.addActions(userContext, sku, tokens);
		
		addAction(userContext, sku, tokens,"@create","createSku","createSku/","main","primary");
		addAction(userContext, sku, tokens,"@update","updateSku","updateSku/"+sku.getId()+"/","main","primary");
		addAction(userContext, sku, tokens,"@copy","cloneSku","cloneSku/"+sku.getId()+"/","main","primary");
		
		addAction(userContext, sku, tokens,"sku.transfer_to_product","transferToAnotherProduct","transferToAnotherProduct/"+sku.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(PimUserContext userContext, Sku sku, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Sku createSku(PimUserContext userContext,String name, String size, String productId, boolean active, BigDecimal basePrice) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfSku(name);
		userContext.getChecker().checkSizeOfSku(size);
		userContext.getChecker().checkActiveOfSku(active);
		userContext.getChecker().checkBasePriceOfSku(basePrice);
	
		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);


		Sku sku=createNewSku();	

		sku.setName(name);
		sku.setSize(size);
			
		Product product = loadProduct(userContext, productId,emptyOptions());
		sku.setProduct(product);
		
		
		sku.setActive(active);
		sku.setBasePrice(basePrice);
		sku.setLastUpdateTime(userContext.now());

		sku = saveSku(userContext, sku, emptyOptions());
		
		onNewInstanceCreated(userContext, sku);
		return sku;

		
	}
	protected Sku createNewSku() 
	{
		
		return new Sku();		
	}
	
	protected void checkParamsForUpdatingSku(PimUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkVersionOfSku( skuVersion);
		

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
	
		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);
	
		
	}
	
	
	
	public Sku clone(PimUserContext userContext, String fromSkuId) throws Exception{
		
		return userContext.getDAOGroup().getSkuDAO().clone(fromSkuId, this.allTokens());
	}
	
	public Sku internalSaveSku(PimUserContext userContext, Sku sku) throws Exception 
	{
		return internalSaveSku(userContext, sku, allTokens());

	}
	public Sku internalSaveSku(PimUserContext userContext, Sku sku, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(sku){ 
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.
			
			
			sku = saveSku(userContext, sku, options);
			return sku;
			
		}

	}
	
	public Sku updateSku(PimUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);
		
		
		
		Sku sku = loadSku(userContext, skuId, allTokens());
		if(sku.getVersion() != skuVersion){
			String message = "The target version("+sku.getVersion()+") is not equals to version("+skuVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(sku){ 
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.
			sku.updateLastUpdateTime(userContext.now());
			sku.changeProperty(property, newValueExpr);
			sku = saveSku(userContext, sku, tokens().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
			//return saveSku(userContext, sku, tokens().done());
		}

	}
	
	public Sku updateSkuProperty(PimUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);
		
		Sku sku = loadSku(userContext, skuId, allTokens());
		if(sku.getVersion() != skuVersion){
			String message = "The target version("+sku.getVersion()+") is not equals to version("+skuVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(sku){ 
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.
			
			sku.changeProperty(property, newValueExpr);
			sku.updateLastUpdateTime(userContext.now());
			sku = saveSku(userContext, sku, tokens().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
			//return saveSku(userContext, sku, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SkuTokens tokens(){
		return SkuTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SkuTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SkuTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProduct(PimUserContext userContext, String skuId, String anotherProductId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSku(skuId);
 		userContext.getChecker().checkIdOfProduct(anotherProductId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);
 		
 	}
 	public Sku transferToAnotherProduct(PimUserContext userContext, String skuId, String anotherProductId) throws Exception
 	{
 		checkParamsForTransferingAnotherProduct(userContext, skuId,anotherProductId);
 
		Sku sku = loadSku(userContext, skuId, allTokens());	
		synchronized(sku){
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Product product = loadProduct(userContext, anotherProductId, emptyOptions());		
			sku.updateProduct(product);		
			sku = saveSku(userContext, sku, emptyOptions());
			
			return present(userContext,sku, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProduct requestCandidateProduct(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProduct result = new CandidateProduct();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Product> candidateList = userContext.getDAOGroup().getProductDAO().requestCandidateProductForSku(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Product loadProduct(PimUserContext userContext, String newProductId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProductDAO().load(newProductId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(PimUserContext userContext, String skuId, int skuVersion) throws Exception {
		//deleteInternal(userContext, skuId, skuVersion);		
	}
	protected void deleteInternal(PimUserContext userContext,
			String skuId, int skuVersion) throws Exception{
			
		userContext.getDAOGroup().getSkuDAO().delete(skuId, skuVersion);
	}
	
	public Sku forgetByAll(PimUserContext userContext, String skuId, int skuVersion) throws Exception {
		return forgetByAllInternal(userContext, skuId, skuVersion);		
	}
	protected Sku forgetByAllInternal(PimUserContext userContext,
			String skuId, int skuVersion) throws Exception{
			
		return userContext.getDAOGroup().getSkuDAO().disconnectFromAll(skuId, skuVersion);
	}
	

	
	public int deleteAll(PimUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SkuManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(PimUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSkuDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(PimUserContext userContext, Sku newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


