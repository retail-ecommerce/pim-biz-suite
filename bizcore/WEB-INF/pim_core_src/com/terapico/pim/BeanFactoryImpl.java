
package com.terapico.pim;
import java.util.Map;

import com.terapico.pim.platform.Platform;
import com.terapico.pim.site.Site;
import com.terapico.pim.catalog.Catalog;
import com.terapico.pim.levelonecategory.LevelOneCategory;
import com.terapico.pim.leveltwocategory.LevelTwoCategory;
import com.terapico.pim.levelncategory.LevelNCategory;
import com.terapico.pim.brand.Brand;
import com.terapico.pim.product.Product;
import com.terapico.pim.sku.Sku;
import com.terapico.pim.userdomain.UserDomain;
import com.terapico.pim.userwhitelist.UserWhiteList;
import com.terapico.pim.secuser.SecUser;
import com.terapico.pim.secuserblocking.SecUserBlocking;
import com.terapico.pim.userapp.UserApp;
import com.terapico.pim.listaccess.ListAccess;
import com.terapico.pim.objectaccess.ObjectAccess;
import com.terapico.pim.loginhistory.LoginHistory;
import com.terapico.pim.genericform.GenericForm;
import com.terapico.pim.formmessage.FormMessage;
import com.terapico.pim.formfieldmessage.FormFieldMessage;
import com.terapico.pim.formfield.FormField;
import com.terapico.pim.formaction.FormAction;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public Site createSite(Map<String,Object> options){
		return new Site();
	}


	public Catalog createCatalog(Map<String,Object> options){
		return new Catalog();
	}


	public LevelOneCategory createLevelOneCategory(Map<String,Object> options){
		return new LevelOneCategory();
	}


	public LevelTwoCategory createLevelTwoCategory(Map<String,Object> options){
		return new LevelTwoCategory();
	}


	public LevelNCategory createLevelNCategory(Map<String,Object> options){
		return new LevelNCategory();
	}


	public Brand createBrand(Map<String,Object> options){
		return new Brand();
	}


	public Product createProduct(Map<String,Object> options){
		return new Product();
	}


	public Sku createSku(Map<String,Object> options){
		return new Sku();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}





}










