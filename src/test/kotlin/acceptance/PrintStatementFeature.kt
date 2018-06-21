package acceptance

import com.bankkata.Console
import com.bankkata.Account
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.inOrder
import org.mockito.runners.MockitoJUnitRunner

import org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner::class)
class PrintStatementFeature {

    @Mock
    private lateinit var console: Console

    private lateinit var account: Account

    @Before
    fun initialise(){
        account = Account()
    }

    @Test
    fun should_print_statement_containing_all_transactions() {

        account.deposit(1000)
        account.withdraw(100)
        account.deposit(500)


        account.printStatement()

        val inOrder = inOrder(console)
        inOrder.verify(console).println("DATE       | AMOUNT  | BALANCE")
        inOrder.verify(console).println("10/04/2014 | 500.00  | 1400.00")
        inOrder.verify(console).println("02/04/2014 | -100.00 | 900.00")
        inOrder.verify(console).println("01/04/2014 | 1000.00 | 1000.00")
    }

}