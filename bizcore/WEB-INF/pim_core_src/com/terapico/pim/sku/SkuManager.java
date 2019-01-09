
package com.terapico.pim.sku;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface SkuManager{

		

	public Sku createSku(PimUserContext userContext, String name, String size, String productId, boolean active, BigDecimal basePrice) throws Exception;	
	public Sku updateSku(PimUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Sku loadSku(PimUserContext userContext, String skuId, String [] tokensExpr) throws Exception;
	public Sku internalSaveSku(PimUserContext userContext, Sku sku) throws Exception;
	public Sku internalSaveSku(PimUserContext userContext, Sku sku,Map<String,Object>option) throws Exception;
	
	public Sku transferToAnotherProduct(PimUserContext userContext, String skuId, String anotherProductId)  throws Exception;
 

	public void delete(PimUserContext userContext, String skuId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, Sku newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


