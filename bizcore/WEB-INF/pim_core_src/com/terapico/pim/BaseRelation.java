/*
******************************           DO NOT EDIT THIS FILE!!!           				*********************************
******************************         Please edit CustomRelation.java instead!        		*********************************	
******************************         不要编辑这个文件，这个文件每次都会被机器人覆盖!!!              *********************************
******************************    CustomRelation.java专门用于定制，该文件存在的时候不会被覆盖      	*********************************


*/
package com.terapico.pim;
import java.util.HashMap;
import java.util.Map;

public class BaseRelation{

	
	Map<String, String> relationMapping ;
	
	public String getRelation(String fromType, String fromId, String targetField, String targetId)
	{
		//the entry for external calls, ugly code with many path just works, using a map is fine but lose the way to override the methods
		
		if(relationMapping == null){
			prepareRelation();
		}

		String key = fromType+"->"+targetField;
		
		String relation = relationMapping.get(key);
		if(relation == null){
			throw new IllegalArgumentException("Not able to find any relation to the target type: "+ targetField);
		}
		return relation;
		
	}
	
	protected void addGenericRelation(String fromType, String relation,String targetField)
	{
		if(relationMapping == null){
			relationMapping = new HashMap<String,String>();
		}
		String key = fromType.trim()+"->"+targetField.trim();
		relationMapping.put(key, relation);
	}
	protected void replaceGenericRelation(String fromType, String relation,String targetField)
	{
		addGenericRelation( fromType, relation, targetField );
	}
	
	
	
	Map<String, String[]> relationIndex ;
	protected void addRelationIndex(String fromType,String related[])
	{
		if(relationIndex == null){
			relationIndex = new HashMap<String,String[]>();
		}
		
		relationIndex.put(fromType, related);
	}
	protected void replaceRelationIndex(String fromType,String related[])
	{
		addRelationIndex( fromType, related);
	}
	
	public String getTableFieldName(String expr){
		//the expr looks like owner:DecorationAccelerator
		String[] splitedValues = expr.split(":");
		if(splitedValues.length < 1){
			throw new IllegalArgumentException("Not able to split expr: "+expr);
		}
		
		return splitedValues[0];
	}
	public String getBeanFieldName(String expr){
		//the expr looks like owner:DecorationAccelerator
		String[] splitedValues = getTableFieldName(expr).split("_");
		String ret = splitedValues[0];
		for(int i=1;i<splitedValues.length;i++){
			
			ret = ret+splitedValues[i].substring(0,1).toUpperCase()+splitedValues[i].substring(1);
			
		}
		
		return ret;
	}
	public String getFieldType(String expr){
		//the expr looks like owner:DecorationAccelerator
		String[] splitedValues = expr.split(":");
		if(splitedValues.length < 2){
			throw new IllegalArgumentException("Not able to split expr: "+expr);
		}
		
		return splitedValues[1];
	}
	public String [] getRelationIndex(String type){
		
		if(relationIndex == null){
			prepareRelationIndex();
		}
		
		String relations [] =relationIndex.get(type);
		if(relations == null){
			//throw new IllegalArgumentException("Not able to find related objects for type: "+ type);
		}
		return relations;
	}
	
	protected void prepareRelationIndex()
	{
		
		
		String [] siteRelatedObjectNames = {"platform:Platform"};
		addRelationIndex("Site",siteRelatedObjectNames);

		String [] catalogRelatedObjectNames = {"site:Site","platform:Platform"};
		addRelationIndex("Catalog",catalogRelatedObjectNames);

		String [] levelOneCategoryRelatedObjectNames = {"catalog:Catalog"};
		addRelationIndex("LevelOneCategory",levelOneCategoryRelatedObjectNames);

		String [] levelTwoCategoryRelatedObjectNames = {"parent_category:LevelOneCategory"};
		addRelationIndex("LevelTwoCategory",levelTwoCategoryRelatedObjectNames);

		String [] levelNCategoryRelatedObjectNames = {"parent_category:LevelTwoCategory"};
		addRelationIndex("LevelNCategory",levelNCategoryRelatedObjectNames);

		String [] brandRelatedObjectNames = {"platform:Platform"};
		addRelationIndex("Brand",brandRelatedObjectNames);

		String [] productRelatedObjectNames = {"parent_category:LevelNCategory","brand:Brand","catalog:Catalog"};
		addRelationIndex("Product",productRelatedObjectNames);

		String [] skuRelatedObjectNames = {"product:Product"};
		addRelationIndex("Sku",skuRelatedObjectNames);

		String [] userWhiteListRelatedObjectNames = {"domain:UserDomain"};
		addRelationIndex("UserWhiteList",userWhiteListRelatedObjectNames);

		String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		addRelationIndex("SecUser",secUserRelatedObjectNames);

		String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		addRelationIndex("UserApp",userAppRelatedObjectNames);

		String [] listAccessRelatedObjectNames = {"app:UserApp"};
		addRelationIndex("ListAccess",listAccessRelatedObjectNames);

		String [] objectAccessRelatedObjectNames = {"app:UserApp"};
		addRelationIndex("ObjectAccess",objectAccessRelatedObjectNames);

		String [] loginHistoryRelatedObjectNames = {"sec_user:SecUser"};
		addRelationIndex("LoginHistory",loginHistoryRelatedObjectNames);

		String [] formMessageRelatedObjectNames = {"form:GenericForm"};
		addRelationIndex("FormMessage",formMessageRelatedObjectNames);

		String [] formFieldMessageRelatedObjectNames = {"form:GenericForm"};
		addRelationIndex("FormFieldMessage",formFieldMessageRelatedObjectNames);

		String [] formFieldRelatedObjectNames = {"form:GenericForm"};
		addRelationIndex("FormField",formFieldRelatedObjectNames);

		String [] formActionRelatedObjectNames = {"form:GenericForm"};
		addRelationIndex("FormAction",formActionRelatedObjectNames);

	
	
	}
	protected static final String TRUST_CHAIN_READ = "R";
	protected static final String TRUST_CHAIN_WRITE = "W";
	protected static final String TRUST_CHAIN_MANAGEMENT = "M";
	protected static final String TRUST_CHAIN_EXECUTION = "X";
	
	protected static final String TRUST_READ = "r";
	protected static final String TRUST_WRITE = "w";
	protected static final String TRUST_MANAGEMENT = "m";
	protected static final String TRUST_EXECUTION = "x";
	
	protected static final String TRUST_CHAIN_ALL = "MXWR";
	
	
	//small 'r','w','m','x' mean no chain trust, just trust the same level
	//default for reading trust chain, the default sequence are MXWR, the order is not affect the result
	protected void prepareRelation()
	{
		addGenericRelation("Site"                                  ,TRUST_CHAIN_READ,"platform");
		addGenericRelation("Catalog"                               ,TRUST_CHAIN_READ,"site");
		addGenericRelation("Catalog"                               ,TRUST_CHAIN_READ,"platform");
		addGenericRelation("LevelOneCategory"                      ,TRUST_CHAIN_READ,"catalog");
		addGenericRelation("LevelTwoCategory"                      ,TRUST_CHAIN_READ,"parentCategory");
		addGenericRelation("LevelNCategory"                        ,TRUST_CHAIN_READ,"parentCategory");
		addGenericRelation("Brand"                                 ,TRUST_CHAIN_READ,"platform");
		addGenericRelation("Product"                               ,TRUST_CHAIN_READ,"parentCategory");
		addGenericRelation("Product"                               ,TRUST_CHAIN_READ,"brand");
		addGenericRelation("Product"                               ,TRUST_CHAIN_READ,"catalog");
		addGenericRelation("Sku"                                   ,TRUST_CHAIN_READ,"product");
		addGenericRelation("UserWhiteList"                         ,TRUST_CHAIN_READ,"domain");
		addGenericRelation("SecUser"                               ,TRUST_CHAIN_READ,"domain");
		addGenericRelation("UserApp"                               ,TRUST_CHAIN_READ,"secUser");
		addGenericRelation("ListAccess"                            ,TRUST_CHAIN_READ,"app");
		addGenericRelation("ObjectAccess"                          ,TRUST_CHAIN_READ,"app");
		addGenericRelation("LoginHistory"                          ,TRUST_CHAIN_READ,"secUser");
		addGenericRelation("FormMessage"                           ,TRUST_CHAIN_READ,"form");
		addGenericRelation("FormFieldMessage"                      ,TRUST_CHAIN_READ,"form");
		addGenericRelation("FormField"                             ,TRUST_CHAIN_READ,"form");
		addGenericRelation("FormAction"                            ,TRUST_CHAIN_READ,"form");
	
	}

	


}


