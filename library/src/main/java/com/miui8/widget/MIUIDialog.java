package com.miui8.widget;

import android.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.widget.Gallery.*;
import java.util.*;

import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery.LayoutParams;
import android.support.v7.widget.*;

public class MIUIDialog
{
    private Dialog mDialog;
    private Context mContext;
    private CharSequence PositiveText=null;
    private CharSequence NegativeText=null;
    private CharSequence NeutralText=null;
    private CharSequence messageText=null;
    private CharSequence setEditText=null;
    private CharSequence hint=null;
    private CharSequence titleText=null;
    private int defStyle;
    private int PositiveId=0;
    private int NegativeId=0;
    private int NeutralId=0;
    private int messageId=0;
    private int EditTextId=0;
    private int titleId=0;
    private int hintId=0;
    private boolean isPositiveButtonShow=false;
    private boolean isNegativeButtonShow=false;
    private boolean isNeutralButtonShow=false;
    private boolean isEditText=false;
    private boolean isListView1=false;
    private boolean isListView2=false;
    private boolean isListView3=false;
    private boolean isListView4=false;
	//private boolean isListView5=false;
    //private boolean isListView6=false;
    //private int postion;
    private View mView;
    //private LinearLayout layouts;
    private ListView ChoiceList;
    private String[] items;
    private List<String> arrayList;
    private int defItem;
    private int choiceMode;
    private MIUIDialog.Builder mBuilder;
    private View.OnClickListener  PositiveListener,NegativeListener,NeutralListener;
    private OnItemClickListener mlistener;
	private ViewGroup v2;
	private EditText Edits;
	private int mViewId=0;
	private boolean CanceledOnTouchOutside=true;
	private boolean Cancelable=true;
	

	// EditText Edits = (EditText) findViewById(R.id.Edits);

    public MIUIDialog show()
	{
        mBuilder = new Builder();
        if (!mDialog.isShowing())
		{
            mDialog.show();
        }
        return this;
    }
    public MIUIDialog dismiss()
	{
        mDialog.dismiss();
        return this;
    }
    public MIUIDialog cancel()
	{
        mDialog.cancel();
        return this;
    }
    public MIUIDialog(Context context)
	{
        this.mContext = context;
        this.defStyle = R.style.CustomDialog;
    }

    private class Builder
	{
        private Button PositiveButton;
        private Button NegativeButton;
        private Button NeutralButton; 
        private TextView mMessage,mTitle;
        private LinearLayout mButton;
        private FrameLayout mFrameLayout;
        private ListView mChoiceList;
        private ListView mList;
		private View v1view;
		private View neutralview;
		private View positiveview;
		private View v3;
		//private ListView l;
		//private ScrollView scrollView;

        private Builder()
		{
            mDialog = new Dialog(mContext, defStyle);
//            mDialog.getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_BLUR_BEHIND, 
//                WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
            mDialog.setContentView(R.layout.miui_dialog_layout);
			mDialog.getWindow().getDecorView().setPadding(0, 0, 0, 0);
            Window dialogWindow = mDialog.getWindow();
            DisplayMetrics d = mContext.getResources().getDisplayMetrics();
            WindowManager.LayoutParams p = dialogWindow.getAttributes(); 
			mDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialogWindow.setGravity(Gravity.CENTER | Gravity.BOTTOM);
			p.x = 0;//设置x坐标
			p.y = 22;//设置y坐标
            p.width = (int)(d.widthPixels * 0.95);
            dialogWindow.setAttributes(p);
            setCustomView(mDialog);
        }
        private void setCustomView(Dialog dialog)
		{
            mTitle = (TextView)dialog.findViewById(R.id.custom_miui_dialog_title);
			v1view = (View)dialog.findViewById(R.id.v1);
			neutralview = (View)dialog.findViewById(R.id.neutral_view);
			positiveview = (View)dialog.findViewById(R.id.positive_view);
			PositiveButton = (Button)dialog.findViewById(R.id.positive_button);
            NegativeButton = (Button)dialog.findViewById(R.id.negative_button);
            NeutralButton = (Button)dialog.findViewById(R.id.neutral_button); 
            mButton = (LinearLayout)dialog.findViewById(R.id.custom_miui_dialog_button);
            mFrameLayout = (FrameLayout)dialog.findViewById(R.id.custom_miui_dialog_view);
            v2 = (ViewGroup)dialog.findViewById(R.id.v2);
			Edits = (EditText)dialog.findViewById(R.id.Edits);
			//scrollView=(ScrollView)dialog.findViewById(R.id.parallax_scrollView);
			PositiveButton.setTextColor(Color.parseColor("#ff35a7ff"));
			NegativeButton.setTextColor(Color.parseColor("#ff6c6c6c"));
			NeutralButton.setTextColor(Color.parseColor("#ff6c6c6c"));
			v3 =(View)dialog.findViewById(R.id.v_3);
			//mChoiceList= (ListView)dialog.findViewById(R.id.parallax_s);
			Edits.setVisibility(View.GONE);
			v3.setVisibility(View.GONE);
			
            ScrollView scrollView=new ScrollView(mContext);
            mMessage = new TextView(mContext);
            mMessage.setPadding(110, 0, 110, 8);
            mMessage.setTextColor(Color.parseColor("#5B5A5A"));
            mMessage.setTextSize(14);
            mMessage.setLineSpacing(1, 1.3f);
            scrollView.addView(mMessage);
            mFrameLayout.addView(scrollView);

			
            if (isEditText == true)
			{
				Edits.setVisibility(View.VISIBLE);

                if (EditTextId == 0 && getEditText() != null)
				{
                    Edits.setText(setEditText);
                }
                else if (EditTextId != 0 && getEditText() == null)
				{
                    Edits.setText(EditTextId);
                }
                if (hintId == 0 && hint != null)
				{
                    Edits.setHint(hint);
                }
                else if (hintId != 0 && hint == null)
				{
                    Edits.setHint(hintId);
                }
            }
            if (isListView1 == true || isListView2 == true)
			{
				v3.setVisibility(View.VISIBLE);
				
				LayoutInflater inflater = LayoutInflater.from(mContext);
				LinearLayout l = (LinearLayout) inflater.inflate(R.layout.linearlayout,null).findViewById(R.id.layout_s);
                View v=new View(mContext);
                v.setBackgroundColor(Color.parseColor("#F2B6B6B6"));
                v.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, 1));
                l.addView(v);
//                mChoiceList = new ListView(mContext);
				mChoiceList = (MIUI8ListView) inflater.inflate(R.layout.listview_layout,null).findViewById(R.id.parallax_s);
				mChoiceList.setDivider(new ColorDrawable(0xF2B6B6B6));
				mChoiceList.setDividerHeight(1);
                if (isListView1 == true && isListView2 == false)
				{
                    mChoiceList.setAdapter(new ListViewChoiceAdapter(mContext, items));
				}
				else if (isListView1 == false && isListView2 == true)
				{
					mChoiceList.setAdapter(new ListViewChoiceAdapter(mContext, arrayList));
				}
                mChoiceList.setChoiceMode(choiceMode);
                mChoiceList.setItemChecked(defItem, true);
                mChoiceList.setOnItemClickListener(mlistener);
                ChoiceList = mChoiceList;
                l.addView(mChoiceList);
                mFrameLayout.addView(l);
			}
           
			if (isListView3 == true || isListView4 == true)
			{
				v3.setVisibility(View.VISIBLE);
				LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);  
				lp.setMargins(0,0,-23,0);  
				v2.setLayoutParams(lp); 
				LayoutInflater inflater = LayoutInflater.from(mContext);
				LinearLayout l = (LinearLayout) inflater.inflate(R.layout.linearlayout,null).findViewById(R.id.layout_s);
                View v=new View(mContext);
                v.setBackgroundColor(Color.parseColor("#F2B6B6B6"));
                v.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, 1));
                l.addView(v);
				mList = (ListView) inflater.inflate(R.layout.listview_layout,null).findViewById(R.id.parallax_s);
                //mList = new ListView(mContext);
				mList.setDivider(new ColorDrawable(0xF2B6B6B6));
				mList.setDividerHeight(1);
                if (isListView3 == true && isListView4 == false)
				{
                    mList.setAdapter(new ArrayAdapter<String>(mContext, R.layout.single_click_item, R.id.single_click_item_text, items));
                }
                else if (isListView3 == false && isListView4 == true)
				{
                    mList.setAdapter(new ArrayAdapter<String>(mContext, R.layout.single_click_item, R.id.single_click_item_text, arrayList));
                }
                mList.setChoiceMode(choiceMode);
                mList.setItemChecked(defItem, true);
                mList.setOnItemClickListener(mlistener);
                ChoiceList = mList;
                l.addView(mList);
                mFrameLayout.addView(l);
            }
            if (mViewId != 0 && mView == null)
			{
				LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);  
				lp.setMargins(0,0,-23,0);  
				v2.setLayoutParams(lp); 
				LayoutInflater inflater = LayoutInflater.from(mContext);
				LinearLayout mView = (LinearLayout) inflater.inflate(mViewId, null); 
                mView.setPadding(50,0,50,0);
                mFrameLayout.addView(mView);
			}
            else if (mViewId == 0 && mView != null)
			{
				LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);  
				lp.setMargins(0,0,-23,0);  
				v2.setLayoutParams(lp); 
				mView.setPadding(50,0,50,50);
                mFrameLayout.addView(mView);
            }
			
			
            if (CanceledOnTouchOutside == true)
			{
                 mDialog.setCanceledOnTouchOutside(true);
            }
            else if (CanceledOnTouchOutside == false)
			{
                mDialog.setCanceledOnTouchOutside(false);
  
            }
			if (Cancelable == true)
			{
				mDialog.setCancelable(true);
            }
            else if (Cancelable == false)
			{
                mDialog.setCancelable(false);

            }
			

			if (titleId == 0 && titleText == null)
			{
                mTitle.setVisibility(View.GONE);
            }
            else if (titleId != 0 && titleText == null)
			{
                mTitle.setText(titleId);
            }
            else if (titleId == 0 && titleText != null)
			{
                mTitle.setText(titleText);
            }
            if (messageId == 0 && messageText == null)
			{
                mMessage.setVisibility(View.GONE);
            }
            else if (messageId != 0 && messageText == null)
			{
                mMessage.setText(messageId);
            }
            else if (messageId == 0 && messageText != null)
			{
                mMessage.setText(messageText);
            }

            if (PositiveId != 0 && PositiveText == null)
			{
				PositiveButton.setText(PositiveId);
            }
            else if (PositiveId == 0 && PositiveText != null)
			{
                PositiveButton.setText(PositiveText);
            }

            if (NegativeId != 0 && NegativeText == null)
			{
                NegativeButton.setText(NegativeId);
            }
            else if (NegativeId == 0 && NegativeText != null)
			{
                NegativeButton.setText(NegativeText);
            }

            if (NeutralId != 0 && NeutralText == null)
			{
                NeutralButton.setText(NegativeId);
            }
            else if (NeutralId == 0 && NeutralText != null)
			{
                NeutralButton.setText(NeutralText);
            }

            if (PositiveListener != null)
			{
                PositiveButton.setOnClickListener(PositiveListener);
            }
            else
			{
                PositiveButton.setOnClickListener(new OnDialogButtonClickListener());
            }
            if (NegativeListener != null)
			{
                NegativeButton.setOnClickListener(NegativeListener);
            }
            else
			{
                NegativeButton.setOnClickListener(new OnDialogButtonClickListener());
            }
            if (NeutralListener != null)
			{
                NeutralButton.setOnClickListener(NeutralListener);
            }
            else
			{
                NeutralButton.setOnClickListener(new OnDialogButtonClickListener());
            }
            viewButton();

        }

		private Resources getResources()
		{
			// TODO: Implement this method
			return null;
		}

        private void viewButton()
		{
            int button_shape_bg=R.drawable.button_shape_bg;
            int button_shape_left=R.drawable.button_shape_left;
            int button_shape_center=R.drawable.button_shape_center;
            int button_shape_right=R.drawable.button_shape_right;

            if (isPositiveButtonShow == true && isNegativeButtonShow == false && isNeutralButtonShow == false)
			{
                PositiveButton.setBackgroundResource(button_shape_bg);
                NegativeButton.setVisibility(View.GONE);
                NeutralButton.setVisibility(View.GONE);
				neutralview.setVisibility(View.GONE);
				positiveview.setVisibility(View.GONE);
            }
            if (isPositiveButtonShow == false && isNegativeButtonShow == true && isNeutralButtonShow == false)
			{
                PositiveButton.setVisibility(View.GONE);
                NegativeButton.setBackgroundResource(button_shape_bg);
                NeutralButton.setVisibility(View.GONE);
				positiveview.setVisibility(View.GONE);
				neutralview.setVisibility(View.GONE);
            }
            if (isPositiveButtonShow == false && isNegativeButtonShow == false && isNeutralButtonShow == true)
			{
                PositiveButton.setVisibility(View.GONE);
                NegativeButton.setVisibility(View.GONE);
				neutralview.setVisibility(View.GONE);
				positiveview.setVisibility(View.GONE);
                NeutralButton.setBackgroundResource(button_shape_bg);
            }
            if (isPositiveButtonShow == true && isNegativeButtonShow == true && isNeutralButtonShow == false)
			{
                PositiveButton.setBackgroundResource(button_shape_right);
                NegativeButton.setBackgroundResource(button_shape_left);
                NeutralButton.setVisibility(View.GONE);
				neutralview.setVisibility(View.GONE);
            }
            if (isPositiveButtonShow == true && isNegativeButtonShow == false && isNeutralButtonShow == true)
			{
                PositiveButton.setBackgroundResource(button_shape_right);
                NegativeButton.setVisibility(View.GONE);
				positiveview.setVisibility(View.GONE);
                NeutralButton.setBackgroundResource(button_shape_left);
            }
            if (isPositiveButtonShow == false && isNegativeButtonShow == true && isNeutralButtonShow == true)
			{
                PositiveButton.setVisibility(View.GONE);
				positiveview.setVisibility(View.GONE);
                NegativeButton.setBackgroundResource(button_shape_right);
                NeutralButton.setBackgroundResource(button_shape_left);
            }
            if (isPositiveButtonShow == true && isNegativeButtonShow == true && isNeutralButtonShow == true)
			{
                PositiveButton.setBackgroundResource(button_shape_right);
                NegativeButton.setBackgroundResource(button_shape_center);
                NeutralButton.setBackgroundResource(button_shape_left);
            }
            if (isPositiveButtonShow == false && isNegativeButtonShow == false && isNeutralButtonShow == false)
			{
                mButton.setVisibility(View.GONE);
				v2.setVisibility(View.GONE);
				v1view.setVisibility(View.GONE);
            }
        }
	}
	public MIUIDialog setCanceledOnTouchOutside(boolean Cancele)
	{
        this.CanceledOnTouchOutside = Cancele;
        return this;
    }
	public MIUIDialog setCancelable(boolean OnTouch)
	{
        this.Cancelable = OnTouch;
        return this;
    }
	
	
    public MIUIDialog setTitle(CharSequence text)
	{
        this.titleText = text;
        return this;
    }
    public MIUIDialog setTitle(int resourcesId)
	{
        this.titleId = resourcesId;
        return this;
    }
    public MIUIDialog setMessage(CharSequence text)
	{
        this.messageText = text;
        return this;
    }
    public MIUIDialog setMessage(int resourcesId)
	{
        this.messageId = resourcesId;
        return this;
    }
    public MIUIDialog setView(View view)
	{
        this.mView = view;
        return this;
		
    }
	public MIUIDialog setView(int resourcesId)
	{
        this.mViewId = resourcesId;
        return this;
    }
    public MIUIDialog setEditText(CharSequence defaultText, int hintId)
	{
        this.setEditText = defaultText;
        this.hintId = hintId;
        this.isEditText = true;
        return this;
    }
    public MIUIDialog setEditText(int defaultTextId, CharSequence hint)
	{
        this.EditTextId = defaultTextId;
        this.hint = hint;
        this.isEditText = true;
        return this;
    }
    public MIUIDialog setEditText(CharSequence defaultText, CharSequence hint)
	{
        this.setEditText = defaultText;
        this.hint = hint;
        this.isEditText = true;
        return this;
    }
    public MIUIDialog setEditText(int defaultTextId, int hintId)
	{
        this.EditTextId = defaultTextId;
        this.hintId = hintId;
        this.isEditText = true;
        return this;
    }
    public String getEditText()
	{
		//EditText Edits = (EditText) LayoutInflater.from(mContext).inflate(R.layout.dialog_edittext, null).findViewById(R.id.Edits);
        return Edits.getText().toString();
    }
    public MIUIDialog setSingleChoiceItems(int defaultItem, String[] items, OnItemClickListener listener)
	{
        this.defItem = defaultItem;
        this.items = items;
        this.mlistener = listener;
        this.isListView1 = true;
        this.choiceMode = ListView.CHOICE_MODE_SINGLE;
        return this;
    }
    public MIUIDialog setSingleChoiceItems(int defaultItem, List<String> arrayList, OnItemClickListener listener)
	{
        this.defItem = defaultItem;
        this.arrayList = arrayList;
        this.mlistener = listener;
        this.isListView2 = true;
        this.choiceMode = ListView.CHOICE_MODE_SINGLE;
        return this;
    }
    public MIUIDialog setMultiChoiceItems(int defaultItem, String[] items, OnItemClickListener listener)
	{
        this.defItem = defaultItem;
        this.items = items;
        this.mlistener = listener;
        this.isListView3 = true;
        this.choiceMode = ListView.CHOICE_MODE_MULTIPLE;
        return this;
    }
    public MIUIDialog setMultiChoiceItems(int defaultItem, List<String> arrayList, OnItemClickListener listener)
	{
        this.defItem = defaultItem;
        this.arrayList = arrayList;
        this.mlistener = listener;
        this.isListView4 = true;
        this.choiceMode = ListView.CHOICE_MODE_MULTIPLE;
        return this;
    }
    
    public boolean isItemChecked(int postion)
	{
		// this.postion=postion;
        return !ChoiceList.isItemChecked(postion);
    }
    public MIUIDialog setPositiveButton(int resourcesId, final View.OnClickListener listener)
	{
        this.PositiveId = resourcesId;
        this.PositiveListener = listener;
        this.isPositiveButtonShow = true;
        return this;
    }
    public MIUIDialog setNegativeButton(int resourcesId, final View.OnClickListener listener)
	{
        this.NegativeId = resourcesId;
        this.NegativeListener = listener;
        this.isNegativeButtonShow = true;
        return this;
    }
    public MIUIDialog setNeutralButton(int resourcesId, final View.OnClickListener listener)
	{
        this.NeutralId = resourcesId;
        this.NeutralListener = listener;
        this.isNeutralButtonShow = true;
        return this;
    }
    public MIUIDialog setPositiveButton(CharSequence text, final View.OnClickListener listener)
	{
        this.PositiveText = text;
        this.PositiveListener = listener;
        this.isPositiveButtonShow = true;
        return this;
    }
    public MIUIDialog setNegativeButton(CharSequence text, final View.OnClickListener listener)
	{
        this.NegativeText = text;
        this.NegativeListener = listener;
        this.isNegativeButtonShow = true;
        return this;
    }
    public MIUIDialog setNeutralButton(CharSequence text, final View.OnClickListener listener)
	{
        this.NeutralText = text;
        this.NeutralListener = listener;
        this.isNeutralButtonShow = true;
        return this;
    }
	
    private class OnDialogButtonClickListener implements OnClickListener
    {

        @Override
        public void onClick(View p1)
        {
            // TODO: Implement this method
            mDialog.dismiss();
        }
    }
}

