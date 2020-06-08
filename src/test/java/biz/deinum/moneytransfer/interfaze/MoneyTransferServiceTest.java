package biz.deinum.moneytransfer.interfaze;

import biz.deinum.moneytransfer.domain.Account;
import biz.deinum.moneytransfer.domain.MoneyTransferTransaction;
import biz.deinum.moneytransfer.repository.AccountRepository;
import biz.deinum.moneytransfer.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MoneyTransferServiceTest {

    private final AccountRepository mockAccountRepository = Mockito.mock(AccountRepository.class);
    private final TransactionRepository mockTransactionRepository = Mockito.mock(TransactionRepository.class);
    private final MoneyTransferService service = new MoneyTransferService();

    @BeforeEach
    public void setup() {
        Injections.inject(service, mockAccountRepository, mockTransactionRepository);
    }

    @Test
    @DisplayName("Money Transfer - Setter Injection")
    public void transferMoney() {
        // Given
        var act1 = new Account("123456");
        act1.debit(BigDecimal.valueOf(1000L));
        when(mockAccountRepository.find("123456")).thenReturn(act1);
        when(mockAccountRepository.find("654321")).thenReturn(new Account("654321"));
        when(mockTransactionRepository.store(isA(MoneyTransferTransaction.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
        //When
        var transaction = service.transfer("123456", "654321", new BigDecimal("250.00"));
        //Then
        assertNotNull(transaction);
        verify(mockTransactionRepository, times(1)).store(isA(MoneyTransferTransaction.class));
    }
}