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

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


