
package com.terapico.pim.platform;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;
import com.terapico.pim.MultipleAccessKey;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.product.ProductDAO;
import com.terapico.pim.site.SiteDAO;
import com.terapico.pim.catalog.CatalogDAO;
import com.terapico.pim.brand.BrandDAO;


public interface PlatformDAO{

	
	public Platform load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Platform> platformList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Platform present(Platform platform,Map<String,Object> options) throws Exception;
	public Platform clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Platform save(Platform platform,Map<String,Object> options);
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String platformId, int version) throws Exception;
	public Platform disconnectFromAll(String platformId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public SiteDAO getSiteDAO();
		
	public CatalogDAO getCatalogDAO();
		
	public BrandDAO getBrandDAO();
		
	public ProductDAO getProductDAO();
		
	
 	public SmartList<Platform> requestCandidatePlatformForSite(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForCatalog(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForBrand(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForProduct(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Platform planToRemoveSiteList(Platform platform, String siteIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveCatalogList(Platform platform, String catalogIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with seller_id in Catalog
	public Platform planToRemoveCatalogListWithSellerId(Platform platform, String sellerIdId, Map<String,Object> options)throws Exception;
	public int countCatalogListWithSellerId(String platformId, String sellerIdId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with site in Catalog
	public Platform planToRemoveCatalogListWithSite(Platform platform, String siteId, Map<String,Object> options)throws Exception;
	public int countCatalogListWithSite(String platformId, String siteId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveBrandList(Platform platform, String brandIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveProductList(Platform platform, String productIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with parent_category in Product
	public Platform planToRemoveProductListWithParentCategory(Platform platform, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countProductListWithParentCategory(String platformId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with brand in Product
	public Platform planToRemoveProductListWithBrand(Platform platform, String brandId, Map<String,Object> options)throws Exception;
	public int countProductListWithBrand(String platformId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with catalog in Product
	public Platform planToRemoveProductListWithCatalog(Platform platform, String catalogId, Map<String,Object> options)throws Exception;
	public int countProductListWithCatalog(String platformId, String catalogId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Platform> queryList(String sql, Object ... parmeters);
}


