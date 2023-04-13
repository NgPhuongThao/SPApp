package com.example.spapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.Locale;

public class LocaleHelper {
    private static final String LANGUE_SELECTIONNEE = "Locale.Helper.Selected.Language";

    // Set la langue au démarrage
    public static void setLocale(Activity activite, String langue){
        Locale local = new Locale(langue);
        local.setDefault(local);
        Resources ressources = activite.getResources();
        Configuration config = ressources.getConfiguration();
        config.setLocale(local);
        ressources.updateConfiguration(config, ressources.getDisplayMetrics());
    }
}
