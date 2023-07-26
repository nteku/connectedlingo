package com.maid.connectedlingo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Menu extends AppCompatActivity {

    private TextView message;
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        message = findViewById(R.id.openingmessage);

        Intent intent = getIntent();

        if (intent != null)
        {
            account = (Account) intent.getSerializableExtra("account");
            message.setText("Hello " + account.getUsername() + ". Lets get Started.");
        }
        BottomNavigationView bottomNavView = findViewById(R.id.bottomNavView);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_item1:
                        replaceFragment(new Translator()); // Replace 'fragme()' with the actual Fragment you want to show
                        return true;
                    case R.id.menu_item2:
                        // Handle click for Item 2
                        return true;
                    case R.id.menu_item3:
                        // Handle click for Item 3
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        /*
        FragmentManager fragmentManager = getSupportFragmentManager();
        int containerId = R.id.frameLayout; // Replace with the actual ID of your FrameLayout container
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerId, fragment);
        fragmentTransaction.commit();
         */
    }
}
