package com.example.bijuli;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.bijuli.birthday.R;

public class AboutActivity extends Activity implements OnClickListener{
	
	Button home;
	Button back;
	//Button about;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		
		home=(Button) findViewById(R.id.close);
		back=(Button) findViewById(R.id.back);
	
		
		home.setOnClickListener(this);
		back.setOnClickListener(this);
		
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
		default:
			break;
		}
	}

	private static long back_pressed;

	@Override
	public void onBackPressed() {
		if (back_pressed + 2000 > System.currentTimeMillis())
			super.onBackPressed();
		else
			Toast.makeText(getBaseContext(), "Press once again to Back!", Toast.LENGTH_SHORT).show();
		back_pressed = System.currentTimeMillis();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



}
