
package com.terapico.pim.leveltwocategory;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class LevelTwoCategoryManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public LevelTwoCategoryManagerException(String string) {
		super(string);
	}
	public LevelTwoCategoryManagerException(Message message) {
		super(message);
	}
	public LevelTwoCategoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


