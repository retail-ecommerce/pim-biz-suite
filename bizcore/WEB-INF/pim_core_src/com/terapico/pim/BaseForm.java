package com.terapico.pim;

import com.terapico.pim.genericform.GenericForm;
import com.terapico.pim.formfield.FormField;
import com.terapico.pim.formaction.FormAction;
import com.terapico.pim.formmessage.FormMessage;
import com.terapico.pim.formfieldmessage.FormFieldMessage;




public class BaseForm extends GenericForm{

	public FormField getFieldByParamterName(String parameterName){
        
        for(FormField field: this.getFormFieldList()){
            if(parameterName.equals(field.getParameterName())){
                return field;
            }
            
        }
        return null;
    }
	public BaseForm hideByParamterName(String parameterName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setType("hidden");
				break;
			}
			
		}
		return this;
	}
	public BaseForm disableByParamterName(String parameterName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setDisabled(true);
				break;
			}
			
		}
		return this;
	}
	public BaseForm setAllGroupNameTo(String groupName){
		
		for(FormField field: this.getFormFieldList()){
			field.setFieldGroup(groupName);
		}
		return this;
		
	}
	
	public BaseForm disableByGroup(String groupName){
		
		for(FormField field: this.getFormFieldList()){
			if(groupName.equals(field.getFieldGroup())){
				field.setDisabled(true);
				continue;
			}
			
		}
		return this;
		
	}
	
	public BaseForm setGroupNameByParamterName(String parameterName, String groupName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setFieldGroup(groupName);
				break;
			}
			
		}
		return this;
		
	}


	protected FormField idFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("platform.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("platform.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField introductionFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Introduction");
		field.setLocaleKey("platform.introduction");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Introduction");
		return field;
	}

	protected FormField currentVersionFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Current Version");
		field.setLocaleKey("platform.current_version");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Current Version");
		return field;
	}

	protected FormField idFromSite(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("site.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromSite(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("site.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField introductionFromSite(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Introduction");
		field.setLocaleKey("site.introduction");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Introduction");
		return field;
	}

	protected FormField platformIdFromSite(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Platform");
		field.setLocaleKey("site.platform");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Platform");
		field.setRequired(true);
		field.setPlaceholder("请填写Platform");
		return field;
	}

	protected FormField lastUpdateTimeFromSite(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("site.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromCatalog(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("catalog.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromCatalog(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("catalog.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField sellerIdFromCatalog(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Seller Id");
		field.setLocaleKey("catalog.seller_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Seller Id");
		return field;
	}

	protected FormField siteIdFromCatalog(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Site");
		field.setLocaleKey("catalog.site");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Site");
		field.setRequired(true);
		field.setPlaceholder("请填写Site");
		return field;
	}

	protected FormField platformIdFromCatalog(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Platform");
		field.setLocaleKey("catalog.platform");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Platform");
		field.setRequired(true);
		field.setPlaceholder("请填写Platform");
		return field;
	}

	protected FormField idFromLevelOneCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("level_one_category.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField catalogIdFromLevelOneCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Catalog");
		field.setLocaleKey("level_one_category.catalog");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Catalog");
		field.setRequired(true);
		field.setPlaceholder("请填写Catalog");
		return field;
	}

	protected FormField nameFromLevelOneCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("level_one_category.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField idFromLevelTwoCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("level_two_category.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField parentCategoryIdFromLevelTwoCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Parent Category");
		field.setLocaleKey("level_two_category.parent_category");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("LevelOneCategory");
		field.setRequired(true);
		field.setPlaceholder("请填写Parent Category");
		return field;
	}

	protected FormField nameFromLevelTwoCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("level_two_category.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField idFromLevelNCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("level_n_category.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField parentCategoryIdFromLevelNCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Parent Category");
		field.setLocaleKey("level_n_category.parent_category");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("LevelTwoCategory");
		field.setRequired(true);
		field.setPlaceholder("请填写Parent Category");
		return field;
	}

	protected FormField nameFromLevelNCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("level_n_category.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField idFromBrand(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("brand.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField brandNameFromBrand(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Brand Name");
		field.setLocaleKey("brand.brand_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Brand Name");
		return field;
	}

	protected FormField logoFromBrand(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Logo");
		field.setLocaleKey("brand.logo");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("image");
		field.setRequired(true);
		field.setPlaceholder("请填写Logo");
		return field;
	}

	protected FormField remarkFromBrand(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Remark");
		field.setLocaleKey("brand.remark");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Remark");
		return field;
	}

	protected FormField platformIdFromBrand(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Platform");
		field.setLocaleKey("brand.platform");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Platform");
		field.setRequired(true);
		field.setPlaceholder("请填写Platform");
		return field;
	}

	protected FormField idFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("product.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("product.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField parentCategoryIdFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Parent Category");
		field.setLocaleKey("product.parent_category");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("LevelNCategory");
		field.setRequired(true);
		field.setPlaceholder("请填写Parent Category");
		return field;
	}

	protected FormField brandIdFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Brand");
		field.setLocaleKey("product.brand");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Brand");
		field.setRequired(true);
		field.setPlaceholder("请填写Brand");
		return field;
	}

	protected FormField originFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Origin");
		field.setLocaleKey("product.origin");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Origin");
		return field;
	}

	protected FormField catalogIdFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Catalog");
		field.setLocaleKey("product.catalog");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Catalog");
		field.setRequired(true);
		field.setPlaceholder("请填写Catalog");
		return field;
	}

	protected FormField remarkFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Remark");
		field.setLocaleKey("product.remark");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Remark");
		return field;
	}

	protected FormField lastUpdateTimeFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("product.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("sku.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("sku.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField sizeFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Size");
		field.setLocaleKey("sku.size");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Size");
		return field;
	}

	protected FormField productIdFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Product");
		field.setLocaleKey("sku.product");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Product");
		field.setRequired(true);
		field.setPlaceholder("请填写Product");
		return field;
	}

	protected FormField activeFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Active");
		field.setLocaleKey("sku.active");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Active");
		return field;
	}

	protected FormField basePriceFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Base Price");
		field.setLocaleKey("sku.base_price");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写Base Price");
		return field;
	}

	protected FormField lastUpdateTimeFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("sku.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromUserDomain(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("user_domain.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromUserDomain(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("user_domain.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField idFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("user_white_list.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField userIdentityFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("User Identity");
		field.setLocaleKey("user_white_list.user_identity");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写User Identity");
		return field;
	}

	protected FormField userSpecialFunctionsFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("User Special Functions");
		field.setLocaleKey("user_white_list.user_special_functions");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写User Special Functions");
		return field;
	}

	protected FormField domainIdFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Domain");
		field.setLocaleKey("user_white_list.domain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserDomain");
		field.setRequired(true);
		field.setPlaceholder("请填写Domain");
		return field;
	}

	protected FormField idFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("sec_user.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField loginFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Login");
		field.setLocaleKey("sec_user.login");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Login");
		return field;
	}

	protected FormField mobileFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Mobile");
		field.setLocaleKey("sec_user.mobile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写Mobile");
		return field;
	}

	protected FormField emailFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Email");
		field.setLocaleKey("sec_user.email");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Email");
		return field;
	}

	protected FormField pwdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Pwd");
		field.setLocaleKey("sec_user.pwd");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("password");
		field.setRequired(true);
		field.setPlaceholder("请填写Pwd");
		return field;
	}

	protected FormField verificationCodeFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Verification Code");
		field.setLocaleKey("sec_user.verification_code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Verification Code");
		return field;
	}

	protected FormField verificationCodeExpireFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Verification Code Expire");
		field.setLocaleKey("sec_user.verification_code_expire");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Verification Code Expire");
		return field;
	}

	protected FormField lastLoginTimeFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Login Time");
		field.setLocaleKey("sec_user.last_login_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Login Time");
		return field;
	}

	protected FormField domainIdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Domain");
		field.setLocaleKey("sec_user.domain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserDomain");
		field.setRequired(true);
		field.setPlaceholder("请填写Domain");
		return field;
	}

	protected FormField blockingIdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Blocking");
		field.setLocaleKey("sec_user.blocking");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUserBlocking");
		field.setRequired(true);
		field.setPlaceholder("请填写Blocking");
		return field;
	}

	protected FormField currentStatusFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Current Status");
		field.setLocaleKey("sec_user.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Current Status");
		return field;
	}

	protected FormField idFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("sec_user_blocking.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField whoFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Who");
		field.setLocaleKey("sec_user_blocking.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Who");
		return field;
	}

	protected FormField blockTimeFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Block Time");
		field.setLocaleKey("sec_user_blocking.block_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Block Time");
		return field;
	}

	protected FormField commentsFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Comments");
		field.setLocaleKey("sec_user_blocking.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Comments");
		return field;
	}

	protected FormField idFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("user_app.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField titleFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Title");
		field.setLocaleKey("user_app.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Title");
		return field;
	}

	protected FormField secUserIdFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Sec User");
		field.setLocaleKey("user_app.sec_user");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUser");
		field.setRequired(true);
		field.setPlaceholder("请填写Sec User");
		return field;
	}

	protected FormField appIconFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("App Icon");
		field.setLocaleKey("user_app.app_icon");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写App Icon");
		return field;
	}

	protected FormField fullAccessFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Full Access");
		field.setLocaleKey("user_app.full_access");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Full Access");
		return field;
	}

	protected FormField permissionFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Permission");
		field.setLocaleKey("user_app.permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Permission");
		return field;
	}

	protected FormField objectTypeFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Object Type");
		field.setLocaleKey("user_app.object_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Object Type");
		return field;
	}

	protected FormField objectIdFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Object Id");
		field.setLocaleKey("user_app.object_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Object Id");
		return field;
	}

	protected FormField locationFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Location");
		field.setLocaleKey("user_app.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Location");
		return field;
	}

	protected FormField idFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("list_access.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("list_access.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField internalNameFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Internal Name");
		field.setLocaleKey("list_access.internal_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Internal Name");
		return field;
	}

	protected FormField readPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Read Permission");
		field.setLocaleKey("list_access.read_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Read Permission");
		return field;
	}

	protected FormField createPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Create Permission");
		field.setLocaleKey("list_access.create_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Create Permission");
		return field;
	}

	protected FormField deletePermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Delete Permission");
		field.setLocaleKey("list_access.delete_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Delete Permission");
		return field;
	}

	protected FormField updatePermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Update Permission");
		field.setLocaleKey("list_access.update_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Update Permission");
		return field;
	}

	protected FormField executionPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Execution Permission");
		field.setLocaleKey("list_access.execution_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Execution Permission");
		return field;
	}

	protected FormField appIdFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("App");
		field.setLocaleKey("list_access.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("请填写App");
		return field;
	}

	protected FormField idFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("object_access.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("object_access.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField objectTypeFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Object Type");
		field.setLocaleKey("object_access.object_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Object Type");
		return field;
	}

	protected FormField list1FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List1");
		field.setLocaleKey("object_access.list1");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List1");
		return field;
	}

	protected FormField list2FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List2");
		field.setLocaleKey("object_access.list2");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List2");
		return field;
	}

	protected FormField list3FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List3");
		field.setLocaleKey("object_access.list3");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List3");
		return field;
	}

	protected FormField list4FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List4");
		field.setLocaleKey("object_access.list4");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List4");
		return field;
	}

	protected FormField list5FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List5");
		field.setLocaleKey("object_access.list5");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List5");
		return field;
	}

	protected FormField list6FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List6");
		field.setLocaleKey("object_access.list6");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List6");
		return field;
	}

	protected FormField list7FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List7");
		field.setLocaleKey("object_access.list7");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List7");
		return field;
	}

	protected FormField list8FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List8");
		field.setLocaleKey("object_access.list8");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List8");
		return field;
	}

	protected FormField list9FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List9");
		field.setLocaleKey("object_access.list9");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List9");
		return field;
	}

	protected FormField appIdFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("App");
		field.setLocaleKey("object_access.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("请填写App");
		return field;
	}

	protected FormField idFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("login_history.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField loginTimeFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Login Time");
		field.setLocaleKey("login_history.login_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Login Time");
		return field;
	}

	protected FormField fromIpFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("From Ip");
		field.setLocaleKey("login_history.from_ip");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写From Ip");
		return field;
	}

	protected FormField descriptionFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Description");
		field.setLocaleKey("login_history.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Description");
		return field;
	}

	protected FormField secUserIdFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Sec User");
		field.setLocaleKey("login_history.sec_user");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUser");
		field.setRequired(true);
		field.setPlaceholder("请填写Sec User");
		return field;
	}

	protected FormField idFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("generic_form.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField titleFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Title");
		field.setLocaleKey("generic_form.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Title");
		return field;
	}

	protected FormField descriptionFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Description");
		field.setLocaleKey("generic_form.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Description");
		return field;
	}

	protected FormField idFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("form_message.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField titleFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Title");
		field.setLocaleKey("form_message.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Title");
		return field;
	}

	protected FormField formIdFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Form");
		field.setLocaleKey("form_message.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写Form");
		return field;
	}

	protected FormField levelFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Level");
		field.setLocaleKey("form_message.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Level");
		return field;
	}

	protected FormField idFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("form_field_message.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField titleFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Title");
		field.setLocaleKey("form_field_message.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Title");
		return field;
	}

	protected FormField parameterNameFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Parameter Name");
		field.setLocaleKey("form_field_message.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Parameter Name");
		return field;
	}

	protected FormField formIdFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Form");
		field.setLocaleKey("form_field_message.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写Form");
		return field;
	}

	protected FormField levelFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Level");
		field.setLocaleKey("form_field_message.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Level");
		return field;
	}

	protected FormField idFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("form_field.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField labelFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Label");
		field.setLocaleKey("form_field.label");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Label");
		return field;
	}

	protected FormField localeKeyFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Locale Key");
		field.setLocaleKey("form_field.locale_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Locale Key");
		return field;
	}

	protected FormField parameterNameFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Parameter Name");
		field.setLocaleKey("form_field.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Parameter Name");
		return field;
	}

	protected FormField typeFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Type");
		field.setLocaleKey("form_field.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Type");
		return field;
	}

	protected FormField formIdFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Form");
		field.setLocaleKey("form_field.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写Form");
		return field;
	}

	protected FormField placeholderFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Placeholder");
		field.setLocaleKey("form_field.placeholder");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Placeholder");
		return field;
	}

	protected FormField defaultValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Default Value");
		field.setLocaleKey("form_field.default_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Default Value");
		return field;
	}

	protected FormField descriptionFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Description");
		field.setLocaleKey("form_field.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Description");
		return field;
	}

	protected FormField fieldGroupFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Field Group");
		field.setLocaleKey("form_field.field_group");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Field Group");
		return field;
	}

	protected FormField minimumValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Minimum Value");
		field.setLocaleKey("form_field.minimum_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Minimum Value");
		return field;
	}

	protected FormField maximumValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Maximum Value");
		field.setLocaleKey("form_field.maximum_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Maximum Value");
		return field;
	}

	protected FormField requiredFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Required");
		field.setLocaleKey("form_field.required");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Required");
		return field;
	}

	protected FormField disabledFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Disabled");
		field.setLocaleKey("form_field.disabled");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Disabled");
		return field;
	}

	protected FormField customRenderingFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Custom Rendering");
		field.setLocaleKey("form_field.custom_rendering");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Custom Rendering");
		return field;
	}

	protected FormField candidateValuesFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Candidate Values");
		field.setLocaleKey("form_field.candidate_values");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Candidate Values");
		return field;
	}

	protected FormField suggestValuesFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Suggest Values");
		field.setLocaleKey("form_field.suggest_values");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Suggest Values");
		return field;
	}

	protected FormField idFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("form_action.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField labelFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Label");
		field.setLocaleKey("form_action.label");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Label");
		return field;
	}

	protected FormField localeKeyFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Locale Key");
		field.setLocaleKey("form_action.locale_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Locale Key");
		return field;
	}

	protected FormField actionKeyFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Action Key");
		field.setLocaleKey("form_action.action_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Action Key");
		return field;
	}

	protected FormField levelFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Level");
		field.setLocaleKey("form_action.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Level");
		return field;
	}

	protected FormField urlFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Url");
		field.setLocaleKey("form_action.url");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Url");
		return field;
	}

	protected FormField formIdFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Form");
		field.setLocaleKey("form_action.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写Form");
		return field;
	}

}









