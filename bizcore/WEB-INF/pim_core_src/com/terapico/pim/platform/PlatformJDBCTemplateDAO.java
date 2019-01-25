
package com.terapico.pim.platform;

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


import com.terapico.pim.site.Site;
import com.terapico.pim.product.Product;
import com.terapico.pim.catalog.Catalog;
import com.terapico.pim.brand.Brand;

import com.terapico.pim.product.ProductDAO;
import com.terapico.pim.site.SiteDAO;
import com.terapico.pim.catalog.CatalogDAO;
import com.terapico.pim.brand.BrandDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class PlatformJDBCTemplateDAO extends PimNamingServiceDAO implements PlatformDAO{


			
		
	
  	private  SiteDAO  siteDAO;
 	public void setSiteDAO(SiteDAO pSiteDAO){
 	
 		if(pSiteDAO == null){
 			throw new IllegalStateException("Do not try to set siteDAO to null.");
 		}
	 	this.siteDAO = pSiteDAO;
 	}
 	public SiteDAO getSiteDAO(){
 		if(this.siteDAO == null){
 			throw new IllegalStateException("The siteDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.siteDAO;
 	}	
 	
			
		
	
  	private  CatalogDAO  catalogDAO;
 	public void setCatalogDAO(CatalogDAO pCatalogDAO){
 	
 		if(pCatalogDAO == null){
 			throw new IllegalStateException("Do not try to set catalogDAO to null.");
 		}
	 	this.catalogDAO = pCatalogDAO;
 	}
 	public CatalogDAO getCatalogDAO(){
 		if(this.catalogDAO == null){
 			throw new IllegalStateException("The catalogDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.catalogDAO;
 	}	
 	
			
		
	
  	private  BrandDAO  brandDAO;
 	public void setBrandDAO(BrandDAO pBrandDAO){
 	
 		if(pBrandDAO == null){
 			throw new IllegalStateException("Do not try to set brandDAO to null.");
 		}
	 	this.brandDAO = pBrandDAO;
 	}
 	public BrandDAO getBrandDAO(){
 		if(this.brandDAO == null){
 			throw new IllegalStateException("The brandDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.brandDAO;
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
	protected Platform load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Platform load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(PlatformTable.withId(id), options);
	}
	
	
	
	public Platform save(Platform platform,Map<String,Object> options){
		
		String methodName="save(Platform platform,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(platform, methodName, "platform");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPlatform(platform,options);
	}
	public Platform clone(String platformId, Map<String,Object> options) throws Exception{
	
		return clone(PlatformTable.withId(platformId),options);
	}
	
	protected Platform clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String platformId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Platform newPlatform = loadInternalPlatform(accessKey, options);
		newPlatform.setVersion(0);
		
		
 		
 		if(isSaveSiteListEnabled(options)){
 			for(Site item: newPlatform.getSiteList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCatalogListEnabled(options)){
 			for(Catalog item: newPlatform.getCatalogList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveBrandListEnabled(options)){
 			for(Brand item: newPlatform.getBrandList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveProductListEnabled(options)){
 			for(Product item: newPlatform.getProductList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPlatform(newPlatform,options);
		
		return newPlatform;
	}
	
	
	
	

	protected void throwIfHasException(String platformId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PlatformVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PlatformNotFoundException(
					"The " + this.getTableName() + "(" + platformId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String platformId, int version) throws Exception{
	
		String methodName="delete(String platformId, int version)";
		assertMethodArgumentNotNull(platformId, methodName, "platformId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{platformId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(platformId,version);
		}
		
	
	}
	
	
	
	
	

	public Platform disconnectFromAll(String platformId, int version) throws Exception{
	
		
		Platform platform = loadInternalPlatform(PlatformTable.withId(platformId), emptyOptions());
		platform.clearFromAll();
		this.savePlatform(platform);
		return platform;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PlatformTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "platform";
	}
	@Override
	protected String getBeanName() {
		
		return "platform";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PlatformTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractSiteListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.SITE_LIST);
 	}
 	protected boolean isAnalyzeSiteListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.SITE_LIST+".analyze");
 	}
	
	protected boolean isSaveSiteListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.SITE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractCatalogListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.CATALOG_LIST);
 	}
 	protected boolean isAnalyzeCatalogListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.CATALOG_LIST+".analyze");
 	}
	
	protected boolean isSaveCatalogListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.CATALOG_LIST);
		
 	}
 	
		
	
	protected boolean isExtractBrandListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.BRAND_LIST);
 	}
 	protected boolean isAnalyzeBrandListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.BRAND_LIST+".analyze");
 	}
	
	protected boolean isSaveBrandListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.BRAND_LIST);
		
 	}
 	
		
	
	protected boolean isExtractProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveProductListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.PRODUCT_LIST);
		
 	}
 	
		

	

	protected PlatformMapper getPlatformMapper(){
		return new PlatformMapper();
	}

	
	
	protected Platform extractPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Platform platform = loadSingleObject(accessKey, getPlatformMapper());
			return platform;
		}catch(EmptyResultDataAccessException e){
			throw new PlatformNotFoundException("Platform("+accessKey+") is not found!");
		}

	}

	
	

	protected Platform loadInternalPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Platform platform = extractPlatform(accessKey, loadOptions);

		
		if(isExtractSiteListEnabled(loadOptions)){
	 		extractSiteList(platform, loadOptions);
 		}	
 		if(isAnalyzeSiteListEnabled(loadOptions)){
	 		analyzeSiteList(platform, loadOptions);
 		}
 		
		
		if(isExtractCatalogListEnabled(loadOptions)){
	 		extractCatalogList(platform, loadOptions);
 		}	
 		if(isAnalyzeCatalogListEnabled(loadOptions)){
	 		analyzeCatalogList(platform, loadOptions);
 		}
 		
		
		if(isExtractBrandListEnabled(loadOptions)){
	 		extractBrandList(platform, loadOptions);
 		}	
 		if(isAnalyzeBrandListEnabled(loadOptions)){
	 		analyzeBrandList(platform, loadOptions);
 		}
 		
		
		if(isExtractProductListEnabled(loadOptions)){
	 		extractProductList(platform, loadOptions);
 		}	
 		if(isAnalyzeProductListEnabled(loadOptions)){
	 		analyzeProductList(platform, loadOptions);
 		}
 		
		
		return platform;
		
	}

	
		
	protected void enhanceSiteList(SmartList<Site> siteList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractSiteList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Site> siteList = getSiteDAO().findSiteByPlatform(platform.getId(),options);
		if(siteList != null){
			enhanceSiteList(siteList,options);
			platform.setSiteList(siteList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeSiteList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Site> siteList = platform.getSiteList();
		if(siteList != null){
			getSiteDAO().analyzeSiteByPlatform(siteList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractCatalogList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Catalog> catalogList = getCatalogDAO().findCatalogByPlatform(platform.getId(),options);
		if(catalogList != null){
			enhanceCatalogList(catalogList,options);
			platform.setCatalogList(catalogList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeCatalogList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Catalog> catalogList = platform.getCatalogList();
		if(catalogList != null){
			getCatalogDAO().analyzeCatalogByPlatform(catalogList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceBrandList(SmartList<Brand> brandList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractBrandList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Brand> brandList = getBrandDAO().findBrandByPlatform(platform.getId(),options);
		if(brandList != null){
			enhanceBrandList(brandList,options);
			platform.setBrandList(brandList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeBrandList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Brand> brandList = platform.getBrandList();
		if(brandList != null){
			getBrandDAO().analyzeBrandByPlatform(brandList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceProductList(SmartList<Product> productList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Product> productList = getProductDAO().findProductByPlatform(platform.getId(),options);
		if(productList != null){
			enhanceProductList(productList,options);
			platform.setProductList(productList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Product> productList = platform.getProductList();
		if(productList != null){
			getProductDAO().analyzeProductByPlatform(productList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
		
 	
		
		
		

	

	protected Platform savePlatform(Platform  platform){
		
		if(!platform.isChanged()){
			return platform;
		}
		
		
		String SQL=this.getSavePlatformSQL(platform);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePlatformParameters(platform);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		platform.incVersion();
		return platform;
	
	}
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPlatformList(platformList);
		
		batchPlatformCreate((List<Platform>)lists[CREATE_LIST_INDEX]);
		
		batchPlatformUpdate((List<Platform>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Platform platform:platformList){
			if(platform.isChanged()){
				platform.incVersion();
			}
			
		
		}
		
		
		return platformList;
	}

	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		
		
		super.removeList(platformList, options);
		
		return platformList;
		
		
	}
	
	protected List<Object[]> preparePlatformBatchCreateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			Object [] parameters = preparePlatformCreateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePlatformBatchUpdateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			if(!platform.isChanged()){
				continue;
			}
			Object [] parameters = preparePlatformUpdateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPlatformCreate(List<Platform> platformList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePlatformBatchCreateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPlatformUpdate(List<Platform> platformList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePlatformBatchUpdateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPlatformList(List<Platform> platformList){
		
		List<Platform> platformCreateList=new ArrayList<Platform>();
		List<Platform> platformUpdateList=new ArrayList<Platform>();
		
		for(Platform platform: platformList){
			if(isUpdateRequest(platform)){
				platformUpdateList.add( platform);
				continue;
			}
			platformCreateList.add(platform);
		}
		
		return new Object[]{platformCreateList,platformUpdateList};
	}
	
	protected boolean isUpdateRequest(Platform platform){
 		return platform.getVersion() > 0;
 	}
 	protected String getSavePlatformSQL(Platform platform){
 		if(isUpdateRequest(platform)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePlatformParameters(Platform platform){
 		if(isUpdateRequest(platform) ){
 			return preparePlatformUpdateParameters(platform);
 		}
 		return preparePlatformCreateParameters(platform);
 	}
 	protected Object[] preparePlatformUpdateParameters(Platform platform){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = platform.getName();
 		parameters[1] = platform.getIntroduction();
 		parameters[2] = platform.getCurrentVersion();		
 		parameters[3] = platform.nextVersion();
 		parameters[4] = platform.getId();
 		parameters[5] = platform.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePlatformCreateParameters(Platform platform){
		Object[] parameters = new Object[4];
		String newPlatformId=getNextId();
		platform.setId(newPlatformId);
		parameters[0] =  platform.getId();
 
 		parameters[1] = platform.getName();
 		parameters[2] = platform.getIntroduction();
 		parameters[3] = platform.getCurrentVersion();		
 				
 		return parameters;
 	}
 	
	protected Platform saveInternalPlatform(Platform platform, Map<String,Object> options){
		
		savePlatform(platform);

		
		if(isSaveSiteListEnabled(options)){
	 		saveSiteList(platform, options);
	 		//removeSiteList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveCatalogListEnabled(options)){
	 		saveCatalogList(platform, options);
	 		//removeCatalogList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveBrandListEnabled(options)){
	 		saveBrandList(platform, options);
	 		//removeBrandList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveProductListEnabled(options)){
	 		saveProductList(platform, options);
	 		//removeProductList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		return platform;
		
	}
	
	
	
	//======================================================================================
	

	
	public Platform planToRemoveSiteList(Platform platform, String siteIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Site.PLATFORM_PROPERTY, platform.getId());
		key.put(Site.ID_PROPERTY, siteIds);
		
		SmartList<Site> externalSiteList = getSiteDAO().
				findSiteWithKey(key, options);
		if(externalSiteList == null){
			return platform;
		}
		if(externalSiteList.isEmpty()){
			return platform;
		}
		
		for(Site site: externalSiteList){

			site.clearFromAll();
		}
		
		
		SmartList<Site> siteList = platform.getSiteList();		
		siteList.addAllToRemoveList(externalSiteList);
		return platform;	
	
	}


	public Platform planToRemoveCatalogList(Platform platform, String catalogIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.PLATFORM_PROPERTY, platform.getId());
		key.put(Catalog.ID_PROPERTY, catalogIds);
		
		SmartList<Catalog> externalCatalogList = getCatalogDAO().
				findCatalogWithKey(key, options);
		if(externalCatalogList == null){
			return platform;
		}
		if(externalCatalogList.isEmpty()){
			return platform;
		}
		
		for(Catalog catalog: externalCatalogList){

			catalog.clearFromAll();
		}
		
		
		SmartList<Catalog> catalogList = platform.getCatalogList();		
		catalogList.addAllToRemoveList(externalCatalogList);
		return platform;	
	
	}


	//disconnect Platform with seller_id in Catalog
	public Platform planToRemoveCatalogListWithSellerId(Platform platform, String sellerIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.PLATFORM_PROPERTY, platform.getId());
		key.put(Catalog.SELLER_ID_PROPERTY, sellerIdId);
		
		SmartList<Catalog> externalCatalogList = getCatalogDAO().
				findCatalogWithKey(key, options);
		if(externalCatalogList == null){
			return platform;
		}
		if(externalCatalogList.isEmpty()){
			return platform;
		}
		
		for(Catalog catalog: externalCatalogList){
			catalog.clearSellerId();
			catalog.clearPlatform();
			
		}
		
		
		SmartList<Catalog> catalogList = platform.getCatalogList();		
		catalogList.addAllToRemoveList(externalCatalogList);
		return platform;
	}
	
	public int countCatalogListWithSellerId(String platformId, String sellerIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.PLATFORM_PROPERTY, platformId);
		key.put(Catalog.SELLER_ID_PROPERTY, sellerIdId);
		
		int count = getCatalogDAO().countCatalogWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with site in Catalog
	public Platform planToRemoveCatalogListWithSite(Platform platform, String siteId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.PLATFORM_PROPERTY, platform.getId());
		key.put(Catalog.SITE_PROPERTY, siteId);
		
		SmartList<Catalog> externalCatalogList = getCatalogDAO().
				findCatalogWithKey(key, options);
		if(externalCatalogList == null){
			return platform;
		}
		if(externalCatalogList.isEmpty()){
			return platform;
		}
		
		for(Catalog catalog: externalCatalogList){
			catalog.clearSite();
			catalog.clearPlatform();
			
		}
		
		
		SmartList<Catalog> catalogList = platform.getCatalogList();		
		catalogList.addAllToRemoveList(externalCatalogList);
		return platform;
	}
	
	public int countCatalogListWithSite(String platformId, String siteId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.PLATFORM_PROPERTY, platformId);
		key.put(Catalog.SITE_PROPERTY, siteId);
		
		int count = getCatalogDAO().countCatalogWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveBrandList(Platform platform, String brandIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Brand.PLATFORM_PROPERTY, platform.getId());
		key.put(Brand.ID_PROPERTY, brandIds);
		
		SmartList<Brand> externalBrandList = getBrandDAO().
				findBrandWithKey(key, options);
		if(externalBrandList == null){
			return platform;
		}
		if(externalBrandList.isEmpty()){
			return platform;
		}
		
		for(Brand brand: externalBrandList){

			brand.clearFromAll();
		}
		
		
		SmartList<Brand> brandList = platform.getBrandList();		
		brandList.addAllToRemoveList(externalBrandList);
		return platform;	
	
	}


	public Platform planToRemoveProductList(Platform platform, String productIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platform.getId());
		key.put(Product.ID_PROPERTY, productIds);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return platform;
		}
		if(externalProductList.isEmpty()){
			return platform;
		}
		
		for(Product product: externalProductList){

			product.clearFromAll();
		}
		
		
		SmartList<Product> productList = platform.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return platform;	
	
	}


	//disconnect Platform with parent_category in Product
	public Platform planToRemoveProductListWithParentCategory(Platform platform, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platform.getId());
		key.put(Product.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return platform;
		}
		if(externalProductList.isEmpty()){
			return platform;
		}
		
		for(Product product: externalProductList){
			product.clearParentCategory();
			product.clearPlatform();
			
		}
		
		
		SmartList<Product> productList = platform.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return platform;
	}
	
	public int countProductListWithParentCategory(String platformId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platformId);
		key.put(Product.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with brand in Product
	public Platform planToRemoveProductListWithBrand(Platform platform, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platform.getId());
		key.put(Product.BRAND_PROPERTY, brandId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return platform;
		}
		if(externalProductList.isEmpty()){
			return platform;
		}
		
		for(Product product: externalProductList){
			product.clearBrand();
			product.clearPlatform();
			
		}
		
		
		SmartList<Product> productList = platform.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return platform;
	}
	
	public int countProductListWithBrand(String platformId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platformId);
		key.put(Product.BRAND_PROPERTY, brandId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with catalog in Product
	public Platform planToRemoveProductListWithCatalog(Platform platform, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platform.getId());
		key.put(Product.CATALOG_PROPERTY, catalogId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return platform;
		}
		if(externalProductList.isEmpty()){
			return platform;
		}
		
		for(Product product: externalProductList){
			product.clearCatalog();
			product.clearPlatform();
			
		}
		
		
		SmartList<Product> productList = platform.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return platform;
	}
	
	public int countProductListWithCatalog(String platformId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platformId);
		key.put(Product.CATALOG_PROPERTY, catalogId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	

		
	protected Platform saveSiteList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Site> siteList = platform.getSiteList();
		if(siteList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Site> mergedUpdateSiteList = new SmartList<Site>();
		
		
		mergedUpdateSiteList.addAll(siteList); 
		if(siteList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSiteList.addAll(siteList.getToRemoveList());
			siteList.removeAll(siteList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getSiteDAO().saveSiteList(mergedUpdateSiteList,options);
		
		if(siteList.getToRemoveList() != null){
			siteList.removeAll(siteList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeSiteList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Site> siteList = platform.getSiteList();
		if(siteList == null){
			return platform;
		}	
	
		SmartList<Site> toRemoveSiteList = siteList.getToRemoveList();
		
		if(toRemoveSiteList == null){
			return platform;
		}
		if(toRemoveSiteList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSiteDAO().removeSiteList(toRemoveSiteList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveCatalogList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Catalog> catalogList = platform.getCatalogList();
		if(catalogList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Catalog> mergedUpdateCatalogList = new SmartList<Catalog>();
		
		
		mergedUpdateCatalogList.addAll(catalogList); 
		if(catalogList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCatalogList.addAll(catalogList.getToRemoveList());
			catalogList.removeAll(catalogList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getCatalogDAO().saveCatalogList(mergedUpdateCatalogList,options);
		
		if(catalogList.getToRemoveList() != null){
			catalogList.removeAll(catalogList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeCatalogList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Catalog> catalogList = platform.getCatalogList();
		if(catalogList == null){
			return platform;
		}	
	
		SmartList<Catalog> toRemoveCatalogList = catalogList.getToRemoveList();
		
		if(toRemoveCatalogList == null){
			return platform;
		}
		if(toRemoveCatalogList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCatalogDAO().removeCatalogList(toRemoveCatalogList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveBrandList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Brand> brandList = platform.getBrandList();
		if(brandList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Brand> mergedUpdateBrandList = new SmartList<Brand>();
		
		
		mergedUpdateBrandList.addAll(brandList); 
		if(brandList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateBrandList.addAll(brandList.getToRemoveList());
			brandList.removeAll(brandList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getBrandDAO().saveBrandList(mergedUpdateBrandList,options);
		
		if(brandList.getToRemoveList() != null){
			brandList.removeAll(brandList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeBrandList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Brand> brandList = platform.getBrandList();
		if(brandList == null){
			return platform;
		}	
	
		SmartList<Brand> toRemoveBrandList = brandList.getToRemoveList();
		
		if(toRemoveBrandList == null){
			return platform;
		}
		if(toRemoveBrandList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getBrandDAO().removeBrandList(toRemoveBrandList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveProductList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Product> productList = platform.getProductList();
		if(productList == null){
			//null list means nothing
			return platform;
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
		
		
		return platform;
	
	}
	
	protected Platform removeProductList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Product> productList = platform.getProductList();
		if(productList == null){
			return platform;
		}	
	
		SmartList<Product> toRemoveProductList = productList.getToRemoveList();
		
		if(toRemoveProductList == null){
			return platform;
		}
		if(toRemoveProductList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProductDAO().removeProductList(toRemoveProductList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		

	public Platform present(Platform platform,Map<String, Object> options){
	
		presentSiteList(platform,options);
		presentCatalogList(platform,options);
		presentBrandList(platform,options);
		presentProductList(platform,options);

		return platform;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentSiteList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Site> siteList = platform.getSiteList();		
				SmartList<Site> newList= presentSubList(platform.getId(),
				siteList,
				options,
				getSiteDAO()::countSiteByPlatform,
				getSiteDAO()::findSiteByPlatform
				);

		
		platform.setSiteList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentCatalogList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Catalog> catalogList = platform.getCatalogList();		
				SmartList<Catalog> newList= presentSubList(platform.getId(),
				catalogList,
				options,
				getCatalogDAO()::countCatalogByPlatform,
				getCatalogDAO()::findCatalogByPlatform
				);

		
		platform.setCatalogList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentBrandList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Brand> brandList = platform.getBrandList();		
				SmartList<Brand> newList= presentSubList(platform.getId(),
				brandList,
				options,
				getBrandDAO()::countBrandByPlatform,
				getBrandDAO()::findBrandByPlatform
				);

		
		platform.setBrandList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentProductList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Product> productList = platform.getProductList();		
				SmartList<Product> newList= presentSubList(platform.getId(),
				productList,
				options,
				getProductDAO()::countProductByPlatform,
				getProductDAO()::findProductByPlatform
				);

		
		platform.setProductList(newList);
		

		return platform;
	}			
		

	
    public SmartList<Platform> requestCandidatePlatformForSite(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForCatalog(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForBrand(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForProduct(PimUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		

	protected String getTableName(){
		return PlatformTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Platform> platformList) {		
		this.enhanceListInternal(platformList, this.getPlatformMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Platform> platformList = ownerEntity.collectRefsWithType(Platform.INTERNAL_TYPE);
		this.enhanceList(platformList);
		
	}
	
	@Override
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPlatformMapper());

	}
	@Override
	public int countPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Platform> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPlatformMapper());
	}
}


