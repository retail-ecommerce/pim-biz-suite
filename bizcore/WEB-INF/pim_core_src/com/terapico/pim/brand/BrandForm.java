package com.terapico.pim.brand;
import com.terapico.pim.BaseForm;
import com.terapico.pim.genericform.GenericForm;
import com.terapico.pim.formfield.FormField;
import com.terapico.pim.formaction.FormAction;
import com.terapico.pim.formmessage.FormMessage;
import com.terapico.pim.formfieldmessage.FormFieldMessage;



public class BrandForm extends BaseForm {
	
	
	public BrandForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public BrandForm brandIdField(String parameterName, String initValue){
		FormField field = idFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandIdField(String initValue){
		return brandIdField("brandId",initValue);
	}
	public BrandForm brandIdField(){
		return brandIdField("brandId","");
	}


	public BrandForm brandNameField(String parameterName, String initValue){
		FormField field = brandNameFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandNameField(String initValue){
		return brandNameField("brandName",initValue);
	}
	public BrandForm brandNameField(){
		return brandNameField("brandName","");
	}


	public BrandForm logoField(String parameterName, String initValue){
		FormField field = logoFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm logoField(String initValue){
		return logoField("logo",initValue);
	}
	public BrandForm logoField(){
		return logoField("logo","");
	}


	public BrandForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public BrandForm remarkField(){
		return remarkField("remark","");
	}


	public BrandForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public BrandForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public BrandForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BrandForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public BrandForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public BrandForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BrandForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public BrandForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public BrandForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BrandForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public BrandForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public BrandForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BrandForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public BrandForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public BrandForm productIdFieldForProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm productIdFieldForProduct(String initValue){
		return productIdFieldForProduct("productId",initValue);
	}
	public BrandForm productIdFieldForProduct(){
		return productIdFieldForProduct("productId","");
	}


	public BrandForm nameFieldForProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm nameFieldForProduct(String initValue){
		return nameFieldForProduct("name",initValue);
	}
	public BrandForm nameFieldForProduct(){
		return nameFieldForProduct("name","");
	}


	public BrandForm parentCategoryIdFieldForProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm parentCategoryIdFieldForProduct(String initValue){
		return parentCategoryIdFieldForProduct("parentCategoryId",initValue);
	}
	public BrandForm parentCategoryIdFieldForProduct(){
		return parentCategoryIdFieldForProduct("parentCategoryId","");
	}


	public BrandForm brandIdFieldForProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandIdFieldForProduct(String initValue){
		return brandIdFieldForProduct("brandId",initValue);
	}
	public BrandForm brandIdFieldForProduct(){
		return brandIdFieldForProduct("brandId","");
	}


	public BrandForm originFieldForProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm originFieldForProduct(String initValue){
		return originFieldForProduct("origin",initValue);
	}
	public BrandForm originFieldForProduct(){
		return originFieldForProduct("origin","");
	}


	public BrandForm catalogIdFieldForProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm catalogIdFieldForProduct(String initValue){
		return catalogIdFieldForProduct("catalogId",initValue);
	}
	public BrandForm catalogIdFieldForProduct(){
		return catalogIdFieldForProduct("catalogId","");
	}


	public BrandForm remarkFieldForProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm remarkFieldForProduct(String initValue){
		return remarkFieldForProduct("remark",initValue);
	}
	public BrandForm remarkFieldForProduct(){
		return remarkFieldForProduct("remark","");
	}


	public BrandForm lastUpdateTimeFieldForProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm lastUpdateTimeFieldForProduct(String initValue){
		return lastUpdateTimeFieldForProduct("lastUpdateTime",initValue);
	}
	public BrandForm lastUpdateTimeFieldForProduct(){
		return lastUpdateTimeFieldForProduct("lastUpdateTime","");
	}


	public BrandForm platformIdFieldForProduct(String parameterName, String initValue){
		FormField field =  platformIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm platformIdFieldForProduct(String initValue){
		return platformIdFieldForProduct("platformId",initValue);
	}
	public BrandForm platformIdFieldForProduct(){
		return platformIdFieldForProduct("platformId","");
	}

	

	
 	public BrandForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/brandId/");
		this.addFormAction(action);
		return this;
	}

 

	public BrandForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


