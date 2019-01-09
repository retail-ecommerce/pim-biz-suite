
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
	

	//public  ProductManager getProductManager(PimUserContext userContext, String levelNCategoryId, String name, String brandId, String origin, String catalogId, String remark ,String [] tokensExpr)  throws Exception;
	
	public  LevelNCategory addProduct(PimUserContext userContext, String levelNCategoryId, String name, String brandId, String origin, String catalogId, String remark , String [] tokensExpr)  throws Exception;
	public  LevelNCategory removeProduct(PimUserContext userContext, String levelNCategoryId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  LevelNCategory updateProduct(PimUserContext userContext, String levelNCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


