package com.hima.parent;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class HomeActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String currentDate = "";
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private TextView textview37;
	private TextView textview36;
	private TextView id;
	private TextView textview1;
	private LinearLayout linear62;
	private LinearLayout linear3;
	private LinearLayout linear21;
	private LinearLayout linear25;
	private LinearLayout linear34;
	private LinearLayout linear60;
	private LinearLayout linear4;
	private LinearLayout linear18;
	private LinearLayout linear20;
	private LinearLayout linear19;
	private CircleImageView circleimageview1;
	private TextView textview25;
	private TextView name;
	private LinearLayout linear22;
	private LinearLayout linear23;
	private LinearLayout date;
	private TextView textview27;
	private LinearLayout linear26;
	private LinearLayout linear27;
	private LinearLayout screentime;
	private LinearLayout location;
	private TextView screentimee;
	private TextView textview29;
	private ImageView imageview2;
	private TextView textview31;
	private LinearLayout linear35;
	private LinearLayout con3;
	private LinearLayout linear37;
	private LinearLayout linear58;
	private LinearLayout linear49;
	private LinearLayout linear57;
	private LinearLayout linear53;
	private LinearLayout linear41;
	private LinearLayout linear44;
	private LinearLayout linear47;
	private ImageView imageview5;
	private TextView textview32;
	private ImageView imageview8;
	private LinearLayout linear50;
	private LinearLayout linear51;
	private LinearLayout linear52;
	private ImageView imageview10;
	private TextView textview33;
	private ImageView imageview11;
	private LinearLayout linear54;
	private LinearLayout linear55;
	private LinearLayout linear56;
	private ImageView imageview12;
	private TextView textview34;
	private ImageView imageview13;
	private LinearLayout linear61;
	private LinearLayout block;
	private TextView textview35;
	
	private Intent inte = new Intent();
	private SharedPreferences idd;
	private DatabaseReference dsb = _firebase.getReference("child");
	private ChildEventListener _dsb_child_listener;
	private AlertDialog.Builder fa;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		vscroll1 = findViewById(R.id.vscroll1);
		textview37 = findViewById(R.id.textview37);
		textview36 = findViewById(R.id.textview36);
		id = findViewById(R.id.id);
		textview1 = findViewById(R.id.textview1);
		linear62 = findViewById(R.id.linear62);
		linear3 = findViewById(R.id.linear3);
		linear21 = findViewById(R.id.linear21);
		linear25 = findViewById(R.id.linear25);
		linear34 = findViewById(R.id.linear34);
		linear60 = findViewById(R.id.linear60);
		linear4 = findViewById(R.id.linear4);
		linear18 = findViewById(R.id.linear18);
		linear20 = findViewById(R.id.linear20);
		linear19 = findViewById(R.id.linear19);
		circleimageview1 = findViewById(R.id.circleimageview1);
		textview25 = findViewById(R.id.textview25);
		name = findViewById(R.id.name);
		linear22 = findViewById(R.id.linear22);
		linear23 = findViewById(R.id.linear23);
		date = findViewById(R.id.date);
		textview27 = findViewById(R.id.textview27);
		linear26 = findViewById(R.id.linear26);
		linear27 = findViewById(R.id.linear27);
		screentime = findViewById(R.id.screentime);
		location = findViewById(R.id.location);
		screentimee = findViewById(R.id.screentimee);
		textview29 = findViewById(R.id.textview29);
		imageview2 = findViewById(R.id.imageview2);
		textview31 = findViewById(R.id.textview31);
		linear35 = findViewById(R.id.linear35);
		con3 = findViewById(R.id.con3);
		linear37 = findViewById(R.id.linear37);
		linear58 = findViewById(R.id.linear58);
		linear49 = findViewById(R.id.linear49);
		linear57 = findViewById(R.id.linear57);
		linear53 = findViewById(R.id.linear53);
		linear41 = findViewById(R.id.linear41);
		linear44 = findViewById(R.id.linear44);
		linear47 = findViewById(R.id.linear47);
		imageview5 = findViewById(R.id.imageview5);
		textview32 = findViewById(R.id.textview32);
		imageview8 = findViewById(R.id.imageview8);
		linear50 = findViewById(R.id.linear50);
		linear51 = findViewById(R.id.linear51);
		linear52 = findViewById(R.id.linear52);
		imageview10 = findViewById(R.id.imageview10);
		textview33 = findViewById(R.id.textview33);
		imageview11 = findViewById(R.id.imageview11);
		linear54 = findViewById(R.id.linear54);
		linear55 = findViewById(R.id.linear55);
		linear56 = findViewById(R.id.linear56);
		imageview12 = findViewById(R.id.imageview12);
		textview34 = findViewById(R.id.textview34);
		imageview13 = findViewById(R.id.imageview13);
		linear61 = findViewById(R.id.linear61);
		block = findViewById(R.id.block);
		textview35 = findViewById(R.id.textview35);
		idd = getSharedPreferences("id", Activity.MODE_PRIVATE);
		fa = new AlertDialog.Builder(this);
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				idd.edit().putString("id", "no").commit();
				inte.putExtra("roll", "no");
				finishAffinity();
			}
		});
		
		location.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				textview37.setText("https://maps.google.com/?q=".concat(textview36.getText().toString()));
				inte.setAction(Intent.ACTION_VIEW);
				inte.setData(Uri.parse(textview37.getText().toString()));
				startActivity(inte);
			}
		});
		
		linear37.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inte.setClass(getApplicationContext(), AppusageActivity.class);
				startActivity(inte);
			}
		});
		
		linear49.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inte.setClass(getApplicationContext(), ManageappActivity.class);
				startActivity(inte);
			}
		});
		
		linear53.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inte.setClass(getApplicationContext(), DeviceinfoActivity.class);
				startActivity(inte);
			}
		});
		
		block.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				fa.setTitle("Block Social Media Apps");
				fa.setMessage("Are you sure that you want to block the social media apps of your child.");
				fa.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				fa.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				fa.create().show();
			}
		});
		
		_dsb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(id.getText().toString())) {
					name.setText(_childValue.get("name").toString());
					screentimee.setText(_childValue.get("screentime").toString());
					textview36.setText(_childValue.get("location").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(id.getText().toString())) {
					name.setText(_childValue.get("name").toString());
					screentimee.setText(_childValue.get("screentime").toString());
				}
				else {
					
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		dsb.addChildEventListener(_dsb_child_listener);
	}
	
	private void initializeLogic() {
		id.setText(idd.getString("id", ""));
		_GradientDrawable(date, 35, 0, 5, "#ffffff", "#ffffff", false, false, 0);
		_GradientDrawable(screentime, 35, 0, 0, "#383e7e", "#383e7e", false, false, 0);
		_GradientDrawable(location, 35, 0, 0, "#383e7e", "#383e7e", false, false, 0);
		_GradientDrawable(con3, 35, 0, 5, "#ffffff", "#ffffff", false, false, 0);
		_GradientDrawable(block, 35, 0, 0, "#942222", "#924444", false, false, 0);
		currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
		textview27.setText("TODAY : ".concat(currentDate));
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/regular.ttf"), 0);
		id.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/italic.ttf"), 0);
		textview25.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/regular.ttf"), 0);
		name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		textview27.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		screentimee.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		textview29.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/regular.ttf"), 0);
		textview31.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/regular.ttf"), 0);
		textview32.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/semi.ttf"), 0);
		textview33.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/semi.ttf"), 0);
		textview34.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/semi.ttf"), 0);
		textview35.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
	}
	public void _GradientDrawable(final View _view, final double _radius, final double _stroke, final double _shadow, final String _color, final String _borderColor, final boolean _ripple, final boolean _clickAnim, final double _animDuration) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			gd.setStroke((int)_stroke,Color.parseColor(_borderColor));
			if (Build.VERSION.SDK_INT >= 21){
				_view.setElevation((int)_shadow);}
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9e9e9e")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			gd.setStroke((int)_stroke,Color.parseColor(_borderColor));
			_view.setBackground(gd);
			if (Build.VERSION.SDK_INT >= 21){
				_view.setElevation((int)_shadow);}
		}
		if (_clickAnim) {
			_view.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(_view);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration((int)_animDuration);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(_view);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration((int)_animDuration);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(_view);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration((int)_animDuration);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(_view);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues((float)1);
							scaleY.setDuration((int)_animDuration);
							scaleY.start();
							
							break;
						}
					}
					return false;
				}
			});
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}