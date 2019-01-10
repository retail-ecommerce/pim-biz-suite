
package com.terapico.pim.site;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;
import com.terapico.pim.MultipleAccessKey;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.catalog.CatalogDAO;
import com.terapico.pim.platform.PlatformDAO;


public interface SiteDAO{

	
	public Site load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Site> siteList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Site present(Site site,Map<String,Object> options) throws Exception;
	public Site clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Site save(Site site,Map<String,Object> options);
	public SmartList<Site> saveSiteList(SmartList<Site> siteList,Map<String,Object> options);
	public SmartList<Site> removeSiteList(SmartList<Site> siteList,Map<String,Object> options);
	public SmartList<Site> findSiteWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSiteWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSiteWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String siteId, int version) throws Exception;
	public Site disconnectFromAll(String siteId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public CatalogDAO getCatalogDAO();
		
	
 	public SmartList<Site> requestCandidateSiteForCatalog(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Site planToRemoveCatalogList(Site site, String catalogIds[], Map<String,Object> options)throws Exception;


	//disconnect Site with seller_id in Catalog
	public Site planToRemoveCatalogListWithSellerId(Site site, String sellerIdId, Map<String,Object> options)throws Exception;
	public int countCatalogListWithSellerId(String siteId, String sellerIdId, Map<String,Object> options)throws Exception;
	
	//disconnect Site with platform in Catalog
	public Site planToRemoveCatalogListWithPlatform(Site site, String platformId, Map<String,Object> options)throws Exception;
	public int countCatalogListWithPlatform(String siteId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Site> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Site> findSiteByPlatform(String platformId, Map<String,Object> options);
 	public int countSiteByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countSiteByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Site> findSiteByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeSiteByPlatform(SmartList<Site> resultList, String platformId, Map<String,Object> options);

 
 }


