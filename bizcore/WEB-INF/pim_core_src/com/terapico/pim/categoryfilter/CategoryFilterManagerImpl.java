
package com.terapico.pim.categoryfilter;

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







public class CategoryFilterManagerImpl extends CustomPimCheckerManager implements CategoryFilterManager {
	
	private static final String SERVICE_TYPE = "CategoryFilter";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws CategoryFilterManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new CategoryFilterManagerException(message);

	}
	
	

 	protected CategoryFilter saveCategoryFilter(PimUserContext userContext, CategoryFilter categoryFilter, String [] tokensExpr) throws Exception{	
 		//return getCategoryFilterDAO().save(categoryFilter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCategoryFilter(userContext, categoryFilter, tokens);
 	}
 	
 	protected CategoryFilter saveCategoryFilterDetail(PimUserContext userContext, CategoryFilter categoryFilter) throws Exception{	

 		
 		return saveCategoryFilter(userContext, categoryFilter, allTokens());
 	}
 	
 	public CategoryFilter loadCategoryFilter(PimUserContext userContext, String categoryFilterId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
		userContext.getChecker().throwExceptionIfHasErrors( CategoryFilterManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CategoryFilter categoryFilter = loadCategoryFilter( userContext, categoryFilterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,categoryFilter, tokens);
 	}
 	
 	
 	 public CategoryFilter searchCategoryFilter(PimUserContext userContext, String categoryFilterId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
		userContext.getChecker().throwExceptionIfHasErrors( CategoryFilterManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		CategoryFilter categoryFilter = loadCategoryFilter( userContext, categoryFilterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,categoryFilter, tokens);
 	}
 	
 	

 	protected CategoryFilter present(PimUserContext userContext, CategoryFilter categoryFilter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,categoryFilter,tokens);
		
		
		CategoryFilter  categoryFilterToPresent = userContext.getDAOGroup().getCategoryFilterDAO().present(categoryFilter, tokens);
		
		List<BaseEntity> entityListToNaming = categoryFilterToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getCategoryFilterDAO().alias(entityListToNaming);
		
		return  categoryFilterToPresent;
		
		
	}
 
 	
 	
 	public CategoryFilter loadCategoryFilterDetail(PimUserContext userContext, String categoryFilterId) throws Exception{	
 		CategoryFilter categoryFilter = loadCategoryFilter( userContext, categoryFilterId, allTokens());
 		return present(userContext,categoryFilter, allTokens());
		
 	}
 	
 	public Object view(PimUserContext userContext, String categoryFilterId) throws Exception{	
 		CategoryFilter categoryFilter = loadCategoryFilter( userContext, categoryFilterId, viewTokens());
 		return present(userContext,categoryFilter, allTokens());
		
 	}
 	protected CategoryFilter saveCategoryFilter(PimUserContext userContext, CategoryFilter categoryFilter, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getCategoryFilterDAO().save(categoryFilter, tokens);
 	}
 	protected CategoryFilter loadCategoryFilter(PimUserContext userContext, String categoryFilterId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
		userContext.getChecker().throwExceptionIfHasErrors( CategoryFilterManagerException.class);

 
 		return userContext.getDAOGroup().getCategoryFilterDAO().load(categoryFilterId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(PimUserContext userContext, CategoryFilter categoryFilter, Map<String, Object> tokens){
		super.addActions(userContext, categoryFilter, tokens);
		
		addAction(userContext, categoryFilter, tokens,"@create","createCategoryFilter","createCategoryFilter/","main","primary");
		addAction(userContext, categoryFilter, tokens,"@update","updateCategoryFilter","updateCategoryFilter/"+categoryFilter.getId()+"/","main","primary");
		addAction(userContext, categoryFilter, tokens,"@copy","cloneCategoryFilter","cloneCategoryFilter/"+categoryFilter.getId()+"/","main","primary");
		
		addAction(userContext, categoryFilter, tokens,"category_filter.transfer_to_profile","transferToAnotherProfile","transferToAnotherProfile/"+categoryFilter.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(PimUserContext userContext, CategoryFilter categoryFilter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public CategoryFilter createCategoryFilter(PimUserContext userContext,String name, String internalId, String profileId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfCategoryFilter(name);
		userContext.getChecker().checkInternalIdOfCategoryFilter(internalId);
	
		userContext.getChecker().throwExceptionIfHasErrors(CategoryFilterManagerException.class);


		CategoryFilter categoryFilter=createNewCategoryFilter();	

		categoryFilter.setName(name);
		categoryFilter.setInternalId(internalId);
			
		Profile profile = loadProfile(userContext, profileId,emptyOptions());
		categoryFilter.setProfile(profile);
		
		

		categoryFilter = saveCategoryFilter(userContext, categoryFilter, emptyOptions());
		
		onNewInstanceCreated(userContext, categoryFilter);
		return categoryFilter;

		
	}
	protected CategoryFilter createNewCategoryFilter() 
	{
		
		return new CategoryFilter();		
	}
	
	protected void checkParamsForUpdatingCategoryFilter(PimUserContext userContext,String categoryFilterId, int categoryFilterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
		userContext.getChecker().checkVersionOfCategoryFilter( categoryFilterVersion);
		

		if(CategoryFilter.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfCategoryFilter(parseString(newValueExpr));
		}
		if(CategoryFilter.INTERNAL_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkInternalIdOfCategoryFilter(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(CategoryFilterManagerException.class);
	
		
	}
	
	
	
	public CategoryFilter clone(PimUserContext userContext, String fromCategoryFilterId) throws Exception{
		
		return userContext.getDAOGroup().getCategoryFilterDAO().clone(fromCategoryFilterId, this.allTokens());
	}
	
	public CategoryFilter internalSaveCategoryFilter(PimUserContext userContext, CategoryFilter categoryFilter) throws Exception 
	{
		return internalSaveCategoryFilter(userContext, categoryFilter, allTokens());

	}
	public CategoryFilter internalSaveCategoryFilter(PimUserContext userContext, CategoryFilter categoryFilter, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingCategoryFilter(userContext, categoryFilterId, categoryFilterVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(categoryFilter){ 
			//will be good when the categoryFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CategoryFilter.
			
			
			categoryFilter = saveCategoryFilter(userContext, categoryFilter, options);
			return categoryFilter;
			
		}

	}
	
	public CategoryFilter updateCategoryFilter(PimUserContext userContext,String categoryFilterId, int categoryFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCategoryFilter(userContext, categoryFilterId, categoryFilterVersion, property, newValueExpr, tokensExpr);
		
		
		
		CategoryFilter categoryFilter = loadCategoryFilter(userContext, categoryFilterId, allTokens());
		if(categoryFilter.getVersion() != categoryFilterVersion){
			String message = "The target version("+categoryFilter.getVersion()+") is not equals to version("+categoryFilterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(categoryFilter){ 
			//will be good when the categoryFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CategoryFilter.
			
			categoryFilter.changeProperty(property, newValueExpr);
			categoryFilter = saveCategoryFilter(userContext, categoryFilter, tokens().done());
			return present(userContext,categoryFilter, mergedAllTokens(tokensExpr));
			//return saveCategoryFilter(userContext, categoryFilter, tokens().done());
		}

	}
	
	public CategoryFilter updateCategoryFilterProperty(PimUserContext userContext,String categoryFilterId, int categoryFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCategoryFilter(userContext, categoryFilterId, categoryFilterVersion, property, newValueExpr, tokensExpr);
		
		CategoryFilter categoryFilter = loadCategoryFilter(userContext, categoryFilterId, allTokens());
		if(categoryFilter.getVersion() != categoryFilterVersion){
			String message = "The target version("+categoryFilter.getVersion()+") is not equals to version("+categoryFilterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(categoryFilter){ 
			//will be good when the categoryFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CategoryFilter.
			
			categoryFilter.changeProperty(property, newValueExpr);
			
			categoryFilter = saveCategoryFilter(userContext, categoryFilter, tokens().done());
			return present(userContext,categoryFilter, mergedAllTokens(tokensExpr));
			//return saveCategoryFilter(userContext, categoryFilter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CategoryFilterTokens tokens(){
		return CategoryFilterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CategoryFilterTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CategoryFilterTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProfile(PimUserContext userContext, String categoryFilterId, String anotherProfileId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
 		userContext.getChecker().checkIdOfProfile(anotherProfileId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(CategoryFilterManagerException.class);
 		
 	}
 	public CategoryFilter transferToAnotherProfile(PimUserContext userContext, String categoryFilterId, String anotherProfileId) throws Exception
 	{
 		checkParamsForTransferingAnotherProfile(userContext, categoryFilterId,anotherProfileId);
 
		CategoryFilter categoryFilter = loadCategoryFilter(userContext, categoryFilterId, allTokens());	
		synchronized(categoryFilter){
			//will be good when the categoryFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile profile = loadProfile(userContext, anotherProfileId, emptyOptions());		
			categoryFilter.updateProfile(profile);		
			categoryFilter = saveCategoryFilter(userContext, categoryFilter, emptyOptions());
			
			return present(userContext,categoryFilter, allTokens());
			
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
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForCategoryFilter(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(PimUserContext userContext, String categoryFilterId, int categoryFilterVersion) throws Exception {
		//deleteInternal(userContext, categoryFilterId, categoryFilterVersion);		
	}
	protected void deleteInternal(PimUserContext userContext,
			String categoryFilterId, int categoryFilterVersion) throws Exception{
			
		userContext.getDAOGroup().getCategoryFilterDAO().delete(categoryFilterId, categoryFilterVersion);
	}
	
	public CategoryFilter forgetByAll(PimUserContext userContext, String categoryFilterId, int categoryFilterVersion) throws Exception {
		return forgetByAllInternal(userContext, categoryFilterId, categoryFilterVersion);		
	}
	protected CategoryFilter forgetByAllInternal(PimUserContext userContext,
			String categoryFilterId, int categoryFilterVersion) throws Exception{
			
		return userContext.getDAOGroup().getCategoryFilterDAO().disconnectFromAll(categoryFilterId, categoryFilterVersion);
	}
	

	
	public int deleteAll(PimUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CategoryFilterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(PimUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getCategoryFilterDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(PimUserContext userContext, CategoryFilter newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


