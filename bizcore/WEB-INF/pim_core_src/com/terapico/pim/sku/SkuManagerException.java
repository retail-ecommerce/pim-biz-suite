
package com.terapico.pim.sku;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class SkuManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public SkuManagerException(String string) {
		super(string);
	}
	public SkuManagerException(Message message) {
		super(message);
	}
	public SkuManagerException(List<Message> messageList) {
		super(messageList);
	}

}


