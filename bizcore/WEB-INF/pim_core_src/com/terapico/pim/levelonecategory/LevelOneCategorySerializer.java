package com.terapico.pim.levelonecategory;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.pim.PimObjectPlainCustomSerializer;
public class LevelOneCategorySerializer extends PimObjectPlainCustomSerializer<LevelOneCategory>{

	@Override
	public void serialize(LevelOneCategory levelOneCategory, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, levelOneCategory, provider);
		
	}
}


