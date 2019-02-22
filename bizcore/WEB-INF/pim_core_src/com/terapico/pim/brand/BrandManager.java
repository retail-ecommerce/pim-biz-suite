
package com.terapico.pim.brand;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface BrandManager{

		

	public Brand createBrand(PimUserContext userContext, String brandName, String logo, String remark, String platformId) throws Exception;	
	public Brand updateBrand(PimUserContext userContext,String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Brand loadBrand(PimUserContext userContext, String brandId, String [] tokensExpr) throws Exception;
	public Brand internalSaveBrand(PimUserContext userContext, Brand brand) throws Exception;
	public Brand internalSaveBrand(PimUserContext userContext, Brand brand,Map<String,Object>option) throws Exception;
	
	public Brand transferToAnotherPlatform(PimUserContext userContext, String brandId, String anotherPlatformId)  throws Exception;
 

	public void delete(PimUserContext userContext, String brandId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, Brand newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ProductManager getProductManager(PimUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Brand addProduct(PimUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Brand removeProduct(PimUserContext userContext, String brandId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateProduct(PimUserContext userContext, String brandId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  NewProductManager getNewProductManager(PimUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Brand addNewProduct(PimUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Brand removeNewProduct(PimUserContext userContext, String brandId, String newProductId, int newProductVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateNewProduct(PimUserContext userContext, String brandId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EditorPickProductManager getEditorPickProductManager(PimUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Brand addEditorPickProduct(PimUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Brand removeEditorPickProduct(PimUserContext userContext, String brandId, String editorPickProductId, int editorPickProductVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateEditorPickProduct(PimUserContext userContext, String brandId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TopRatedProductManager getTopRatedProductManager(PimUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Brand addTopRatedProduct(PimUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId , String [] tokensExpr)  throws Exception;
	public  Brand removeTopRatedProduct(PimUserContext userContext, String brandId, String topRatedProductId, int topRatedProductVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateTopRatedProduct(PimUserContext userContext, String brandId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RecommandProductManager getRecommandProductManager(PimUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Brand addRecommandProduct(PimUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId , String [] tokensExpr)  throws Exception;
	public  Brand removeRecommandProduct(PimUserContext userContext, String brandId, String recommandProductId, int recommandProductVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateRecommandProduct(PimUserContext userContext, String brandId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


