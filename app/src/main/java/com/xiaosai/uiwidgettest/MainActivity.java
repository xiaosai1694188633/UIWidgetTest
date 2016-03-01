package com.xiaosai.uiwidgettest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/3/1 0001.
 */
public class MainActivity extends Activity implements View.OnClickListener {

	private Button btn_btn;
	private EditText edit;
	private ImageView img;
	private ProgressBar bp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_btn = (Button) findViewById(R.id.btn_button);
		edit = (EditText) findViewById(R.id.edit_text);
		img = (ImageView) findViewById(R.id.img_3g);
		bp = (ProgressBar) findViewById(R.id.progressbar);

		btn_btn.setOnClickListener(this);
		img.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.btn_button:
				//此处添加逻辑代码
//				Toast.makeText(MainActivity.this, edit.getText().toString(), Toast.LENGTH_SHORT).show();
				/**
				 * 以下代码是AlertDialog的使用方法
				 */
				AlertDialog.Builder alterdialog = new AlertDialog.Builder(MainActivity.this);
				alterdialog.setTitle("提示");  //设置标题
				alterdialog.setMessage("确定要替换图片吗？");  //设置主要提示的内容、信息
				alterdialog.setCancelable(false);
				//设置确定按钮
				alterdialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

						/**
						 * 测试一下带进度条的ProgressDialog
						 */
						ProgressDialog pd = new ProgressDialog(MainActivity.this);
						pd.setTitle("请稍候....");
						pd.setMessage("正在替换中，请稍等....");
						pd.setCancelable(true);
						pd.show();
						img.setImageResource(R.drawable.th_3g_off);
						pd.setMax(20);
						Toast.makeText(MainActivity.this, "替换图片成功...", Toast.LENGTH_SHORT).show();
					}
				});

				//设置取消按钮
				alterdialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "替换图片失败", Toast.LENGTH_SHORT).show();
					}
				});
				//最后显示
				alterdialog.show();

				break;
			case R.id.img_3g:
				int i = bp.getProgress()+10;
				bp.setProgress(i);
				if(i==100){
					i=0;
					bp.setProgress(i);
				}
				break;
		}
	}


}
