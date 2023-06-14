package Excepciones;

public class Invalido extends Exception{
    public Invalido(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
