package br.com.picpaychallenge.adapter.inbound.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public record TransferRequest(
        UUID destinationAccount,
        BigDecimal value
) {
}
