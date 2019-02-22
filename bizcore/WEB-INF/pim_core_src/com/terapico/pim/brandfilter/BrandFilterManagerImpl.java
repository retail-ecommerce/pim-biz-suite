
package com.terapico.pim.brandfilter;

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

import com.terapico.pim.profile.Profile;

import com.terapico.pim.profile.CandidateProfile;







public class BrandFilterManagerImpl extends CustomPimCheckerManager implements BrandFilterManager {
	
	private static final String SERVICE_TYPE = "BrandFilter";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws BrandFilterManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new BrandFilterManagerException(message);

	}
	
	

 	protected BrandFilter saveBrandFilter(PimUserContext userContext, BrandFilter brandFilter, String [] tokensExpr) throws Exception{	
 		//return getBrandFilterDAO().save(brandFilter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveBrandFilter(userContext, brandFilter, tokens);
 	}
 	
 	protected BrandFilter saveBrandFilterDetail(PimUserContext userContext, BrandFilter brandFilter) throws Exception{	

 		
 		return saveBrandFilter(userContext, brandFilter, allTokens());
 	}
 	
 	public BrandFilter loadBrandFilter(PimUserContext userContext, String brandFilterId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandFilterManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		BrandFilter brandFilter = loadBrandFilter( userContext, brandFilterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,brandFilter, tokens);
 	}
 	
 	
 	 public BrandFilter searchBrandFilter(PimUserContext userContext, String brandFilterId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandFilterManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		BrandFilter brandFilter = loadBrandFilter( userContext, brandFilterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,brandFilter, tokens);
 	}
 	
 	

 	protected BrandFilter present(PimUserContext userContext, BrandFilter brandFilter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,brandFilter,tokens);
		
		
		BrandFilter  brandFilterToPresent = userContext.getDAOGroup().getBrandFilterDAO().present(brandFilter, tokens);
		
		List<BaseEntity> entityListToNaming = brandFilterToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getBrandFilterDAO().alias(entityListToNaming);
		
		return  brandFilterToPresent;
		
		
	}
 
 	
 	
 	public BrandFilter loadBrandFilterDetail(PimUserContext userContext, String brandFilterId) throws Exception{	
 		BrandFilter brandFilter = loadBrandFilter( userContext, brandFilterId, allTokens());
 		return present(userContext,brandFilter, allTokens());
		
 	}
 	
 	public Object view(PimUserContext userContext, String brandFilterId) throws Exception{	
 		BrandFilter brandFilter = loadBrandFilter( userContext, brandFilterId, viewTokens());
 		return present(userContext,brandFilter, allTokens());
		
 	}
 	protected BrandFilter saveBrandFilter(PimUserContext userContext, BrandFilter brandFilter, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getBrandFilterDAO().save(brandFilter, tokens);
 	}
 	protected BrandFilter loadBrandFilter(PimUserContext userContext, String brandFilterId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandFilterManagerException.class);

 
 		return userContext.getDAOGroup().getBrandFilterDAO().load(brandFilterId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(PimUserContext userContext, BrandFilter brandFilter, Map<String, Object> tokens){
		super.addActions(userContext, brandFilter, tokens);
		
		addAction(userContext, brandFilter, tokens,"@create","createBrandFilter","createBrandFilter/","main","primary");
		addAction(userContext, brandFilter, tokens,"@update","updateBrandFilter","updateBrandFilter/"+brandFilter.getId()+"/","main","primary");
		addAction(userContext, brandFilter, tokens,"@copy","cloneBrandFilter","cloneBrandFilter/"+brandFilter.getId()+"/","main","primary");
		
		addAction(userContext, brandFilter, tokens,"brand_filter.transfer_to_profile","transferToAnotherProfile","transferToAnotherProfile/"+brandFilter.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(PimUserContext userContext, BrandFilter brandFilter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public BrandFilter createBrandFilter(PimUserContext userContext,String name, String internalId, String profileId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfBrandFilter(name);
		userContext.getChecker().checkInternalIdOfBrandFilter(internalId);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandFilterManagerException.class);


		BrandFilter brandFilter=createNewBrandFilter();	

		brandFilter.setName(name);
		brandFilter.setInternalId(internalId);
			
		Profile profile = loadProfile(userContext, profileId,emptyOptions());
		brandFilter.setProfile(profile);
		
		

		brandFilter = saveBrandFilter(userContext, brandFilter, emptyOptions());
		
		onNewInstanceCreated(userContext, brandFilter);
		return brandFilter;

		
	}
	protected BrandFilter createNewBrandFilter() 
	{
		
		return new BrandFilter();		
	}
	
	protected void checkParamsForUpdatingBrandFilter(PimUserContext userContext,String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().checkVersionOfBrandFilter( brandFilterVersion);
		

		if(BrandFilter.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfBrandFilter(parseString(newValueExpr));
		}
		if(BrandFilter.INTERNAL_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkInternalIdOfBrandFilter(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandFilterManagerException.class);
	
		
	}
	
	
	
	public BrandFilter clone(PimUserContext userContext, String fromBrandFilterId) throws Exception{
		
		return userContext.getDAOGroup().getBrandFilterDAO().clone(fromBrandFilterId, this.allTokens());
	}
	
	public BrandFilter internalSaveBrandFilter(PimUserContext userContext, BrandFilter brandFilter) throws Exception 
	{
		return internalSaveBrandFilter(userContext, brandFilter, allTokens());

	}
	public BrandFilter internalSaveBrandFilter(PimUserContext userContext, BrandFilter brandFilter, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingBrandFilter(userContext, brandFilterId, brandFilterVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(brandFilter){ 
			//will be good when the brandFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to BrandFilter.
			
			
			brandFilter = saveBrandFilter(userContext, brandFilter, options);
			return brandFilter;
			
		}

	}
	
	public BrandFilter updateBrandFilter(PimUserContext userContext,String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBrandFilter(userContext, brandFilterId, brandFilterVersion, property, newValueExpr, tokensExpr);
		
		
		
		BrandFilter brandFilter = loadBrandFilter(userContext, brandFilterId, allTokens());
		if(brandFilter.getVersion() != brandFilterVersion){
			String message = "The target version("+brandFilter.getVersion()+") is not equals to version("+brandFilterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(brandFilter){ 
			//will be good when the brandFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to BrandFilter.
			
			brandFilter.changeProperty(property, newValueExpr);
			brandFilter = saveBrandFilter(userContext, brandFilter, tokens().done());
			return present(userContext,brandFilter, mergedAllTokens(tokensExpr));
			//return saveBrandFilter(userContext, brandFilter, tokens().done());
		}

	}
	
	public BrandFilter updateBrandFilterProperty(PimUserContext userContext,String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBrandFilter(userContext, brandFilterId, brandFilterVersion, property, newValueExpr, tokensExpr);
		
		BrandFilter brandFilter = loadBrandFilter(userContext, brandFilterId, allTokens());
		if(brandFilter.getVersion() != brandFilterVersion){
			String message = "The target version("+brandFilter.getVersion()+") is not equals to version("+brandFilterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(brandFilter){ 
			//will be good when the brandFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to BrandFilter.
			
			brandFilter.changeProperty(property, newValueExpr);
			
			brandFilter = saveBrandFilter(userContext, brandFilter, tokens().done());
			return present(userContext,brandFilter, mergedAllTokens(tokensExpr));
			//return saveBrandFilter(userContext, brandFilter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected BrandFilterTokens tokens(){
		return BrandFilterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return BrandFilterTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return BrandFilterTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProfile(PimUserContext userContext, String brandFilterId, String anotherProfileId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
 		userContext.getChecker().checkIdOfProfile(anotherProfileId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(BrandFilterManagerException.class);
 		
 	}
 	public BrandFilter transferToAnotherProfile(PimUserContext userContext, String brandFilterId, String anotherProfileId) throws Exception
 	{
 		checkParamsForTransferingAnotherProfile(userContext, brandFilterId,anotherProfileId);
 
		BrandFilter brandFilter = loadBrandFilter(userContext, brandFilterId, allTokens());	
		synchronized(brandFilter){
			//will be good when the brandFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile profile = loadProfile(userContext, anotherProfileId, emptyOptions());		
			brandFilter.updateProfile(profile);		
			brandFilter = saveBrandFilter(userContext, brandFilter, emptyOptions());
			
			return present(userContext,brandFilter, allTokens());
			
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
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForBrandFilter(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Profile loadProfile(PimUserContext userContext, String newProfileId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProfileDAO().load(newProfileId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(PimUserContext userContext, String brandFilterId, int brandFilterVersion) throws Exception {
		//deleteInternal(userContext, brandFilterId, brandFilterVersion);		
	}
	protected void deleteInternal(PimUserContext userContext,
			String brandFilterId, int brandFilterVersion) throws Exception{
			
		userContext.getDAOGroup().getBrandFilterDAO().delete(brandFilterId, brandFilterVersion);
	}
	
	public BrandFilter forgetByAll(PimUserContext userContext, String brandFilterId, int brandFilterVersion) throws Exception {
		return forgetByAllInternal(userContext, brandFilterId, brandFilterVersion);		
	}
	protected BrandFilter forgetByAllInternal(PimUserContext userContext,
			String brandFilterId, int brandFilterVersion) throws Exception{
			
		return userContext.getDAOGroup().getBrandFilterDAO().disconnectFromAll(brandFilterId, brandFilterVersion);
	}
	

	
	public int deleteAll(PimUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new BrandFilterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(PimUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getBrandFilterDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(PimUserContext userContext, BrandFilter newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


