
package com.terapico.pim.recommandproduct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface RecommandProductManager{

		

	public RecommandProduct createRecommandProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId) throws Exception;	
	public RecommandProduct updateRecommandProduct(PimUserContext userContext,String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RecommandProduct loadRecommandProduct(PimUserContext userContext, String recommandProductId, String [] tokensExpr) throws Exception;
	public RecommandProduct internalSaveRecommandProduct(PimUserContext userContext, RecommandProduct recommandProduct) throws Exception;
	public RecommandProduct internalSaveRecommandProduct(PimUserContext userContext, RecommandProduct recommandProduct,Map<String,Object>option) throws Exception;
	
	public RecommandProduct transferToAnotherParentCategory(PimUserContext userContext, String recommandProductId, String anotherParentCategoryId)  throws Exception;
 	public RecommandProduct transferToAnotherBrand(PimUserContext userContext, String recommandProductId, String anotherBrandId)  throws Exception;
 	public RecommandProduct transferToAnotherCatalog(PimUserContext userContext, String recommandProductId, String anotherCatalogId)  throws Exception;
 	public RecommandProduct transferToAnotherProfile(PimUserContext userContext, String recommandProductId, String anotherProfileId)  throws Exception;
 	public RecommandProduct transferToAnotherPlatform(PimUserContext userContext, String recommandProductId, String anotherPlatformId)  throws Exception;
 

	public void delete(PimUserContext userContext, String recommandProductId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, RecommandProduct newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


