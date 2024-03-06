import domain.sealed_classes.NavigationScreen

sealed class SettingsScreen(val name: String, val icon: String, val route: String) {
    class ChatScreen : SettingsScreen(
        "settings_chat",
        "ic_settings_chat",
        NavigationScreen.SettingsChatScreen().route
    )

    class AccountScreen : SettingsScreen(
        "settings_account",
        "ic_settings_account",
        NavigationScreen.SettingsAccountScreen().route
    )

    class LanguageScreen : SettingsScreen(
        "settings_language",
        "ic_settings_language",
        NavigationScreen.SettingsLanguageScreen().route
    )

    class ThemeScreen : SettingsScreen(
        "settings_theme",
        "ic_settings_theme",
        NavigationScreen.SettingsThemeScreen().route
    )

    class FeedbackScreen : SettingsScreen(
        "settings_feedback",
        "ic_settings_feedback",
        NavigationScreen.SettingsFeedbackScreen().route
    )

    class PrivacyPolicyScreen : SettingsScreen(
        "settings_privacy_policy",
        "ic_settings_privacy",
        NavigationScreen.SettingsPrivacyPolicyScreen().route
    )

    companion object {
        val allSettingsScreens: List<SettingsScreen> = listOf(
            ChatScreen(),
            AccountScreen(),
            LanguageScreen(),
            ThemeScreen(),
            FeedbackScreen(),
            PrivacyPolicyScreen()
        )

        fun isSettingsScreen(route: String?) = allSettingsScreens.map { it.route }.contains(route)

        fun settingsScreenNameByRoute(route: String?) =
            allSettingsScreens.find { it.route == route }?.name ?: "app_name"
    }
}
