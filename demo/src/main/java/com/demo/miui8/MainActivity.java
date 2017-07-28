package com.demo.miui8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.miui8.widget.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.Toolbar;
import android.view.*;
import com.miui8.widget.*;
import android.view.View.*;
import android.content.*;
import android.widget.AdapterView.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
		mToolbar.setTitle("");
		setSupportActionBar(mToolbar);
		Window window = getWindow();
		window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        init();
    }

    private void init() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapter adapter = new ItemAdapter(R.layout.item, itemList());
        adapter.bindToRecyclerView(recyclerView);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
				@Override
				public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
					SharedPreferences sp=getSharedPreferences("single_choice_item",Context.MODE_PRIVATE);
					final SharedPreferences.Editor edit=sp.edit();
					if(position == 0){
						final MIUIDialog a=new MIUIDialog(MainActivity.this);
						a.setTitle("Title"); //设置对话框标题
						a.setMessage("This Is Message"); //设置对话框信息
						//a.setCanceledOnTouchOutside(true); //设置对话框是否可以触摸关闭
						//a.setCancelable(true); //设置对话框是否可以点击返回键关闭
						a.setPositiveButton("Ok", new OnClickListener(){
								//设置对话框按钮
								@Override
								public void onClick(View p1)
								{
									// 按钮点击事件
									a.dismiss(); //关闭对话框
								}
							});
						a.show(); //显示对话框
					}else if(position ==1){
						final MIUIDialog b=new MIUIDialog(MainActivity.this);
						b.setTitle("Title");
						b.setMessage("This Is Message");
						b.setCanceledOnTouchOutside(false);
						b.setNeutralButton("Cancel",null);
						b.setPositiveButton("Ok", new OnClickListener(){

								@Override
								public void onClick(View p1)
								{
									// TODO: Implement this method
									b.dismiss();
								}
							});
						b.show();
					}else if(position ==2){
						final MIUIDialog c=new MIUIDialog(MainActivity.this);
						c.setTitle("Title");
						c.setMessage("This Is Message");
						c.setCanceledOnTouchOutside(false);
						c.setNeutralButton("Button",null);
						c.setNegativeButton("Button",null);
						c.setPositiveButton("Button", new OnClickListener(){

								@Override
								public void onClick(View p1)
								{
									// TODO: Implement this method
									c.dismiss();
								}
							});
						c.show();
					}else if(position ==3){
						//设置控件
						//ImageView image=new ImageView(MainActivity.this);
						//image.setImageResource(R.drawable.ic_launcher);
						final MIUIDialog d=new MIUIDialog(MainActivity.this);
						d.setTitle("Title");
						d.setView(R.layout.test); //设置布局
						//d.setView(image); //设置控件
						d.setCanceledOnTouchOutside(false);
						d.setNegativeButton("Cancel",null);
						d.setPositiveButton("Ok", new OnClickListener(){

								@Override
								public void onClick(View p1)
								{
									// TODO: Implement this method
									d.dismiss();
								}
							});
						d.show();
					}else if(position ==4){
						final MIUIDialog e=new MIUIDialog(MainActivity.this);
						e.setTitle("Title");
						//e.setMessage("This Is Message");
						e.setEditText("Text","Hint");
						e.setCanceledOnTouchOutside(false);
						e.setNegativeButton("Cancel",null);
						e.setPositiveButton("Ok", new OnClickListener(){

								@Override
								public void onClick(View p1)
								{
									// TODO: Implement this method
									e.dismiss();
									//关闭对话框
									if("".equals(e.getEditText().toString().trim()))
									{ //判断输入框内是否有内容
										//Toast.makeText(MainActivity.this, "你还没有输入文字",0).show();
									}else{ //如果有内容则
										Toast.makeText(MainActivity.this,e.getEditText(),0).show();
									}
								}
							});
						e.show();
					}else if(position ==5){
						final MIUIDialog g=new MIUIDialog(MainActivity.this);
						g.setTitle("Title");
						g.setCanceledOnTouchOutside(false);

						//使用方法：
						//final List<String> lg=new ArrayList<>();
						//for(int i=0;i<8;i++){ lg.add("Item "+i); }

						//final List<String> lg=new ArrayList<>();
						//{ lg.add("Item0"); 
						//	lg.add("Item1"); 
						//	lg.add("Item2"); 
						//	lg.add("Item3"); 
						//	lg.add("Item4");
						//	lg.add("Item5"); 
						//	lg.add("Item6");
						//	lg.add("Item7"); }

						final String[] lg = new String[] {"Item0","Item1","Item2","Item3","Item4","Item5","Item6","Item7"};
						g.setSingleChoiceItems(sp.getInt("item", 0), lg, new OnItemClickListener(){

								@Override
								public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
								{
									g.dismiss();
									// 设置列表选项点击事件
									edit.putInt("item",p3).commit();
									Toast.makeText(MainActivity.this,lg[p3],0).show();

								}
							});
						//g.setPositiveButton("Cancel", null);
						g.show();
					}else if(position ==6){
						final MIUIDialog h=new MIUIDialog(MainActivity.this);
						h.setTitle("Title");
						h.setCanceledOnTouchOutside(false);

						//使用方法：
						//final List<String> lh=new ArrayList<>();
						//for(int i=0;i<6;i++){ lh.add("Item"+i); }

						//final List<String> lh=new ArrayList<>();
						//{ lh.add("Item0"); 
						//  lh.add("Item1"); 
						//  lh.add("Item2"); 
						//  lh.add("Item3"); 
						//  lh.add("Item4");
						//  lh.add("Item5");  }

						final String[] lh = new String[] {"Item0","Item1","Item2","Item3","Item4","Item5"};
						h.setMultiChoiceItems(sp.getInt("item",0), lh, new OnItemClickListener(){

								@Override
								public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
								{
									// 设置列表选项点击事件
									Toast.makeText(MainActivity.this,lh[p3],0).show();
								}
							});
						h.setNegativeButton("Cancel", new OnClickListener(){

								@Override
								public void onClick(View p1)
								{
									// TODO: Implement this method
									h.dismiss();
									//Toast.makeText(MainActivity.this,"已取消",0).show();
								}
							});
						h.setPositiveButton("Ok", new OnClickListener(){

								@Override
								public void onClick(View p1)
								{
									h.dismiss();
								}
							});

						h.show();
					}
				}
			});
    }

    private List<Item> itemList() {
        List<Item> items = new ArrayList<>();
        {
			items.add(new Item("One Button"));
			items.add(new Item("Two Button"));
			items.add(new Item("Three Button"));
			items.add(new Item("Custom Layout"));
			items.add(new Item("EditText View"));
			items.add(new Item("SingleChoiceItem"));
			items.add(new Item("MultiChoiceItem"));
        }
        return items;
    }
}

