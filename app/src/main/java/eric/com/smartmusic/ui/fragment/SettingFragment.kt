package eric.com.smartmusic.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import eric.com.smartmusic.R
import eric.com.smartmusic.ui.activity.AboutActivity

class SettingFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.setting)
    }

    override fun onPreferenceTreeClick(preference: Preference?): Boolean {
        if (preference != null) {
            when(preference.key){
                "clear_cache"->{
                    Toast.makeText(context, "clear_cache", Toast.LENGTH_SHORT).show()
                }
                "push"->{
                    Toast.makeText(context, "push", Toast.LENGTH_SHORT).show()
                }
                "none_wifi"->{
                    Toast.makeText(context, "none_wifi", Toast.LENGTH_SHORT).show()
                }
                "about"->{
                    Intent(context, AboutActivity::class.java).apply {
                        startActivity(this)
                    }
                    Toast.makeText(context, "about", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return super.onPreferenceTreeClick(preference)
    }
}
