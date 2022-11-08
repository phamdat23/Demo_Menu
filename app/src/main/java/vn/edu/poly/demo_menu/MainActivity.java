 package vn.edu.poly.demo_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_tv01= findViewById(R.id.tv_tv01);
        // làm contextmenu
        registerForContextMenu(tv_tv01);// đăng ký sử dụng contextmenu
        //======== popup menu
        Button btn_popup = findViewById(R.id.btn_poupmenu);
        btn_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // tạo popup
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btn_popup);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu1, popupMenu.getMenu());

                // sử lí sự kiện
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id){
                            case R.id.m_call:
                                Toast.makeText(MainActivity.this, "Gọi điện",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.m_radio:
                                Toast.makeText(MainActivity.this, "Radio",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.m_edit:
                                Toast.makeText(MainActivity.this, "Sửa",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }
    //--------------contextmenu

     @Override
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
         super.onCreateContextMenu(menu, v, menuInfo);
         MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.menu1, menu);
     }

     @Override
     public boolean onContextItemSelected(@NonNull MenuItem item) {
         int id = item.getItemId();
         switch (id){
             case R.id.m_call:
                 Toast.makeText(MainActivity.this, "Gọi điện",Toast.LENGTH_SHORT).show();
                 break;
             case R.id.m_radio:
                 Toast.makeText(MainActivity.this, "Radio",Toast.LENGTH_SHORT).show();
                 break;
             case R.id.m_edit:
                 Toast.makeText(MainActivity.this, "Sửa",Toast.LENGTH_SHORT).show();
                 break;
         }
         return super.onContextItemSelected(item);
     }

     //--------------option menu
    // hàm khởi tạo
     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.menu1, menu);
         return super.onCreateOptionsMenu(menu);
     }
     // hàm sử lí chọn 1 menu
     @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         int id = item.getItemId();
         switch (id){
             case R.id.m_call:
                 Toast.makeText(MainActivity.this, "Gọi điện",Toast.LENGTH_SHORT).show();
                 break;
             case R.id.m_radio:
                 Toast.makeText(MainActivity.this, "Radio",Toast.LENGTH_SHORT).show();
                 break;
             case R.id.m_edit:
                 Toast.makeText(MainActivity.this, "Sửa",Toast.LENGTH_SHORT).show();
                 break;
         }
         return super.onOptionsItemSelected(item);
     }
 }