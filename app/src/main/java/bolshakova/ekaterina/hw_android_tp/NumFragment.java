package bolshakova.ekaterina.hw_android_tp;

import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NumFragment extends Fragment {
    String num;
    public NumFragment() {
        // Required empty public constructor
    }

    public void SetArguments(String _num) {
        num = _num;
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
        return view;
    }
}
