package news.airweb.fr.airweb.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import news.airweb.fr.airweb.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        changeFragment(new NewsFragment());

    }

    public void changeFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        //ft.setCustomAnimations();
        ft.replace(R.id.ctnFrame, fragment);
        ft.addToBackStack(null);
        ft.commit();

    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if(fm.getBackStackEntryCount() > 1)
            fm.popBackStack();
        else
            finish();
    }
}
