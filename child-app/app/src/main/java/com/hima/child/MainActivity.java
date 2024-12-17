package com.hima.child;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.location.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.List;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> jancok = new HashMap<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView id;
	private TextView textview12;
	private TextView gamesListTextView;
	private TextView resultTextView;
	private TextView locationText;
	private TextView textview11;
	private ScrollView vscroll1;
	private LinearLayout linear10;
	private LinearLayout linear3;
	private LinearLayout linear7;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private ImageView imageview1;
	private TextView textview13;
	private EditText edittext1;
	private EditText edittext2;
	private LinearLayout linear8;
	private TextView textview14;
	private TextView textview16;
	private TextView textview15;
	
	private DatabaseReference fdb = _firebase.getReference("child");
	private ChildEventListener _fdb_child_listener;
	private TimerTask terre;
	private TimerTask tt;
	private SharedPreferences child;
	private AlertDialog.Builder dia;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		id = findViewById(R.id.id);
		textview12 = findViewById(R.id.textview12);
		gamesListTextView = findViewById(R.id.gamesListTextView);
		resultTextView = findViewById(R.id.resultTextView);
		locationText = findViewById(R.id.locationText);
		textview11 = findViewById(R.id.textview11);
		vscroll1 = findViewById(R.id.vscroll1);
		linear10 = findViewById(R.id.linear10);
		linear3 = findViewById(R.id.linear3);
		linear7 = findViewById(R.id.linear7);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		imageview1 = findViewById(R.id.imageview1);
		textview13 = findViewById(R.id.textview13);
		edittext1 = findViewById(R.id.edittext1);
		edittext2 = findViewById(R.id.edittext2);
		linear8 = findViewById(R.id.linear8);
		textview14 = findViewById(R.id.textview14);
		textview16 = findViewById(R.id.textview16);
		textview15 = findViewById(R.id.textview15);
		child = getSharedPreferences("child", Activity.MODE_PRIVATE);
		dia = new AlertDialog.Builder(this);
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dia.setTitle("Confirm your Details");
				dia.setMessage("Make sure that the details are correct. You can't edit the details after this.");
				dia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						child.edit().putString("login", "yes").commit();
						child.edit().putString("pass", edittext2.getText().toString()).commit();
						textview14.setVisibility(View.VISIBLE);
						_infodevice(textview12);
						tt = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										Context context = MainActivity.this; // Explicitly use MainActivity.this
										
										    AppOpsManager appOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
										    int mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
										            android.os.Process.myUid(), context.getPackageName());
										
										    if (mode != AppOpsManager.MODE_ALLOWED) {
											        // Permission not granted, redirect to settings
											        Toast.makeText(context, "Grant Usage Access Permission", Toast.LENGTH_LONG).show();
											        Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
											        intent.setData(Uri.parse("package:" + context.getPackageName()));
											        context.startActivity(intent);
											    } else {
											        // Permission already granted
											        Toast.makeText(context, "Usage Access Permission Already Granted", Toast.LENGTH_SHORT).show();
											    }
										UsageStatsManager statsManager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
										
										Calendar calendar = Calendar.getInstance();
										calendar.set(Calendar.HOUR_OF_DAY, 0);
										calendar.set(Calendar.MINUTE, 0);
										calendar.set(Calendar.SECOND, 0);
										long startOfDay = calendar.getTimeInMillis();
										
										calendar.set(Calendar.HOUR_OF_DAY, 23);
										calendar.set(Calendar.MINUTE, 59);
										calendar.set(Calendar.SECOND, 59);
										long endOfDay = calendar.getTimeInMillis();
										
										List<UsageStats> statsList = statsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, startOfDay, endOfDay);
										
										long totallTime = 0;
										for (UsageStats stats : statsList) {
											    totallTime += stats.getTotalTimeInForeground();
										}
										
										long screenHours = totallTime / 3600000;
										long screenMinutes = (totallTime % 3600000) / 60000;
										long screenSeconds = (totallTime % 60000) / 1000;
										
										String screenTimeText = screenHours + "h " + screenMinutes + "m " + screenSeconds + "s";
										textview11.setText(screenTimeText);
										
										    // Permission granted, proceed with location logic
										    LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
										    TextView locationText = findViewById(R.id.locationText);
										
										    if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
											        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
											
											        if (location != null) {
												            double latitude = location.getLatitude();
												            double longitude = location.getLongitude();
												            locationText.setText( latitude + "," + longitude);
												        } else {
												            locationText.setText("Location not available");
												        }
											    } else {
											        locationText.setText("GPS is disabled");
											    }
										
										// Separate class for app usage info
										class AppUsageInfo {
											    private String appName;
											    private long usageTime;
											
											    public AppUsageInfo(String appName, long usageTime) {
												        this.appName = appName;
												        this.usageTime = usageTime;
												    }
											
											    public String getAppName() {
												        return appName;
												    }
											
											    public long getUsageTime() {
												        return usageTime;
												    }
										}
										
										PackageManager packageManagerr = getPackageManager();
										UsageStatsManager usageStatsManager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
										
										long endTime = System.currentTimeMillis();
										long startTime = endTime - 24 * 60 * 60 * 1000;
										
										List<UsageStats> usageStatsList = usageStatsManager.queryUsageStats(
										    UsageStatsManager.INTERVAL_DAILY, 
										    startTime, 
										    endTime
										);
										
										List<AppUsageInfo> appUsageInfoList = new ArrayList<>();
										
										for (UsageStats usageStats : usageStatsList) {
											    try {
												        ApplicationInfo applicationInfo = packageManagerr.getApplicationInfo(usageStats.getPackageName(), 0);
												        
												        String appName = packageManagerr.getApplicationLabel(applicationInfo).toString();
												        long totalTime = usageStats.getTotalTimeInForeground();
												        
												        if (totalTime > 0) {
													            appUsageInfoList.add(new AppUsageInfo(appName, totalTime));
													        }
												    } catch (PackageManager.NameNotFoundException e) {
												        // Skip apps that can't be found
												    }
										}
										
										Collections.sort(appUsageInfoList, new Comparator<AppUsageInfo>() {
											    @Override
											    public int compare(AppUsageInfo app1, AppUsageInfo app2) {
												        return Long.compare(app2.getUsageTime(), app1.getUsageTime());
												    }
										});
										
										StringBuilder resultText = new StringBuilder("");
										
										int displayCount = Math.min(10, appUsageInfoList.size());
										for (int i = 0; i < displayCount; i++) {
											    AppUsageInfo appUsage = appUsageInfoList.get(i);
											    long hours = appUsage.getUsageTime() / (1000 * 60 * 60);
											    long minutes = (appUsage.getUsageTime() % (1000 * 60 * 60)) / (1000 * 60);
											    
											    resultText.append(appUsage.getAppName())
											              .append(": ")
											              .append(hours)
											              .append(" hours ")
											              .append(minutes)
											              .append(" minutes\n");
										}
										
										resultTextView.setText(resultText.toString());
										PackageManager packageManager = getPackageManager();
										List<ApplicationInfo> apps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
										
										StringBuilder appList = new StringBuilder("");
										
										for (ApplicationInfo appInfo : apps) {
											    Intent launchIntent = packageManager.getLaunchIntentForPackage(appInfo.packageName);
											    if (launchIntent != null) {
												        // Fetch the app name
												        String appName = packageManager.getApplicationLabel(appInfo).toString();
												        appList.append(appName).append("\n");
												    }
										}
										
										// Display the list in the TextView
										gamesListTextView.setText(appList.toString());
										
										jancok = new HashMap<>();
										jancok.put("screentime", textview11.getText().toString());
										jancok.put("name", edittext1.getText().toString());
										jancok.put("location", locationText.getText().toString());
										jancok.put("appusage", resultTextView.getText().toString());
										jancok.put("games", gamesListTextView.getText().toString());
										jancok.put("about", textview12.getText().toString());
										jancok.put("id", id.getText().toString());
										fdb.child(id.getText().toString()).updateChildren(jancok);
										jancok.clear();
									}
								});
							}
						};
						_timer.scheduleAtFixedRate(tt, (int)(1000), (int)(1000));
					}
				});
				dia.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				dia.create().show();
			}
		});
		
		textview14.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", id.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Copied");
				return true;
			}
		});
		
		textview14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", id.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Copied");
			}
		});
		
		textview15.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", id.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Copied");
				return true;
			}
		});
		
		textview15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", id.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Copied");
			}
		});
		
		_fdb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		fdb.addChildEventListener(_fdb_child_listener);
	}
	
	private void initializeLogic() {
		textview13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/semi.ttf"), 0);
		edittext2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/semi.ttf"), 0);
		textview16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/semi.ttf"), 0);
		textview14.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/italic.ttf"), 0);
		textview15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/italic.ttf"), 0);
		id.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(100), (int)(999)))).concat("D".concat(String.valueOf((long)(SketchwareUtil.getRandom((int)(10), (int)(99)))))).concat(String.valueOf((long)(SketchwareUtil.getRandom((int)(10), (int)(99)))).concat("X")));
		Intent serviceIntent = new Intent(this, MyForegroundService.class);
		startService(serviceIntent);
		
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
		        != PackageManager.PERMISSION_GRANTED) {
			    ActivityCompat.requestPermissions(this,
			            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
		} else {
			    Toast.makeText(this, "Location Permission Already Granted", Toast.LENGTH_SHORT).show();
		}
		
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFF383E7E));
		linear7.setVisibility(View.GONE);
		textview14.setVisibility(View.INVISIBLE);
		_GradientDrawable(linear3, 35, 0, 6, "#ffffff", "#ffffff", false, false, 0);
		if (child.getString("login", "").equals("yes")) {
			linear5.setVisibility(View.INVISIBLE);
			linear7.setVisibility(View.VISIBLE);
		}
		else {
			
		}
	}
	
	public void _infodevice(final TextView _tv) {
		DisplayMetrics dm = new DisplayMetrics(); getWindowManager().getDefaultDisplay().getMetrics(dm); int width = dm.widthPixels; int height = dm.heightPixels; _tv.setText( "SERIAL: " + Build.SERIAL + "\n\n" + "MODEL: " + Build.MODEL + "\n\n" + "ID: " + Build.ID + "\n\n" + "Manufacture: " + Build.MANUFACTURER + "\n\n" + "Brand: " + Build.BRAND + "\n\n" + "Device Language: " + Locale.getDefault().getDisplayLanguage() + "\n\n" + "Screen Resolution: " + width + "x" + height + "\n\n" + "Type: " + Build.TYPE + "\n\n" + "User: " + Build.USER + "\n\n" + "BASE: " + Build.VERSION_CODES.BASE + "\n\n" + "INCREMENTAL: " + Build.VERSION.INCREMENTAL + "\n\n" + "SDK: " + Build.VERSION.SDK + "\n\n" + "BOARD: " + Build.BOARD + "\n\n" + "BRAND: " + Build.BRAND + "\n\n" + "HOST: " + Build.HOST + "\n\n" + "FINGERPRINT: "+Build.FINGERPRINT + "\n\n" + "Version Code: " + Build.VERSION.RELEASE );
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