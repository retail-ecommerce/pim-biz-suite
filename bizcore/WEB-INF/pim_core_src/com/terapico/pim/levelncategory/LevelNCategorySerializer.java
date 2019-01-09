package com.terapico.pim.levelncategory;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.pim.PimObjectPlainCustomSerializer;
public class LevelNCategorySerializer extends PimObjectPlainCustomSerializer<LevelNCategory>{

	@Override
	public void serialize(LevelNCategory levelNCategory, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, levelNCategory, provider);
		
	}
}


