package jc.spotifyclient.screens.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import jc.spotifyclient.App;
import jc.spotifyclient.R;
import jc.spotifyclient.framework.BaseActivity;

public class HomeScreenActivity extends BaseActivity<HomeScreenPresenter>
        implements NavigationView.OnNavigationItemSelectedListener, HomeScreen {

    @BindView(R.id.main_hello_text) TextView helloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void resolveDependencies() {
        ((App)getApplication()).getActivityComponent().inject(this);
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_settings) {
            Log.i("JC", "Settings clicked");
            Log.i("JC", "PRESENTER: "+presenter);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_options_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.search_item).getActionView();
        final WeakReference<SearchView> weakSearchView = new WeakReference<>(searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SearchView sv = weakSearchView.get();
                if (null != sv) {
                    sv.clearFocus();
                }
                handleSearchQuery(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        return true;
    }

    private void handleSearchQuery(String query) {
        Log.i("JC", "QUERY TEXT: "+query);
        presenter.searchForText(query);
    }

    ////// HomeScreen implementation

    public void updateHelloText(String text) {
        helloTextView.setText(text);
    }


}
