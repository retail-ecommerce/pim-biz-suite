
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
			.withSiteList();
	
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
	
	
		
	
	public  PlatformTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfSiteList(verb, value);	
		return this;
	}
}

