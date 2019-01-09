
package com.terapico.pim;


public class PimRuntimeException extends RuntimeException {
    static final long serialVersionUID = -1;

    public PimRuntimeException() {
        super();
    }


    public PimRuntimeException(String message) {
        super(message);
    }


    public PimRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }


    public PimRuntimeException(Throwable cause) {
        super(cause);
    }


   
}












