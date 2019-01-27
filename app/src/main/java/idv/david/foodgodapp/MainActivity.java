package idv.david.foodgodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    LinearLayout linearLayout;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);//設定主畫面為activity_navigation_drawer(會自動跳轉activity main)
        toolbar = findViewById(R.id.toolbar);//頂端欄
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        findViews();
    }


    private void findViews() {
        linearLayout = findViewById(R.id.linearLayout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();//利用MenuInflater建立選單
        inflater.inflate(R.menu.option_menu, menu);//登記menu id=options_menu的選單
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()) {
            case R.id.itemSignIn://(登入專區)
                intent.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.itemNews://(廣告專區)
                intent.setClass(MainActivity.this, NewsActivity.class);
                startActivity(intent);
                break;
            case R.id.itemMember://(會員專區)
                intent.setClass(MainActivity.this, MemberActivity.class);
                startActivity(intent);
                break;
            case R.id.itemMall://(商城專區)
                intent.setClass(MainActivity.this, MallActivity.class);
                startActivity(intent);
                break;
            case R.id.itemOrder://(訂單專區)
                intent.setClass(MainActivity.this, OrderActivity.class);
                startActivity(intent);
                break;

            case R.id.itemForums://(論壇專區)
                intent.setClass(MainActivity.this, LivesActivity.class);
                startActivity(intent);
                break;
            case R.id.itemLives://(直播專區)
                intent.setClass(MainActivity.this, LivesActivity.class);
                startActivity(intent);
                break;
            case R.id.itemCustomerService://(客服專區)
                intent.setClass(MainActivity.this, CustomerServiceActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }


        return true;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()) {
            case R.id.itemSignIn://(登入專區)
                intent.setClass(MainActivity.this, LoginActivity.class);
                Toast.makeText(getApplicationContext(), R.string.stringSignIn, Toast.LENGTH_LONG).show();
                startActivity(intent);
                overridePendingTransition(R.anim.in,R.anim.out);
                break;
            case R.id.itemNews://(廣告專區)
                intent.setClass(MainActivity.this, NewsActivity.class);
                Toast.makeText(getApplicationContext(), R.string.stringNews, Toast.LENGTH_LONG).show();
                startActivity(intent);
                overridePendingTransition(R.anim.in,R.anim.out);
                break;
            case R.id.itemMember://(會員專區)
                intent.setClass(MainActivity.this, MemberActivity.class);
                Toast.makeText(getApplicationContext(), R.string.stringMember, Toast.LENGTH_LONG).show();
                startActivity(intent);
                overridePendingTransition(R.anim.in,R.anim.out);
                break;
            case R.id.itemMall://(商城專區)
                intent.setClass(MainActivity.this, MallActivity.class);
                Toast.makeText(getApplicationContext(),R.string.stringMall, Toast.LENGTH_LONG).show();
                startActivity(intent);
                overridePendingTransition(R.anim.in,R.anim.out);
                break;
            case R.id.itemOrder://(訂單專區)
                intent.setClass(MainActivity.this, OrderActivity.class);
                Toast.makeText(getApplicationContext(),R.string.stringOrder, Toast.LENGTH_LONG).show();
                startActivity(intent);
                overridePendingTransition(R.anim.in,R.anim.out);
                break;

            case R.id.itemForums://(論壇專區)
                intent.setClass(MainActivity.this, LivesActivity.class);
                Toast.makeText(getApplicationContext(),R.string.stringForum, Toast.LENGTH_LONG).show();
                startActivity(intent);
                overridePendingTransition(R.anim.in,R.anim.out);
                break;
            case R.id.itemLives://(直播專區)
                intent.setClass(MainActivity.this, LivesActivity.class);
                Toast.makeText(getApplicationContext(),R.string.stringLives, Toast.LENGTH_LONG).show();
                startActivity(intent);
                overridePendingTransition(R.anim.in,R.anim.out);
                break;
            case R.id.itemCustomerService://(客服專區)
                intent.setClass(MainActivity.this, CustomerServiceActivity.class);
                Toast.makeText(getApplicationContext(),R.string.stringCustomerService, Toast.LENGTH_LONG).show();
                startActivity(intent);
//                imageView =findViewById(R.drawable.LOGO);
                overridePendingTransition(R.anim.in,R.anim.out);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }


        return true;
    }
}