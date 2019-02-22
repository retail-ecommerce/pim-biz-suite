
package com.terapico.pim.brandfilter;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class BrandFilterManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public BrandFilterManagerException(String string) {
		super(string);
	}
	public BrandFilterManagerException(Message message) {
		super(message);
	}
	public BrandFilterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


