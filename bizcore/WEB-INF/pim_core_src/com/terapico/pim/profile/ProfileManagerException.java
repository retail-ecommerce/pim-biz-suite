
package com.terapico.pim.profile;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class ProfileManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public ProfileManagerException(String string) {
		super(string);
	}
	public ProfileManagerException(Message message) {
		super(message);
	}
	public ProfileManagerException(List<Message> messageList) {
		super(messageList);
	}

}


