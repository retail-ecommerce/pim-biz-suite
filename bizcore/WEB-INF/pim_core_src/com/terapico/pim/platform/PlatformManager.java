
package com.terapico.pim.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(PimUserContext userContext, String name, String introduction, String currentVersion) throws Exception;	
	public Platform updatePlatform(PimUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(PimUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(PimUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(PimUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(PimUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  SiteManager getSiteManager(PimUserContext userContext, String platformId, String name, String introduction ,String [] tokensExpr)  throws Exception;
	
	public  Platform addSite(PimUserContext userContext, String platformId, String name, String introduction , String [] tokensExpr)  throws Exception;
	public  Platform removeSite(PimUserContext userContext, String platformId, String siteId, int siteVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateSite(PimUserContext userContext, String platformId, String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CatalogManager getCatalogManager(PimUserContext userContext, String platformId, String name, String sellerId, String siteId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addCatalog(PimUserContext userContext, String platformId, String name, String sellerId, String siteId , String [] tokensExpr)  throws Exception;
	public  Platform removeCatalog(PimUserContext userContext, String platformId, String catalogId, int catalogVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateCatalog(PimUserContext userContext, String platformId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  BrandManager getBrandManager(PimUserContext userContext, String platformId, String brandName, String logo, String remark ,String [] tokensExpr)  throws Exception;
	
	public  Platform addBrand(PimUserContext userContext, String platformId, String brandName, String logo, String remark , String [] tokensExpr)  throws Exception;
	public  Platform removeBrand(PimUserContext userContext, String platformId, String brandId, int brandVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateBrand(PimUserContext userContext, String platformId, String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProductManager getProductManager(PimUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProduct(PimUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark , String [] tokensExpr)  throws Exception;
	public  Platform removeProduct(PimUserContext userContext, String platformId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateProduct(PimUserContext userContext, String platformId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProfileManager getProfileManager(PimUserContext userContext, String platformId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProfile(PimUserContext userContext, String platformId, String name , String [] tokensExpr)  throws Exception;
	public  Platform removeProfile(PimUserContext userContext, String platformId, String profileId, int profileVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateProfile(PimUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  NewProductManager getNewProductManager(PimUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark ,String [] tokensExpr)  throws Exception;
	
	public  Platform addNewProduct(PimUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark , String [] tokensExpr)  throws Exception;
	public  Platform removeNewProduct(PimUserContext userContext, String platformId, String newProductId, int newProductVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateNewProduct(PimUserContext userContext, String platformId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EditorPickProductManager getEditorPickProductManager(PimUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark ,String [] tokensExpr)  throws Exception;
	
	public  Platform addEditorPickProduct(PimUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark , String [] tokensExpr)  throws Exception;
	public  Platform removeEditorPickProduct(PimUserContext userContext, String platformId, String editorPickProductId, int editorPickProductVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateEditorPickProduct(PimUserContext userContext, String platformId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TopRatedProductManager getTopRatedProductManager(PimUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addTopRatedProduct(PimUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId , String [] tokensExpr)  throws Exception;
	public  Platform removeTopRatedProduct(PimUserContext userContext, String platformId, String topRatedProductId, int topRatedProductVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateTopRatedProduct(PimUserContext userContext, String platformId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RecommandProductManager getRecommandProductManager(PimUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addRecommandProduct(PimUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId , String [] tokensExpr)  throws Exception;
	public  Platform removeRecommandProduct(PimUserContext userContext, String platformId, String recommandProductId, int recommandProductVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateRecommandProduct(PimUserContext userContext, String platformId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


