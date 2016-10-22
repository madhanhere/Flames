package com.example.bijuli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bijuli.birthday.R;

public class Second_activity extends Activity implements OnClickListener{

	
	TextView textView1;
	TextView textView2;
	private ImageView image;
	Button home;
	Button back;
	Button about;
	Toast info;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear_layout);
		info=Toast.makeText(this,"finding your relationship",Toast.LENGTH_LONG);
		info.show();
		image=(ImageView) findViewById(R.id.image);

		textView1=(TextView) findViewById(R.id.msg);
		textView2=(TextView) findViewById(R.id.textView2);

		Intent intent=getIntent();
		home=(Button) findViewById(R.id.close);
		back=(Button) findViewById(R.id.back);
		about=(Button) findViewById(R.id.about);
		String fName = intent.getStringExtra("fname");
		String lName = intent.getStringExtra("lname");

		String relationship=prediction(fName,lName);

		textView2.setText(relationship);

		home.setOnClickListener(this);
		back.setOnClickListener(this);
		about.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v){

		switch(v.getId()){
		case R.id.close:
			Intent startMain = new Intent(Intent.ACTION_MAIN);
			startMain.addCategory(Intent.CATEGORY_HOME);
			startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(startMain); 
			break;
		case R.id.back:
			super.onBackPressed();
			break;
		case R.id.about:
			Intent intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}


	private static long back_pressed;

	@Override
	public void onBackPressed() {
		if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
		else Toast.makeText(getBaseContext(), "Press once again to Back!", Toast.LENGTH_SHORT).show();
		back_pressed = System.currentTimeMillis();
	}



	public String prediction(String nam1,String nam2){

		String relation=new String();
		nam1 = nam1.trim();
		nam2 = nam2.trim();
		nam1 = nam1.toLowerCase(); 
		nam2 = nam2.toLowerCase();
		String name1_split[] = nam1.split(" ");
		String name2_split[] = nam2.split(" ");
		nam1="";
		nam2="";
		for(int i=0;i<name1_split.length;i++)
		{
			nam1 = nam1+name1_split[i];
		}
		for(int i=0;i<name2_split.length;i++)
		{
			nam2 = nam2+name2_split[i];
		}
		StringBuffer name1=new StringBuffer(nam1);
		StringBuffer name2=new StringBuffer(nam2);
		int a=nam1.length(),b=nam2.length();
		for(int i=0;i<a;i++)
		{
			char h=name1.charAt(i);
			for(int j=0;j<b;j++)
			{
				char d=name2.charAt(j);
				if(h==d)
				{
					name1.deleteCharAt(i);
					name2.deleteCharAt(j);
					a=name1.length();
					b=name2.length();
					i=0;
					j=0;
				}

			}			
		}

		int count=a+b;
		StringBuffer s3=new StringBuffer("flames");
		String s4=new String();
		for(int i=0;i<5;i++) // size of flames array
		{
			int n=-1,l=0,p=0;
			for(int j=0;j<count;j++) //size of remaining array 
			{
				n++;
				l++;
				if(n>s3.length()-1)
				{
					char e=s3.charAt(p);
					if(l==count)
					{
						s3.deleteCharAt(p);
						s4=s3.substring(p,s3.length());
						s3.delete(p,s3.length());
						s3.insert(0,s4);
						break;
					}
					else
					{
						p++;
						if(p==s3.length())
						{
							p=0;
						}
					}
				}
				else
				{
					char e=s3.charAt(n);
					if(l==count)
					{
						s3.deleteCharAt(n);

						s4=s3.substring(n,s3.length());
						s3.delete(n,s3.length());
						s3.insert(0,s4);
						break;
					}

				}

			}
		}
		char result=s3.charAt(0);
		switch(result){
		case 'f':
			relation="Hey "+nam1+", "+nam2+" is your Friend";
			image.setImageResource(R.drawable.friend);
			break;
		case 'l':
			relation="Hey "+nam1+", I think "+nam2+" is your Love";
			image.setImageResource(R.drawable.love);
			break;
		case 'a':
			relation="Belive me "+nam1+" , "+nam2+" is your Affection";
			image.setImageResource(R.drawable.affection);
			break;
		case 'm':
			relation=nam1+", you are going to marry "+nam2;
			image.setImageResource(R.drawable.marriage);
			break;
		case 'e':
			relation="Oops "+nam2+" is your Enemy";
			image.setImageResource(R.drawable.enemy);
			break;
		case 's':
			relation="I reckon "+nam2+" is your Sibling";
			image.setImageResource(R.drawable.sibling);
			break;
		}
		return relation;	
	}

	
}
