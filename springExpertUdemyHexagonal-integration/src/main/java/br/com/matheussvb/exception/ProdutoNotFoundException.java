package br.com.matheussvb.exception;

public class ProdutoNotFoundException extends  RuntimeException{
    public ProdutoNotFoundException(String message){
        super(message);
    }
}
