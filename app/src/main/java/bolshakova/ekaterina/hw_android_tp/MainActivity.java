package bolshakova.ekaterina.hw_android_tp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<DataSource.NumberModel> numbers = DataSource.getInstance().getData();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        int columns = 3;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) columns = 4;
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        MyAdapter adapter = new MyAdapter(numbers);
        recyclerView.setAdapter(adapter);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<DataSource.NumberModel> mData;

        public MyAdapter(List<DataSource.NumberModel> data) {
            mData = data;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout, parent, false);
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

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView mNumber;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mNumber = itemView.findViewById(R.id.tv_number);
        }
    }
}