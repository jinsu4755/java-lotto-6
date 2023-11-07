package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoGameTest {

    private final LottoTicketDispenser ticketDispenser = new LottoTicketDispenser(new AutoLottoNumberGenerator());

    @Test
    void 로또_게임에_금액을_입력하면_구매된_로또_목록을_얻을_수_있다() {
        // given
        LottoGame lottoGame = new LottoGame(ticketDispenser);
        String cost = "2000";
        // when
        PurchasedLottoTickets purchasedLottoTickets = lottoGame.purchaseLottoTickets(cost);
        // then
        assertThat(purchasedLottoTickets.size()).isEqualTo(2);
    }

    @Test
    void 로또_게임에_유효하지_않은_금액을_입력하면_예외가_발생한다() {
        // given
        LottoGame lottoGame = new LottoGame(ticketDispenser);
        String cost = "2000A";
        // when
        // then
        assertThatThrownBy(() -> lottoGame.purchaseLottoTickets(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 금액입니다.");
    }
}