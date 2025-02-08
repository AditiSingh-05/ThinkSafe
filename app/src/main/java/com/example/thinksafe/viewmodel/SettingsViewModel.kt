package com.example.thinksafe.viewmodel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.thinksafe.data.PreferencesKeys

class SettingsViewModel(private val dataStore: DataStore<Preferences>) : ViewModel() {
    val themeMode: Flow<Boolean> = dataStore.data.map { it[PreferencesKeys.THEME_KEY] ?: false }

    suspend fun setThemeMode(isDarkMode: Boolean) {
        dataStore.edit { it[PreferencesKeys.THEME_KEY] = isDarkMode }
    }
}
