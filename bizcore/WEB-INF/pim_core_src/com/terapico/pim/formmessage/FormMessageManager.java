
package com.terapico.pim.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;

public interface FormMessageManager{

		

	public FormMessage createFormMessage(PimUserContext userContext, String title, String formId, String level) throws Exception;	
	public FormMessage updateFormMessage(PimUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(PimUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(PimUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(PimUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(PimUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(PimUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(PimUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(PimUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


