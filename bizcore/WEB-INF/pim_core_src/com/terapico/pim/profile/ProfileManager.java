
package com.terapico.pim.profile;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface ProfileManager{

		

	public Profile createProfile(PimUserContext userContext, String name, String platformId) throws Exception;	
	public Profile updateProfile(PimUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Profile loadProfile(PimUserContext userContext, String profileId, String [] tokensExpr) throws Exception;
	public Profile internalSaveProfile(PimUserContext userContext, Profile profile) throws Exception;
	public Profile internalSaveProfile(PimUserContext userContext, Profile profile,Map<String,Object>option) throws Exception;
	
	public Profile transferToAnotherPlatform(PimUserContext userContext, String profileId, String anotherPlatformId)  throws Exception;
 

	public void delete(PimUserContext userContext, String profileId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, Profile newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  BrandFilterManager getBrandFilterManager(PimUserContext userContext, String profileId, String name, String internalId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addBrandFilter(PimUserContext userContext, String profileId, String name, String internalId , String [] tokensExpr)  throws Exception;
	public  Profile removeBrandFilter(PimUserContext userContext, String profileId, String brandFilterId, int brandFilterVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateBrandFilter(PimUserContext userContext, String profileId, String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PriceFilterManager getPriceFilterManager(PimUserContext userContext, String profileId, String name, BigDecimal priceStart, BigDecimal priceEnd ,String [] tokensExpr)  throws Exception;
	
	public  Profile addPriceFilter(PimUserContext userContext, String profileId, String name, BigDecimal priceStart, BigDecimal priceEnd , String [] tokensExpr)  throws Exception;
	public  Profile removePriceFilter(PimUserContext userContext, String profileId, String priceFilterId, int priceFilterVersion,String [] tokensExpr)  throws Exception;
	public  Profile updatePriceFilter(PimUserContext userContext, String profileId, String priceFilterId, int priceFilterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CategoryFilterManager getCategoryFilterManager(PimUserContext userContext, String profileId, String name, String internalId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addCategoryFilter(PimUserContext userContext, String profileId, String name, String internalId , String [] tokensExpr)  throws Exception;
	public  Profile removeCategoryFilter(PimUserContext userContext, String profileId, String categoryFilterId, int categoryFilterVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateCategoryFilter(PimUserContext userContext, String profileId, String categoryFilterId, int categoryFilterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  NewProductManager getNewProductManager(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addNewProduct(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Profile removeNewProduct(PimUserContext userContext, String profileId, String newProductId, int newProductVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateNewProduct(PimUserContext userContext, String profileId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EditorPickProductManager getEditorPickProductManager(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addEditorPickProduct(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Profile removeEditorPickProduct(PimUserContext userContext, String profileId, String editorPickProductId, int editorPickProductVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateEditorPickProduct(PimUserContext userContext, String profileId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TopRatedProductManager getTopRatedProductManager(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addTopRatedProduct(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Profile removeTopRatedProduct(PimUserContext userContext, String profileId, String topRatedProductId, int topRatedProductVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateTopRatedProduct(PimUserContext userContext, String profileId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RecommandProductManager getRecommandProductManager(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addRecommandProduct(PimUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Profile removeRecommandProduct(PimUserContext userContext, String profileId, String recommandProductId, int recommandProductVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateRecommandProduct(PimUserContext userContext, String profileId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


