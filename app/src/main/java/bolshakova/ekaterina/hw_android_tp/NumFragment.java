package bolshakova.ekaterina.hw_android_tp;

import android.graphics.Color;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NumFragment extends Fragment {
    String num;
    int color;
    public NumFragment() {
        // Required empty public constructor
    }

    public void SetArguments(String _num, int _color) {
        num = _num;
        color = _color;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_num, container, false);
        TextView tv = view.findViewById(R.id.num_tv);
        tv.setText(num);
        tv.setTextColor(color);
        return view;
    }
}
