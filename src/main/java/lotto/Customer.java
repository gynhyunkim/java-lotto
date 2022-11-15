package lotto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final List<Lotto> lottoNumbers;
    private Lotto winNumbers;
    private int bonusNumber;
    private final int money;
    private final int lottoCount;

    public Customer(int money) {
        validateMoney(money);
        this.money = money;
        lottoCount = money / 1000;
        lottoNumbers = new ArrayList<>();
    }

    private void validateMoney(int money) {
        if (money % 1000 > 0) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INVALID_MONEY));
        }
        if (money < 1000) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.TOO_SMALl_MONEY));
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.NOT_UNIQUE_NUMBERS));
        }
    }

    public void purchaseLotto() {
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(new Lotto(NumbersGenerator.getRandomNumbers()));
        }
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }

    public void setWinNumbers(Lotto newWinNumbers) {
        winNumbers = newWinNumbers;
    }

    public void setBonusNumber(int newBonusNumber) {
        validateBonusNumber(newBonusNumber);
        bonusNumber = newBonusNumber;
    }
}
