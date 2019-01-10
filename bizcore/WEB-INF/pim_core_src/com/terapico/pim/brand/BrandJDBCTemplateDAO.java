
package com.terapico.pim.brand;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.terapico.pim.PimNamingServiceDAO;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;
import com.terapico.pim.AccessKey;
import com.terapico.pim.DateKey;
import com.terapico.pim.StatsInfo;
import com.terapico.pim.StatsItem;

import com.terapico.pim.MultipleAccessKey;
import com.terapico.pim.PimUserContext;


import com.terapico.pim.product.Product;
import com.terapico.pim.platform.Platform;

import com.terapico.pim.product.ProductDAO;
import com.terapico.pim.platform.PlatformDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class BrandJDBCTemplateDAO extends PimNamingServiceDAO implements BrandDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  ProductDAO  productDAO;
 	public void setProductDAO(ProductDAO pProductDAO){
 	
 		if(pProductDAO == null){
 			throw new IllegalStateException("Do not try to set productDAO to null.");
 		}
	 	this.productDAO = pProductDAO;
 	}
 	public ProductDAO getProductDAO(){
 		if(this.productDAO == null){
 			throw new IllegalStateException("The productDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.productDAO;
 	}	
 	
			
		

	
	/*
	protected Brand load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalBrand(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Brand load(String id,Map<String,Object> options) throws Exception{
		return loadInternalBrand(BrandTable.withId(id), options);
	}
	
	
	
	public Brand save(Brand brand,Map<String,Object> options){
		
		String methodName="save(Brand brand,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(brand, methodName, "brand");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalBrand(brand,options);
	}
	public Brand clone(String brandId, Map<String,Object> options) throws Exception{
	
		return clone(BrandTable.withId(brandId),options);
	}
	
	protected Brand clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String brandId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Brand newBrand = loadInternalBrand(accessKey, options);
		newBrand.setVersion(0);
		
		
 		
 		if(isSaveProductListEnabled(options)){
 			for(Product item: newBrand.getProductList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalBrand(newBrand,options);
		
		return newBrand;
	}
	
	
	
	

	protected void throwIfHasException(String brandId,int version,int count) throws Exception{
		if (count == 1) {
			throw new BrandVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new BrandNotFoundException(
					"The " + this.getTableName() + "(" + brandId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String brandId, int version) throws Exception{
	
		String methodName="delete(String brandId, int version)";
		assertMethodArgumentNotNull(brandId, methodName, "brandId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{brandId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(brandId,version);
		}
		
	
	}
	
	
	
	
	

	public Brand disconnectFromAll(String brandId, int version) throws Exception{
	
		
		Brand brand = loadInternalBrand(BrandTable.withId(brandId), emptyOptions());
		brand.clearFromAll();
		this.saveBrand(brand);
		return brand;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return BrandTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "brand";
	}
	@Override
	protected String getBeanName() {
		
		return "brand";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return BrandTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, BrandTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, BrandTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,BrandTokens.PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,BrandTokens.PRODUCT_LIST+".analyze");
 	}

	protected boolean isSaveProductListEnabled(Map<String,Object> options){
		return checkOptions(options, BrandTokens.PRODUCT_LIST);
		
 	}
 	
		

	

	protected BrandMapper getBrandMapper(){
		return new BrandMapper();
	}

	
	
	protected Brand extractBrand(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Brand brand = loadSingleObject(accessKey, getBrandMapper());
			return brand;
		}catch(EmptyResultDataAccessException e){
			throw new BrandNotFoundException("Brand("+accessKey+") is not found!");
		}

	}

	
	

	protected Brand loadInternalBrand(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Brand brand = extractBrand(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(brand, loadOptions);
 		}
 
		
		if(isExtractProductListEnabled(loadOptions)){
	 		extractProductList(brand, loadOptions);
 		}	
 		if(isAnalyzeProductListEnabled(loadOptions)){
	 		// analyzeProductList(brand, loadOptions);
 		}
 		
		
		return brand;
		
	}

	 

 	protected Brand extractPlatform(Brand brand, Map<String,Object> options) throws Exception{

		if(brand.getPlatform() == null){
			return brand;
		}
		String platformId = brand.getPlatform().getId();
		if( platformId == null){
			return brand;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			brand.setPlatform(platform);
		}
		
 		
 		return brand;
 	}
 		
 
		
	protected void enhanceProductList(SmartList<Product> productList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Brand extractProductList(Brand brand, Map<String,Object> options){
		
		
		if(brand == null){
			return null;
		}
		if(brand.getId() == null){
			return brand;
		}

		
		
		SmartList<Product> productList = getProductDAO().findProductByBrand(brand.getId(),options);
		if(productList != null){
			enhanceProductList(productList,options);
			brand.setProductList(productList);
		}
		
		return brand;
	
	}	
	
	protected Brand analyzeProductList(Brand brand, Map<String,Object> options){
		
		
		if(brand == null){
			return null;
		}
		if(brand.getId() == null){
			return brand;
		}

		
		
		SmartList<Product> productList = brand.getProductList();
		if(productList != null){
			getProductDAO().analyzeProductByBrand(productList, brand.getId(), options);
			
		}
		
		return brand;
	
	}	
	
		
		
  	
 	public SmartList<Brand> findBrandByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Brand> resultList = queryWith(BrandTable.COLUMN_PLATFORM, platformId, options, getBrandMapper());
		// analyzeBrandByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Brand> findBrandByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Brand> resultList =  queryWithRange(BrandTable.COLUMN_PLATFORM, platformId, options, getBrandMapper(), start, count);
 		//analyzeBrandByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeBrandByPlatform(SmartList<Brand> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countBrandByPlatform(String platformId,Map<String,Object> options){

 		return countWith(BrandTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countBrandByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(BrandTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Brand saveBrand(Brand  brand){
		
		if(!brand.isChanged()){
			return brand;
		}
		
		
		String SQL=this.getSaveBrandSQL(brand);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveBrandParameters(brand);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		brand.incVersion();
		return brand;
	
	}
	public SmartList<Brand> saveBrandList(SmartList<Brand> brandList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitBrandList(brandList);
		
		batchBrandCreate((List<Brand>)lists[CREATE_LIST_INDEX]);
		
		batchBrandUpdate((List<Brand>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Brand brand:brandList){
			if(brand.isChanged()){
				brand.incVersion();
			}
			
		
		}
		
		
		return brandList;
	}

	public SmartList<Brand> removeBrandList(SmartList<Brand> brandList,Map<String,Object> options){
		
		
		super.removeList(brandList, options);
		
		return brandList;
		
		
	}
	
	protected List<Object[]> prepareBrandBatchCreateArgs(List<Brand> brandList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Brand brand:brandList ){
			Object [] parameters = prepareBrandCreateParameters(brand);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBrandBatchUpdateArgs(List<Brand> brandList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Brand brand:brandList ){
			if(!brand.isChanged()){
				continue;
			}
			Object [] parameters = prepareBrandUpdateParameters(brand);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchBrandCreate(List<Brand> brandList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBrandBatchCreateArgs(brandList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchBrandUpdate(List<Brand> brandList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBrandBatchUpdateArgs(brandList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitBrandList(List<Brand> brandList){
		
		List<Brand> brandCreateList=new ArrayList<Brand>();
		List<Brand> brandUpdateList=new ArrayList<Brand>();
		
		for(Brand brand: brandList){
			if(isUpdateRequest(brand)){
				brandUpdateList.add( brand);
				continue;
			}
			brandCreateList.add(brand);
		}
		
		return new Object[]{brandCreateList,brandUpdateList};
	}
	
	protected boolean isUpdateRequest(Brand brand){
 		return brand.getVersion() > 0;
 	}
 	protected String getSaveBrandSQL(Brand brand){
 		if(isUpdateRequest(brand)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveBrandParameters(Brand brand){
 		if(isUpdateRequest(brand) ){
 			return prepareBrandUpdateParameters(brand);
 		}
 		return prepareBrandCreateParameters(brand);
 	}
 	protected Object[] prepareBrandUpdateParameters(Brand brand){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = brand.getBrandName();
 		parameters[1] = brand.getLogo();
 		parameters[2] = brand.getRemark(); 	
 		if(brand.getPlatform() != null){
 			parameters[3] = brand.getPlatform().getId();
 		}
 		
 		parameters[4] = brand.nextVersion();
 		parameters[5] = brand.getId();
 		parameters[6] = brand.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareBrandCreateParameters(Brand brand){
		Object[] parameters = new Object[5];
		String newBrandId=getNextId();
		brand.setId(newBrandId);
		parameters[0] =  brand.getId();
 
 		parameters[1] = brand.getBrandName();
 		parameters[2] = brand.getLogo();
 		parameters[3] = brand.getRemark(); 	
 		if(brand.getPlatform() != null){
 			parameters[4] = brand.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Brand saveInternalBrand(Brand brand, Map<String,Object> options){
		
		saveBrand(brand);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(brand, options);
 		}
 
		
		if(isSaveProductListEnabled(options)){
	 		saveProductList(brand, options);
	 		//removeProductList(brand, options);
	 		//Not delete the record
	 		
 		}		
		
		return brand;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Brand savePlatform(Brand brand, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(brand.getPlatform() == null){
 			return brand;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(brand.getPlatform(),options);
 		return brand;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Brand planToRemoveProductList(Brand brand, String productIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.BRAND_PROPERTY, brand.getId());
		key.put(Product.ID_PROPERTY, productIds);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return brand;
		}
		if(externalProductList.isEmpty()){
			return brand;
		}
		
		for(Product product: externalProductList){

			product.clearFromAll();
		}
		
		
		SmartList<Product> productList = brand.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return brand;	
	
	}


	//disconnect Brand with parent_category in Product
	public Brand planToRemoveProductListWithParentCategory(Brand brand, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.BRAND_PROPERTY, brand.getId());
		key.put(Product.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return brand;
		}
		if(externalProductList.isEmpty()){
			return brand;
		}
		
		for(Product product: externalProductList){
			product.clearParentCategory();
			product.clearBrand();
			
		}
		
		
		SmartList<Product> productList = brand.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return brand;
	}
	
	public int countProductListWithParentCategory(String brandId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.BRAND_PROPERTY, brandId);
		key.put(Product.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with catalog in Product
	public Brand planToRemoveProductListWithCatalog(Brand brand, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.BRAND_PROPERTY, brand.getId());
		key.put(Product.CATALOG_PROPERTY, catalogId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return brand;
		}
		if(externalProductList.isEmpty()){
			return brand;
		}
		
		for(Product product: externalProductList){
			product.clearCatalog();
			product.clearBrand();
			
		}
		
		
		SmartList<Product> productList = brand.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return brand;
	}
	
	public int countProductListWithCatalog(String brandId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.BRAND_PROPERTY, brandId);
		key.put(Product.CATALOG_PROPERTY, catalogId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	

		
	protected Brand saveProductList(Brand brand, Map<String,Object> options){
		
		
		
		
		SmartList<Product> productList = brand.getProductList();
		if(productList == null){
			//null list means nothing
			return brand;
		}
		SmartList<Product> mergedUpdateProductList = new SmartList<Product>();
		
		
		mergedUpdateProductList.addAll(productList); 
		if(productList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProductList.addAll(productList.getToRemoveList());
			productList.removeAll(productList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProductDAO().saveProductList(mergedUpdateProductList,options);
		
		if(productList.getToRemoveList() != null){
			productList.removeAll(productList.getToRemoveList());
		}
		
		
		return brand;
	
	}
	
	protected Brand removeProductList(Brand brand, Map<String,Object> options){
	
	
		SmartList<Product> productList = brand.getProductList();
		if(productList == null){
			return brand;
		}	
	
		SmartList<Product> toRemoveProductList = productList.getToRemoveList();
		
		if(toRemoveProductList == null){
			return brand;
		}
		if(toRemoveProductList.isEmpty()){
			return brand;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProductDAO().removeProductList(toRemoveProductList,options);
		
		return brand;
	
	}
	
	

 	
 	
	
	
	
		

	public Brand present(Brand brand,Map<String, Object> options){
	
		presentProductList(brand,options);

		return brand;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Brand presentProductList(
			Brand brand,
			Map<String, Object> options) {

		SmartList<Product> productList = brand.getProductList();		
				SmartList<Product> newList= presentSubList(brand.getId(),
				productList,
				options,
				getProductDAO()::countProductByBrand,
				getProductDAO()::findProductByBrand
				);

		
		brand.setProductList(newList);
		

		return brand;
	}			
		

	
    public SmartList<Brand> requestCandidateBrandForProduct(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(BrandTable.COLUMN_BRAND_NAME, filterKey, pageNo, pageSize, getBrandMapper());
    }
		

	protected String getTableName(){
		return BrandTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Brand> brandList) {		
		this.enhanceListInternal(brandList, this.getBrandMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Brand> brandList = ownerEntity.collectRefsWithType(Brand.INTERNAL_TYPE);
		this.enhanceList(brandList);
		
	}
	
	@Override
	public SmartList<Brand> findBrandWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getBrandMapper());

	}
	@Override
	public int countBrandWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countBrandWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Brand> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getBrandMapper());
	}
}


