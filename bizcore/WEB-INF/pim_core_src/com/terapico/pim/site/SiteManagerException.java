
package com.terapico.pim.site;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class SiteManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public SiteManagerException(String string) {
		super(string);
	}
	public SiteManagerException(Message message) {
		super(message);
	}
	public SiteManagerException(List<Message> messageList) {
		super(messageList);
	}

}


