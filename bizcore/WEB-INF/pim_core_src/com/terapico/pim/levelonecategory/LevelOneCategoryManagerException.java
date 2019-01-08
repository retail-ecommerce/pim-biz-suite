
package com.terapico.pim.levelonecategory;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class LevelOneCategoryManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public LevelOneCategoryManagerException(String string) {
		super(string);
	}
	public LevelOneCategoryManagerException(Message message) {
		super(message);
	}
	public LevelOneCategoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


