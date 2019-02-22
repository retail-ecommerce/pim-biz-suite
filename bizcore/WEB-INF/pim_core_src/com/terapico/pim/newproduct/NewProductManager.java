
package com.terapico.pim.newproduct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface NewProductManager{

		

	public NewProduct createNewProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId) throws Exception;	
	public NewProduct updateNewProduct(PimUserContext userContext,String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public NewProduct loadNewProduct(PimUserContext userContext, String newProductId, String [] tokensExpr) throws Exception;
	public NewProduct internalSaveNewProduct(PimUserContext userContext, NewProduct newProduct) throws Exception;
	public NewProduct internalSaveNewProduct(PimUserContext userContext, NewProduct newProduct,Map<String,Object>option) throws Exception;
	
	public NewProduct transferToAnotherParentCategory(PimUserContext userContext, String newProductId, String anotherParentCategoryId)  throws Exception;
 	public NewProduct transferToAnotherBrand(PimUserContext userContext, String newProductId, String anotherBrandId)  throws Exception;
 	public NewProduct transferToAnotherCatalog(PimUserContext userContext, String newProductId, String anotherCatalogId)  throws Exception;
 	public NewProduct transferToAnotherProfile(PimUserContext userContext, String newProductId, String anotherProfileId)  throws Exception;
 	public NewProduct transferToAnotherPlatform(PimUserContext userContext, String newProductId, String anotherPlatformId)  throws Exception;
 

	public void delete(PimUserContext userContext, String newProductId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, NewProduct newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


