package bolshakova.ekaterina.hw_android_tp;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

class DataSource {
    private static final DataSource ourInstance = new DataSource();
    private final List<NumberModel> list;

    static DataSource getInstance() {
        return ourInstance;
    }

    public List<NumberModel> getData() {
        return list;
    }

    public void addData(NumberModel model){
        list.add(model);
    }

    private DataSource() {
        list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            int color = Color.RED;
            if (i % 2 == 1) color = Color.BLUE;
            list.add(new NumberModel(i, color));
        }
    }

    public static class NumberModel {
        private int mNumber;
        private int mColor;

        public NumberModel(int number, int color){
            mNumber = number;
            mColor = color;
        }

        public int getNumber() {
            return mNumber;
        }

        public int getColor() {
            return mColor;
        }
    }
}
