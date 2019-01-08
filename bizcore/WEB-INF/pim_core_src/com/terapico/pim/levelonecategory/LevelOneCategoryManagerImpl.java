
package com.terapico.pim.levelonecategory;

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

import com.terapico.pim.catalog.Catalog;
import com.terapico.pim.leveltwocategory.LevelTwoCategory;

import com.terapico.pim.catalog.CandidateCatalog;

import com.terapico.pim.levelonecategory.LevelOneCategory;






public class LevelOneCategoryManagerImpl extends CustomPimCheckerManager implements LevelOneCategoryManager {
	
	private static final String SERVICE_TYPE = "LevelOneCategory";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LevelOneCategoryManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LevelOneCategoryManagerException(message);

	}
	
	

 	protected LevelOneCategory saveLevelOneCategory(PimUserContext userContext, LevelOneCategory levelOneCategory, String [] tokensExpr) throws Exception{	
 		//return getLevelOneCategoryDAO().save(levelOneCategory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelOneCategory(userContext, levelOneCategory, tokens);
 	}
 	
 	protected LevelOneCategory saveLevelOneCategoryDetail(PimUserContext userContext, LevelOneCategory levelOneCategory) throws Exception{	

 		
 		return saveLevelOneCategory(userContext, levelOneCategory, allTokens());
 	}
 	
 	public LevelOneCategory loadLevelOneCategory(PimUserContext userContext, String levelOneCategoryId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelOneCategoryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelOneCategory, tokens);
 	}
 	
 	
 	 public LevelOneCategory searchLevelOneCategory(PimUserContext userContext, String levelOneCategoryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelOneCategoryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelOneCategory, tokens);
 	}
 	
 	

 	protected LevelOneCategory present(PimUserContext userContext, LevelOneCategory levelOneCategory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelOneCategory,tokens);
		
		
		LevelOneCategory  levelOneCategoryToPresent = userContext.getDAOGroup().getLevelOneCategoryDAO().present(levelOneCategory, tokens);
		
		List<BaseEntity> entityListToNaming = levelOneCategoryToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLevelOneCategoryDAO().alias(entityListToNaming);
		
		return  levelOneCategoryToPresent;
		
		
	}
 
 	
 	
 	public LevelOneCategory loadLevelOneCategoryDetail(PimUserContext userContext, String levelOneCategoryId) throws Exception{	
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, allTokens());
 		return present(userContext,levelOneCategory, allTokens());
		
 	}
 	
 	public Object view(PimUserContext userContext, String levelOneCategoryId) throws Exception{	
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, viewTokens());
 		return present(userContext,levelOneCategory, allTokens());
		
 	}
 	protected LevelOneCategory saveLevelOneCategory(PimUserContext userContext, LevelOneCategory levelOneCategory, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLevelOneCategoryDAO().save(levelOneCategory, tokens);
 	}
 	protected LevelOneCategory loadLevelOneCategory(PimUserContext userContext, String levelOneCategoryId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelOneCategoryManagerException.class);

 
 		return userContext.getDAOGroup().getLevelOneCategoryDAO().load(levelOneCategoryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(PimUserContext userContext, LevelOneCategory levelOneCategory, Map<String, Object> tokens){
		super.addActions(userContext, levelOneCategory, tokens);
		
		addAction(userContext, levelOneCategory, tokens,"@create","createLevelOneCategory","createLevelOneCategory/","main","primary");
		addAction(userContext, levelOneCategory, tokens,"@update","updateLevelOneCategory","updateLevelOneCategory/"+levelOneCategory.getId()+"/","main","primary");
		addAction(userContext, levelOneCategory, tokens,"@copy","cloneLevelOneCategory","cloneLevelOneCategory/"+levelOneCategory.getId()+"/","main","primary");
		
		addAction(userContext, levelOneCategory, tokens,"level_one_category.transfer_to_catalog","transferToAnotherCatalog","transferToAnotherCatalog/"+levelOneCategory.getId()+"/","main","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.addLevelTwoCategory","addLevelTwoCategory","addLevelTwoCategory/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.removeLevelTwoCategory","removeLevelTwoCategory","removeLevelTwoCategory/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.updateLevelTwoCategory","updateLevelTwoCategory","updateLevelTwoCategory/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.copyLevelTwoCategoryFrom","copyLevelTwoCategoryFrom","copyLevelTwoCategoryFrom/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(PimUserContext userContext, LevelOneCategory levelOneCategory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelOneCategory createLevelOneCategory(PimUserContext userContext,String catalogId, String displayName) throws Exception
	{
		
		

		

		userContext.getChecker().checkDisplayNameOfLevelOneCategory(displayName);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);


		LevelOneCategory levelOneCategory=createNewLevelOneCategory();	

			
		Catalog catalog = loadCatalog(userContext, catalogId,emptyOptions());
		levelOneCategory.setCatalog(catalog);
		
		
		levelOneCategory.setDisplayName(displayName);

		levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, emptyOptions());
		
		onNewInstanceCreated(userContext, levelOneCategory);
		return levelOneCategory;

		
	}
	protected LevelOneCategory createNewLevelOneCategory() 
	{
		
		return new LevelOneCategory();		
	}
	
	protected void checkParamsForUpdatingLevelOneCategory(PimUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().checkVersionOfLevelOneCategory( levelOneCategoryVersion);
		
		

		
		if(LevelOneCategory.DISPLAY_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkDisplayNameOfLevelOneCategory(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
	
		
	}
	
	
	
	public LevelOneCategory clone(PimUserContext userContext, String fromLevelOneCategoryId) throws Exception{
		
		return userContext.getDAOGroup().getLevelOneCategoryDAO().clone(fromLevelOneCategoryId, this.allTokens());
	}
	
	public LevelOneCategory internalSaveLevelOneCategory(PimUserContext userContext, LevelOneCategory levelOneCategory) throws Exception 
	{
		return internalSaveLevelOneCategory(userContext, levelOneCategory, allTokens());

	}
	public LevelOneCategory internalSaveLevelOneCategory(PimUserContext userContext, LevelOneCategory levelOneCategory, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLevelOneCategory(userContext, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(levelOneCategory){ 
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneCategory.
			
			
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, options);
			return levelOneCategory;
			
		}

	}
	
	public LevelOneCategory updateLevelOneCategory(PimUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelOneCategory(userContext, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		if(levelOneCategory.getVersion() != levelOneCategoryVersion){
			String message = "The target version("+levelOneCategory.getVersion()+") is not equals to version("+levelOneCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelOneCategory){ 
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneCategory.
			
			levelOneCategory.changeProperty(property, newValueExpr);
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
			//return saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
		}

	}
	
	public LevelOneCategory updateLevelOneCategoryProperty(PimUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelOneCategory(userContext, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr, tokensExpr);
		
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		if(levelOneCategory.getVersion() != levelOneCategoryVersion){
			String message = "The target version("+levelOneCategory.getVersion()+") is not equals to version("+levelOneCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelOneCategory){ 
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneCategory.
			
			levelOneCategory.changeProperty(property, newValueExpr);
			
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
			//return saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelOneCategoryTokens tokens(){
		return LevelOneCategoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelOneCategoryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLevelTwoCategoryListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelOneCategoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCatalog(PimUserContext userContext, String levelOneCategoryId, String anotherCatalogId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
 		userContext.getChecker().checkIdOfCatalog(anotherCatalogId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
 		
 	}
 	public LevelOneCategory transferToAnotherCatalog(PimUserContext userContext, String levelOneCategoryId, String anotherCatalogId) throws Exception
 	{
 		checkParamsForTransferingAnotherCatalog(userContext, levelOneCategoryId,anotherCatalogId);
 
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());	
		synchronized(levelOneCategory){
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Catalog catalog = loadCatalog(userContext, anotherCatalogId, emptyOptions());		
			levelOneCategory.updateCatalog(catalog);		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, emptyOptions());
			
			return present(userContext,levelOneCategory, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateCatalog requestCandidateCatalog(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCatalog result = new CandidateCatalog();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("displayName");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Catalog> candidateList = userContext.getDAOGroup().getCatalogDAO().requestCandidateCatalogForLevelOneCategory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(PimUserContext userContext, String levelOneCategoryId, int levelOneCategoryVersion) throws Exception {
		//deleteInternal(userContext, levelOneCategoryId, levelOneCategoryVersion);		
	}
	protected void deleteInternal(PimUserContext userContext,
			String levelOneCategoryId, int levelOneCategoryVersion) throws Exception{
			
		userContext.getDAOGroup().getLevelOneCategoryDAO().delete(levelOneCategoryId, levelOneCategoryVersion);
	}
	
	public LevelOneCategory forgetByAll(PimUserContext userContext, String levelOneCategoryId, int levelOneCategoryVersion) throws Exception {
		return forgetByAllInternal(userContext, levelOneCategoryId, levelOneCategoryVersion);		
	}
	protected LevelOneCategory forgetByAllInternal(PimUserContext userContext,
			String levelOneCategoryId, int levelOneCategoryVersion) throws Exception{
			
		return userContext.getDAOGroup().getLevelOneCategoryDAO().disconnectFromAll(levelOneCategoryId, levelOneCategoryVersion);
	}
	

	
	public int deleteAll(PimUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelOneCategoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(PimUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLevelOneCategoryDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingLevelTwoCategory(PimUserContext userContext, String levelOneCategoryId, String displayName,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);

		
		userContext.getChecker().checkDisplayNameOfLevelTwoCategory(displayName);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);

	
	}
	public  LevelOneCategory addLevelTwoCategory(PimUserContext userContext, String levelOneCategoryId, String displayName, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelTwoCategory(userContext,levelOneCategoryId,displayName,tokensExpr);
		
		LevelTwoCategory levelTwoCategory = createLevelTwoCategory(userContext,displayName);
		
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		synchronized(levelOneCategory){ 
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneCategory.addLevelTwoCategory( levelTwoCategory );		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			
			userContext.getManagerGroup().getLevelTwoCategoryManager().onNewInstanceCreated(userContext, levelTwoCategory);
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelTwoCategoryProperties(PimUserContext userContext, String levelOneCategoryId,String id,String displayName,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().checkIdOfLevelTwoCategory(id);
		
		userContext.getChecker().checkDisplayNameOfLevelTwoCategory( displayName);

		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
		
	}
	public  LevelOneCategory updateLevelTwoCategoryProperties(PimUserContext userContext, String levelOneCategoryId, String id,String displayName, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingLevelTwoCategoryProperties(userContext,levelOneCategoryId,id,displayName,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelTwoCategoryListList()
				.searchLevelTwoCategoryListWith(LevelTwoCategory.ID_PROPERTY, "is", id).done();
		
		LevelOneCategory levelOneCategoryToUpdate = loadLevelOneCategory(userContext, levelOneCategoryId, options);
		
		if(levelOneCategoryToUpdate.getLevelTwoCategoryList().isEmpty()){
			throw new LevelOneCategoryManagerException("LevelTwoCategory is NOT FOUND with id: '"+id+"'");
		}
		
		LevelTwoCategory item = levelOneCategoryToUpdate.getLevelTwoCategoryList().first();
		
		item.updateDisplayName( displayName );

		
		//checkParamsForAddingLevelTwoCategory(userContext,levelOneCategoryId,name, code, used,tokensExpr);
		LevelOneCategory levelOneCategory = saveLevelOneCategory(userContext, levelOneCategoryToUpdate, tokens().withLevelTwoCategoryList().done());
		synchronized(levelOneCategory){ 
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected LevelTwoCategory createLevelTwoCategory(PimUserContext userContext, String displayName) throws Exception{

		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
		
		
		levelTwoCategory.setDisplayName(displayName);
	
		
		return levelTwoCategory;
	
		
	}
	
	protected LevelTwoCategory createIndexedLevelTwoCategory(String id, int version){

		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
		levelTwoCategory.setId(id);
		levelTwoCategory.setVersion(version);
		return levelTwoCategory;			
		
	}
	
	protected void checkParamsForRemovingLevelTwoCategoryList(PimUserContext userContext, String levelOneCategoryId, 
			String levelTwoCategoryIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		for(String levelTwoCategoryId: levelTwoCategoryIds){
			userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
		
	}
	public  LevelOneCategory removeLevelTwoCategoryList(PimUserContext userContext, String levelOneCategoryId, 
			String levelTwoCategoryIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingLevelTwoCategoryList(userContext, levelOneCategoryId,  levelTwoCategoryIds, tokensExpr);
			
			
			LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
			synchronized(levelOneCategory){ 
				//Will be good when the levelOneCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelOneCategoryDAO().planToRemoveLevelTwoCategoryList(levelOneCategory, levelTwoCategoryIds, allTokens());
				levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
				deleteRelationListInGraph(userContext, levelOneCategory.getLevelTwoCategoryList());
				return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingLevelTwoCategory(PimUserContext userContext, String levelOneCategoryId, 
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelOneCategory( levelOneCategoryId);
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().checkVersionOfLevelTwoCategory(levelTwoCategoryVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
	
	}
	public  LevelOneCategory removeLevelTwoCategory(PimUserContext userContext, String levelOneCategoryId, 
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelTwoCategory(userContext,levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion,tokensExpr);
		
		LevelTwoCategory levelTwoCategory = createIndexedLevelTwoCategory(levelTwoCategoryId, levelTwoCategoryVersion);
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		synchronized(levelOneCategory){ 
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneCategory.removeLevelTwoCategory( levelTwoCategory );		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			deleteRelationInGraph(userContext, levelTwoCategory);
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingLevelTwoCategory(PimUserContext userContext, String levelOneCategoryId, 
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelOneCategory( levelOneCategoryId);
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().checkVersionOfLevelTwoCategory(levelTwoCategoryVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
	
	}
	public  LevelOneCategory copyLevelTwoCategoryFrom(PimUserContext userContext, String levelOneCategoryId, 
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelTwoCategory(userContext,levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion,tokensExpr);
		
		LevelTwoCategory levelTwoCategory = createIndexedLevelTwoCategory(levelTwoCategoryId, levelTwoCategoryVersion);
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		synchronized(levelOneCategory){ 
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			levelOneCategory.copyLevelTwoCategoryFrom( levelTwoCategory );		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			
			userContext.getManagerGroup().getLevelTwoCategoryManager().onNewInstanceCreated(userContext, (LevelTwoCategory)levelOneCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingLevelTwoCategory(PimUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().checkVersionOfLevelTwoCategory(levelTwoCategoryVersion);
		

		if(LevelTwoCategory.DISPLAY_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkDisplayNameOfLevelTwoCategory(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
	
	}
	
	public  LevelOneCategory updateLevelTwoCategory(PimUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelTwoCategory(userContext, levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withLevelTwoCategoryList().searchLevelTwoCategoryListWith(LevelTwoCategory.ID_PROPERTY, "eq", levelTwoCategoryId).done();
		
		
		
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, loadTokens);
		
		synchronized(levelOneCategory){ 
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelOneCategory.removeLevelTwoCategory( levelTwoCategory );	
			//make changes to AcceleraterAccount.
			LevelTwoCategory levelTwoCategoryIndex = createIndexedLevelTwoCategory(levelTwoCategoryId, levelTwoCategoryVersion);
		
			LevelTwoCategory levelTwoCategory = levelOneCategory.findTheLevelTwoCategory(levelTwoCategoryIndex);
			if(levelTwoCategory == null){
				throw new LevelOneCategoryManagerException(levelTwoCategory+" is NOT FOUND" );
			}
			
			levelTwoCategory.changeProperty(property, newValueExpr);
			
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(PimUserContext userContext, LevelOneCategory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


