
package com.terapico.pim.recommandproduct;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class RecommandProductManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public RecommandProductManagerException(String string) {
		super(string);
	}
	public RecommandProductManagerException(Message message) {
		super(message);
	}
	public RecommandProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


