package br.com.picpaychallenge.adapter.outbound.rest;

import br.com.picpaychallenge.application.ports.rest.HttpRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@Component
@FeignClient(name="transactions-service", url="https://run.mocky.io/v3")
public interface TransactionFeignClient extends HttpRequest {

    @Override
    @GetMapping("/5794d450-d2e2-4412-8131-73d0293ac1cc")
    String getTransactionAuthorization();

    @Override
    @GetMapping("/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6")
    String notifyUser();
}
