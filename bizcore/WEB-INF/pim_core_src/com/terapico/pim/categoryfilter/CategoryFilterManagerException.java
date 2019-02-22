
package com.terapico.pim.categoryfilter;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class CategoryFilterManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public CategoryFilterManagerException(String string) {
		super(string);
	}
	public CategoryFilterManagerException(Message message) {
		super(message);
	}
	public CategoryFilterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


