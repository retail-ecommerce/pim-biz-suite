
package com.terapico.pim.levelncategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface LevelNCategoryManager{

		

	public LevelNCategory createLevelNCategory(PimUserContext userContext, String parentCategoryId, String name) throws Exception;	
	public LevelNCategory updateLevelNCategory(PimUserContext userContext,String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelNCategory loadLevelNCategory(PimUserContext userContext, String levelNCategoryId, String [] tokensExpr) throws Exception;
	public LevelNCategory internalSaveLevelNCategory(PimUserContext userContext, LevelNCategory levelNCategory) throws Exception;
	public LevelNCategory internalSaveLevelNCategory(PimUserContext userContext, LevelNCategory levelNCategory,Map<String,Object>option) throws Exception;
	
	public LevelNCategory transferToAnotherParentCategory(PimUserContext userContext, String levelNCategoryId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(PimUserContext userContext, String levelNCategoryId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, LevelNCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ProductManager getProductManager(PimUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  LevelNCategory addProduct(PimUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  LevelNCategory removeProduct(PimUserContext userContext, String levelNCategoryId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  LevelNCategory updateProduct(PimUserContext userContext, String levelNCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  NewProductManager getNewProductManager(PimUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  LevelNCategory addNewProduct(PimUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  LevelNCategory removeNewProduct(PimUserContext userContext, String levelNCategoryId, String newProductId, int newProductVersion,String [] tokensExpr)  throws Exception;
	public  LevelNCategory updateNewProduct(PimUserContext userContext, String levelNCategoryId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EditorPickProductManager getEditorPickProductManager(PimUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  LevelNCategory addEditorPickProduct(PimUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  LevelNCategory removeEditorPickProduct(PimUserContext userContext, String levelNCategoryId, String editorPickProductId, int editorPickProductVersion,String [] tokensExpr)  throws Exception;
	public  LevelNCategory updateEditorPickProduct(PimUserContext userContext, String levelNCategoryId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TopRatedProductManager getTopRatedProductManager(PimUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  LevelNCategory addTopRatedProduct(PimUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId , String [] tokensExpr)  throws Exception;
	public  LevelNCategory removeTopRatedProduct(PimUserContext userContext, String levelNCategoryId, String topRatedProductId, int topRatedProductVersion,String [] tokensExpr)  throws Exception;
	public  LevelNCategory updateTopRatedProduct(PimUserContext userContext, String levelNCategoryId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RecommandProductManager getRecommandProductManager(PimUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  LevelNCategory addRecommandProduct(PimUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId , String [] tokensExpr)  throws Exception;
	public  LevelNCategory removeRecommandProduct(PimUserContext userContext, String levelNCategoryId, String recommandProductId, int recommandProductVersion,String [] tokensExpr)  throws Exception;
	public  LevelNCategory updateRecommandProduct(PimUserContext userContext, String levelNCategoryId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


