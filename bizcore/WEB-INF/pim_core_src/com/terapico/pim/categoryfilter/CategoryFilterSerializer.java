package com.terapico.pim.categoryfilter;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.pim.PimObjectPlainCustomSerializer;
public class CategoryFilterSerializer extends PimObjectPlainCustomSerializer<CategoryFilter>{

	@Override
	public void serialize(CategoryFilter categoryFilter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, categoryFilter, provider);
		
	}
}


