package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.utils.TestUtils.testLottoNumbers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumbersTest {

    private LottoNumbers testLottoNumbers;

    @BeforeEach
    void setUp() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(new LottoNumber(i));
        }
        this.testLottoNumbers = new LottoNumbers(numbers);
    }

    @Test
    @DisplayName("selectNumbers 메소드는 로또 번호를 맨 앞에서부터 특정 개수만큼 추첨한다")
    void 테스트_selectNumbers_로또_번호를_추첨한다() {
        // given
        int count = 6;

        // when
        LottoNumbers lottoNumbers = this.testLottoNumbers.selectNumbers(count);

        // then
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(
                Arrays.asList(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))));
    }

    @Test
    @DisplayName("isWinning 메소드는 파라미터로 전달된 당첨 번호와 비교해 당첨 개수를 반환한다")
    void 테스트_isWinning_당첨_개수를_반환한다() {
        // given
        int count = 6;
        LottoNumbers winningNumbers = testLottoNumbers();

        // when
        LottoNumbers lottoNumbers = this.testLottoNumbers.selectNumbers(count);

        // then
        assertThat(lottoNumbers.winningCount(winningNumbers)).isEqualTo(6);
    }

    @Test
    @DisplayName("toString 메소드는 로또 번호를 문자열로 반환한다")
    void 테스트_toString_로또_번호_문자열_반환() {
        // given
        LottoNumbers testNumbers = testLottoNumbers();

        // when
        String result = testNumbers.toString();

        // then
        assertThat(result).isEqualTo("[ 1, 2, 3, 4, 5, 6 ]");
    }
}