package com.terapico.pim.profile;
import com.terapico.pim.BaseForm;
import com.terapico.pim.genericform.GenericForm;
import com.terapico.pim.formfield.FormField;
import com.terapico.pim.formaction.FormAction;
import com.terapico.pim.formmessage.FormMessage;
import com.terapico.pim.formfieldmessage.FormFieldMessage;



public class ProfileForm extends BaseForm {
	
	
	public ProfileForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProfileForm profileIdField(String parameterName, String initValue){
		FormField field = idFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public ProfileForm profileIdField(){
		return profileIdField("profileId","");
	}


	public ProfileForm nameField(String parameterName, String initValue){
		FormField field = nameFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ProfileForm nameField(){
		return nameField("name","");
	}


	public ProfileForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ProfileForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ProfileForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ProfileForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ProfileForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ProfileForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public ProfileForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public ProfileForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public ProfileForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public ProfileForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public ProfileForm brandFilterIdFieldForBrandFilter(String parameterName, String initValue){
		FormField field =  idFromBrandFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm brandFilterIdFieldForBrandFilter(String initValue){
		return brandFilterIdFieldForBrandFilter("brandFilterId",initValue);
	}
	public ProfileForm brandFilterIdFieldForBrandFilter(){
		return brandFilterIdFieldForBrandFilter("brandFilterId","");
	}


	public ProfileForm nameFieldForBrandFilter(String parameterName, String initValue){
		FormField field =  nameFromBrandFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameFieldForBrandFilter(String initValue){
		return nameFieldForBrandFilter("name",initValue);
	}
	public ProfileForm nameFieldForBrandFilter(){
		return nameFieldForBrandFilter("name","");
	}


	public ProfileForm internalIdFieldForBrandFilter(String parameterName, String initValue){
		FormField field =  internalIdFromBrandFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm internalIdFieldForBrandFilter(String initValue){
		return internalIdFieldForBrandFilter("internalId",initValue);
	}
	public ProfileForm internalIdFieldForBrandFilter(){
		return internalIdFieldForBrandFilter("internalId","");
	}


	public ProfileForm profileIdFieldForBrandFilter(String parameterName, String initValue){
		FormField field =  profileIdFromBrandFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdFieldForBrandFilter(String initValue){
		return profileIdFieldForBrandFilter("profileId",initValue);
	}
	public ProfileForm profileIdFieldForBrandFilter(){
		return profileIdFieldForBrandFilter("profileId","");
	}


	public ProfileForm priceFilterIdFieldForPriceFilter(String parameterName, String initValue){
		FormField field =  idFromPriceFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm priceFilterIdFieldForPriceFilter(String initValue){
		return priceFilterIdFieldForPriceFilter("priceFilterId",initValue);
	}
	public ProfileForm priceFilterIdFieldForPriceFilter(){
		return priceFilterIdFieldForPriceFilter("priceFilterId","");
	}


	public ProfileForm nameFieldForPriceFilter(String parameterName, String initValue){
		FormField field =  nameFromPriceFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameFieldForPriceFilter(String initValue){
		return nameFieldForPriceFilter("name",initValue);
	}
	public ProfileForm nameFieldForPriceFilter(){
		return nameFieldForPriceFilter("name","");
	}


	public ProfileForm priceStartFieldForPriceFilter(String parameterName, String initValue){
		FormField field =  priceStartFromPriceFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm priceStartFieldForPriceFilter(String initValue){
		return priceStartFieldForPriceFilter("priceStart",initValue);
	}
	public ProfileForm priceStartFieldForPriceFilter(){
		return priceStartFieldForPriceFilter("priceStart","");
	}


	public ProfileForm priceEndFieldForPriceFilter(String parameterName, String initValue){
		FormField field =  priceEndFromPriceFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm priceEndFieldForPriceFilter(String initValue){
		return priceEndFieldForPriceFilter("priceEnd",initValue);
	}
	public ProfileForm priceEndFieldForPriceFilter(){
		return priceEndFieldForPriceFilter("priceEnd","");
	}


	public ProfileForm profileIdFieldForPriceFilter(String parameterName, String initValue){
		FormField field =  profileIdFromPriceFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdFieldForPriceFilter(String initValue){
		return profileIdFieldForPriceFilter("profileId",initValue);
	}
	public ProfileForm profileIdFieldForPriceFilter(){
		return profileIdFieldForPriceFilter("profileId","");
	}


	public ProfileForm categoryFilterIdFieldForCategoryFilter(String parameterName, String initValue){
		FormField field =  idFromCategoryFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm categoryFilterIdFieldForCategoryFilter(String initValue){
		return categoryFilterIdFieldForCategoryFilter("categoryFilterId",initValue);
	}
	public ProfileForm categoryFilterIdFieldForCategoryFilter(){
		return categoryFilterIdFieldForCategoryFilter("categoryFilterId","");
	}


	public ProfileForm nameFieldForCategoryFilter(String parameterName, String initValue){
		FormField field =  nameFromCategoryFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameFieldForCategoryFilter(String initValue){
		return nameFieldForCategoryFilter("name",initValue);
	}
	public ProfileForm nameFieldForCategoryFilter(){
		return nameFieldForCategoryFilter("name","");
	}


	public ProfileForm internalIdFieldForCategoryFilter(String parameterName, String initValue){
		FormField field =  internalIdFromCategoryFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm internalIdFieldForCategoryFilter(String initValue){
		return internalIdFieldForCategoryFilter("internalId",initValue);
	}
	public ProfileForm internalIdFieldForCategoryFilter(){
		return internalIdFieldForCategoryFilter("internalId","");
	}


	public ProfileForm profileIdFieldForCategoryFilter(String parameterName, String initValue){
		FormField field =  profileIdFromCategoryFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdFieldForCategoryFilter(String initValue){
		return profileIdFieldForCategoryFilter("profileId",initValue);
	}
	public ProfileForm profileIdFieldForCategoryFilter(){
		return profileIdFieldForCategoryFilter("profileId","");
	}


	public ProfileForm newProductIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  idFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm newProductIdFieldForNewProduct(String initValue){
		return newProductIdFieldForNewProduct("newProductId",initValue);
	}
	public ProfileForm newProductIdFieldForNewProduct(){
		return newProductIdFieldForNewProduct("newProductId","");
	}


	public ProfileForm nameFieldForNewProduct(String parameterName, String initValue){
		FormField field =  nameFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameFieldForNewProduct(String initValue){
		return nameFieldForNewProduct("name",initValue);
	}
	public ProfileForm nameFieldForNewProduct(){
		return nameFieldForNewProduct("name","");
	}


	public ProfileForm parentCategoryIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm parentCategoryIdFieldForNewProduct(String initValue){
		return parentCategoryIdFieldForNewProduct("parentCategoryId",initValue);
	}
	public ProfileForm parentCategoryIdFieldForNewProduct(){
		return parentCategoryIdFieldForNewProduct("parentCategoryId","");
	}


	public ProfileForm brandIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  brandIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm brandIdFieldForNewProduct(String initValue){
		return brandIdFieldForNewProduct("brandId",initValue);
	}
	public ProfileForm brandIdFieldForNewProduct(){
		return brandIdFieldForNewProduct("brandId","");
	}


	public ProfileForm productCoverImageFieldForNewProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm productCoverImageFieldForNewProduct(String initValue){
		return productCoverImageFieldForNewProduct("productCoverImage",initValue);
	}
	public ProfileForm productCoverImageFieldForNewProduct(){
		return productCoverImageFieldForNewProduct("productCoverImage","");
	}


	public ProfileForm originFieldForNewProduct(String parameterName, String initValue){
		FormField field =  originFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm originFieldForNewProduct(String initValue){
		return originFieldForNewProduct("origin",initValue);
	}
	public ProfileForm originFieldForNewProduct(){
		return originFieldForNewProduct("origin","");
	}


	public ProfileForm catalogIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm catalogIdFieldForNewProduct(String initValue){
		return catalogIdFieldForNewProduct("catalogId",initValue);
	}
	public ProfileForm catalogIdFieldForNewProduct(){
		return catalogIdFieldForNewProduct("catalogId","");
	}


	public ProfileForm profileIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  profileIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdFieldForNewProduct(String initValue){
		return profileIdFieldForNewProduct("profileId",initValue);
	}
	public ProfileForm profileIdFieldForNewProduct(){
		return profileIdFieldForNewProduct("profileId","");
	}


	public ProfileForm remarkFieldForNewProduct(String parameterName, String initValue){
		FormField field =  remarkFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm remarkFieldForNewProduct(String initValue){
		return remarkFieldForNewProduct("remark",initValue);
	}
	public ProfileForm remarkFieldForNewProduct(){
		return remarkFieldForNewProduct("remark","");
	}


	public ProfileForm lastUpdateTimeFieldForNewProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm lastUpdateTimeFieldForNewProduct(String initValue){
		return lastUpdateTimeFieldForNewProduct("lastUpdateTime",initValue);
	}
	public ProfileForm lastUpdateTimeFieldForNewProduct(){
		return lastUpdateTimeFieldForNewProduct("lastUpdateTime","");
	}


	public ProfileForm platformIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  platformIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdFieldForNewProduct(String initValue){
		return platformIdFieldForNewProduct("platformId",initValue);
	}
	public ProfileForm platformIdFieldForNewProduct(){
		return platformIdFieldForNewProduct("platformId","");
	}


	public ProfileForm editorPickProductIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  idFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm editorPickProductIdFieldForEditorPickProduct(String initValue){
		return editorPickProductIdFieldForEditorPickProduct("editorPickProductId",initValue);
	}
	public ProfileForm editorPickProductIdFieldForEditorPickProduct(){
		return editorPickProductIdFieldForEditorPickProduct("editorPickProductId","");
	}


	public ProfileForm nameFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  nameFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameFieldForEditorPickProduct(String initValue){
		return nameFieldForEditorPickProduct("name",initValue);
	}
	public ProfileForm nameFieldForEditorPickProduct(){
		return nameFieldForEditorPickProduct("name","");
	}


	public ProfileForm parentCategoryIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm parentCategoryIdFieldForEditorPickProduct(String initValue){
		return parentCategoryIdFieldForEditorPickProduct("parentCategoryId",initValue);
	}
	public ProfileForm parentCategoryIdFieldForEditorPickProduct(){
		return parentCategoryIdFieldForEditorPickProduct("parentCategoryId","");
	}


	public ProfileForm brandIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  brandIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm brandIdFieldForEditorPickProduct(String initValue){
		return brandIdFieldForEditorPickProduct("brandId",initValue);
	}
	public ProfileForm brandIdFieldForEditorPickProduct(){
		return brandIdFieldForEditorPickProduct("brandId","");
	}


	public ProfileForm productCoverImageFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm productCoverImageFieldForEditorPickProduct(String initValue){
		return productCoverImageFieldForEditorPickProduct("productCoverImage",initValue);
	}
	public ProfileForm productCoverImageFieldForEditorPickProduct(){
		return productCoverImageFieldForEditorPickProduct("productCoverImage","");
	}


	public ProfileForm originFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  originFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm originFieldForEditorPickProduct(String initValue){
		return originFieldForEditorPickProduct("origin",initValue);
	}
	public ProfileForm originFieldForEditorPickProduct(){
		return originFieldForEditorPickProduct("origin","");
	}


	public ProfileForm catalogIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm catalogIdFieldForEditorPickProduct(String initValue){
		return catalogIdFieldForEditorPickProduct("catalogId",initValue);
	}
	public ProfileForm catalogIdFieldForEditorPickProduct(){
		return catalogIdFieldForEditorPickProduct("catalogId","");
	}


	public ProfileForm profileIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  profileIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdFieldForEditorPickProduct(String initValue){
		return profileIdFieldForEditorPickProduct("profileId",initValue);
	}
	public ProfileForm profileIdFieldForEditorPickProduct(){
		return profileIdFieldForEditorPickProduct("profileId","");
	}


	public ProfileForm remarkFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  remarkFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm remarkFieldForEditorPickProduct(String initValue){
		return remarkFieldForEditorPickProduct("remark",initValue);
	}
	public ProfileForm remarkFieldForEditorPickProduct(){
		return remarkFieldForEditorPickProduct("remark","");
	}


	public ProfileForm lastUpdateTimeFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm lastUpdateTimeFieldForEditorPickProduct(String initValue){
		return lastUpdateTimeFieldForEditorPickProduct("lastUpdateTime",initValue);
	}
	public ProfileForm lastUpdateTimeFieldForEditorPickProduct(){
		return lastUpdateTimeFieldForEditorPickProduct("lastUpdateTime","");
	}


	public ProfileForm platformIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  platformIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdFieldForEditorPickProduct(String initValue){
		return platformIdFieldForEditorPickProduct("platformId",initValue);
	}
	public ProfileForm platformIdFieldForEditorPickProduct(){
		return platformIdFieldForEditorPickProduct("platformId","");
	}


	public ProfileForm topRatedProductIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  idFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm topRatedProductIdFieldForTopRatedProduct(String initValue){
		return topRatedProductIdFieldForTopRatedProduct("topRatedProductId",initValue);
	}
	public ProfileForm topRatedProductIdFieldForTopRatedProduct(){
		return topRatedProductIdFieldForTopRatedProduct("topRatedProductId","");
	}


	public ProfileForm nameFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  nameFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameFieldForTopRatedProduct(String initValue){
		return nameFieldForTopRatedProduct("name",initValue);
	}
	public ProfileForm nameFieldForTopRatedProduct(){
		return nameFieldForTopRatedProduct("name","");
	}


	public ProfileForm parentCategoryIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm parentCategoryIdFieldForTopRatedProduct(String initValue){
		return parentCategoryIdFieldForTopRatedProduct("parentCategoryId",initValue);
	}
	public ProfileForm parentCategoryIdFieldForTopRatedProduct(){
		return parentCategoryIdFieldForTopRatedProduct("parentCategoryId","");
	}


	public ProfileForm brandIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  brandIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm brandIdFieldForTopRatedProduct(String initValue){
		return brandIdFieldForTopRatedProduct("brandId",initValue);
	}
	public ProfileForm brandIdFieldForTopRatedProduct(){
		return brandIdFieldForTopRatedProduct("brandId","");
	}


	public ProfileForm productCoverImageFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm productCoverImageFieldForTopRatedProduct(String initValue){
		return productCoverImageFieldForTopRatedProduct("productCoverImage",initValue);
	}
	public ProfileForm productCoverImageFieldForTopRatedProduct(){
		return productCoverImageFieldForTopRatedProduct("productCoverImage","");
	}


	public ProfileForm originFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  originFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm originFieldForTopRatedProduct(String initValue){
		return originFieldForTopRatedProduct("origin",initValue);
	}
	public ProfileForm originFieldForTopRatedProduct(){
		return originFieldForTopRatedProduct("origin","");
	}


	public ProfileForm catalogIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm catalogIdFieldForTopRatedProduct(String initValue){
		return catalogIdFieldForTopRatedProduct("catalogId",initValue);
	}
	public ProfileForm catalogIdFieldForTopRatedProduct(){
		return catalogIdFieldForTopRatedProduct("catalogId","");
	}


	public ProfileForm remarkFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  remarkFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm remarkFieldForTopRatedProduct(String initValue){
		return remarkFieldForTopRatedProduct("remark",initValue);
	}
	public ProfileForm remarkFieldForTopRatedProduct(){
		return remarkFieldForTopRatedProduct("remark","");
	}


	public ProfileForm lastUpdateTimeFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm lastUpdateTimeFieldForTopRatedProduct(String initValue){
		return lastUpdateTimeFieldForTopRatedProduct("lastUpdateTime",initValue);
	}
	public ProfileForm lastUpdateTimeFieldForTopRatedProduct(){
		return lastUpdateTimeFieldForTopRatedProduct("lastUpdateTime","");
	}


	public ProfileForm profileIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  profileIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdFieldForTopRatedProduct(String initValue){
		return profileIdFieldForTopRatedProduct("profileId",initValue);
	}
	public ProfileForm profileIdFieldForTopRatedProduct(){
		return profileIdFieldForTopRatedProduct("profileId","");
	}


	public ProfileForm platformIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  platformIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdFieldForTopRatedProduct(String initValue){
		return platformIdFieldForTopRatedProduct("platformId",initValue);
	}
	public ProfileForm platformIdFieldForTopRatedProduct(){
		return platformIdFieldForTopRatedProduct("platformId","");
	}


	public ProfileForm recommandProductIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  idFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm recommandProductIdFieldForRecommandProduct(String initValue){
		return recommandProductIdFieldForRecommandProduct("recommandProductId",initValue);
	}
	public ProfileForm recommandProductIdFieldForRecommandProduct(){
		return recommandProductIdFieldForRecommandProduct("recommandProductId","");
	}


	public ProfileForm nameFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  nameFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameFieldForRecommandProduct(String initValue){
		return nameFieldForRecommandProduct("name",initValue);
	}
	public ProfileForm nameFieldForRecommandProduct(){
		return nameFieldForRecommandProduct("name","");
	}


	public ProfileForm parentCategoryIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm parentCategoryIdFieldForRecommandProduct(String initValue){
		return parentCategoryIdFieldForRecommandProduct("parentCategoryId",initValue);
	}
	public ProfileForm parentCategoryIdFieldForRecommandProduct(){
		return parentCategoryIdFieldForRecommandProduct("parentCategoryId","");
	}


	public ProfileForm brandIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  brandIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm brandIdFieldForRecommandProduct(String initValue){
		return brandIdFieldForRecommandProduct("brandId",initValue);
	}
	public ProfileForm brandIdFieldForRecommandProduct(){
		return brandIdFieldForRecommandProduct("brandId","");
	}


	public ProfileForm productCoverImageFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm productCoverImageFieldForRecommandProduct(String initValue){
		return productCoverImageFieldForRecommandProduct("productCoverImage",initValue);
	}
	public ProfileForm productCoverImageFieldForRecommandProduct(){
		return productCoverImageFieldForRecommandProduct("productCoverImage","");
	}


	public ProfileForm originFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  originFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm originFieldForRecommandProduct(String initValue){
		return originFieldForRecommandProduct("origin",initValue);
	}
	public ProfileForm originFieldForRecommandProduct(){
		return originFieldForRecommandProduct("origin","");
	}


	public ProfileForm catalogIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm catalogIdFieldForRecommandProduct(String initValue){
		return catalogIdFieldForRecommandProduct("catalogId",initValue);
	}
	public ProfileForm catalogIdFieldForRecommandProduct(){
		return catalogIdFieldForRecommandProduct("catalogId","");
	}


	public ProfileForm remarkFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  remarkFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm remarkFieldForRecommandProduct(String initValue){
		return remarkFieldForRecommandProduct("remark",initValue);
	}
	public ProfileForm remarkFieldForRecommandProduct(){
		return remarkFieldForRecommandProduct("remark","");
	}


	public ProfileForm lastUpdateTimeFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm lastUpdateTimeFieldForRecommandProduct(String initValue){
		return lastUpdateTimeFieldForRecommandProduct("lastUpdateTime",initValue);
	}
	public ProfileForm lastUpdateTimeFieldForRecommandProduct(){
		return lastUpdateTimeFieldForRecommandProduct("lastUpdateTime","");
	}


	public ProfileForm profileIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  profileIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdFieldForRecommandProduct(String initValue){
		return profileIdFieldForRecommandProduct("profileId",initValue);
	}
	public ProfileForm profileIdFieldForRecommandProduct(){
		return profileIdFieldForRecommandProduct("profileId","");
	}


	public ProfileForm platformIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  platformIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdFieldForRecommandProduct(String initValue){
		return platformIdFieldForRecommandProduct("platformId",initValue);
	}
	public ProfileForm platformIdFieldForRecommandProduct(){
		return platformIdFieldForRecommandProduct("platformId","");
	}

	

	
 	public ProfileForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/profileId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProfileForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


