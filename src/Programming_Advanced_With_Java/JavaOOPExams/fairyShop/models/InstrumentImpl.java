package Programming_Advanced_With_Java.JavaOOPExams.fairyShop.models;

import static Programming_Advanced_With_Java.JavaOOPExams.fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument {
    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {
        this.power -= 10;
        if (this.power < 0) {
            this.power = 0;
        }
    }

    @Override
    public boolean isBroken() {
       if (this.power == 0) {
           return true;
       }
       return false;
    }

    public void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }
}
