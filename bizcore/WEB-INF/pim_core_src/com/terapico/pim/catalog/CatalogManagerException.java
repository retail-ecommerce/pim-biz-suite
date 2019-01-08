
package com.terapico.pim.catalog;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class CatalogManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public CatalogManagerException(String string) {
		super(string);
	}
	public CatalogManagerException(Message message) {
		super(message);
	}
	public CatalogManagerException(List<Message> messageList) {
		super(messageList);
	}

}


