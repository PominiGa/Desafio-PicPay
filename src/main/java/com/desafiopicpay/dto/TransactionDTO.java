package com.desafiopicpay.dto;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal amount, long senderId, long receiverId) {
}
