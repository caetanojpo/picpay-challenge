package br.com.picpaychallenge.adapter.outbound.rest;

import br.com.picpaychallenge.application.core.dto.response.TransactionMessageResponse;
import br.com.picpaychallenge.application.ports.rest.HttpRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(name = "transactions-service", url = "https://run.mocky.io/v3")
public interface TransactionFeignClient extends HttpRequest {


    @Override
    @GetMapping("{url}")
    TransactionMessageResponse transactionValidations(@PathVariable String url);

}
