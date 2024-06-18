package data.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.sqlite.driver.JdbcSqliteDriver
import com.vnteam.talktoai.AppDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        val driver: SqlDriver = JdbcSqliteDriver(url = "jdbc:sqlite:test.db")
        AppDatabase.Schema.create(driver)
        return driver
    }
}