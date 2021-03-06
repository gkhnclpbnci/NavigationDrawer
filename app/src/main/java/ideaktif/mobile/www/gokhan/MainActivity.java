package ideaktif.mobile.www.gokhan;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;

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
import pages.IletisimFragment;
import pages.KurumFragment;
import pages.YazilimFragment;
import pages.YonetimFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String fragment_name = "";

    View view_Group;
    private DrawerLayout mDrawerLayout;
    XpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    //Icons, use as you want
    static int[] icon = {R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            expandableList.setIndicatorBounds(expandableList.getRight() - 80, expandableList.getWidth());
        } else {
            expandableList.setIndicatorBoundsRelative(expandableList.getRight() - 80, expandableList.getWidth());
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (fragment.isAdded()) {

        } else {
            onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        expandableList = (ExpandableListView) findViewById(R.id.navigationmenu);

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }
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
             /*   Toast.makeText(MainActivity.this,
                        "Header: " + String.valueOf(groupPosition) +
                                "\nItem: " + String.valueOf(childPosition), Toast.LENGTH_SHORT)
                        .show();*/
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

        displayPage(0);
    }

    private Fragment fragment = null;

    private void displayPage(int position) {


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
        if (fragment != null) {

            // Fragment transaction nesnesi ile fragment ekranları arasında geçiş sağlıyor
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container, fragment).addToBackStack(fragment_name).commit();

            // Stack te bulunan fragment sayısını alıyor
            int count = getSupportFragmentManager().getBackStackEntryCount();

            if (count != 0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains(fragment_name)) {
                    getSupportFragmentManager().popBackStack();
                }
            }

        }

    }


    private void displayPage2(int position) {

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
         /*   case 3:
                fragment = new KobiFragment();
                fragment_name = "KobiFragment";
                break;*/
            case 3:
                fragment = new ErpFragment();
                fragment_name = "ErpFragment";
                break;
            case 4:
                fragment = new DonanimFragment();
                fragment_name = "DonanimFragment";
                break;

            default:
                break;
        }
        if (fragment != null) {

            // Fragment transaction nesnesi ile fragment ekranları arasında geçiş sağlıyor
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container, fragment).addToBackStack(fragment_name).commit();

            // Stack te bulunan fragment sayısını alıyor
            int count = getSupportFragmentManager().getBackStackEntryCount();

            if (count != 0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains(fragment_name)) {
                    getSupportFragmentManager().popBackStack();
                }
            }
        }

    }


    private void displayPage3(int position) {

        switch (position) {
            case 0:
                fragment = new YonetimFragment();
                fragment_name = "YonetimFragment";
                break;
           /* case 1:
                fragment = new IhtiyacFragment();
                fragment_name = "IhtiyacFragment";
                break;*/
            case 1:
                fragment = new ArgeFragment();
                fragment_name = "ArgeFragment";
                break;
            case 2:
                fragment = new GelistirmeFragment();
                fragment_name = "GelistirmeFragment";
                break;
            case 3:
                fragment = new KurumFragment();
                fragment_name = "KurumFragment";

                break;

            default:
                break;
        }
        if (fragment != null) {

            // Fragment transaction nesnesi ile fragment ekranları arasında geçiş sağlıyor
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container, fragment).addToBackStack(fragment_name).commit();

            // Stack te bulunan fragment sayısını alıyor
            int count = getSupportFragmentManager().getBackStackEntryCount();

            if (count != 0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains(fragment_name)) {
                    getSupportFragmentManager().popBackStack();
                }
            }
        }

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
        //  urunlerHeader.add("KOBİ Kurum Kültürü Geliştirme Envanteri Yazılımı");
        urunlerHeader.add("ERP Çözümleri");
        urunlerHeader.add("Donanım Ürünleri");


        List<String> hizmetlerHeader = new ArrayList<String>();
        hizmetlerHeader.add("Üretim Yönetimi Danışmanlığı\n");
        // hizmetlerHeader.add("İhtiyaç Planlama ve Stok Yönetim Danışmanlığı");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
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

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //geri tuşuna basılma durumunu yakalıyoruz
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Çıkmak istediğinizden emin misiniz ?");
            alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    //evet seçilmesi durumunda yapılacak işlemler
                    // finish ile activity'i sonlandırıyoruz.
                    finish();
                }
            });
            alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    //hayır seçildiginde yapılacak işlemler
                }
            });

            alert.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}