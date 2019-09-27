package br.com.creative.devlet.exception;

public class BussinessException extends Exception {

    public BussinessException(String message) {
        super(message);
    }

    public void thrownIf(Boolean value) throws BussinessException {
        if(value){
            throw this;
        }
    }
}
