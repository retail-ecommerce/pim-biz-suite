
package com.terapico.pim.platform;
import com.terapico.pim.CommonTokens;
import java.util.Map;
public class PlatformTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="platform";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected PlatformTokens(){
		//ensure not initialized outside the class
	}
	
	public PlatformTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PlatformTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PlatformTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PlatformTokens start(){
		return new PlatformTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PlatformTokens allTokens(){
		
		return start()
			.withSiteList()
			.withCatalogList()
			.withBrandList()
			.withProductList();
	
	}
	public static PlatformTokens withoutListsTokens(){
		
		return start();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String SITE_LIST = "siteList";
	public String getSiteList(){
		return SITE_LIST;
	}
	public PlatformTokens withSiteList(){		
		addSimpleOptions(SITE_LIST);
		return this;
	}
	public PlatformTokens analyzeSiteList(){		
		addSimpleOptions(SITE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSiteListEnabled(){		
		
		return checkOptions(this.options(), SITE_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromSiteList(String idsSeperatedWithComma){		
		addSimpleOptions(SITE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int siteListSortCounter = 0;
	public PlatformTokens sortSiteListWith(String field, String descOrAsc){		
		addSortMoreOptions(SITE_LIST,siteListSortCounter++, field, descOrAsc);
		return this;
	}
	private int siteListSearchCounter = 0;
	public PlatformTokens searchSiteListWith(String field, String verb, String value){		
		addSearchMoreOptions(SITE_LIST,siteListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfSiteList(String verb, String value){	
		String field = "id|name|introduction";
		addSearchMoreOptions(SITE_LIST,siteListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfSiteList(int rowsPerPage){		
		addSimpleOptions(SITE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfSiteList(int currentPageNumber){		
		addSimpleOptions(SITE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfSiteList(String[] columns){		
		addSimpleOptions(SITE_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfSiteList(String[] columns){		
		addSimpleOptions(SITE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CATALOG_LIST = "catalogList";
	public String getCatalogList(){
		return CATALOG_LIST;
	}
	public PlatformTokens withCatalogList(){		
		addSimpleOptions(CATALOG_LIST);
		return this;
	}
	public PlatformTokens analyzeCatalogList(){		
		addSimpleOptions(CATALOG_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCatalogListEnabled(){		
		
		return checkOptions(this.options(), CATALOG_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromCatalogList(String idsSeperatedWithComma){		
		addSimpleOptions(CATALOG_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int catalogListSortCounter = 0;
	public PlatformTokens sortCatalogListWith(String field, String descOrAsc){		
		addSortMoreOptions(CATALOG_LIST,catalogListSortCounter++, field, descOrAsc);
		return this;
	}
	private int catalogListSearchCounter = 0;
	public PlatformTokens searchCatalogListWith(String field, String verb, String value){		
		addSearchMoreOptions(CATALOG_LIST,catalogListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfCatalogList(String verb, String value){	
		String field = "id|name|sellerId";
		addSearchMoreOptions(CATALOG_LIST,catalogListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfCatalogList(int rowsPerPage){		
		addSimpleOptions(CATALOG_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfCatalogList(int currentPageNumber){		
		addSimpleOptions(CATALOG_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfCatalogList(String[] columns){		
		addSimpleOptions(CATALOG_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfCatalogList(String[] columns){		
		addSimpleOptions(CATALOG_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String BRAND_LIST = "brandList";
	public String getBrandList(){
		return BRAND_LIST;
	}
	public PlatformTokens withBrandList(){		
		addSimpleOptions(BRAND_LIST);
		return this;
	}
	public PlatformTokens analyzeBrandList(){		
		addSimpleOptions(BRAND_LIST+".anaylze");
		return this;
	}
	public boolean analyzeBrandListEnabled(){		
		
		return checkOptions(this.options(), BRAND_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromBrandList(String idsSeperatedWithComma){		
		addSimpleOptions(BRAND_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int brandListSortCounter = 0;
	public PlatformTokens sortBrandListWith(String field, String descOrAsc){		
		addSortMoreOptions(BRAND_LIST,brandListSortCounter++, field, descOrAsc);
		return this;
	}
	private int brandListSearchCounter = 0;
	public PlatformTokens searchBrandListWith(String field, String verb, String value){		
		addSearchMoreOptions(BRAND_LIST,brandListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfBrandList(String verb, String value){	
		String field = "id|brandName|remark";
		addSearchMoreOptions(BRAND_LIST,brandListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfBrandList(int rowsPerPage){		
		addSimpleOptions(BRAND_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfBrandList(int currentPageNumber){		
		addSimpleOptions(BRAND_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfBrandList(String[] columns){		
		addSimpleOptions(BRAND_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfBrandList(String[] columns){		
		addSimpleOptions(BRAND_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String PRODUCT_LIST = "productList";
	public String getProductList(){
		return PRODUCT_LIST;
	}
	public PlatformTokens withProductList(){		
		addSimpleOptions(PRODUCT_LIST);
		return this;
	}
	public PlatformTokens analyzeProductList(){		
		addSimpleOptions(PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProductListEnabled(){		
		
		return checkOptions(this.options(), PRODUCT_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromProductList(String idsSeperatedWithComma){		
		addSimpleOptions(PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int productListSortCounter = 0;
	public PlatformTokens sortProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(PRODUCT_LIST,productListSortCounter++, field, descOrAsc);
		return this;
	}
	private int productListSearchCounter = 0;
	public PlatformTokens searchProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfProductList(int rowsPerPage){		
		addSimpleOptions(PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfProductList(int currentPageNumber){		
		addSimpleOptions(PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PlatformTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfSiteList(verb, value);	
		searchAllTextOfCatalogList(verb, value);	
		searchAllTextOfBrandList(verb, value);	
		searchAllTextOfProductList(verb, value);	
		return this;
	}
}

