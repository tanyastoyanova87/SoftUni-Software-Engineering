package Programming_Advanced_With_Java.JavaOOPExams.fairyShop.models;

public class ShopImpl implements Shop {

    @Override
    public void craft(Present present, Helper helper) {
        for (Instrument instrument : helper.getInstruments()) {
            while (helper.canWork() && !instrument.isBroken()) {
                present.getCrafted();
                helper.work();
                instrument.use();
                if (present.isDone()) {
                    return;
                }
                if (!helper.canWork()) {
                    return;
                }
            }
        }
    }
}
