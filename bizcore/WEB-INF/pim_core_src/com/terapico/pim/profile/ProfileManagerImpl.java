
package com.terapico.pim.profile;

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

import com.terapico.pim.brandfilter.BrandFilter;
import com.terapico.pim.editorpickproduct.EditorPickProduct;
import com.terapico.pim.pricefilter.PriceFilter;
import com.terapico.pim.categoryfilter.CategoryFilter;
import com.terapico.pim.newproduct.NewProduct;
import com.terapico.pim.topratedproduct.TopRatedProduct;
import com.terapico.pim.recommandproduct.RecommandProduct;
import com.terapico.pim.platform.Platform;

import com.terapico.pim.platform.CandidatePlatform;

import com.terapico.pim.levelncategory.LevelNCategory;
import com.terapico.pim.profile.Profile;
import com.terapico.pim.catalog.Catalog;
import com.terapico.pim.brand.Brand;
import com.terapico.pim.platform.Platform;






public class ProfileManagerImpl extends CustomPimCheckerManager implements ProfileManager {
	
	private static final String SERVICE_TYPE = "Profile";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProfileManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProfileManagerException(message);

	}
	
	

 	protected Profile saveProfile(PimUserContext userContext, Profile profile, String [] tokensExpr) throws Exception{	
 		//return getProfileDAO().save(profile, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProfile(userContext, profile, tokens);
 	}
 	
 	protected Profile saveProfileDetail(PimUserContext userContext, Profile profile) throws Exception{	

 		
 		return saveProfile(userContext, profile, allTokens());
 	}
 	
 	public Profile loadProfile(PimUserContext userContext, String profileId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Profile profile = loadProfile( userContext, profileId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,profile, tokens);
 	}
 	
 	
 	 public Profile searchProfile(PimUserContext userContext, String profileId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Profile profile = loadProfile( userContext, profileId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,profile, tokens);
 	}
 	
 	

 	protected Profile present(PimUserContext userContext, Profile profile, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,profile,tokens);
		
		
		Profile  profileToPresent = userContext.getDAOGroup().getProfileDAO().present(profile, tokens);
		
		List<BaseEntity> entityListToNaming = profileToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProfileDAO().alias(entityListToNaming);
		
		return  profileToPresent;
		
		
	}
 
 	
 	
 	public Profile loadProfileDetail(PimUserContext userContext, String profileId) throws Exception{	
 		Profile profile = loadProfile( userContext, profileId, allTokens());
 		return present(userContext,profile, allTokens());
		
 	}
 	
 	public Object view(PimUserContext userContext, String profileId) throws Exception{	
 		Profile profile = loadProfile( userContext, profileId, viewTokens());
 		return present(userContext,profile, allTokens());
		
 	}
 	protected Profile saveProfile(PimUserContext userContext, Profile profile, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProfileDAO().save(profile, tokens);
 	}
 	protected Profile loadProfile(PimUserContext userContext, String profileId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 
 		return userContext.getDAOGroup().getProfileDAO().load(profileId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(PimUserContext userContext, Profile profile, Map<String, Object> tokens){
		super.addActions(userContext, profile, tokens);
		
		addAction(userContext, profile, tokens,"@create","createProfile","createProfile/","main","primary");
		addAction(userContext, profile, tokens,"@update","updateProfile","updateProfile/"+profile.getId()+"/","main","primary");
		addAction(userContext, profile, tokens,"@copy","cloneProfile","cloneProfile/"+profile.getId()+"/","main","primary");
		
		addAction(userContext, profile, tokens,"profile.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+profile.getId()+"/","main","primary");
		addAction(userContext, profile, tokens,"profile.addBrandFilter","addBrandFilter","addBrandFilter/"+profile.getId()+"/","brandFilterList","primary");
		addAction(userContext, profile, tokens,"profile.removeBrandFilter","removeBrandFilter","removeBrandFilter/"+profile.getId()+"/","brandFilterList","primary");
		addAction(userContext, profile, tokens,"profile.updateBrandFilter","updateBrandFilter","updateBrandFilter/"+profile.getId()+"/","brandFilterList","primary");
		addAction(userContext, profile, tokens,"profile.copyBrandFilterFrom","copyBrandFilterFrom","copyBrandFilterFrom/"+profile.getId()+"/","brandFilterList","primary");
		addAction(userContext, profile, tokens,"profile.addPriceFilter","addPriceFilter","addPriceFilter/"+profile.getId()+"/","priceFilterList","primary");
		addAction(userContext, profile, tokens,"profile.removePriceFilter","removePriceFilter","removePriceFilter/"+profile.getId()+"/","priceFilterList","primary");
		addAction(userContext, profile, tokens,"profile.updatePriceFilter","updatePriceFilter","updatePriceFilter/"+profile.getId()+"/","priceFilterList","primary");
		addAction(userContext, profile, tokens,"profile.copyPriceFilterFrom","copyPriceFilterFrom","copyPriceFilterFrom/"+profile.getId()+"/","priceFilterList","primary");
		addAction(userContext, profile, tokens,"profile.addCategoryFilter","addCategoryFilter","addCategoryFilter/"+profile.getId()+"/","categoryFilterList","primary");
		addAction(userContext, profile, tokens,"profile.removeCategoryFilter","removeCategoryFilter","removeCategoryFilter/"+profile.getId()+"/","categoryFilterList","primary");
		addAction(userContext, profile, tokens,"profile.updateCategoryFilter","updateCategoryFilter","updateCategoryFilter/"+profile.getId()+"/","categoryFilterList","primary");
		addAction(userContext, profile, tokens,"profile.copyCategoryFilterFrom","copyCategoryFilterFrom","copyCategoryFilterFrom/"+profile.getId()+"/","categoryFilterList","primary");
		addAction(userContext, profile, tokens,"profile.addNewProduct","addNewProduct","addNewProduct/"+profile.getId()+"/","newProductList","primary");
		addAction(userContext, profile, tokens,"profile.removeNewProduct","removeNewProduct","removeNewProduct/"+profile.getId()+"/","newProductList","primary");
		addAction(userContext, profile, tokens,"profile.updateNewProduct","updateNewProduct","updateNewProduct/"+profile.getId()+"/","newProductList","primary");
		addAction(userContext, profile, tokens,"profile.copyNewProductFrom","copyNewProductFrom","copyNewProductFrom/"+profile.getId()+"/","newProductList","primary");
		addAction(userContext, profile, tokens,"profile.addEditorPickProduct","addEditorPickProduct","addEditorPickProduct/"+profile.getId()+"/","editorPickProductList","primary");
		addAction(userContext, profile, tokens,"profile.removeEditorPickProduct","removeEditorPickProduct","removeEditorPickProduct/"+profile.getId()+"/","editorPickProductList","primary");
		addAction(userContext, profile, tokens,"profile.updateEditorPickProduct","updateEditorPickProduct","updateEditorPickProduct/"+profile.getId()+"/","editorPickProductList","primary");
		addAction(userContext, profile, tokens,"profile.copyEditorPickProductFrom","copyEditorPickProductFrom","copyEditorPickProductFrom/"+profile.getId()+"/","editorPickProductList","primary");
		addAction(userContext, profile, tokens,"profile.addTopRatedProduct","addTopRatedProduct","addTopRatedProduct/"+profile.getId()+"/","topRatedProductList","primary");
		addAction(userContext, profile, tokens,"profile.removeTopRatedProduct","removeTopRatedProduct","removeTopRatedProduct/"+profile.getId()+"/","topRatedProductList","primary");
		addAction(userContext, profile, tokens,"profile.updateTopRatedProduct","updateTopRatedProduct","updateTopRatedProduct/"+profile.getId()+"/","topRatedProductList","primary");
		addAction(userContext, profile, tokens,"profile.copyTopRatedProductFrom","copyTopRatedProductFrom","copyTopRatedProductFrom/"+profile.getId()+"/","topRatedProductList","primary");
		addAction(userContext, profile, tokens,"profile.addRecommandProduct","addRecommandProduct","addRecommandProduct/"+profile.getId()+"/","recommandProductList","primary");
		addAction(userContext, profile, tokens,"profile.removeRecommandProduct","removeRecommandProduct","removeRecommandProduct/"+profile.getId()+"/","recommandProductList","primary");
		addAction(userContext, profile, tokens,"profile.updateRecommandProduct","updateRecommandProduct","updateRecommandProduct/"+profile.getId()+"/","recommandProductList","primary");
		addAction(userContext, profile, tokens,"profile.copyRecommandProductFrom","copyRecommandProductFrom","copyRecommandProductFrom/"+profile.getId()+"/","recommandProductList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(PimUserContext userContext, Profile profile, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Profile createProfile(PimUserContext userContext,String name, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfProfile(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);


		Profile profile=createNewProfile();	

		profile.setName(name);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		profile.setPlatform(platform);
		
		

		profile = saveProfile(userContext, profile, emptyOptions());
		
		onNewInstanceCreated(userContext, profile);
		return profile;

		
	}
	protected Profile createNewProfile() 
	{
		
		return new Profile();		
	}
	
	protected void checkParamsForUpdatingProfile(PimUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile( profileVersion);
		

		if(Profile.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProfile(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
		
	}
	
	
	
	public Profile clone(PimUserContext userContext, String fromProfileId) throws Exception{
		
		return userContext.getDAOGroup().getProfileDAO().clone(fromProfileId, this.allTokens());
	}
	
	public Profile internalSaveProfile(PimUserContext userContext, Profile profile) throws Exception 
	{
		return internalSaveProfile(userContext, profile, allTokens());

	}
	public Profile internalSaveProfile(PimUserContext userContext, Profile profile, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			
			profile = saveProfile(userContext, profile, options);
			return profile;
			
		}

	}
	
	public Profile updateProfile(PimUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		if(profile.getVersion() != profileVersion){
			String message = "The target version("+profile.getVersion()+") is not equals to version("+profileVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			profile.changeProperty(property, newValueExpr);
			profile = saveProfile(userContext, profile, tokens().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
			//return saveProfile(userContext, profile, tokens().done());
		}

	}
	
	public Profile updateProfileProperty(PimUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		if(profile.getVersion() != profileVersion){
			String message = "The target version("+profile.getVersion()+") is not equals to version("+profileVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			profile.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
			//return saveProfile(userContext, profile, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProfileTokens tokens(){
		return ProfileTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProfileTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortBrandFilterListWith("id","desc")
		.sortPriceFilterListWith("id","desc")
		.sortCategoryFilterListWith("id","desc")
		.sortNewProductListWith("id","desc")
		.sortEditorPickProductListWith("id","desc")
		.sortTopRatedProductListWith("id","desc")
		.sortRecommandProductListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProfileTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(PimUserContext userContext, String profileId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProfile(profileId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
 		
 	}
 	public Profile transferToAnotherPlatform(PimUserContext userContext, String profileId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, profileId,anotherPlatformId);
 
		Profile profile = loadProfile(userContext, profileId, allTokens());	
		synchronized(profile){
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			profile.updatePlatform(platform);		
			profile = saveProfile(userContext, profile, emptyOptions());
			
			return present(userContext,profile, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForProfile(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(PimUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(PimUserContext userContext, String profileId, int profileVersion) throws Exception {
		//deleteInternal(userContext, profileId, profileVersion);		
	}
	protected void deleteInternal(PimUserContext userContext,
			String profileId, int profileVersion) throws Exception{
			
		userContext.getDAOGroup().getProfileDAO().delete(profileId, profileVersion);
	}
	
	public Profile forgetByAll(PimUserContext userContext, String profileId, int profileVersion) throws Exception {
		return forgetByAllInternal(userContext, profileId, profileVersion);		
	}
	protected Profile forgetByAllInternal(PimUserContext userContext,
			String profileId, int profileVersion) throws Exception{
			
		return userContext.getDAOGroup().getProfileDAO().disconnectFromAll(profileId, profileVersion);
	}
	

	
	public int deleteAll(PimUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProfileManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(PimUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProfileDAO().deleteAll();
	}


	//disconnect Profile with internal_id in BrandFilter
	protected Profile breakWithBrandFilterByInternalId(PimUserContext userContext, String profileId, String internalIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveBrandFilterListWithInternalId(profile, internalIdId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withBrandFilterList().done());
				return profile;
			}
	}
	//disconnect Profile with internal_id in CategoryFilter
	protected Profile breakWithCategoryFilterByInternalId(PimUserContext userContext, String profileId, String internalIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveCategoryFilterListWithInternalId(profile, internalIdId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withCategoryFilterList().done());
				return profile;
			}
	}
	//disconnect Profile with parent_category in NewProduct
	protected Profile breakWithNewProductByParentCategory(PimUserContext userContext, String profileId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveNewProductListWithParentCategory(profile, parentCategoryId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
				return profile;
			}
	}
	//disconnect Profile with brand in NewProduct
	protected Profile breakWithNewProductByBrand(PimUserContext userContext, String profileId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveNewProductListWithBrand(profile, brandId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
				return profile;
			}
	}
	//disconnect Profile with catalog in NewProduct
	protected Profile breakWithNewProductByCatalog(PimUserContext userContext, String profileId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveNewProductListWithCatalog(profile, catalogId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
				return profile;
			}
	}
	//disconnect Profile with platform in NewProduct
	protected Profile breakWithNewProductByPlatform(PimUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveNewProductListWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
				return profile;
			}
	}
	//disconnect Profile with parent_category in EditorPickProduct
	protected Profile breakWithEditorPickProductByParentCategory(PimUserContext userContext, String profileId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveEditorPickProductListWithParentCategory(profile, parentCategoryId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
				return profile;
			}
	}
	//disconnect Profile with brand in EditorPickProduct
	protected Profile breakWithEditorPickProductByBrand(PimUserContext userContext, String profileId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveEditorPickProductListWithBrand(profile, brandId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
				return profile;
			}
	}
	//disconnect Profile with catalog in EditorPickProduct
	protected Profile breakWithEditorPickProductByCatalog(PimUserContext userContext, String profileId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveEditorPickProductListWithCatalog(profile, catalogId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
				return profile;
			}
	}
	//disconnect Profile with platform in EditorPickProduct
	protected Profile breakWithEditorPickProductByPlatform(PimUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveEditorPickProductListWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
				return profile;
			}
	}
	//disconnect Profile with parent_category in TopRatedProduct
	protected Profile breakWithTopRatedProductByParentCategory(PimUserContext userContext, String profileId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveTopRatedProductListWithParentCategory(profile, parentCategoryId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
				return profile;
			}
	}
	//disconnect Profile with brand in TopRatedProduct
	protected Profile breakWithTopRatedProductByBrand(PimUserContext userContext, String profileId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveTopRatedProductListWithBrand(profile, brandId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
				return profile;
			}
	}
	//disconnect Profile with catalog in TopRatedProduct
	protected Profile breakWithTopRatedProductByCatalog(PimUserContext userContext, String profileId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveTopRatedProductListWithCatalog(profile, catalogId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
				return profile;
			}
	}
	//disconnect Profile with platform in TopRatedProduct
	protected Profile breakWithTopRatedProductByPlatform(PimUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveTopRatedProductListWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
				return profile;
			}
	}
	//disconnect Profile with parent_category in RecommandProduct
	protected Profile breakWithRecommandProductByParentCategory(PimUserContext userContext, String profileId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveRecommandProductListWithParentCategory(profile, parentCategoryId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
				return profile;
			}
	}
	//disconnect Profile with brand in RecommandProduct
	protected Profile breakWithRecommandProductByBrand(PimUserContext userContext, String profileId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveRecommandProductListWithBrand(profile, brandId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
				return profile;
			}
	}
	//disconnect Profile with catalog in RecommandProduct
	protected Profile breakWithRecommandProductByCatalog(PimUserContext userContext, String profileId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveRecommandProductListWithCatalog(profile, catalogId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
				return profile;
			}
	}
	//disconnect Profile with platform in RecommandProduct
	protected Profile breakWithRecommandProductByPlatform(PimUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveRecommandProductListWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
				return profile;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingBrandFilter(PimUserContext userContext, String profileId, String name, String internalId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfBrandFilter(name);
		
		userContext.getChecker().checkInternalIdOfBrandFilter(internalId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addBrandFilter(PimUserContext userContext, String profileId, String name, String internalId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingBrandFilter(userContext,profileId,name, internalId,tokensExpr);
		
		BrandFilter brandFilter = createBrandFilter(userContext,name, internalId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addBrandFilter( brandFilter );		
			profile = saveProfile(userContext, profile, tokens().withBrandFilterList().done());
			
			userContext.getManagerGroup().getBrandFilterManager().onNewInstanceCreated(userContext, brandFilter);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingBrandFilterProperties(PimUserContext userContext, String profileId,String id,String name,String internalId,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfBrandFilter(id);
		
		userContext.getChecker().checkNameOfBrandFilter( name);
		userContext.getChecker().checkInternalIdOfBrandFilter( internalId);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateBrandFilterProperties(PimUserContext userContext, String profileId, String id,String name,String internalId, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingBrandFilterProperties(userContext,profileId,id,name,internalId,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withBrandFilterListList()
				.searchBrandFilterListWith(BrandFilter.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getBrandFilterList().isEmpty()){
			throw new ProfileManagerException("BrandFilter is NOT FOUND with id: '"+id+"'");
		}
		
		BrandFilter item = profileToUpdate.getBrandFilterList().first();
		
		item.updateName( name );
		item.updateInternalId( internalId );

		
		//checkParamsForAddingBrandFilter(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withBrandFilterList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected BrandFilter createBrandFilter(PimUserContext userContext, String name, String internalId) throws Exception{

		BrandFilter brandFilter = new BrandFilter();
		
		
		brandFilter.setName(name);		
		brandFilter.setInternalId(internalId);
	
		
		return brandFilter;
	
		
	}
	
	protected BrandFilter createIndexedBrandFilter(String id, int version){

		BrandFilter brandFilter = new BrandFilter();
		brandFilter.setId(id);
		brandFilter.setVersion(version);
		return brandFilter;			
		
	}
	
	protected void checkParamsForRemovingBrandFilterList(PimUserContext userContext, String profileId, 
			String brandFilterIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String brandFilterId: brandFilterIds){
			userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeBrandFilterList(PimUserContext userContext, String profileId, 
			String brandFilterIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingBrandFilterList(userContext, profileId,  brandFilterIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveBrandFilterList(profile, brandFilterIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withBrandFilterList().done());
				deleteRelationListInGraph(userContext, profile.getBrandFilterList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingBrandFilter(PimUserContext userContext, String profileId, 
		String brandFilterId, int brandFilterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().checkVersionOfBrandFilter(brandFilterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeBrandFilter(PimUserContext userContext, String profileId, 
		String brandFilterId, int brandFilterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingBrandFilter(userContext,profileId, brandFilterId, brandFilterVersion,tokensExpr);
		
		BrandFilter brandFilter = createIndexedBrandFilter(brandFilterId, brandFilterVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeBrandFilter( brandFilter );		
			profile = saveProfile(userContext, profile, tokens().withBrandFilterList().done());
			deleteRelationInGraph(userContext, brandFilter);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingBrandFilter(PimUserContext userContext, String profileId, 
		String brandFilterId, int brandFilterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().checkVersionOfBrandFilter(brandFilterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyBrandFilterFrom(PimUserContext userContext, String profileId, 
		String brandFilterId, int brandFilterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingBrandFilter(userContext,profileId, brandFilterId, brandFilterVersion,tokensExpr);
		
		BrandFilter brandFilter = createIndexedBrandFilter(brandFilterId, brandFilterVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			profile.copyBrandFilterFrom( brandFilter );		
			profile = saveProfile(userContext, profile, tokens().withBrandFilterList().done());
			
			userContext.getManagerGroup().getBrandFilterManager().onNewInstanceCreated(userContext, (BrandFilter)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingBrandFilter(PimUserContext userContext, String profileId, String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().checkVersionOfBrandFilter(brandFilterVersion);
		

		if(BrandFilter.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfBrandFilter(parseString(newValueExpr));
		}
		
		if(BrandFilter.INTERNAL_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkInternalIdOfBrandFilter(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateBrandFilter(PimUserContext userContext, String profileId, String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingBrandFilter(userContext, profileId, brandFilterId, brandFilterVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withBrandFilterList().searchBrandFilterListWith(BrandFilter.ID_PROPERTY, "eq", brandFilterId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeBrandFilter( brandFilter );	
			//make changes to AcceleraterAccount.
			BrandFilter brandFilterIndex = createIndexedBrandFilter(brandFilterId, brandFilterVersion);
		
			BrandFilter brandFilter = profile.findTheBrandFilter(brandFilterIndex);
			if(brandFilter == null){
				throw new ProfileManagerException(brandFilter+" is NOT FOUND" );
			}
			
			brandFilter.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().withBrandFilterList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingPriceFilter(PimUserContext userContext, String profileId, String name, BigDecimal priceStart, BigDecimal priceEnd,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfPriceFilter(name);
		
		userContext.getChecker().checkPriceStartOfPriceFilter(priceStart);
		
		userContext.getChecker().checkPriceEndOfPriceFilter(priceEnd);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addPriceFilter(PimUserContext userContext, String profileId, String name, BigDecimal priceStart, BigDecimal priceEnd, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPriceFilter(userContext,profileId,name, priceStart, priceEnd,tokensExpr);
		
		PriceFilter priceFilter = createPriceFilter(userContext,name, priceStart, priceEnd);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addPriceFilter( priceFilter );		
			profile = saveProfile(userContext, profile, tokens().withPriceFilterList().done());
			
			userContext.getManagerGroup().getPriceFilterManager().onNewInstanceCreated(userContext, priceFilter);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPriceFilterProperties(PimUserContext userContext, String profileId,String id,String name,BigDecimal priceStart,BigDecimal priceEnd,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfPriceFilter(id);
		
		userContext.getChecker().checkNameOfPriceFilter( name);
		userContext.getChecker().checkPriceStartOfPriceFilter( priceStart);
		userContext.getChecker().checkPriceEndOfPriceFilter( priceEnd);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updatePriceFilterProperties(PimUserContext userContext, String profileId, String id,String name,BigDecimal priceStart,BigDecimal priceEnd, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingPriceFilterProperties(userContext,profileId,id,name,priceStart,priceEnd,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPriceFilterListList()
				.searchPriceFilterListWith(PriceFilter.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getPriceFilterList().isEmpty()){
			throw new ProfileManagerException("PriceFilter is NOT FOUND with id: '"+id+"'");
		}
		
		PriceFilter item = profileToUpdate.getPriceFilterList().first();
		
		item.updateName( name );
		item.updatePriceStart( priceStart );
		item.updatePriceEnd( priceEnd );

		
		//checkParamsForAddingPriceFilter(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withPriceFilterList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected PriceFilter createPriceFilter(PimUserContext userContext, String name, BigDecimal priceStart, BigDecimal priceEnd) throws Exception{

		PriceFilter priceFilter = new PriceFilter();
		
		
		priceFilter.setName(name);		
		priceFilter.setPriceStart(priceStart);		
		priceFilter.setPriceEnd(priceEnd);
	
		
		return priceFilter;
	
		
	}
	
	protected PriceFilter createIndexedPriceFilter(String id, int version){

		PriceFilter priceFilter = new PriceFilter();
		priceFilter.setId(id);
		priceFilter.setVersion(version);
		return priceFilter;			
		
	}
	
	protected void checkParamsForRemovingPriceFilterList(PimUserContext userContext, String profileId, 
			String priceFilterIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String priceFilterId: priceFilterIds){
			userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removePriceFilterList(PimUserContext userContext, String profileId, 
			String priceFilterIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingPriceFilterList(userContext, profileId,  priceFilterIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemovePriceFilterList(profile, priceFilterIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withPriceFilterList().done());
				deleteRelationListInGraph(userContext, profile.getPriceFilterList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingPriceFilter(PimUserContext userContext, String profileId, 
		String priceFilterId, int priceFilterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
		userContext.getChecker().checkVersionOfPriceFilter(priceFilterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removePriceFilter(PimUserContext userContext, String profileId, 
		String priceFilterId, int priceFilterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPriceFilter(userContext,profileId, priceFilterId, priceFilterVersion,tokensExpr);
		
		PriceFilter priceFilter = createIndexedPriceFilter(priceFilterId, priceFilterVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removePriceFilter( priceFilter );		
			profile = saveProfile(userContext, profile, tokens().withPriceFilterList().done());
			deleteRelationInGraph(userContext, priceFilter);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingPriceFilter(PimUserContext userContext, String profileId, 
		String priceFilterId, int priceFilterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
		userContext.getChecker().checkVersionOfPriceFilter(priceFilterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyPriceFilterFrom(PimUserContext userContext, String profileId, 
		String priceFilterId, int priceFilterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPriceFilter(userContext,profileId, priceFilterId, priceFilterVersion,tokensExpr);
		
		PriceFilter priceFilter = createIndexedPriceFilter(priceFilterId, priceFilterVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			profile.copyPriceFilterFrom( priceFilter );		
			profile = saveProfile(userContext, profile, tokens().withPriceFilterList().done());
			
			userContext.getManagerGroup().getPriceFilterManager().onNewInstanceCreated(userContext, (PriceFilter)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingPriceFilter(PimUserContext userContext, String profileId, String priceFilterId, int priceFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
		userContext.getChecker().checkVersionOfPriceFilter(priceFilterVersion);
		

		if(PriceFilter.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPriceFilter(parseString(newValueExpr));
		}
		
		if(PriceFilter.PRICE_START_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceStartOfPriceFilter(parseBigDecimal(newValueExpr));
		}
		
		if(PriceFilter.PRICE_END_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceEndOfPriceFilter(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updatePriceFilter(PimUserContext userContext, String profileId, String priceFilterId, int priceFilterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPriceFilter(userContext, profileId, priceFilterId, priceFilterVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withPriceFilterList().searchPriceFilterListWith(PriceFilter.ID_PROPERTY, "eq", priceFilterId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removePriceFilter( priceFilter );	
			//make changes to AcceleraterAccount.
			PriceFilter priceFilterIndex = createIndexedPriceFilter(priceFilterId, priceFilterVersion);
		
			PriceFilter priceFilter = profile.findThePriceFilter(priceFilterIndex);
			if(priceFilter == null){
				throw new ProfileManagerException(priceFilter+" is NOT FOUND" );
			}
			
			priceFilter.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().withPriceFilterList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingCategoryFilter(PimUserContext userContext, String profileId, String name, String internalId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfCategoryFilter(name);
		
		userContext.getChecker().checkInternalIdOfCategoryFilter(internalId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addCategoryFilter(PimUserContext userContext, String profileId, String name, String internalId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCategoryFilter(userContext,profileId,name, internalId,tokensExpr);
		
		CategoryFilter categoryFilter = createCategoryFilter(userContext,name, internalId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addCategoryFilter( categoryFilter );		
			profile = saveProfile(userContext, profile, tokens().withCategoryFilterList().done());
			
			userContext.getManagerGroup().getCategoryFilterManager().onNewInstanceCreated(userContext, categoryFilter);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCategoryFilterProperties(PimUserContext userContext, String profileId,String id,String name,String internalId,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfCategoryFilter(id);
		
		userContext.getChecker().checkNameOfCategoryFilter( name);
		userContext.getChecker().checkInternalIdOfCategoryFilter( internalId);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateCategoryFilterProperties(PimUserContext userContext, String profileId, String id,String name,String internalId, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingCategoryFilterProperties(userContext,profileId,id,name,internalId,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCategoryFilterListList()
				.searchCategoryFilterListWith(CategoryFilter.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getCategoryFilterList().isEmpty()){
			throw new ProfileManagerException("CategoryFilter is NOT FOUND with id: '"+id+"'");
		}
		
		CategoryFilter item = profileToUpdate.getCategoryFilterList().first();
		
		item.updateName( name );
		item.updateInternalId( internalId );

		
		//checkParamsForAddingCategoryFilter(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withCategoryFilterList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected CategoryFilter createCategoryFilter(PimUserContext userContext, String name, String internalId) throws Exception{

		CategoryFilter categoryFilter = new CategoryFilter();
		
		
		categoryFilter.setName(name);		
		categoryFilter.setInternalId(internalId);
	
		
		return categoryFilter;
	
		
	}
	
	protected CategoryFilter createIndexedCategoryFilter(String id, int version){

		CategoryFilter categoryFilter = new CategoryFilter();
		categoryFilter.setId(id);
		categoryFilter.setVersion(version);
		return categoryFilter;			
		
	}
	
	protected void checkParamsForRemovingCategoryFilterList(PimUserContext userContext, String profileId, 
			String categoryFilterIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String categoryFilterId: categoryFilterIds){
			userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeCategoryFilterList(PimUserContext userContext, String profileId, 
			String categoryFilterIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingCategoryFilterList(userContext, profileId,  categoryFilterIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveCategoryFilterList(profile, categoryFilterIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withCategoryFilterList().done());
				deleteRelationListInGraph(userContext, profile.getCategoryFilterList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingCategoryFilter(PimUserContext userContext, String profileId, 
		String categoryFilterId, int categoryFilterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
		userContext.getChecker().checkVersionOfCategoryFilter(categoryFilterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeCategoryFilter(PimUserContext userContext, String profileId, 
		String categoryFilterId, int categoryFilterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCategoryFilter(userContext,profileId, categoryFilterId, categoryFilterVersion,tokensExpr);
		
		CategoryFilter categoryFilter = createIndexedCategoryFilter(categoryFilterId, categoryFilterVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeCategoryFilter( categoryFilter );		
			profile = saveProfile(userContext, profile, tokens().withCategoryFilterList().done());
			deleteRelationInGraph(userContext, categoryFilter);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingCategoryFilter(PimUserContext userContext, String profileId, 
		String categoryFilterId, int categoryFilterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
		userContext.getChecker().checkVersionOfCategoryFilter(categoryFilterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyCategoryFilterFrom(PimUserContext userContext, String profileId, 
		String categoryFilterId, int categoryFilterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCategoryFilter(userContext,profileId, categoryFilterId, categoryFilterVersion,tokensExpr);
		
		CategoryFilter categoryFilter = createIndexedCategoryFilter(categoryFilterId, categoryFilterVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			profile.copyCategoryFilterFrom( categoryFilter );		
			profile = saveProfile(userContext, profile, tokens().withCategoryFilterList().done());
			
			userContext.getManagerGroup().getCategoryFilterManager().onNewInstanceCreated(userContext, (CategoryFilter)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingCategoryFilter(PimUserContext userContext, String profileId, String categoryFilterId, int categoryFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
		userContext.getChecker().checkVersionOfCategoryFilter(categoryFilterVersion);
		

		if(CategoryFilter.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfCategoryFilter(parseString(newValueExpr));
		}
		
		if(CategoryFilter.INTERNAL_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkInternalIdOfCategoryFilter(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateCategoryFilter(PimUserContext userContext, String profileId, String categoryFilterId, int categoryFilterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCategoryFilter(userContext, profileId, categoryFilterId, categoryFilterVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withCategoryFilterList().searchCategoryFilterListWith(CategoryFilter.ID_PROPERTY, "eq", categoryFilterId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeCategoryFilter( categoryFilter );	
			//make changes to AcceleraterAccount.
			CategoryFilter categoryFilterIndex = createIndexedCategoryFilter(categoryFilterId, categoryFilterVersion);
		
			CategoryFilter categoryFilter = profile.findTheCategoryFilter(categoryFilterIndex);
			if(categoryFilter == null){
				throw new ProfileManagerException(categoryFilter+" is NOT FOUND" );
			}
			
			categoryFilter.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().withCategoryFilterList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingNewProduct(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfNewProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfNewProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfNewProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfNewProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfNewProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfNewProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfNewProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfNewProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addNewProduct(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingNewProduct(userContext,profileId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId,tokensExpr);
		
		NewProduct newProduct = createNewProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addNewProduct( newProduct );		
			profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
			
			userContext.getManagerGroup().getNewProductManager().onNewInstanceCreated(userContext, newProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingNewProductProperties(PimUserContext userContext, String profileId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfNewProduct(id);
		
		userContext.getChecker().checkNameOfNewProduct( name);
		userContext.getChecker().checkProductCoverImageOfNewProduct( productCoverImage);
		userContext.getChecker().checkOriginOfNewProduct( origin);
		userContext.getChecker().checkRemarkOfNewProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateNewProductProperties(PimUserContext userContext, String profileId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingNewProductProperties(userContext,profileId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withNewProductListList()
				.searchNewProductListWith(NewProduct.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getNewProductList().isEmpty()){
			throw new ProfileManagerException("NewProduct is NOT FOUND with id: '"+id+"'");
		}
		
		NewProduct item = profileToUpdate.getNewProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingNewProduct(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withNewProductList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected NewProduct createNewProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId) throws Exception{

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
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		newProduct.setCatalog(catalog);		
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
	
	protected void checkParamsForRemovingNewProductList(PimUserContext userContext, String profileId, 
			String newProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String newProductId: newProductIds){
			userContext.getChecker().checkIdOfNewProduct(newProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeNewProductList(PimUserContext userContext, String profileId, 
			String newProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingNewProductList(userContext, profileId,  newProductIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveNewProductList(profile, newProductIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
				deleteRelationListInGraph(userContext, profile.getNewProductList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingNewProduct(PimUserContext userContext, String profileId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeNewProduct(PimUserContext userContext, String profileId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingNewProduct(userContext,profileId, newProductId, newProductVersion,tokensExpr);
		
		NewProduct newProduct = createIndexedNewProduct(newProductId, newProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeNewProduct( newProduct );		
			profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
			deleteRelationInGraph(userContext, newProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingNewProduct(PimUserContext userContext, String profileId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyNewProductFrom(PimUserContext userContext, String profileId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingNewProduct(userContext,profileId, newProductId, newProductVersion,tokensExpr);
		
		NewProduct newProduct = createIndexedNewProduct(newProductId, newProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			newProduct.updateLastUpdateTime(userContext.now());
			
			profile.copyNewProductFrom( newProduct );		
			profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
			
			userContext.getManagerGroup().getNewProductManager().onNewInstanceCreated(userContext, (NewProduct)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingNewProduct(PimUserContext userContext, String profileId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateNewProduct(PimUserContext userContext, String profileId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingNewProduct(userContext, profileId, newProductId, newProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withNewProductList().searchNewProductListWith(NewProduct.ID_PROPERTY, "eq", newProductId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeNewProduct( newProduct );	
			//make changes to AcceleraterAccount.
			NewProduct newProductIndex = createIndexedNewProduct(newProductId, newProductVersion);
		
			NewProduct newProduct = profile.findTheNewProduct(newProductIndex);
			if(newProduct == null){
				throw new ProfileManagerException(newProduct+" is NOT FOUND" );
			}
			
			newProduct.changeProperty(property, newValueExpr);
			newProduct.updateLastUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEditorPickProduct(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfEditorPickProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfEditorPickProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfEditorPickProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfEditorPickProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfEditorPickProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfEditorPickProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfEditorPickProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addEditorPickProduct(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEditorPickProduct(userContext,profileId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId,tokensExpr);
		
		EditorPickProduct editorPickProduct = createEditorPickProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addEditorPickProduct( editorPickProduct );		
			profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
			
			userContext.getManagerGroup().getEditorPickProductManager().onNewInstanceCreated(userContext, editorPickProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEditorPickProductProperties(PimUserContext userContext, String profileId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfEditorPickProduct(id);
		
		userContext.getChecker().checkNameOfEditorPickProduct( name);
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct( productCoverImage);
		userContext.getChecker().checkOriginOfEditorPickProduct( origin);
		userContext.getChecker().checkRemarkOfEditorPickProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateEditorPickProductProperties(PimUserContext userContext, String profileId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEditorPickProductProperties(userContext,profileId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEditorPickProductListList()
				.searchEditorPickProductListWith(EditorPickProduct.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getEditorPickProductList().isEmpty()){
			throw new ProfileManagerException("EditorPickProduct is NOT FOUND with id: '"+id+"'");
		}
		
		EditorPickProduct item = profileToUpdate.getEditorPickProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingEditorPickProduct(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withEditorPickProductList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EditorPickProduct createEditorPickProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId) throws Exception{

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
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		editorPickProduct.setCatalog(catalog);		
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
	
	protected void checkParamsForRemovingEditorPickProductList(PimUserContext userContext, String profileId, 
			String editorPickProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String editorPickProductId: editorPickProductIds){
			userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeEditorPickProductList(PimUserContext userContext, String profileId, 
			String editorPickProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEditorPickProductList(userContext, profileId,  editorPickProductIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveEditorPickProductList(profile, editorPickProductIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
				deleteRelationListInGraph(userContext, profile.getEditorPickProductList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEditorPickProduct(PimUserContext userContext, String profileId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeEditorPickProduct(PimUserContext userContext, String profileId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEditorPickProduct(userContext,profileId, editorPickProductId, editorPickProductVersion,tokensExpr);
		
		EditorPickProduct editorPickProduct = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeEditorPickProduct( editorPickProduct );		
			profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
			deleteRelationInGraph(userContext, editorPickProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEditorPickProduct(PimUserContext userContext, String profileId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyEditorPickProductFrom(PimUserContext userContext, String profileId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEditorPickProduct(userContext,profileId, editorPickProductId, editorPickProductVersion,tokensExpr);
		
		EditorPickProduct editorPickProduct = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			editorPickProduct.updateLastUpdateTime(userContext.now());
			
			profile.copyEditorPickProductFrom( editorPickProduct );		
			profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
			
			userContext.getManagerGroup().getEditorPickProductManager().onNewInstanceCreated(userContext, (EditorPickProduct)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEditorPickProduct(PimUserContext userContext, String profileId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateEditorPickProduct(PimUserContext userContext, String profileId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEditorPickProduct(userContext, profileId, editorPickProductId, editorPickProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEditorPickProductList().searchEditorPickProductListWith(EditorPickProduct.ID_PROPERTY, "eq", editorPickProductId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeEditorPickProduct( editorPickProduct );	
			//make changes to AcceleraterAccount.
			EditorPickProduct editorPickProductIndex = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		
			EditorPickProduct editorPickProduct = profile.findTheEditorPickProduct(editorPickProductIndex);
			if(editorPickProduct == null){
				throw new ProfileManagerException(editorPickProduct+" is NOT FOUND" );
			}
			
			editorPickProduct.changeProperty(property, newValueExpr);
			editorPickProduct.updateLastUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTopRatedProduct(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfTopRatedProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfTopRatedProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfTopRatedProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfTopRatedProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfTopRatedProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfTopRatedProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfTopRatedProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addTopRatedProduct(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTopRatedProduct(userContext,profileId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId,tokensExpr);
		
		TopRatedProduct topRatedProduct = createTopRatedProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addTopRatedProduct( topRatedProduct );		
			profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
			
			userContext.getManagerGroup().getTopRatedProductManager().onNewInstanceCreated(userContext, topRatedProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTopRatedProductProperties(PimUserContext userContext, String profileId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfTopRatedProduct(id);
		
		userContext.getChecker().checkNameOfTopRatedProduct( name);
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct( productCoverImage);
		userContext.getChecker().checkOriginOfTopRatedProduct( origin);
		userContext.getChecker().checkRemarkOfTopRatedProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateTopRatedProductProperties(PimUserContext userContext, String profileId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTopRatedProductProperties(userContext,profileId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTopRatedProductListList()
				.searchTopRatedProductListWith(TopRatedProduct.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getTopRatedProductList().isEmpty()){
			throw new ProfileManagerException("TopRatedProduct is NOT FOUND with id: '"+id+"'");
		}
		
		TopRatedProduct item = profileToUpdate.getTopRatedProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingTopRatedProduct(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withTopRatedProductList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TopRatedProduct createTopRatedProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId) throws Exception{

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
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		topRatedProduct.setCatalog(catalog);		
		topRatedProduct.setRemark(remark);		
		topRatedProduct.setLastUpdateTime(userContext.now());		
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
	
	protected void checkParamsForRemovingTopRatedProductList(PimUserContext userContext, String profileId, 
			String topRatedProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String topRatedProductId: topRatedProductIds){
			userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeTopRatedProductList(PimUserContext userContext, String profileId, 
			String topRatedProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTopRatedProductList(userContext, profileId,  topRatedProductIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveTopRatedProductList(profile, topRatedProductIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
				deleteRelationListInGraph(userContext, profile.getTopRatedProductList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTopRatedProduct(PimUserContext userContext, String profileId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeTopRatedProduct(PimUserContext userContext, String profileId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTopRatedProduct(userContext,profileId, topRatedProductId, topRatedProductVersion,tokensExpr);
		
		TopRatedProduct topRatedProduct = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeTopRatedProduct( topRatedProduct );		
			profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
			deleteRelationInGraph(userContext, topRatedProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTopRatedProduct(PimUserContext userContext, String profileId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyTopRatedProductFrom(PimUserContext userContext, String profileId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTopRatedProduct(userContext,profileId, topRatedProductId, topRatedProductVersion,tokensExpr);
		
		TopRatedProduct topRatedProduct = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			topRatedProduct.updateLastUpdateTime(userContext.now());
			
			profile.copyTopRatedProductFrom( topRatedProduct );		
			profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
			
			userContext.getManagerGroup().getTopRatedProductManager().onNewInstanceCreated(userContext, (TopRatedProduct)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTopRatedProduct(PimUserContext userContext, String profileId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateTopRatedProduct(PimUserContext userContext, String profileId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTopRatedProduct(userContext, profileId, topRatedProductId, topRatedProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTopRatedProductList().searchTopRatedProductListWith(TopRatedProduct.ID_PROPERTY, "eq", topRatedProductId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeTopRatedProduct( topRatedProduct );	
			//make changes to AcceleraterAccount.
			TopRatedProduct topRatedProductIndex = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		
			TopRatedProduct topRatedProduct = profile.findTheTopRatedProduct(topRatedProductIndex);
			if(topRatedProduct == null){
				throw new ProfileManagerException(topRatedProduct+" is NOT FOUND" );
			}
			
			topRatedProduct.changeProperty(property, newValueExpr);
			topRatedProduct.updateLastUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRecommandProduct(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfRecommandProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfRecommandProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfRecommandProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfRecommandProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfRecommandProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfRecommandProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfRecommandProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfRecommandProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addRecommandProduct(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRecommandProduct(userContext,profileId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId,tokensExpr);
		
		RecommandProduct recommandProduct = createRecommandProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addRecommandProduct( recommandProduct );		
			profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
			
			userContext.getManagerGroup().getRecommandProductManager().onNewInstanceCreated(userContext, recommandProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRecommandProductProperties(PimUserContext userContext, String profileId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfRecommandProduct(id);
		
		userContext.getChecker().checkNameOfRecommandProduct( name);
		userContext.getChecker().checkProductCoverImageOfRecommandProduct( productCoverImage);
		userContext.getChecker().checkOriginOfRecommandProduct( origin);
		userContext.getChecker().checkRemarkOfRecommandProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateRecommandProductProperties(PimUserContext userContext, String profileId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRecommandProductProperties(userContext,profileId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRecommandProductListList()
				.searchRecommandProductListWith(RecommandProduct.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getRecommandProductList().isEmpty()){
			throw new ProfileManagerException("RecommandProduct is NOT FOUND with id: '"+id+"'");
		}
		
		RecommandProduct item = profileToUpdate.getRecommandProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingRecommandProduct(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withRecommandProductList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RecommandProduct createRecommandProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId) throws Exception{

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
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		recommandProduct.setCatalog(catalog);		
		recommandProduct.setRemark(remark);		
		recommandProduct.setLastUpdateTime(userContext.now());		
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
	
	protected void checkParamsForRemovingRecommandProductList(PimUserContext userContext, String profileId, 
			String recommandProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String recommandProductId: recommandProductIds){
			userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeRecommandProductList(PimUserContext userContext, String profileId, 
			String recommandProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRecommandProductList(userContext, profileId,  recommandProductIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveRecommandProductList(profile, recommandProductIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
				deleteRelationListInGraph(userContext, profile.getRecommandProductList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRecommandProduct(PimUserContext userContext, String profileId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeRecommandProduct(PimUserContext userContext, String profileId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRecommandProduct(userContext,profileId, recommandProductId, recommandProductVersion,tokensExpr);
		
		RecommandProduct recommandProduct = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeRecommandProduct( recommandProduct );		
			profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
			deleteRelationInGraph(userContext, recommandProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRecommandProduct(PimUserContext userContext, String profileId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyRecommandProductFrom(PimUserContext userContext, String profileId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRecommandProduct(userContext,profileId, recommandProductId, recommandProductVersion,tokensExpr);
		
		RecommandProduct recommandProduct = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			recommandProduct.updateLastUpdateTime(userContext.now());
			
			profile.copyRecommandProductFrom( recommandProduct );		
			profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
			
			userContext.getManagerGroup().getRecommandProductManager().onNewInstanceCreated(userContext, (RecommandProduct)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRecommandProduct(PimUserContext userContext, String profileId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateRecommandProduct(PimUserContext userContext, String profileId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRecommandProduct(userContext, profileId, recommandProductId, recommandProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRecommandProductList().searchRecommandProductListWith(RecommandProduct.ID_PROPERTY, "eq", recommandProductId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeRecommandProduct( recommandProduct );	
			//make changes to AcceleraterAccount.
			RecommandProduct recommandProductIndex = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		
			RecommandProduct recommandProduct = profile.findTheRecommandProduct(recommandProductIndex);
			if(recommandProduct == null){
				throw new ProfileManagerException(recommandProduct+" is NOT FOUND" );
			}
			
			recommandProduct.changeProperty(property, newValueExpr);
			recommandProduct.updateLastUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(PimUserContext userContext, Profile newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


