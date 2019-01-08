package com.terapico.pim;


import com.terapico.pim.platform.PlatformManager;

import com.terapico.pim.site.SiteManager;

import com.terapico.pim.catalog.CatalogManager;

import com.terapico.pim.levelonecategory.LevelOneCategoryManager;

import com.terapico.pim.leveltwocategory.LevelTwoCategoryManager;

import com.terapico.pim.levelncategory.LevelNCategoryManager;

import com.terapico.pim.brand.BrandManager;

import com.terapico.pim.product.ProductManager;

import com.terapico.pim.sku.SkuManager;

import com.terapico.pim.userdomain.UserDomainManager;

import com.terapico.pim.userwhitelist.UserWhiteListManager;

import com.terapico.pim.secuser.SecUserManager;

import com.terapico.pim.secuserblocking.SecUserBlockingManager;

import com.terapico.pim.userapp.UserAppManager;

import com.terapico.pim.listaccess.ListAccessManager;

import com.terapico.pim.objectaccess.ObjectAccessManager;

import com.terapico.pim.loginhistory.LoginHistoryManager;

import com.terapico.pim.genericform.GenericFormManager;

import com.terapico.pim.formmessage.FormMessageManager;

import com.terapico.pim.formfieldmessage.FormFieldMessageManager;

import com.terapico.pim.formfield.FormFieldManager;

import com.terapico.pim.formaction.FormActionManager;


public class ManagerGroup {

	protected PlatformManager platformManager;

	protected SiteManager siteManager;

	protected CatalogManager catalogManager;

	protected LevelOneCategoryManager levelOneCategoryManager;

	protected LevelTwoCategoryManager levelTwoCategoryManager;

	protected LevelNCategoryManager levelNCategoryManager;

	protected BrandManager brandManager;

	protected ProductManager productManager;

	protected SkuManager skuManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected SecUserBlockingManager secUserBlockingManager;

	protected UserAppManager userAppManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	

	public PlatformManager getPlatformManager(){
		return this.platformManager;
	}
	public void setPlatformManager(PlatformManager manager){
		this.platformManager = manager;
	}


	public SiteManager getSiteManager(){
		return this.siteManager;
	}
	public void setSiteManager(SiteManager manager){
		this.siteManager = manager;
	}


	public CatalogManager getCatalogManager(){
		return this.catalogManager;
	}
	public void setCatalogManager(CatalogManager manager){
		this.catalogManager = manager;
	}


	public LevelOneCategoryManager getLevelOneCategoryManager(){
		return this.levelOneCategoryManager;
	}
	public void setLevelOneCategoryManager(LevelOneCategoryManager manager){
		this.levelOneCategoryManager = manager;
	}


	public LevelTwoCategoryManager getLevelTwoCategoryManager(){
		return this.levelTwoCategoryManager;
	}
	public void setLevelTwoCategoryManager(LevelTwoCategoryManager manager){
		this.levelTwoCategoryManager = manager;
	}


	public LevelNCategoryManager getLevelNCategoryManager(){
		return this.levelNCategoryManager;
	}
	public void setLevelNCategoryManager(LevelNCategoryManager manager){
		this.levelNCategoryManager = manager;
	}


	public BrandManager getBrandManager(){
		return this.brandManager;
	}
	public void setBrandManager(BrandManager manager){
		this.brandManager = manager;
	}


	public ProductManager getProductManager(){
		return this.productManager;
	}
	public void setProductManager(ProductManager manager){
		this.productManager = manager;
	}


	public SkuManager getSkuManager(){
		return this.skuManager;
	}
	public void setSkuManager(SkuManager manager){
		this.skuManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public SecUserBlockingManager getSecUserBlockingManager(){
		return this.secUserBlockingManager;
	}
	public void setSecUserBlockingManager(SecUserBlockingManager manager){
		this.secUserBlockingManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


}









