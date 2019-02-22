
package com.terapico.pim.brandfilter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface BrandFilterManager{

		

	public BrandFilter createBrandFilter(PimUserContext userContext, String name, String internalId, String profileId) throws Exception;	
	public BrandFilter updateBrandFilter(PimUserContext userContext,String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public BrandFilter loadBrandFilter(PimUserContext userContext, String brandFilterId, String [] tokensExpr) throws Exception;
	public BrandFilter internalSaveBrandFilter(PimUserContext userContext, BrandFilter brandFilter) throws Exception;
	public BrandFilter internalSaveBrandFilter(PimUserContext userContext, BrandFilter brandFilter,Map<String,Object>option) throws Exception;
	
	public BrandFilter transferToAnotherProfile(PimUserContext userContext, String brandFilterId, String anotherProfileId)  throws Exception;
 

	public void delete(PimUserContext userContext, String brandFilterId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, BrandFilter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


