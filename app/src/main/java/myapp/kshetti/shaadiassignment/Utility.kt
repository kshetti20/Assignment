package myapp.kshetti.shaadiassignment

import android.content.Context
import android.net.ConnectivityManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Utility @Inject constructor(@ApplicationContext val context: Context) {

    fun isNetworkConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }

    fun saveViewedPosition(uID: Long) {
        val sharedPreference = context.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putLong(VIEWED_ID, uID)
        editor.commit()
    }

    fun getViewedPosition(): Long {
        val sharedPreference = context.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE)
            return sharedPreference.getLong(VIEWED_ID, DEFAULT_POSITION)
    }


    companion object {
        const val USER_PREF = "user_pref"
        const val VIEWED_ID = "viewed_id"
        const val DEFAULT_POSITION: Long = 0
    }
}