package at.fhtw.swen3.services.exceptions.badexception;

public class BadTrackingIDException extends Exception{
    public BadTrackingIDException(String message){
        super(message);
    }
}