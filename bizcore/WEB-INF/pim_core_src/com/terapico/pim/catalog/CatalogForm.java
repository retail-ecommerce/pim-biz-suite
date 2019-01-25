package com.terapico.pim.catalog;
import com.terapico.pim.BaseForm;
import com.terapico.pim.genericform.GenericForm;
import com.terapico.pim.formfield.FormField;
import com.terapico.pim.formaction.FormAction;
import com.terapico.pim.formmessage.FormMessage;
import com.terapico.pim.formfieldmessage.FormFieldMessage;



public class CatalogForm extends BaseForm {
	
	
	public CatalogForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public CatalogForm catalogIdField(String parameterName, String initValue){
		FormField field = idFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm catalogIdField(String initValue){
		return catalogIdField("catalogId",initValue);
	}
	public CatalogForm catalogIdField(){
		return catalogIdField("catalogId","");
	}


	public CatalogForm nameField(String parameterName, String initValue){
		FormField field = nameFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public CatalogForm nameField(){
		return nameField("name","");
	}


	public CatalogForm sellerIdField(String parameterName, String initValue){
		FormField field = sellerIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm sellerIdField(String initValue){
		return sellerIdField("sellerId",initValue);
	}
	public CatalogForm sellerIdField(){
		return sellerIdField("sellerId","");
	}


	public CatalogForm siteIdField(String parameterName, String initValue){
		FormField field = siteIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm siteIdField(String initValue){
		return siteIdField("siteId",initValue);
	}
	public CatalogForm siteIdField(){
		return siteIdField("siteId","");
	}


	public CatalogForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public CatalogForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public CatalogForm siteIdFieldOfSite(String parameterName, String initValue){
		FormField field =  idFromSite(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm siteIdFieldOfSite(String initValue){
		return siteIdFieldOfSite("siteId",initValue);
	}
	public CatalogForm siteIdFieldOfSite(){
		return siteIdFieldOfSite("siteId","");
	}


	public CatalogForm nameFieldOfSite(String parameterName, String initValue){
		FormField field =  nameFromSite(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm nameFieldOfSite(String initValue){
		return nameFieldOfSite("name",initValue);
	}
	public CatalogForm nameFieldOfSite(){
		return nameFieldOfSite("name","");
	}


	public CatalogForm introductionFieldOfSite(String parameterName, String initValue){
		FormField field =  introductionFromSite(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm introductionFieldOfSite(String initValue){
		return introductionFieldOfSite("introduction",initValue);
	}
	public CatalogForm introductionFieldOfSite(){
		return introductionFieldOfSite("introduction","");
	}


	public CatalogForm platformIdFieldOfSite(String parameterName, String initValue){
		FormField field =  platformIdFromSite(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm platformIdFieldOfSite(String initValue){
		return platformIdFieldOfSite("platformId",initValue);
	}
	public CatalogForm platformIdFieldOfSite(){
		return platformIdFieldOfSite("platformId","");
	}


	public CatalogForm lastUpdateTimeFieldOfSite(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSite(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm lastUpdateTimeFieldOfSite(String initValue){
		return lastUpdateTimeFieldOfSite("lastUpdateTime",initValue);
	}
	public CatalogForm lastUpdateTimeFieldOfSite(){
		return lastUpdateTimeFieldOfSite("lastUpdateTime","");
	}


	public CatalogForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public CatalogForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public CatalogForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public CatalogForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public CatalogForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public CatalogForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public CatalogForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public CatalogForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public CatalogForm levelOneCategoryIdFieldForLevelOneCategory(String parameterName, String initValue){
		FormField field =  idFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm levelOneCategoryIdFieldForLevelOneCategory(String initValue){
		return levelOneCategoryIdFieldForLevelOneCategory("levelOneCategoryId",initValue);
	}
	public CatalogForm levelOneCategoryIdFieldForLevelOneCategory(){
		return levelOneCategoryIdFieldForLevelOneCategory("levelOneCategoryId","");
	}


	public CatalogForm catalogIdFieldForLevelOneCategory(String parameterName, String initValue){
		FormField field =  catalogIdFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm catalogIdFieldForLevelOneCategory(String initValue){
		return catalogIdFieldForLevelOneCategory("catalogId",initValue);
	}
	public CatalogForm catalogIdFieldForLevelOneCategory(){
		return catalogIdFieldForLevelOneCategory("catalogId","");
	}


	public CatalogForm nameFieldForLevelOneCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm nameFieldForLevelOneCategory(String initValue){
		return nameFieldForLevelOneCategory("name",initValue);
	}
	public CatalogForm nameFieldForLevelOneCategory(){
		return nameFieldForLevelOneCategory("name","");
	}


	public CatalogForm productIdFieldForProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm productIdFieldForProduct(String initValue){
		return productIdFieldForProduct("productId",initValue);
	}
	public CatalogForm productIdFieldForProduct(){
		return productIdFieldForProduct("productId","");
	}


	public CatalogForm nameFieldForProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm nameFieldForProduct(String initValue){
		return nameFieldForProduct("name",initValue);
	}
	public CatalogForm nameFieldForProduct(){
		return nameFieldForProduct("name","");
	}


	public CatalogForm parentCategoryIdFieldForProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm parentCategoryIdFieldForProduct(String initValue){
		return parentCategoryIdFieldForProduct("parentCategoryId",initValue);
	}
	public CatalogForm parentCategoryIdFieldForProduct(){
		return parentCategoryIdFieldForProduct("parentCategoryId","");
	}


	public CatalogForm brandIdFieldForProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm brandIdFieldForProduct(String initValue){
		return brandIdFieldForProduct("brandId",initValue);
	}
	public CatalogForm brandIdFieldForProduct(){
		return brandIdFieldForProduct("brandId","");
	}


	public CatalogForm originFieldForProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm originFieldForProduct(String initValue){
		return originFieldForProduct("origin",initValue);
	}
	public CatalogForm originFieldForProduct(){
		return originFieldForProduct("origin","");
	}


	public CatalogForm catalogIdFieldForProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm catalogIdFieldForProduct(String initValue){
		return catalogIdFieldForProduct("catalogId",initValue);
	}
	public CatalogForm catalogIdFieldForProduct(){
		return catalogIdFieldForProduct("catalogId","");
	}


	public CatalogForm remarkFieldForProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm remarkFieldForProduct(String initValue){
		return remarkFieldForProduct("remark",initValue);
	}
	public CatalogForm remarkFieldForProduct(){
		return remarkFieldForProduct("remark","");
	}


	public CatalogForm lastUpdateTimeFieldForProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm lastUpdateTimeFieldForProduct(String initValue){
		return lastUpdateTimeFieldForProduct("lastUpdateTime",initValue);
	}
	public CatalogForm lastUpdateTimeFieldForProduct(){
		return lastUpdateTimeFieldForProduct("lastUpdateTime","");
	}


	public CatalogForm platformIdFieldForProduct(String parameterName, String initValue){
		FormField field =  platformIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm platformIdFieldForProduct(String initValue){
		return platformIdFieldForProduct("platformId",initValue);
	}
	public CatalogForm platformIdFieldForProduct(){
		return platformIdFieldForProduct("platformId","");
	}

	

	
 	public CatalogForm transferToAnotherSiteAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSite/catalogId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public CatalogForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/catalogId/");
		this.addFormAction(action);
		return this;
	}

 

	public CatalogForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


