package com.sermage.surfteam.settings

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SettingsStorage @Inject constructor(
    @ApplicationContext context: Context
) : UserSettings {

    override var theme: AppTheme by AppThemePreferenceDelegate("app_theme", AppTheme.MODE_AUTO)

    private val preferences: SharedPreferences =
        context.getSharedPreferences("shared_preferences", Context.MODE_PRIVATE)


    inner class AppThemePreferenceDelegate(
        private val name: String,
        private val default: AppTheme,
    ) : ReadWriteProperty<Any?, AppTheme> {

        override fun getValue(thisRef: Any?, property: KProperty<*>): AppTheme =
            AppTheme.fromOrdinal(preferences.getInt(name, default.ordinal))

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: AppTheme) {
            preferences.edit {
                putInt(name, value.ordinal)
            }
        }
    }
}