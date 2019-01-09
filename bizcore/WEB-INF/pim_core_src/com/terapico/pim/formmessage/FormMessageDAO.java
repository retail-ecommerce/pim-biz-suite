
package com.terapico.pim.formmessage;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.pim.BaseEntity;
import com.terapico.pim.SmartList;
import com.terapico.pim.MultipleAccessKey;
import com.terapico.pim.PimUserContext;
import com.terapico.pim.genericform.GenericFormDAO;


public interface FormMessageDAO{

	
	public FormMessage load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<FormMessage> formMessageList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public FormMessage present(FormMessage formMessage,Map<String,Object> options) throws Exception;
	public FormMessage clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public FormMessage save(FormMessage formMessage,Map<String,Object> options);
	public SmartList<FormMessage> saveFormMessageList(SmartList<FormMessage> formMessageList,Map<String,Object> options);
	public SmartList<FormMessage> removeFormMessageList(SmartList<FormMessage> formMessageList,Map<String,Object> options);
	public SmartList<FormMessage> findFormMessageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countFormMessageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countFormMessageWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String formMessageId, int version) throws Exception;
	public FormMessage disconnectFromAll(String formMessageId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<FormMessage> queryList(String sql, Object ... parmeters);
 
 	public SmartList<FormMessage> findFormMessageByForm(String genericFormId, Map<String,Object> options);
 	public int countFormMessageByForm(String genericFormId, Map<String,Object> options);
 	public Map<String, Integer> countFormMessageByFormIds(String[] ids, Map<String,Object> options);
 	public SmartList<FormMessage> findFormMessageByForm(String genericFormId, int start, int count, Map<String,Object> options);
 	public void analyzeFormMessageByForm(SmartList<FormMessage> resultList, String genericFormId, Map<String,Object> options);

 
 }

