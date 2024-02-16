package domain

object Constants {
    const val SERVER_TIMEOUT = 50L

    //App
    const val SUCCESS_MESSAGE = "successMessage"
    const val ERROR_MESSAGE = "errorMessage"

    //Chat
    const val CURRENT_CHAT_ID = "current_chat_id"
    const val DEFAULT_CHAT_ID = -1L
    const val DESTINATION_CHAT_SCREEN = "destination_chat_screen"

    //Settings
    const val ON_BOARDING_SEEN = "onBoardingSeen"
    const val APP_LANG = "appLang"
    const val APP_THEME = "appTheme"
    const val REVIEW_VOTE = "reviewVote"

    //App languages
    const val APP_LANG_EN = "en"
    const val APP_LANG_UK = "uk"
    const val APP_LANG_RU = "ru"

    //Data base
    const val USERS = "users"
    const val CHATS = "chats"
    const val MESSAGES = "messages"
    const val FEEDBACK = "feedback"
    const val PRIVACY_POLICY = "privacyPolicy"

    //WebView
    const val MIME_TYPE = "text/html; charset=utf-8"
    const val ENCODING = "UTF-8"
    const val DARK_MODE_TEXT = "javascript:document.body.style.setProperty(\"color\", \"white\");"
    const val WHITE_MODE_TEXT = "javascript:document.body.style.setProperty(\"color\", \"black\");"

    //Message Actions
    const val MESSAGE_ACTION_CANCEL = "Cancel"
    const val MESSAGE_ACTION_COPY = "Copy"
    const val MESSAGE_ACTION_DELETE = "Delete"
    const val MESSAGE_ACTION_TRANSFER = "Transfer"
    const val MESSAGE_ACTION_SHARE = "Share"
}