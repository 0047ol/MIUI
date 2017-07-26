package com.demo.miui8;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import java.util.List;
import java.util.ArrayList;
import android.widget.*;
import android.view.*;
import android.os.*;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.miui8.widget.MIUIDialog;
import java.util.*;
import com.miui8.widget.*;
import android.util.*;

public class MainActivity extends AppCompatActivity implements OnClickListener
{

	private Toolbar mToolbar;
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		mToolbar.setTitle("");
		setSupportActionBar(mToolbar);
		Window window = getWindow();
		window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        one=(Button)findViewById(R.id.one);
        one.setOnClickListener(this);

        two=(Button)findViewById(R.id.two);
        two.setOnClickListener(this);

        three=(Button)findViewById(R.id.three);
        three.setOnClickListener(this);

        view=(Button)findViewById(R.id.view_dialog);
        view.setOnClickListener(this);

        mEdit=(Button)findViewById(R.id.edit_dialog);
        mEdit.setOnClickListener(this);    

        singleChoice=(Button)findViewById(R.id.single_choice_dialog);
        singleChoice.setOnClickListener(this);

        multiChoice=(Button)findViewById(R.id.multi_choices_dialog);
        multiChoice.setOnClickListener(this);

    }
    @Override
    public void onClick(View p1)
    {
        SharedPreferences sp=getSharedPreferences("single_choice_item",Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit=sp.edit();
		
        switch(p1.getId()){
            case R.id.one:
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
                break;
				
             case R.id.two:
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
               break;
			   
            case R.id.three:
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
               break;
			   
            case R.id.view_dialog:
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
                break;
				
           case R.id.edit_dialog:
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
               break;
			   
            case R.id.single_choice_dialog:
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
                break;
				
            case R.id.multi_choices_dialog:
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
                break;
		
        }
    }

	
    Button one,two,three,view,mEdit,itemClick,singleChoice,multiChoice;
}
