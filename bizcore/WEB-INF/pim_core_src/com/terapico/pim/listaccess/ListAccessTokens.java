
package com.terapico.pim.listaccess;
import com.terapico.pim.CommonTokens;
import java.util.Map;
public class ListAccessTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="listAccess";
	
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
	protected ListAccessTokens(){
		//ensure not initialized outside the class
	}
	
	public ListAccessTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ListAccessTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ListAccessTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ListAccessTokens start(){
		return new ListAccessTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ListAccessTokens allTokens(){
		
		return start()
			.withApp();
	
	}
	public static ListAccessTokens withoutListsTokens(){
		
		return start()
			.withApp();
	
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

	protected static final String APP = "app";
	public String getApp(){
		return APP;
	}
	public ListAccessTokens withApp(){		
		addSimpleOptions(APP);
		return this;
	}
	
	
	
	public  ListAccessTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

