
package com.terapico.pim.product;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface ProductManager{

		

	public Product createProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String origin, String catalogId, String remark) throws Exception;	
	public Product updateProduct(PimUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Product loadProduct(PimUserContext userContext, String productId, String [] tokensExpr) throws Exception;
	public Product internalSaveProduct(PimUserContext userContext, Product product) throws Exception;
	public Product internalSaveProduct(PimUserContext userContext, Product product,Map<String,Object>option) throws Exception;
	
	public Product transferToAnotherParentCategory(PimUserContext userContext, String productId, String anotherParentCategoryId)  throws Exception;
 	public Product transferToAnotherBrand(PimUserContext userContext, String productId, String anotherBrandId)  throws Exception;
 	public Product transferToAnotherCatalog(PimUserContext userContext, String productId, String anotherCatalogId)  throws Exception;
 

	public void delete(PimUserContext userContext, String productId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, Product newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  SkuManager getSkuManager(PimUserContext userContext, String productId, String name, String size, boolean active, BigDecimal basePrice ,String [] tokensExpr)  throws Exception;
	
	public  Product addSku(PimUserContext userContext, String productId, String name, String size, boolean active, BigDecimal basePrice , String [] tokensExpr)  throws Exception;
	public  Product removeSku(PimUserContext userContext, String productId, String skuId, int skuVersion,String [] tokensExpr)  throws Exception;
	public  Product updateSku(PimUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


