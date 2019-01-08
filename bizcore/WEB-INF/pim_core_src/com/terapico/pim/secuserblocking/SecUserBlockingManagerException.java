
package com.terapico.pim.secuserblocking;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class SecUserBlockingManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public SecUserBlockingManagerException(String string) {
		super(string);
	}
	public SecUserBlockingManagerException(Message message) {
		super(message);
	}
	public SecUserBlockingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


