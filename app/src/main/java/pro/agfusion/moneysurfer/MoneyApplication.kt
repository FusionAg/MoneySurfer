package pro.agfusion.moneysurfer

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric


class MoneyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.enableCrashlytics) {
            Fabric.with(this, Crashlytics())
        }
    }
}