package br.com.picpaychallenge.application.ports.rest;

import br.com.picpaychallenge.application.core.dto.response.TransactionMessageResponse;

public interface HttpRequest {

    TransactionMessageResponse transactionValidations(String url);

}
