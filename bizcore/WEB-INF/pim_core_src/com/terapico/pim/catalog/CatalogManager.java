
package com.terapico.pim.catalog;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface CatalogManager{

		

	public Catalog createCatalog(PimUserContext userContext, String name, String sellerId, String siteId, String platformId) throws Exception;	
	public Catalog updateCatalog(PimUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Catalog loadCatalog(PimUserContext userContext, String catalogId, String [] tokensExpr) throws Exception;
	public Catalog internalSaveCatalog(PimUserContext userContext, Catalog catalog) throws Exception;
	public Catalog internalSaveCatalog(PimUserContext userContext, Catalog catalog,Map<String,Object>option) throws Exception;
	
	public Catalog transferToAnotherSite(PimUserContext userContext, String catalogId, String anotherSiteId)  throws Exception;
 	public Catalog transferToAnotherPlatform(PimUserContext userContext, String catalogId, String anotherPlatformId)  throws Exception;
 

	public void delete(PimUserContext userContext, String catalogId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, Catalog newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LevelOneCategoryManager getLevelOneCategoryManager(PimUserContext userContext, String catalogId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Catalog addLevelOneCategory(PimUserContext userContext, String catalogId, String name , String [] tokensExpr)  throws Exception;
	public  Catalog removeLevelOneCategory(PimUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateLevelOneCategory(PimUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProductManager getProductManager(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String origin, String remark ,String [] tokensExpr)  throws Exception;
	
	public  Catalog addProduct(PimUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String origin, String remark , String [] tokensExpr)  throws Exception;
	public  Catalog removeProduct(PimUserContext userContext, String catalogId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateProduct(PimUserContext userContext, String catalogId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


