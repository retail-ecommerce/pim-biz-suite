
package com.terapico.pim.pricefilter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface PriceFilterManager{

		

	public PriceFilter createPriceFilter(PimUserContext userContext, String name, BigDecimal priceStart, BigDecimal priceEnd, String profileId) throws Exception;	
	public PriceFilter updatePriceFilter(PimUserContext userContext,String priceFilterId, int priceFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PriceFilter loadPriceFilter(PimUserContext userContext, String priceFilterId, String [] tokensExpr) throws Exception;
	public PriceFilter internalSavePriceFilter(PimUserContext userContext, PriceFilter priceFilter) throws Exception;
	public PriceFilter internalSavePriceFilter(PimUserContext userContext, PriceFilter priceFilter,Map<String,Object>option) throws Exception;
	
	public PriceFilter transferToAnotherProfile(PimUserContext userContext, String priceFilterId, String anotherProfileId)  throws Exception;
 

	public void delete(PimUserContext userContext, String priceFilterId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, PriceFilter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


