
package com.terapico.pim.topratedproduct;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;
import com.terapico.pim.MultipleAccessKey;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.levelncategory.LevelNCategoryDAO;
import com.terapico.pim.catalog.CatalogDAO;
import com.terapico.pim.profile.ProfileDAO;
import com.terapico.pim.brand.BrandDAO;
import com.terapico.pim.platform.PlatformDAO;


public interface TopRatedProductDAO{

	
	public TopRatedProduct load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TopRatedProduct> topRatedProductList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TopRatedProduct present(TopRatedProduct topRatedProduct,Map<String,Object> options) throws Exception;
	public TopRatedProduct clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TopRatedProduct save(TopRatedProduct topRatedProduct,Map<String,Object> options);
	public SmartList<TopRatedProduct> saveTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList,Map<String,Object> options);
	public SmartList<TopRatedProduct> removeTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList,Map<String,Object> options);
	public SmartList<TopRatedProduct> findTopRatedProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTopRatedProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTopRatedProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String topRatedProductId, int version) throws Exception;
	public TopRatedProduct disconnectFromAll(String topRatedProductId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<TopRatedProduct> queryList(String sql, Object ... parmeters);
 
 	public SmartList<TopRatedProduct> findTopRatedProductByParentCategory(String levelNCategoryId, Map<String,Object> options);
 	public int countTopRatedProductByParentCategory(String levelNCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countTopRatedProductByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<TopRatedProduct> findTopRatedProductByParentCategory(String levelNCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeTopRatedProductByParentCategory(SmartList<TopRatedProduct> resultList, String levelNCategoryId, Map<String,Object> options);

 
  
 	public SmartList<TopRatedProduct> findTopRatedProductByBrand(String brandId, Map<String,Object> options);
 	public int countTopRatedProductByBrand(String brandId, Map<String,Object> options);
 	public Map<String, Integer> countTopRatedProductByBrandIds(String[] ids, Map<String,Object> options);
 	public SmartList<TopRatedProduct> findTopRatedProductByBrand(String brandId, int start, int count, Map<String,Object> options);
 	public void analyzeTopRatedProductByBrand(SmartList<TopRatedProduct> resultList, String brandId, Map<String,Object> options);

 
  
 	public SmartList<TopRatedProduct> findTopRatedProductByCatalog(String catalogId, Map<String,Object> options);
 	public int countTopRatedProductByCatalog(String catalogId, Map<String,Object> options);
 	public Map<String, Integer> countTopRatedProductByCatalogIds(String[] ids, Map<String,Object> options);
 	public SmartList<TopRatedProduct> findTopRatedProductByCatalog(String catalogId, int start, int count, Map<String,Object> options);
 	public void analyzeTopRatedProductByCatalog(SmartList<TopRatedProduct> resultList, String catalogId, Map<String,Object> options);

 
  
 	public SmartList<TopRatedProduct> findTopRatedProductByProfile(String profileId, Map<String,Object> options);
 	public int countTopRatedProductByProfile(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countTopRatedProductByProfileIds(String[] ids, Map<String,Object> options);
 	public SmartList<TopRatedProduct> findTopRatedProductByProfile(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeTopRatedProductByProfile(SmartList<TopRatedProduct> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<TopRatedProduct> findTopRatedProductByPlatform(String platformId, Map<String,Object> options);
 	public int countTopRatedProductByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countTopRatedProductByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<TopRatedProduct> findTopRatedProductByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeTopRatedProductByPlatform(SmartList<TopRatedProduct> resultList, String platformId, Map<String,Object> options);

 
 }


