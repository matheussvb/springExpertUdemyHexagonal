package br.com.matheussvb.config.exceptions;

import br.com.matheussvb.exception.ClienteNotFoundException;
import br.com.matheussvb.model.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

//    @ExceptionHandler(RegraNegocioException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ApiErrors handleRegraNegocioException(RegraNegocioException ex){
//        String mensagemErro = ex.getMessage();
//        return new ApiErrors(mensagemErro);
//    }
//
//    @ExceptionHandler(PedidoNaoEncontradoException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ApiErrors handlePedidoNotFoundException( PedidoNaoEncontradoException ex ){
//        return new ApiErrors(ex.getMessage());
//    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClienteNotFoundException.class)
    public ApiErrors handleClienteNotFoundException(ClienteNotFoundException ex){

        return new ApiErrors(ex.getMessage());

    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotResponseStatusException(ResponseStatusException exception) {
        return new ApiErrors(exception.getReason());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException( MethodArgumentNotValidException ex ){


        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(erro ->

                        erro.getDefaultMessage()


                )
                .collect(Collectors.toList());
        return new ApiErrors(errors);
    }
}