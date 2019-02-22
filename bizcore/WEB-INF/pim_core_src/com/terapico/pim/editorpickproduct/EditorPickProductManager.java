
package com.terapico.pim.editorpickproduct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface EditorPickProductManager{

		

	public EditorPickProduct createEditorPickProduct(PimUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId) throws Exception;	
	public EditorPickProduct updateEditorPickProduct(PimUserContext userContext,String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EditorPickProduct loadEditorPickProduct(PimUserContext userContext, String editorPickProductId, String [] tokensExpr) throws Exception;
	public EditorPickProduct internalSaveEditorPickProduct(PimUserContext userContext, EditorPickProduct editorPickProduct) throws Exception;
	public EditorPickProduct internalSaveEditorPickProduct(PimUserContext userContext, EditorPickProduct editorPickProduct,Map<String,Object>option) throws Exception;
	
	public EditorPickProduct transferToAnotherParentCategory(PimUserContext userContext, String editorPickProductId, String anotherParentCategoryId)  throws Exception;
 	public EditorPickProduct transferToAnotherBrand(PimUserContext userContext, String editorPickProductId, String anotherBrandId)  throws Exception;
 	public EditorPickProduct transferToAnotherCatalog(PimUserContext userContext, String editorPickProductId, String anotherCatalogId)  throws Exception;
 	public EditorPickProduct transferToAnotherProfile(PimUserContext userContext, String editorPickProductId, String anotherProfileId)  throws Exception;
 	public EditorPickProduct transferToAnotherPlatform(PimUserContext userContext, String editorPickProductId, String anotherPlatformId)  throws Exception;
 

	public void delete(PimUserContext userContext, String editorPickProductId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, EditorPickProduct newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


