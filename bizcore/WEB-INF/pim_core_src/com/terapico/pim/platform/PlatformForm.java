package com.terapico.pim.platform;
import com.terapico.pim.BaseForm;
import com.terapico.pim.genericform.GenericForm;
import com.terapico.pim.formfield.FormField;
import com.terapico.pim.formaction.FormAction;
import com.terapico.pim.formmessage.FormMessage;
import com.terapico.pim.formfieldmessage.FormFieldMessage;



public class PlatformForm extends BaseForm {
	
	
	public PlatformForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PlatformForm platformIdField(String parameterName, String initValue){
		FormField field = idFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public PlatformForm platformIdField(){
		return platformIdField("platformId","");
	}


	public PlatformForm nameField(String parameterName, String initValue){
		FormField field = nameFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PlatformForm nameField(){
		return nameField("name","");
	}


	public PlatformForm introductionField(String parameterName, String initValue){
		FormField field = introductionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm introductionField(String initValue){
		return introductionField("introduction",initValue);
	}
	public PlatformForm introductionField(){
		return introductionField("introduction","");
	}


	public PlatformForm currentVersionField(String parameterName, String initValue){
		FormField field = currentVersionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm currentVersionField(String initValue){
		return currentVersionField("currentVersion",initValue);
	}
	public PlatformForm currentVersionField(){
		return currentVersionField("currentVersion","");
	}

	
	

	



	public PlatformForm siteIdFieldForSite(String parameterName, String initValue){
		FormField field =  idFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm siteIdFieldForSite(String initValue){
		return siteIdFieldForSite("siteId",initValue);
	}
	public PlatformForm siteIdFieldForSite(){
		return siteIdFieldForSite("siteId","");
	}


	public PlatformForm nameFieldForSite(String parameterName, String initValue){
		FormField field =  nameFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForSite(String initValue){
		return nameFieldForSite("name",initValue);
	}
	public PlatformForm nameFieldForSite(){
		return nameFieldForSite("name","");
	}


	public PlatformForm introductionFieldForSite(String parameterName, String initValue){
		FormField field =  introductionFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm introductionFieldForSite(String initValue){
		return introductionFieldForSite("introduction",initValue);
	}
	public PlatformForm introductionFieldForSite(){
		return introductionFieldForSite("introduction","");
	}


	public PlatformForm platformIdFieldForSite(String parameterName, String initValue){
		FormField field =  platformIdFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForSite(String initValue){
		return platformIdFieldForSite("platformId",initValue);
	}
	public PlatformForm platformIdFieldForSite(){
		return platformIdFieldForSite("platformId","");
	}


	public PlatformForm lastUpdateTimeFieldForSite(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateTimeFieldForSite(String initValue){
		return lastUpdateTimeFieldForSite("lastUpdateTime",initValue);
	}
	public PlatformForm lastUpdateTimeFieldForSite(){
		return lastUpdateTimeFieldForSite("lastUpdateTime","");
	}


	public PlatformForm catalogIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm catalogIdFieldForCatalog(String initValue){
		return catalogIdFieldForCatalog("catalogId",initValue);
	}
	public PlatformForm catalogIdFieldForCatalog(){
		return catalogIdFieldForCatalog("catalogId","");
	}


	public PlatformForm nameFieldForCatalog(String parameterName, String initValue){
		FormField field =  nameFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForCatalog(String initValue){
		return nameFieldForCatalog("name",initValue);
	}
	public PlatformForm nameFieldForCatalog(){
		return nameFieldForCatalog("name","");
	}


	public PlatformForm sellerIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  sellerIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm sellerIdFieldForCatalog(String initValue){
		return sellerIdFieldForCatalog("sellerId",initValue);
	}
	public PlatformForm sellerIdFieldForCatalog(){
		return sellerIdFieldForCatalog("sellerId","");
	}


	public PlatformForm siteIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  siteIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm siteIdFieldForCatalog(String initValue){
		return siteIdFieldForCatalog("siteId",initValue);
	}
	public PlatformForm siteIdFieldForCatalog(){
		return siteIdFieldForCatalog("siteId","");
	}


	public PlatformForm platformIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  platformIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForCatalog(String initValue){
		return platformIdFieldForCatalog("platformId",initValue);
	}
	public PlatformForm platformIdFieldForCatalog(){
		return platformIdFieldForCatalog("platformId","");
	}


	public PlatformForm brandIdFieldForBrand(String parameterName, String initValue){
		FormField field =  idFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm brandIdFieldForBrand(String initValue){
		return brandIdFieldForBrand("brandId",initValue);
	}
	public PlatformForm brandIdFieldForBrand(){
		return brandIdFieldForBrand("brandId","");
	}


	public PlatformForm brandNameFieldForBrand(String parameterName, String initValue){
		FormField field =  brandNameFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm brandNameFieldForBrand(String initValue){
		return brandNameFieldForBrand("brandName",initValue);
	}
	public PlatformForm brandNameFieldForBrand(){
		return brandNameFieldForBrand("brandName","");
	}


	public PlatformForm logoFieldForBrand(String parameterName, String initValue){
		FormField field =  logoFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm logoFieldForBrand(String initValue){
		return logoFieldForBrand("logo",initValue);
	}
	public PlatformForm logoFieldForBrand(){
		return logoFieldForBrand("logo","");
	}


	public PlatformForm remarkFieldForBrand(String parameterName, String initValue){
		FormField field =  remarkFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm remarkFieldForBrand(String initValue){
		return remarkFieldForBrand("remark",initValue);
	}
	public PlatformForm remarkFieldForBrand(){
		return remarkFieldForBrand("remark","");
	}


	public PlatformForm platformIdFieldForBrand(String parameterName, String initValue){
		FormField field =  platformIdFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForBrand(String initValue){
		return platformIdFieldForBrand("platformId",initValue);
	}
	public PlatformForm platformIdFieldForBrand(){
		return platformIdFieldForBrand("platformId","");
	}


	public PlatformForm productIdFieldForProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm productIdFieldForProduct(String initValue){
		return productIdFieldForProduct("productId",initValue);
	}
	public PlatformForm productIdFieldForProduct(){
		return productIdFieldForProduct("productId","");
	}


	public PlatformForm nameFieldForProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForProduct(String initValue){
		return nameFieldForProduct("name",initValue);
	}
	public PlatformForm nameFieldForProduct(){
		return nameFieldForProduct("name","");
	}


	public PlatformForm parentCategoryIdFieldForProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm parentCategoryIdFieldForProduct(String initValue){
		return parentCategoryIdFieldForProduct("parentCategoryId",initValue);
	}
	public PlatformForm parentCategoryIdFieldForProduct(){
		return parentCategoryIdFieldForProduct("parentCategoryId","");
	}


	public PlatformForm brandIdFieldForProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm brandIdFieldForProduct(String initValue){
		return brandIdFieldForProduct("brandId",initValue);
	}
	public PlatformForm brandIdFieldForProduct(){
		return brandIdFieldForProduct("brandId","");
	}


	public PlatformForm originFieldForProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm originFieldForProduct(String initValue){
		return originFieldForProduct("origin",initValue);
	}
	public PlatformForm originFieldForProduct(){
		return originFieldForProduct("origin","");
	}


	public PlatformForm catalogIdFieldForProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm catalogIdFieldForProduct(String initValue){
		return catalogIdFieldForProduct("catalogId",initValue);
	}
	public PlatformForm catalogIdFieldForProduct(){
		return catalogIdFieldForProduct("catalogId","");
	}


	public PlatformForm remarkFieldForProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm remarkFieldForProduct(String initValue){
		return remarkFieldForProduct("remark",initValue);
	}
	public PlatformForm remarkFieldForProduct(){
		return remarkFieldForProduct("remark","");
	}


	public PlatformForm lastUpdateTimeFieldForProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateTimeFieldForProduct(String initValue){
		return lastUpdateTimeFieldForProduct("lastUpdateTime",initValue);
	}
	public PlatformForm lastUpdateTimeFieldForProduct(){
		return lastUpdateTimeFieldForProduct("lastUpdateTime","");
	}


	public PlatformForm platformIdFieldForProduct(String parameterName, String initValue){
		FormField field =  platformIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForProduct(String initValue){
		return platformIdFieldForProduct("platformId",initValue);
	}
	public PlatformForm platformIdFieldForProduct(){
		return platformIdFieldForProduct("platformId","");
	}

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


