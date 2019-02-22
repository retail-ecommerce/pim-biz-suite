package com.terapico.pim.recommandproduct;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.pim.PimObjectPlainCustomSerializer;
public class RecommandProductSerializer extends PimObjectPlainCustomSerializer<RecommandProduct>{

	@Override
	public void serialize(RecommandProduct recommandProduct, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, recommandProduct, provider);
		
	}
}


