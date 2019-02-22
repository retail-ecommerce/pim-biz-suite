package com.terapico.pim;

public interface FootprintProducer {

	boolean canReplaceFootPrint(Footprint fp, Footprint item);
	boolean clearTop();
	String getBeanName();
}


