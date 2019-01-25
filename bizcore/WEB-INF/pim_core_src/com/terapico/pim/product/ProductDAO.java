
package com.terapico.pim.product;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;
import com.terapico.pim.MultipleAccessKey;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.levelncategory.LevelNCategoryDAO;
import com.terapico.pim.catalog.CatalogDAO;
import com.terapico.pim.sku.SkuDAO;
import com.terapico.pim.brand.BrandDAO;
import com.terapico.pim.platform.PlatformDAO;


public interface ProductDAO{

	
	public Product load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Product> productList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Product present(Product product,Map<String,Object> options) throws Exception;
	public Product clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Product save(Product product,Map<String,Object> options);
	public SmartList<Product> saveProductList(SmartList<Product> productList,Map<String,Object> options);
	public SmartList<Product> removeProductList(SmartList<Product> productList,Map<String,Object> options);
	public SmartList<Product> findProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String productId, int version) throws Exception;
	public Product disconnectFromAll(String productId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public SkuDAO getSkuDAO();
		
	
 	public SmartList<Product> requestCandidateProductForSku(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Product planToRemoveSkuList(Product product, String skuIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Product> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Product> findProductByParentCategory(String levelNCategoryId, Map<String,Object> options);
 	public int countProductByParentCategory(String levelNCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countProductByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<Product> findProductByParentCategory(String levelNCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeProductByParentCategory(SmartList<Product> resultList, String levelNCategoryId, Map<String,Object> options);

 
  
 	public SmartList<Product> findProductByBrand(String brandId, Map<String,Object> options);
 	public int countProductByBrand(String brandId, Map<String,Object> options);
 	public Map<String, Integer> countProductByBrandIds(String[] ids, Map<String,Object> options);
 	public SmartList<Product> findProductByBrand(String brandId, int start, int count, Map<String,Object> options);
 	public void analyzeProductByBrand(SmartList<Product> resultList, String brandId, Map<String,Object> options);

 
  
 	public SmartList<Product> findProductByCatalog(String catalogId, Map<String,Object> options);
 	public int countProductByCatalog(String catalogId, Map<String,Object> options);
 	public Map<String, Integer> countProductByCatalogIds(String[] ids, Map<String,Object> options);
 	public SmartList<Product> findProductByCatalog(String catalogId, int start, int count, Map<String,Object> options);
 	public void analyzeProductByCatalog(SmartList<Product> resultList, String catalogId, Map<String,Object> options);

 
  
 	public SmartList<Product> findProductByPlatform(String platformId, Map<String,Object> options);
 	public int countProductByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countProductByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Product> findProductByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeProductByPlatform(SmartList<Product> resultList, String platformId, Map<String,Object> options);

 
 }


