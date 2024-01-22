package br.com.picpaychallenge.application.ports.rest;

public interface HttpRequest {

    String getTransactionAuthorization();

    String notifyUser();
}
