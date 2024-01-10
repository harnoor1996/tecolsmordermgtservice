package com.tecolms.orders.exception.custom;


public class VendorMasterBusinessException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public VendorMasterBusinessException() {
        super();
    }
      
    public VendorMasterBusinessException(Throwable cause) {

        super(cause);

    }


    public VendorMasterBusinessException(String message, Throwable cause) {

        super(message, cause);


    }

    public VendorMasterBusinessException(String message) {

        super(message);

    }

    
}

