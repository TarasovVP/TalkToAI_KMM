package data.database

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.vnteam.talktoai.AppDatabase

actual class DatabaseDriverFactory(private val context: Context? = null) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDatabase.Schema, context!!, "test.db")
    }
}