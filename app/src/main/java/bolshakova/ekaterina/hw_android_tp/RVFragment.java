package bolshakova.ekaterina.hw_android_tp;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import android.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class RVFragment extends Fragment {

    public RVFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_rv, container, false);
        List<DataSource.NumberModel> numbers = DataSource.getInstance().getData();
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        int columns = 3;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) columns = 4;
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), columns));
        final MyAdapter adapter = new MyAdapter(numbers);
        recyclerView.setAdapter(adapter);

        Button button = view.findViewById(R.id.add_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSource.getInstance().addData(new DataSource.NumberModel(0, Color.RED));
                adapter.updateData(DataSource.getInstance().getData());
                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        public List<DataSource.NumberModel> mData;

        public MyAdapter(List<DataSource.NumberModel> data) {
            mData = data;
        }

        public void updateData(List<DataSource.NumberModel> data) {
            mData = data;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            DataSource.NumberModel model = mData.get(position);
            holder.mNumber.setText(String.valueOf(model.getNumber()));
            holder.mNumber.setTextColor(model.getColor());
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView mNumber;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mNumber = itemView.findViewById(R.id.info_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NumFragment nf = new NumFragment();
                    nf.SetArguments(((TextView) v.findViewById(R.id.info_text)).getText().toString(), ((TextView) v.findViewById(R.id.info_text)).getCurrentTextColor());
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fr_container, nf)
                            .addToBackStack(NumFragment.class.getSimpleName()).commit();
                }
            });
        }

    }
}
