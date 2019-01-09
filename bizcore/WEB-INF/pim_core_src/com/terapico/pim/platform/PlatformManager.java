
package com.terapico.pim.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(PimUserContext userContext, String name, String introduction, String currentVersion) throws Exception;	
	public Platform updatePlatform(PimUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(PimUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(PimUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(PimUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(PimUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  SiteManager getSiteManager(PimUserContext userContext, String platformId, String name, String introduction ,String [] tokensExpr)  throws Exception;
	
	public  Platform addSite(PimUserContext userContext, String platformId, String name, String introduction , String [] tokensExpr)  throws Exception;
	public  Platform removeSite(PimUserContext userContext, String platformId, String siteId, int siteVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateSite(PimUserContext userContext, String platformId, String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}

