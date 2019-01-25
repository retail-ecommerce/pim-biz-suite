
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
	

	//public  ProductManager getProductManager(PimUserContext userContext, String brandId, String name, String parentCategoryId, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Brand addProduct(PimUserContext userContext, String brandId, String name, String parentCategoryId, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Brand removeProduct(PimUserContext userContext, String brandId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateProduct(PimUserContext userContext, String brandId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


