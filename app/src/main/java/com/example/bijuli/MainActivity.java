package com.example.bijuli;

import android.support.v7.app.ActionBarActivity;
import android.text.InputFilter;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.bijuli.birthday.R;


public class MainActivity extends ActionBarActivity implements OnClickListener {

	Button find;
	EditText name1;
	EditText name2;
	
	Toast msg;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        find=(Button) findViewById(R.id.button1);
        name1=(EditText) findViewById(R.id.editText1);
        InputFilter[] filterArray = new InputFilter[1];
        filterArray[0] = new InputFilter.LengthFilter(24);
        name1.setFilters(filterArray);
        name2=(EditText) findViewById(R.id.editText2);
        
        name1.setText("");
        name2.setText("");
        
        find.setOnClickListener(this);
        InputFilter[] filterArray1 = new InputFilter[1];
        filterArray1[0] = new InputFilter.LengthFilter(24);
        name2.setFilters(filterArray1);

    }
    
    @Override
    public void onClick(View v){
    	Intent intent = new Intent(this,Second_activity.class); 
        intent.putExtra("fname", name1.getText().toString());
        intent.putExtra("lname", name2.getText().toString());
        if(name1.getText().toString().trim().equals("") || name2.getText().toString().trim().equals("")){
        	msg=Toast.makeText(this,"Make sure all fields are entered",Toast.LENGTH_LONG);
            msg.show();	
        }
        else
        {    
        	startActivity(intent); 
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
