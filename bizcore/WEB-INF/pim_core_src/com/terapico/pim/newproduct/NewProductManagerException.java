
package com.terapico.pim.newproduct;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class NewProductManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public NewProductManagerException(String string) {
		super(string);
	}
	public NewProductManagerException(Message message) {
		super(message);
	}
	public NewProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


