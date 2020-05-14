package eric.com.smartmusic.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import eric.com.smartmusic.R

class SettingFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.setting)
    }
}
