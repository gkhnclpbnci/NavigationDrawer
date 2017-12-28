package example.batuhan.www.navigationdrawer;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pages.AnasayfaFragment;
import pages.ArgeFragment;
import pages.B2BFragment;
import pages.DepoFragment;
import pages.DonanimFragment;
import pages.EkibimizFragment;
import pages.ErpFragment;
import pages.GelistirmeFragment;
import pages.HakkimizdaFragment;
import pages.IdeaProFragment;
import pages.IhtiyacFragment;
import pages.IletisimFragment;
import pages.KobiFragment;
import pages.KurumFragment;
import pages.YazilimFragment;
import pages.YonetimFragment;

public class Baslik1Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private View view_Group;
    private DrawerLayout mDrawerLayout;
    private XpandableListAdapter mMenuAdapter;
    private ExpandableListView expandableList;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private String fragment_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);

        setContentView(R.layout.activity_baslik1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initNavigationDrawer();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            expandableList.setIndicatorBounds(expandableList.getRight()- 80, expandableList.getWidth());
        } else {
            expandableList.setIndicatorBoundsRelative(expandableList.getRight()- 80, expandableList.getWidth());
        }


    }
    private void initNavigationDrawer() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        expandableList = (ExpandableListView) findViewById(R.id.navigationmenu);

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        setupDrawerContent(navigationView);

        prepareListData();
        mMenuAdapter = new XpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expandableList.setAdapter(mMenuAdapter);

        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView,
                                        View view,
                                        int groupPosition,
                                        int childPosition, long id) {
                //Log.d("DEBUG", "submenu item clicked");
                Toast.makeText(Baslik1Activity.this,
                        "Header: " + String.valueOf(groupPosition) +
                                "\nItem: " + String.valueOf(childPosition), Toast.LENGTH_SHORT)
                        .show();
                if (String.valueOf(groupPosition).equals("2")) {
                    displayPage2(childPosition);

                } else {
                    displayPage3(childPosition);

                }

                view.setSelected(true);
                if (view_Group != null) {
                    view_Group.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                view_Group = view;
                view_Group.setBackgroundColor(Color.parseColor("#ffffff"));
                mDrawerLayout.closeDrawers();
                return false;
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                if (String.valueOf(groupPosition).equals("2") || String.valueOf(groupPosition).equals("3")) {

                } else {
                    displayPage(groupPosition);
                    mDrawerLayout.closeDrawers();
                }

                Log.d("DEBUG", "heading clicked");
                return false;
            }
        });

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void displayPage2(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new IdeaProFragment();
                fragment_name = "IdeaProFragment";
                break;
            case 1:
                fragment = new B2BFragment();
                fragment_name = "B2BFragment";
                break;
            case 2:
                fragment = new DepoFragment();
                fragment_name = "DepoFragment";
                break;
            case 3:
                fragment = new KobiFragment();
                fragment_name = "KobiFragment";
                break;
            case 4:
                fragment = new ErpFragment();
                fragment_name = "ErpFragment";
                break;
            case 5:
                fragment = new DonanimFragment();
                fragment_name = "DonanimFragment";
                break;

            default:
                break;
        }

        Intent intent = new Intent(getApplicationContext(),fragment.getClass());
        startActivity(intent);

    }


    private void displayPage3(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new YonetimFragment();
                fragment_name = "YonetimFragment";
                break;
            case 1:
                fragment = new IhtiyacFragment();
                fragment_name = "IhtiyacFragment";
                break;
            case 2:
                fragment = new ArgeFragment();
                fragment_name = "ArgeFragment";
                break;
            case 3:
                fragment = new GelistirmeFragment();
                fragment_name = "GelistirmeFragment";
                break;
            case 4:
                fragment = new KurumFragment();
                fragment_name = "KurumFragment";

                break;

            default:
                break;
        }

        Intent intent = new Intent(getApplicationContext(),fragment.getClass());
        startActivity(intent);

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding data header
        listDataHeader.add("Anasayfa");
        listDataHeader.add("Hakkımızda");
        listDataHeader.add("Ürünler");
        listDataHeader.add("Hizmetler");
        listDataHeader.add("Yazılım Hizmetleri");
        listDataHeader.add("Ekibimiz");
        listDataHeader.add("İletişim");

        // Adding child data
        List<String> anasayfaHeader = new ArrayList<String>();
//        heading1.add("Submenu");
//        heading1.add("Submenu");
//        heading1.add("Submenu");

        List<String> hakkimizdaHeader = new ArrayList<String>();
//        heading2.add("Submenu");
//        heading2.add("Submenu");
//        heading2.add("Submenu");
//        heading2.add("Submenu");


        List<String> urunlerHeader = new ArrayList<String>();
        urunlerHeader.add("İdeaPro Üretim Yönetim Sistemi Yazılımı");
        urunlerHeader.add("İdeaktif B2B Müşteri Web Portalı Yazılımı");
        urunlerHeader.add("Depo Yönetim Sistemi Yazılımı");
        urunlerHeader.add("KOBİ Kurum Kültürü Geliştirme Envanteri Yazılımı");
        urunlerHeader.add("ERP Çözümleri");
        urunlerHeader.add("Donanım Ürünleri");


        List<String> hizmetlerHeader = new ArrayList<String>();
        hizmetlerHeader.add("Üretim Yönetimi Danışmanlığı\n");
        hizmetlerHeader.add("İhtiyaç Planlama ve Stok Yönetim Danışmanlığı");
        hizmetlerHeader.add("Arge ve Bilgi Teknolojileri Danışmanlığı");
        hizmetlerHeader.add("İş Geliştirme Danışmanlığı");
        hizmetlerHeader.add("Kurum Kültürü (Örgüt Kültürü) Geliştirme Danışmanlığı\n");

        List<String> yazilimHeader = new ArrayList<String>();
//        heading5.add("Submenu");
//        heading5.add("Submenu");
//        heading5.add("Submenu");
        List<String> ekibimizHeader = new ArrayList<String>();


        List<String> iletisimHeader = new ArrayList<String>();
//        heading6.add("Submenu");
//        heading6.add("Submenu");


        listDataChild.put(listDataHeader.get(0), anasayfaHeader);// Header, Child data
        listDataChild.put(listDataHeader.get(1), hakkimizdaHeader);
        listDataChild.put(listDataHeader.get(2), urunlerHeader);
        listDataChild.put(listDataHeader.get(3), hizmetlerHeader);
        listDataChild.put(listDataHeader.get(4), yazilimHeader);
        listDataChild.put(listDataHeader.get(5), ekibimizHeader);
        listDataChild.put(listDataHeader.get(6), iletisimHeader);
    }

    private void displayPage(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new AnasayfaFragment();
                fragment_name = "AnasayfaFragment";
                mDrawerLayout.closeDrawers();

                break;
            case 1:
                fragment = new HakkimizdaFragment();
                fragment_name = "HakkimizdaFragment";
                mDrawerLayout.closeDrawers();

                break;
            case 2:
                fragment = new YazilimFragment();
                fragment_name = "YazilimFragment";
                break;
            case 3:
                fragment = new HakkimizdaFragment();
                fragment_name = "HakkimizdaFragment";
                break;
            case 4:
                fragment = new YazilimFragment();
                fragment_name = "YazilimFragment";
                mDrawerLayout.closeDrawers();

                break;
            case 5:
                fragment = new EkibimizFragment();
                fragment_name = "EkibimizFragment";
                mDrawerLayout.closeDrawers();

                break;
            case 6:
                fragment = new IletisimFragment();
                fragment_name = "IletisimFragment";
                mDrawerLayout.closeDrawers();

                break;

            default:
                break;
        }

        Intent intent = new Intent(getApplicationContext(),fragment.getClass());
        startActivity(intent);

    }


}
