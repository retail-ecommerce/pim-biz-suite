
package com.terapico.pim.leveltwocategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface LevelTwoCategoryManager{

		

	public LevelTwoCategory createLevelTwoCategory(PimUserContext userContext, String parentCategoryId, String displayName) throws Exception;	
	public LevelTwoCategory updateLevelTwoCategory(PimUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelTwoCategory loadLevelTwoCategory(PimUserContext userContext, String levelTwoCategoryId, String [] tokensExpr) throws Exception;
	public LevelTwoCategory internalSaveLevelTwoCategory(PimUserContext userContext, LevelTwoCategory levelTwoCategory) throws Exception;
	public LevelTwoCategory internalSaveLevelTwoCategory(PimUserContext userContext, LevelTwoCategory levelTwoCategory,Map<String,Object>option) throws Exception;
	
	public LevelTwoCategory transferToAnotherParentCategory(PimUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(PimUserContext userContext, String levelTwoCategoryId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, LevelTwoCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LevelNCategoryManager getLevelNCategoryManager(PimUserContext userContext, String levelTwoCategoryId, String displayName ,String [] tokensExpr)  throws Exception;
	
	public  LevelTwoCategory addLevelNCategory(PimUserContext userContext, String levelTwoCategoryId, String displayName , String [] tokensExpr)  throws Exception;
	public  LevelTwoCategory removeLevelNCategory(PimUserContext userContext, String levelTwoCategoryId, String levelNCategoryId, int levelNCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelTwoCategory updateLevelNCategory(PimUserContext userContext, String levelTwoCategoryId, String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


