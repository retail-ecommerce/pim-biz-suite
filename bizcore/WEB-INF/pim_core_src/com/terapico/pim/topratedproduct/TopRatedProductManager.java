
package com.terapico.pim.topratedproduct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface TopRatedProductManager{

		

	public TopRatedProduct createTopRatedProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId) throws Exception;	
	public TopRatedProduct updateTopRatedProduct(PimUserContext userContext,String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TopRatedProduct loadTopRatedProduct(PimUserContext userContext, String topRatedProductId, String [] tokensExpr) throws Exception;
	public TopRatedProduct internalSaveTopRatedProduct(PimUserContext userContext, TopRatedProduct topRatedProduct) throws Exception;
	public TopRatedProduct internalSaveTopRatedProduct(PimUserContext userContext, TopRatedProduct topRatedProduct,Map<String,Object>option) throws Exception;
	
	public TopRatedProduct transferToAnotherParentCategory(PimUserContext userContext, String topRatedProductId, String anotherParentCategoryId)  throws Exception;
 	public TopRatedProduct transferToAnotherBrand(PimUserContext userContext, String topRatedProductId, String anotherBrandId)  throws Exception;
 	public TopRatedProduct transferToAnotherCatalog(PimUserContext userContext, String topRatedProductId, String anotherCatalogId)  throws Exception;
 	public TopRatedProduct transferToAnotherProfile(PimUserContext userContext, String topRatedProductId, String anotherProfileId)  throws Exception;
 	public TopRatedProduct transferToAnotherPlatform(PimUserContext userContext, String topRatedProductId, String anotherPlatformId)  throws Exception;
 

	public void delete(PimUserContext userContext, String topRatedProductId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, TopRatedProduct newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


