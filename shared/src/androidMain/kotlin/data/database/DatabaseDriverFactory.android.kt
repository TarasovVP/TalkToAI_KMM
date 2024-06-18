package data.database

import app.cash.sqldelight.android.AndroidSqliteDriver
import app.cash.sqldelight.db.SqlDriver
import com.vnteam.talktoai.AppDatabase

actual class DatabaseDriverFactory(private val context: android.content.Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDatabase.Schema, context, "test.db")
    }
}