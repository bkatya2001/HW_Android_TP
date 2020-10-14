package bolshakova.ekaterina.hw_android_tp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.fr_container, new RVFragment())
                    .addToBackStack(RVFragment.class.getSimpleName()).commit();
        }
    }
}
