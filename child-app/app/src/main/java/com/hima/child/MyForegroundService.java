package com.hima.child;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import java.util.Calendar;

public class MyForegroundService extends Service {
    private static final String CHANNEL_ID = "ForegroundServiceChannel";
    private Handler handler = new Handler(Looper.getMainLooper());
    private MediaPlayer mediaPlayer;

    private Runnable prayerTimeChecker = new Runnable() {
        @Override
        public void run() {
            checkPrayerTimes();
            // Check every minute
            handler.postDelayed(this, 60000);
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        createNotificationChannel();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("You are in control!")
                .setContentText("Remember! Allah is watching you!")
                .setSmallIcon(android.R.drawable.ic_notification_overlay)
                .build();
                
        startForeground(1, notification);
        
        // Start prayer time checking
        handler.post(prayerTimeChecker);
        
        return START_STICKY;
    }

    private void checkPrayerTimes() {
        String[] prayerNames = {"Fajr", "Zuhr", "Asr", "Maghrib", "Isha"};
        int[] prayerHours = {5, 12, 15, 18, 19};
        int[] prayerMinutes = {20, 20, 38, 5, 21};

        Calendar currentTime = Calendar.getInstance();
        int currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
        int currentMinute = currentTime.get(Calendar.MINUTE);

        for (int i = 0; i < prayerNames.length; i++) {
            if (currentHour == prayerHours[i] && currentMinute == prayerMinutes[i]) {
                // Play Adhan
                playAdhan();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setContentTitle("Prayer Time")
                    .setContentText("It's time for " + prayerNames[i] + " prayer")
                    .setSmallIcon(android.R.drawable.ic_notification_overlay)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true);

                NotificationManager notificationManager = 
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                
                if (notificationManager != null) {
                    notificationManager.notify(i, builder.build());
                }
            }
        }
    }

    private void playAdhan() {
        // Stop previous adhan if playing
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        // Create MediaPlayer with your adhan sound
        // Replace R.raw.adhan with your actual adhan sound resource
        mediaPlayer = MediaPlayer.create(this, R.raw.adhan);
        
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(serviceChannel);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stop the handler and release media player
        handler.removeCallbacks(prayerTimeChecker);
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
