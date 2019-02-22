
package com.terapico.pim.topratedproduct;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class TopRatedProductManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public TopRatedProductManagerException(String string) {
		super(string);
	}
	public TopRatedProductManagerException(Message message) {
		super(message);
	}
	public TopRatedProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


