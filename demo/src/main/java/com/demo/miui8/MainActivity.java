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
		
//		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//		setSupportActionBar(toolbar);
//		toolbar.setTitle("调试");
        //设置无标题
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //透明状态栏
        //getWindow().
		Window window = getWindow();

		//window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		//window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
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

		// Button bt1=(Button)findViewById(R.id.bt1);

    }
    @Override
    public void onClick(View p1)
    {
        // TODO: Implement this method
        SharedPreferences sp=getSharedPreferences("single_choice_item",Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit=sp.edit();
        switch(p1.getId()){
            case R.id.one:
                final MIUIDialog a=new MIUIDialog(MainActivity.this);
                a.setTitle("提示信息"); //设置对话框标题
                a.setMessage("文本内容"); //设置对话框信息
				//a.setCanceledOnTouchOutside(true); //设置对话框是否可以触摸关闭
				//a.setCancelable(true); //设置对话框是否可以点击返回键关闭
                a.setPositiveButton("确定", new OnClickListener(){
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
                b.setTitle("提示信息");
                b.setMessage("文本内容");
				b.setCanceledOnTouchOutside(false);
                b.setNeutralButton("取消",null);
                b.setPositiveButton("确定", new OnClickListener(){

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
                c.setTitle("提示信息");
                c.setMessage("文字内容");
				c.setCanceledOnTouchOutside(false);
                c.setNeutralButton("按钮",null);
                c.setNegativeButton("按钮",null);
                c.setPositiveButton("按钮", new OnClickListener(){

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
               // ImageView image=new ImageView(MainActivity.this);
                //image.setImageResource(R.drawable.ic_launcher);
                final MIUIDialog d=new MIUIDialog(MainActivity.this);
                d.setTitle("提示信息");
                d.setView(R.layout.test);
				d.setCanceledOnTouchOutside(false);
                d.setNegativeButton("取消",null);
                d.setPositiveButton("确定", new OnClickListener(){

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
                e.setTitle("提示信息");
				//e.setMessage("文本内容");
                e.setEditText("","请输入文字");
				e.setCanceledOnTouchOutside(false);
                e.setNegativeButton("取消",null);
                e.setPositiveButton("确定", new OnClickListener(){

                        @Override
                        public void onClick(View p1)
                        {
                            // TODO: Implement this method
                            e.dismiss();
							//关闭对话框
							if("".equals(e.getEditText().toString().trim()))
							{ //判断输入框内是否有内容
						    Toast.makeText(MainActivity.this, "你还没有输入文字",0).show();
						    }else{ //如果有内容则
                            Toast.makeText(MainActivity.this,e.getEditText(),0).show();
							}
                        }
                    });
                e.show();
               break;
            case R.id.single_choice_dialog:
                final MIUIDialog g=new MIUIDialog(MainActivity.this);
                g.setTitle("提示信息");
				g.setCanceledOnTouchOutside(false);
				//使用方法1
                //final List<String> lg=new ArrayList<>();
                //for(int i=0;i<6;i++){ lg.add("选项 "+i); }
				//使用方法2
                final String[] lg = new String[] { "选项0", "选项1", "选项2", "选项3" ,"选项4" };
                g.setSingleChoiceItems(sp.getInt("item", 0), lg, new OnItemClickListener(){

                        @Override
                        public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
                        {
							g.dismiss();
                            // 设置列表选项点击事件
                            edit.putInt("item",p3).commit();
							//Toast.makeText(MainActivity.this,lg.get(p3),0).show(); //方法1
                            Toast.makeText(MainActivity.this,"已选择:"+lg[p3],0).show(); //方法2
                        }
                    });
                //g.setPositiveButton("取消", null);
                g.show();
                break;
            case R.id.multi_choices_dialog:
                final MIUIDialog h=new MIUIDialog(MainActivity.this);
                h.setTitle("提示信息");
				h.setCanceledOnTouchOutside(false);
				//使用方法1
                //final List<String> lh=new ArrayList<>();
                //for(int i=0;i<6;i++){ lh.add("选项 "+i); }
				//使用方法2
				final String[] lh = new String[] { "选项0", "选项1", "选项2", "选项3" ,"选项4"};
                h.setMultiChoiceItems(sp.getInt("item",0), lh, new OnItemClickListener(){

                        @Override
                        public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
                        {
                            // 设置列表选项点击事件
							edit.putInt("item",p3).commit();
                            //Toast.makeText(MainActivity.this,lh.get(p3),0).show(); //方法1
							Toast.makeText(MainActivity.this,lh[p3],0).show(); //方法2
							
                        }
                 });
                h.setNegativeButton("取消", new OnClickListener(){

                        @Override
                        public void onClick(View p1)
                        {
							// TODO: Implement this method
							h.dismiss();
							Toast.makeText(MainActivity.this,"已取消",0).show();
                        }
					});
                h.setPositiveButton("确定", new OnClickListener(){

                        @Override
                        public void onClick(View p1)
                        {
							// TODO: Implement this method
                            h.dismiss();
							
                        }
                });
                h.show();
                break;
		
        }
    }

	
    Button one,two,three,view,mEdit,itemClick,singleChoice,multiChoice;
}
