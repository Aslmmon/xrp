package com.pinxrp.xrp;

import android.provider.Settings;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
//import com.google.firebase.iid.FirebaseInstanceId;
//import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by ABC on 8/8/2017.
 */
//public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

public class MyFirebaseInstanceIDService extends FirebaseMessagingService {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        if(mAuth.getCurrentUser()!=null) {
            Log.i("fireabasetoken",s);
            String uiid= Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
            mDatabase.child(mAuth.getCurrentUser().getUid()).child(uiid).child("utok").setValue(s);
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAuth= FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("userprofiles");
    }
}
