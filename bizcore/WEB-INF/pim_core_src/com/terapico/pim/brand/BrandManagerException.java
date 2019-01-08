
package com.terapico.pim.brand;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class BrandManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public BrandManagerException(String string) {
		super(string);
	}
	public BrandManagerException(Message message) {
		super(message);
	}
	public BrandManagerException(List<Message> messageList) {
		super(messageList);
	}

}


