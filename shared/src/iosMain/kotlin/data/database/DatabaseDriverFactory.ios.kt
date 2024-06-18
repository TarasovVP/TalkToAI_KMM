package data.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.drivers.native.NativeSqliteDriver
import com.vnteam.talktoai.AppDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "test.db")
    }
}