
package com.terapico.pim.site;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface SiteManager{

		

	public Site createSite(PimUserContext userContext, String name, String introduction, String platformId) throws Exception;	
	public Site updateSite(PimUserContext userContext,String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Site loadSite(PimUserContext userContext, String siteId, String [] tokensExpr) throws Exception;
	public Site internalSaveSite(PimUserContext userContext, Site site) throws Exception;
	public Site internalSaveSite(PimUserContext userContext, Site site,Map<String,Object>option) throws Exception;
	
	public Site transferToAnotherPlatform(PimUserContext userContext, String siteId, String anotherPlatformId)  throws Exception;
 

	public void delete(PimUserContext userContext, String siteId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, Site newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  CatalogManager getCatalogManager(PimUserContext userContext, String siteId, String displayName, String sellerId ,String [] tokensExpr)  throws Exception;
	
	public  Site addCatalog(PimUserContext userContext, String siteId, String displayName, String sellerId , String [] tokensExpr)  throws Exception;
	public  Site removeCatalog(PimUserContext userContext, String siteId, String catalogId, int catalogVersion,String [] tokensExpr)  throws Exception;
	public  Site updateCatalog(PimUserContext userContext, String siteId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


