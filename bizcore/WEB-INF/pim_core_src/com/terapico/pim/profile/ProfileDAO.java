
package com.terapico.pim.profile;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;
import com.terapico.pim.MultipleAccessKey;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.pricefilter.PriceFilterDAO;
import com.terapico.pim.recommandproduct.RecommandProductDAO;
import com.terapico.pim.topratedproduct.TopRatedProductDAO;
import com.terapico.pim.categoryfilter.CategoryFilterDAO;
import com.terapico.pim.newproduct.NewProductDAO;
import com.terapico.pim.brandfilter.BrandFilterDAO;
import com.terapico.pim.platform.PlatformDAO;
import com.terapico.pim.editorpickproduct.EditorPickProductDAO;


public interface ProfileDAO{

	
	public Profile load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Profile> profileList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Profile present(Profile profile,Map<String,Object> options) throws Exception;
	public Profile clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Profile save(Profile profile,Map<String,Object> options);
	public SmartList<Profile> saveProfileList(SmartList<Profile> profileList,Map<String,Object> options);
	public SmartList<Profile> removeProfileList(SmartList<Profile> profileList,Map<String,Object> options);
	public SmartList<Profile> findProfileWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProfileWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProfileWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String profileId, int version) throws Exception;
	public Profile disconnectFromAll(String profileId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public BrandFilterDAO getBrandFilterDAO();
		
	public PriceFilterDAO getPriceFilterDAO();
		
	public CategoryFilterDAO getCategoryFilterDAO();
		
	public NewProductDAO getNewProductDAO();
		
	public EditorPickProductDAO getEditorPickProductDAO();
		
	public TopRatedProductDAO getTopRatedProductDAO();
		
	public RecommandProductDAO getRecommandProductDAO();
		
	
 	public SmartList<Profile> requestCandidateProfileForBrandFilter(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Profile> requestCandidateProfileForPriceFilter(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Profile> requestCandidateProfileForCategoryFilter(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Profile> requestCandidateProfileForNewProduct(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Profile> requestCandidateProfileForEditorPickProduct(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Profile> requestCandidateProfileForTopRatedProduct(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Profile> requestCandidateProfileForRecommandProduct(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Profile planToRemoveBrandFilterList(Profile profile, String brandFilterIds[], Map<String,Object> options)throws Exception;


	//disconnect Profile with internal_id in BrandFilter
	public Profile planToRemoveBrandFilterListWithInternalId(Profile profile, String internalIdId, Map<String,Object> options)throws Exception;
	public int countBrandFilterListWithInternalId(String profileId, String internalIdId, Map<String,Object> options)throws Exception;
	
	public Profile planToRemovePriceFilterList(Profile profile, String priceFilterIds[], Map<String,Object> options)throws Exception;


	public Profile planToRemoveCategoryFilterList(Profile profile, String categoryFilterIds[], Map<String,Object> options)throws Exception;


	//disconnect Profile with internal_id in CategoryFilter
	public Profile planToRemoveCategoryFilterListWithInternalId(Profile profile, String internalIdId, Map<String,Object> options)throws Exception;
	public int countCategoryFilterListWithInternalId(String profileId, String internalIdId, Map<String,Object> options)throws Exception;
	
	public Profile planToRemoveNewProductList(Profile profile, String newProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Profile with parent_category in NewProduct
	public Profile planToRemoveNewProductListWithParentCategory(Profile profile, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithParentCategory(String profileId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Profile with brand in NewProduct
	public Profile planToRemoveNewProductListWithBrand(Profile profile, String brandId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithBrand(String profileId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Profile with catalog in NewProduct
	public Profile planToRemoveNewProductListWithCatalog(Profile profile, String catalogId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithCatalog(String profileId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Profile with platform in NewProduct
	public Profile planToRemoveNewProductListWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception;
	
	public Profile planToRemoveEditorPickProductList(Profile profile, String editorPickProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Profile with parent_category in EditorPickProduct
	public Profile planToRemoveEditorPickProductListWithParentCategory(Profile profile, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithParentCategory(String profileId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Profile with brand in EditorPickProduct
	public Profile planToRemoveEditorPickProductListWithBrand(Profile profile, String brandId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithBrand(String profileId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Profile with catalog in EditorPickProduct
	public Profile planToRemoveEditorPickProductListWithCatalog(Profile profile, String catalogId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithCatalog(String profileId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Profile with platform in EditorPickProduct
	public Profile planToRemoveEditorPickProductListWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception;
	
	public Profile planToRemoveTopRatedProductList(Profile profile, String topRatedProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Profile with parent_category in TopRatedProduct
	public Profile planToRemoveTopRatedProductListWithParentCategory(Profile profile, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithParentCategory(String profileId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Profile with brand in TopRatedProduct
	public Profile planToRemoveTopRatedProductListWithBrand(Profile profile, String brandId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithBrand(String profileId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Profile with catalog in TopRatedProduct
	public Profile planToRemoveTopRatedProductListWithCatalog(Profile profile, String catalogId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithCatalog(String profileId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Profile with platform in TopRatedProduct
	public Profile planToRemoveTopRatedProductListWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception;
	
	public Profile planToRemoveRecommandProductList(Profile profile, String recommandProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Profile with parent_category in RecommandProduct
	public Profile planToRemoveRecommandProductListWithParentCategory(Profile profile, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithParentCategory(String profileId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Profile with brand in RecommandProduct
	public Profile planToRemoveRecommandProductListWithBrand(Profile profile, String brandId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithBrand(String profileId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Profile with catalog in RecommandProduct
	public Profile planToRemoveRecommandProductListWithCatalog(Profile profile, String catalogId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithCatalog(String profileId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Profile with platform in RecommandProduct
	public Profile planToRemoveRecommandProductListWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Profile> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Profile> findProfileByPlatform(String platformId, Map<String,Object> options);
 	public int countProfileByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countProfileByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Profile> findProfileByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeProfileByPlatform(SmartList<Profile> resultList, String platformId, Map<String,Object> options);

 
 }


