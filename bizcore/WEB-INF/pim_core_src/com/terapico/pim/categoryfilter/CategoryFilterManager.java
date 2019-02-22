
package com.terapico.pim.categoryfilter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface CategoryFilterManager{

		

	public CategoryFilter createCategoryFilter(PimUserContext userContext, String name, String internalId, String profileId) throws Exception;	
	public CategoryFilter updateCategoryFilter(PimUserContext userContext,String categoryFilterId, int categoryFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CategoryFilter loadCategoryFilter(PimUserContext userContext, String categoryFilterId, String [] tokensExpr) throws Exception;
	public CategoryFilter internalSaveCategoryFilter(PimUserContext userContext, CategoryFilter categoryFilter) throws Exception;
	public CategoryFilter internalSaveCategoryFilter(PimUserContext userContext, CategoryFilter categoryFilter,Map<String,Object>option) throws Exception;
	
	public CategoryFilter transferToAnotherProfile(PimUserContext userContext, String categoryFilterId, String anotherProfileId)  throws Exception;
 

	public void delete(PimUserContext userContext, String categoryFilterId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, CategoryFilter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


