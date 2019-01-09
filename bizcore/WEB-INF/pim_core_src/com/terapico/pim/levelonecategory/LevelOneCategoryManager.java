
package com.terapico.pim.levelonecategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface LevelOneCategoryManager{

		

	public LevelOneCategory createLevelOneCategory(PimUserContext userContext, String catalogId, String name) throws Exception;	
	public LevelOneCategory updateLevelOneCategory(PimUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelOneCategory loadLevelOneCategory(PimUserContext userContext, String levelOneCategoryId, String [] tokensExpr) throws Exception;
	public LevelOneCategory internalSaveLevelOneCategory(PimUserContext userContext, LevelOneCategory levelOneCategory) throws Exception;
	public LevelOneCategory internalSaveLevelOneCategory(PimUserContext userContext, LevelOneCategory levelOneCategory,Map<String,Object>option) throws Exception;
	
	public LevelOneCategory transferToAnotherCatalog(PimUserContext userContext, String levelOneCategoryId, String anotherCatalogId)  throws Exception;
 

	public void delete(PimUserContext userContext, String levelOneCategoryId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, LevelOneCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LevelTwoCategoryManager getLevelTwoCategoryManager(PimUserContext userContext, String levelOneCategoryId, String name ,String [] tokensExpr)  throws Exception;
	
	public  LevelOneCategory addLevelTwoCategory(PimUserContext userContext, String levelOneCategoryId, String name , String [] tokensExpr)  throws Exception;
	public  LevelOneCategory removeLevelTwoCategory(PimUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelOneCategory updateLevelTwoCategory(PimUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


