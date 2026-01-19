package resources

import domain.Constants.APP_LANG_RU
import domain.Constants.APP_LANG_UK

sealed class StringResources(
    var APP_NAME: String,
    var APP_ID: String,

    // App
    var APP_EXIT: String,
    var APP_NETWORK_UNAVAILABLE_REPEAT: String,
    var UNKNOWN_ERROR: String,

    // Buttons
    var BUTTON_NEXT: String,
    var BUTTON_ACCEPT: String,
    var BUTTON_CANCEL: String,
    var BUTTON_OK: String,
    var BUTTON_CLOSE: String,

    // Onboarding
    var ONBOARDING_INTRO: String,
    var ONBOARDING_FILTER_CONDITIONS: String,
    var ONBOARDING_INFO: String,
    var ONBOARDING_PERMISSIONS: String,

    // Authorization
    var AUTHORIZATION_ENTRANCE: String,
    var AUTHORIZATION_WITH_GOOGLE_ACCOUNT: String,
    var AUTHORIZATION_ENTER: String,
    var AUTHORIZATION_LOGIN_WITH_GOOGLE_DESCRIPTION: String,
    var AUTHORIZATION_OR: String,
    var AUTHORIZATION_OR_WITH_EMAIL_PASSWORD_DESCRIPTION: String,
    var AUTHORIZATION_OR_WITHOUT_ACCOUNT_DESCRIPTION: String,
    var AUTHORIZATION_EMAIL: String,
    var AUTHORIZATION_PASSWORD: String,
    var AUTHORIZATION_SIGN_UP: String,
    var AUTHORIZATION_SIGN_UP_WITH_GOOGLE_DESCRIPTION: String,
    var AUTHORIZATION_FORGOT_PASSWORD: String,
    var AUTHORIZATION_CONTINUE_WITHOUT_ACCOUNT: String,
    var AUTHORIZATION_FORGOT_PASSWORD_TITLE: String,
    var AUTHORIZATION_ENTER_EMAIL: String,
    var AUTHORIZATION_PASSWORD_RESET_SUCCESS: String,
    var AUTHORIZATION_SIGN_UP_TITLE: String,
    var AUTHORIZATION_ENTRANCE_TITLE: String,
    var AUTHORIZATION_SIGNING_UP: String,
    var AUTHORIZATION_ACCOUNT_NOT_EXIST: String,
    var AUTHORIZATION_ACCOUNT_EXIST: String,
    var AUTHORIZATION_UNAUTHORIZED_ENTER: String,
    var AUTHORIZATION_UNAUTHORIZED_ENTER_BUTTON: String,
    var AUTHORIZATION_NETWORK_UNAVAILABLE: String,

    // Empty state
    var EMPTY_STATE_BLOCKERS: String,

    // Settings screens
    var SETTINGS: String,
    var SETTINGS_CHAT: String,
    var SETTINGS_ACCOUNT: String,
    var SETTINGS_LANGUAGE: String,
    var SETTINGS_THEME: String,
    var SETTINGS_FEEDBACK: String,
    var SETTINGS_PRIVACY_POLICY: String,
    // Settings chat

    // Settings account
    var SETTINGS_ACCOUNT_LOG_OUT_TITLE: String,
    var SETTINGS_ACCOUNT_UNAUTHORISED_LOG_OUT_TITLE: String,
    var SETTINGS_ACCOUNT_UNAUTHORISED: String,
    var SETTINGS_ACCOUNT_CHANGE_PASSWORD_TITLE: String,
    var SETTINGS_ACCOUNT_DELETE_TITLE: String,
    var SETTINGS_ACCOUNT_ENTER_CURRENT_PASSWORD: String,
    var SETTINGS_ACCOUNT_ENTER_NEW_PASSWORD: String,
    var SETTINGS_ACCOUNT_CHANGE_PASSWORD_SUCCEED: String,
    var SETTINGS_ACCOUNT_LOG_OUT: String,
    var SETTINGS_ACCOUNT_UNAUTHORISED_LOG_OUT: String,
    var SETTINGS_ACCOUNT_EMAIL_DELETE: String,
    var SETTINGS_ACCOUNT_GOOGLE_DELETE: String,
    var SETTINGS_ACCOUNT_TRANSFER_DATA_TITLE: String,
    var SETTINGS_ACCOUNT_TRANSFER_DATA_TURN_ON: String,
    var SETTINGS_ACCOUNT_TRANSFER_DATA_TURN_OFF: String,
    var SETTINGS_ACCOUNT_EXIST: String,
    var EMPTY_STATE_ACCOUNT: String,

    // Settings language
    var SETTINGS_LANGUAGE_RUSSIAN: String,
    var SETTINGS_LANGUAGE_UKRAINIAN: String,
    var SETTINGS_LANGUAGE_ENGLISH: String,

    // Settings theme
    var SETTINGS_THEME_DAY: String,
    var SETTINGS_THEME_NIGHT: String,
    var SETTINGS_THEME_AUTO: String,

    // Settings feedback
    var SETTINGS_FEEDBACK_TITLE: String,
    var SETTINGS_FEEDBACK_HINT: String,
    var SETTINGS_FEEDBACK_SEND_BUTTON: String,
    var SETTINGS_FEEDBACK_SEND_SUCCESS: String,

    // Settings privacy
    var PRIVACY_POLICY: String,

    // Menu item
    var MENU_INFO: String,
    var MENU_DELETE: String,
    var MENU_SEARCH: String,
    var ERROR_MESSAGE: String,

    // Chats
    var CHAT_CREATE_TITLE: String,
    var CHAT_RENAME_TITLE: String,
    var CHAT_DELETE_TITLE: String,
    var CHAT_NAME: String,
    var CHAT_EMPTY_STATE: String,
    var NEW_CHAT: String,
    var CHAT_CREATE_BUTTON: String,
    var CHAT_EDIT_BUTTON: String,

    //Messages
    var MESSAGE_ACTION_SELECTED: String,
    var MESSAGE_ACTION_SEND: String,
    var MESSAGE_ACTION_COPY: String,
    var MESSAGE_ACTION_SHARE: String,
    var MESSAGE_ACTION_TRANSFER: String,
    var MESSAGE_ACTION_DELETE: String,
    var MESSAGE_TRANSFER_CONFIRMATION: String,
    var MESSAGE_DELETE_CONFIRMATION: String,
    var MESSAGE_EMPTY_STATE: String,

    var MESSAGE_DELETE_BUTTON: String,
    var MESSAGE_SHARE_BUTTON: String,
    var MESSAGE_COPY_BUTTON: String,
    var MESSAGE_SEND_BUTTON: String,
    var MESSAGE_ENTER_REQUEST: String,
    var MESSAGE_MORE: String,
    var MESSAGE_HIDE: String,

    var AI_AVATAR: String,
    var ACCOUNT_AVATAR: String,
    val NAVIGATION_ICON: String,
    var ONBOARDING_ICON: String,
    var ONBOARDING_SCREEN: String,
)

class StringResourcesEN : StringResources(
    APP_NAME = "Talk to AI",
    APP_ID = "ca-app-pub-8778007212154570~5099361664",

    // App
    APP_EXIT = "Do you want to exit the app?",
    APP_NETWORK_UNAVAILABLE_REPEAT =
        "No internet connection.\nTo continue, connect to the internet and try again.",

    // Buttons
    BUTTON_NEXT = "Next",
    BUTTON_ACCEPT = "Allow",
    BUTTON_CANCEL = "Cancel",
    BUTTON_OK = "OK",
    BUTTON_CLOSE = "Close",

    // Onboarding
    ONBOARDING_INTRO =
        "Hello! I am Smart Blocker. I will be your assistant in blocking unwanted calls and my smart filters will help me with this.",
    ONBOARDING_FILTER_CONDITIONS =
        "Smart filters will analyze incoming calls based on criteria you specify and block or permit them.",
    ONBOARDING_INFO =
        "I'm always available to help you understand how I work. To do this, find the icon <img src =\'ic_info\'> and follow it to the screen with the instruction.",
    ONBOARDING_PERMISSIONS =
        "The phone will ask for the necessary permissions to work properly. To do this, select “Allow” in the system windows.",

    // Authorization
    AUTHORIZATION_ENTRANCE = "Entrance",
    AUTHORIZATION_WITH_GOOGLE_ACCOUNT = "With Google",
    AUTHORIZATION_ENTER = "Login",
    AUTHORIZATION_LOGIN_WITH_GOOGLE_DESCRIPTION = "Login with Google",
    AUTHORIZATION_OR = "Or",
    AUTHORIZATION_OR_WITH_EMAIL_PASSWORD_DESCRIPTION =
        "Or login with Email and password",
    AUTHORIZATION_OR_WITHOUT_ACCOUNT_DESCRIPTION = "Or login without authorisation",
    AUTHORIZATION_EMAIL = "Email",
    AUTHORIZATION_PASSWORD = "Password",
    AUTHORIZATION_SIGN_UP = "Sign up",
    AUTHORIZATION_SIGN_UP_WITH_GOOGLE_DESCRIPTION = "Sign up with Google",
    AUTHORIZATION_FORGOT_PASSWORD = "Forgot password?",
    AUTHORIZATION_CONTINUE_WITHOUT_ACCOUNT = "Without authorisation",
    AUTHORIZATION_FORGOT_PASSWORD_TITLE =
        "Enter your email, and we will send you instructions.",
    AUTHORIZATION_ENTER_EMAIL = "Enter your Email",
    AUTHORIZATION_PASSWORD_RESET_SUCCESS =
        "An email has been sent to your Email. Check in your inbox.",
    AUTHORIZATION_SIGN_UP_TITLE = "Haven`t got an account?&#160;",
    AUTHORIZATION_ENTRANCE_TITLE = "Got an account?&#160;",
    AUTHORIZATION_SIGNING_UP = "Sign Up",
    AUTHORIZATION_ACCOUNT_NOT_EXIST =
        "There is no user with this email address. First you need to create an account. Go to the registration screen?",
    AUTHORIZATION_ACCOUNT_EXIST =
        "A user with this email already exists. You need to log in. Go to the login screen?",
    AUTHORIZATION_UNAUTHORIZED_ENTER =
        "An unauthorized user has data stored locally within a single session. Enter anyway?",
    AUTHORIZATION_UNAUTHORIZED_ENTER_BUTTON = "Enter",
    AUTHORIZATION_NETWORK_UNAVAILABLE =
        "No internet connection.\nTo continue, connect to the internet and log in again.",

    // Empty state
    EMPTY_STATE_BLOCKERS = "Blocker list is empty",

    // Settings screens
    SETTINGS = "Settings",
    SETTINGS_CHAT = "Chat settings",
    SETTINGS_ACCOUNT = "Your account",
    SETTINGS_LANGUAGE = "Language",
    SETTINGS_THEME = "Selecting a theme",
    SETTINGS_FEEDBACK = "Contact developer",
    SETTINGS_PRIVACY_POLICY = "Privacy Policy",
    // Settings chat

    // Settings account
    SETTINGS_ACCOUNT_LOG_OUT_TITLE = "Logout",
    SETTINGS_ACCOUNT_UNAUTHORISED_LOG_OUT_TITLE = "Leave",
    SETTINGS_ACCOUNT_UNAUTHORISED = "Unauthorised",
    SETTINGS_ACCOUNT_CHANGE_PASSWORD_TITLE = "Change password",
    SETTINGS_ACCOUNT_DELETE_TITLE = "Delete account",
    SETTINGS_ACCOUNT_ENTER_CURRENT_PASSWORD = "Current password",
    SETTINGS_ACCOUNT_ENTER_NEW_PASSWORD = "New password",
    SETTINGS_ACCOUNT_CHANGE_PASSWORD_SUCCEED = "Password changed successfully",
    SETTINGS_ACCOUNT_LOG_OUT = "Are you sure you want to log out?",
    SETTINGS_ACCOUNT_UNAUTHORISED_LOG_OUT =
        "If you log out of an unauthorized account, you will lose all created data. Sign up to save. Still leave?",
    SETTINGS_ACCOUNT_EMAIL_DELETE =
        "The account and all created data will be permanently deleted. Enter your current password to continue.",
    SETTINGS_ACCOUNT_GOOGLE_DELETE =
        "The account and all created data will be permanently deleted. Google may ask you to confirm your authorization to continue.",
    SETTINGS_ACCOUNT_TRANSFER_DATA_TITLE = "Transfer data?",
    SETTINGS_ACCOUNT_TRANSFER_DATA_TURN_ON =
        "The created data will be transferred to your account.",
    SETTINGS_ACCOUNT_TRANSFER_DATA_TURN_OFF = "The created data will be deleted.",
    SETTINGS_ACCOUNT_EXIST =
        "A user with this email already exists. You can go to this account. If the choice of data transfer is enabled, they will be transferred to the account, if it is disabled, they will be permanently deleted. Go?",
    EMPTY_STATE_ACCOUNT =
        "Your data is stored locally within a single session and will be lost if you log out of this account, clear the cache, or reinstall the application. To connect remote data storage and access it from any device, register.",

    // Settings language
    SETTINGS_LANGUAGE_RUSSIAN = "Russian",
    SETTINGS_LANGUAGE_UKRAINIAN = "Ukrainian",
    SETTINGS_LANGUAGE_ENGLISH = "English",

    // Settings theme
    SETTINGS_THEME_DAY = "Light",
    SETTINGS_THEME_NIGHT = "Dark",
    SETTINGS_THEME_AUTO = "According to phone settings",

    // Settings feedback
    SETTINGS_FEEDBACK_TITLE =
        "If you have any suggestions or comments, please describe them below",
    SETTINGS_FEEDBACK_HINT = "Message",
    SETTINGS_FEEDBACK_SEND_BUTTON = "Submit",
    SETTINGS_FEEDBACK_SEND_SUCCESS = "Message sent successfully!",

    // Settings privacy
    PRIVACY_POLICY =
        "<![CDATA[<html><head><meta charset=\\'utf–8\\'><meta name=\\'viewport\\' content=\\'width=device–width\\'><title>Privacy Policy</title><style>body {font–family: \\'Helvetica Neue\\', Helvetica, Arial, sans–serif;padding: 1em;}</style></head><body><strong>Privacy Policy</strong><p> Tarasov Volodymyr built the SmartBlocker app as a Commercial app. This SERVICE is provided by Tarasov Volodymyr and is intended for use as is. </p><p> This page is used to inform visitors regarding my policies with the collection, use, and disclosure of Personal Information if anyone decided to use my Service. </p><p> If you choose to use my Service, then you agree to the collection and use of information in relation to this policy. The Personal Information that I collect is used for providing and improving the Service. I will not use or share your information with anyone except as described in this Privacy Policy. </p><p> The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which are accessible at SmartBlocker unless otherwise defined in this Privacy Policy. </p><p><strong>Information Collection and Use</strong></p><p> For a better experience, while using our Service, I may require you to provide us with certain personally identifiable information. The information that I request will be retained on your device and is not collected by me in any way. </p><div><p> The app does use third–party services that may collect information used to identify you. </p><p> Link to the privacy policy of third–party service providers used by the app </p><ul><li><a href=\"https://www.google.com/policies/privacy/\" target=\"_blank\" rel=\"noopener noreferrer\">Google Play Services</a></li><li><a href=\"AdMob policies and restrictions – Google AdMob Help target=\" _blank\" rel=\"noopener noreferrer\">AdMob</a></li><li><a href=\"https://firebase.google.com/policies/analytics\" target=\"_blank\" rel=\"noopener noreferrer\">Google Analytics for Firebase</a> </li><li><a href=\"Firebase Support target=\" _blank\" rel=\"noopener noreferrer\">Firebase Crashlytics</a></li></ul></div><p><strong>Log Data</strong></p><p> I want to inform you that whenever you use my Service, in a case of an error in the app I collect data and information (through third–party products) on your phone called Log Data. This Log Data may include information such as your device Internet Protocol (“IP”) address, device name, operating system version, the configuration of the app when utilizing my Service, the time and date of your use of the Service, and other statistics. </p><p><strong>Cookies</strong></p><p> Cookies are files with a small amount of data that are commonly used as anonymous unique identifiers. These are sent to your browser from the websites that you visit and are stored on your device\\'s internal memory. </p><p> This Service does not use these “cookies” explicitly. However, the app may use third\\–party code and libraries that use “cookies” to collect information and improve their services. You have the option to either accept or refuse these cookies and know when a cookie is being sent to your device. If you choose to refuse our cookies, you may not be able to use some portions of this Service. </p><p><strong>Service Providers</strong></p><p> I may employ third\\–party companies and individuals due to the following reasons: </p><ul><li>To facilitate our Service;</li><li>To provide the Service on our behalf;</li><li>To perform Service–related services; or</li><li>To assist us in analyzing how our Service is used.</li></ul><p> I want to inform users of this Service that these third parties have access to their Personal Information. The reason is to perform the tasks assigned to them on our behalf. However, they are obligated not to disclose or use the information for any other purpose. </p><p><strong>Security</strong></p><p> I value your trust in providing us your Personal Information, thus we are striving to use commercially acceptable means of protecting it. But remember that no method of transmission over the internet, or method of electronic storage is 100% secure and reliable, and I cannot guarantee its absolute security. </p><p><strong>Links to Other Sites</strong></p><p> This Service may contain links to other sites. If you click on a third–party link, you will be directed to that site. Note that these external sites are not operated by me. Therefore, I strongly advise you to review the Privacy Policy of these websites. I have no control over and assume no responsibility for the content, privacy policies, or practices of any third–party sites or services. </p><p><strong>Children\\’s Privacy</strong></p><div><p> These Services do not address anyone under the age of 13. I do not knowingly collect personally identifiable information from children under 13 years of age. In the case I discover that a child under 13 has provided me with personal information, I immediately delete this from our servers. If you are a parent or guardian and you are aware that your child has provided us with personal information, please contact me so that I will be able to do the necessary actions. </p></div><p><strong>Changes to This Privacy Policy</strong></p><p> I may update our Privacy Policy from time to time. Thus, you are advised to review this page periodically for any changes. I will notify you of any changes by posting the new Privacy Policy on this page. </p><p>This policy is effective as of 2023–01–04</p><p><strong>Contact Us</strong></p><p> If you have any questions or suggestions about my Privacy Policy, do not hesitate to contact me at blockersmart2022@gmail.com. </p></body></html>]]>",

    // Menu item
    MENU_INFO = "Info",
    MENU_DELETE = "Delete",
    MENU_SEARCH = "Search",
    ERROR_MESSAGE = "An error occurred",

    // Chats
    CHAT_CREATE_TITLE = "Create chat",
    CHAT_RENAME_TITLE = "Rename chat",
    CHAT_DELETE_TITLE = "Delete chat",
    CHAT_NAME = "Chat name",
    CHAT_EMPTY_STATE = "Chat list is empty",
    NEW_CHAT = "New chat",
    CHAT_CREATE_BUTTON = "Create",
    CHAT_EDIT_BUTTON = "Edit",

    //Messages
    MESSAGE_ACTION_SELECTED = "Selected",
    MESSAGE_ACTION_SEND = "Send",
    MESSAGE_ACTION_COPY = "Copy",
    MESSAGE_ACTION_SHARE = "Share",
    MESSAGE_ACTION_TRANSFER = "Transfer",
    MESSAGE_ACTION_DELETE = "Delete",
    MESSAGE_TRANSFER_CONFIRMATION = "Are you sure you want to transfer the message?",
    MESSAGE_DELETE_CONFIRMATION = "Are you sure you want to delete the message?",
    MESSAGE_EMPTY_STATE = "Message list is empty",

    MESSAGE_DELETE_BUTTON = "Delete",
    MESSAGE_SHARE_BUTTON = "Share",
    MESSAGE_COPY_BUTTON = "Copy",
    MESSAGE_SEND_BUTTON = "Send",
    MESSAGE_ENTER_REQUEST = "Enter your message",
    MESSAGE_MORE = "More",
    MESSAGE_HIDE = "Hide",

    AI_AVATAR = "AI avatar",
    ACCOUNT_AVATAR = "Account",
    NAVIGATION_ICON = "Navigation screen",
    ONBOARDING_ICON = "Onboarding icon",
    ONBOARDING_SCREEN = "Onboarding",
    UNKNOWN_ERROR = "Unknown error"
)

class StringResourcesRU : StringResources(
    APP_NAME = "Talk to AI",
    APP_ID = "ca-app-pub-8778007212154570~5099361664",

    // App
    APP_EXIT = "Вы хотите выйти из приложения?",
    APP_NETWORK_UNAVAILABLE_REPEAT =
        "Интернет соединение отсутствует.\nДля продолжения, подключите интернет и повторите действие.",

    // Buttons
    BUTTON_NEXT = "Дальше",
    BUTTON_ACCEPT = "Разрешить",
    BUTTON_CANCEL = "Отмена",
    BUTTON_OK = "OK",
    BUTTON_CLOSE = "Закрыть",

    // Onboarding
    ONBOARDING_INTRO =
        "Привет! Я - Smart Blocker. Я буду Вашим помощником в блокировании нежелательных звонков и в этом мне помогут мои умные фильтры.",
    ONBOARDING_FILTER_CONDITIONS =
        "Умные фильтры будут анализировать входящие вызовы по заданным Вами признакам и блокировать или разрешать их.",
    ONBOARDING_INFO =
        "Я всегда готов помочь разобраться в том, как я работаю. Для этого найдите иконку <img src ='ic_info'> и по ней перейдите на экран с инструкцией.",
    ONBOARDING_PERMISSIONS =
        "Для корректной работы телефон запросит необходимые разрешения. Для этого выберите “Разрешить” в системных окнах.",

    // Authorization
    AUTHORIZATION_ENTRANCE = "Вход",
    AUTHORIZATION_WITH_GOOGLE_ACCOUNT = "С помощью Google",
    AUTHORIZATION_ENTER = "Войти",
    AUTHORIZATION_LOGIN_WITH_GOOGLE_DESCRIPTION = "Войти с помощью Google",
    AUTHORIZATION_OR = "Или",
    AUTHORIZATION_OR_WITH_EMAIL_PASSWORD_DESCRIPTION = "Или с Email и паролем",
    AUTHORIZATION_OR_WITHOUT_ACCOUNT_DESCRIPTION = "Или войти без авторизации",
    AUTHORIZATION_EMAIL = "Email",
    AUTHORIZATION_PASSWORD = "Пароль",
    AUTHORIZATION_SIGN_UP = "Регистрация",
    AUTHORIZATION_SIGN_UP_WITH_GOOGLE_DESCRIPTION = "Регистрация с помощью Google",
    AUTHORIZATION_FORGOT_PASSWORD = "Забыли пароль?",
    AUTHORIZATION_CONTINUE_WITHOUT_ACCOUNT = "Без авторизации",
    AUTHORIZATION_FORGOT_PASSWORD_TITLE =
        "Введите ваш Email и мы отправим Вам инструкции.",
    AUTHORIZATION_ENTER_EMAIL = "Введите ваш Email",
    AUTHORIZATION_PASSWORD_RESET_SUCCESS =
        "Письмо отправлено на ваш Email. Проверьте во входящих.",
    AUTHORIZATION_SIGN_UP_TITLE = "Еще нет аккаунта?&#160;",
    AUTHORIZATION_ENTRANCE_TITLE = "Есть аккаунт?&#160;",
    AUTHORIZATION_SIGNING_UP = "Зарегистрироваться",
    AUTHORIZATION_ACCOUNT_NOT_EXIST =
        "Пользователя с таким Email не существует. Сначала необходимо создать аккаунт. Перейти на экран регистрации?",
    AUTHORIZATION_ACCOUNT_EXIST =
        "Пользователь с таким Email уже существует. Необходимо авторизоваться. Перейти на экран логина?",
    AUTHORIZATION_UNAUTHORIZED_ENTER =
        "У неавторизованного пользователя данные хранятся локально в рамках одной сессии. Все равно войти?",
    AUTHORIZATION_UNAUTHORIZED_ENTER_BUTTON = "Войти",
    AUTHORIZATION_NETWORK_UNAVAILABLE =
        "Интернет соединение отсутствует.\nДля продолжения, подключите интернет и совершите повторный вход.",

    // Empty state
    EMPTY_STATE_BLOCKERS = "Список блокировщиков пуст",

    // Settings screens
    SETTINGS = "Настройки",
    SETTINGS_CHAT = "Настройки чата",
    SETTINGS_ACCOUNT = "Ваш аккаунт",
    SETTINGS_LANGUAGE = "Язык",
    SETTINGS_THEME = "Выбор темы",
    SETTINGS_FEEDBACK = "Написать разработчику",
    SETTINGS_PRIVACY_POLICY = "Политика конфиденциальности",
    // Settings chat

    // Settings account
    SETTINGS_ACCOUNT_LOG_OUT_TITLE = "Выйти",
    SETTINGS_ACCOUNT_UNAUTHORISED_LOG_OUT_TITLE = "Выйти",
    SETTINGS_ACCOUNT_UNAUTHORISED = "Неавторизованный",
    SETTINGS_ACCOUNT_CHANGE_PASSWORD_TITLE = "Сменить пароль",
    SETTINGS_ACCOUNT_DELETE_TITLE = "Удалить аккаунт",
    SETTINGS_ACCOUNT_ENTER_CURRENT_PASSWORD = "Текущий пароль",
    SETTINGS_ACCOUNT_ENTER_NEW_PASSWORD = "Новый пароль",
    SETTINGS_ACCOUNT_CHANGE_PASSWORD_SUCCEED = "Пароль успешно изменен",
    SETTINGS_ACCOUNT_LOG_OUT = "Вы действительно хотите разлогиниться?",
    SETTINGS_ACCOUNT_UNAUTHORISED_LOG_OUT =
        "При выходе из неавторизованого аккаунта вы потеряете все созданные данные. Для сохранения зарегистрируйтесь. Все равно выйти?",
    SETTINGS_ACCOUNT_EMAIL_DELETE =
        "Аккаунт и все созданные данные будут удалены безвозвратно. Для продолжения введите текущий пароль.",
    SETTINGS_ACCOUNT_GOOGLE_DELETE =
        "Аккаунт и все созданные данные будут удалены безвозвратно. Для продолжения Google может запросить подтверждение авторизации.",
    SETTINGS_ACCOUNT_TRANSFER_DATA_TITLE = "Перенести данные?",
    SETTINGS_ACCOUNT_TRANSFER_DATA_TURN_ON =
        "Cозданные данные будут перенесены в ваш аккаунт.",
    SETTINGS_ACCOUNT_TRANSFER_DATA_TURN_OFF = "Cозданные данные будут удалены.",
    SETTINGS_ACCOUNT_EXIST =
        "Пользователь с таким Email уже существует. Вы можете перейти в этот аккаунт. При включенном выборе переноса данных - они будут перенесены в аккаунт, при выключенном - удалены безвозвартно. Перейти?",
    EMPTY_STATE_ACCOUNT =
        "Ваши данные хранятся локально в рамках одной сессии и будут потеряны при выходе из этого аккаунта, очистке кеша или переустановке приложения. Для подключения удаленного хранения данных и доступа к нему с любого устройства, зарегистрируйтесь.",

    // Settings language
    SETTINGS_LANGUAGE_RUSSIAN = "Русский",
    SETTINGS_LANGUAGE_UKRAINIAN = "Украинский",
    SETTINGS_LANGUAGE_ENGLISH = "Английский",

    // Settings theme
    SETTINGS_THEME_DAY = "Светлая",
    SETTINGS_THEME_NIGHT = "Темная",
    SETTINGS_THEME_AUTO = "Согласно настройек телефона",

    // Settings feedback
    SETTINGS_FEEDBACK_TITLE =
        "Если у вас есть предложения или замечания вы можете их описать ниже",
    SETTINGS_FEEDBACK_HINT = "Сообщение",
    SETTINGS_FEEDBACK_SEND_BUTTON = "Отправить",
    SETTINGS_FEEDBACK_SEND_SUCCESS = "Сообщение успешно отправлено!",

    // Settings privacy
    PRIVACY_POLICY =
        "<![CDATA[<html><head><meta charset=\\'utf–8\\'><meta name=\\'viewport\\' content=\\'width=device–width\\'><title>Privacy Policy</title><style>body {font–family: \\'Helvetica Neue\\', Helvetica, Arial, sans–serif;padding: 1em;}</style></head><body><strong>Privacy Policy</strong><p> Tarasov Volodymyr built the SmartBlocker app as a Commercial app. This SERVICE is provided by Tarasov Volodymyr and is intended for use as is. </p><p> This page is used to inform visitors regarding my policies with the collection, use, and disclosure of Personal Information if anyone decided to use my Service. </p><p> If you choose to use my Service, then you agree to the collection and use of information in relation to this policy. The Personal Information that I collect is used for providing and improving the Service. I will not use or share your information with anyone except as described in this Privacy Policy. </p><p> The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which are accessible at SmartBlocker unless otherwise defined in this Privacy Policy. </p><p><strong>Information Collection and Use</strong></p><p> For a better experience, while using our Service, I may require you to provide us with certain personally identifiable information. The information that I request will be retained on your device and is not collected by me in any way. </p><div><p> The app does use third–party services that may collect information used to identify you. </p><p> Link to the privacy policy of third–party service providers used by the app </p><ul><li><a href=\"https://www.google.com/policies/privacy/\" target=\"_blank\" rel=\"noopener noreferrer\">Google Play Services</a></li><li><a href=\"AdMob policies and restrictions – Google AdMob Help target=\" _blank\" rel=\"noopener noreferrer\">AdMob</a></li><li><a href=\"https://firebase.google.com/policies/analytics\" target=\"_blank\" rel=\"noopener noreferrer\">Google Analytics for Firebase</a> </li><li><a href=\"Firebase Support target=\" _blank\" rel=\"noopener noreferrer\">Firebase Crashlytics</a></li></ul></div><p><strong>Log Data</strong></p><p> I want to inform you that whenever you use my Service, in a case of an error in the app I collect data and information (through third–party products) on your phone called Log Data. This Log Data may include information such as your device Internet Protocol (“IP”) address, device name, operating system version, the configuration of the app when utilizing my Service, the time and date of your use of the Service, and other statistics. </p><p><strong>Cookies</strong></p><p> Cookies are files with a small amount of data that are commonly used as anonymous unique identifiers. These are sent to your browser from the websites that you visit and are stored on your device\\'s internal memory. </p><p> This Service does not use these “cookies” explicitly. However, the app may use third\\–party code and libraries that use “cookies” to collect information and improve their services. You have the option to either accept or refuse these cookies and know when a cookie is being sent to your device. If you choose to refuse our cookies, you may not be able to use some portions of this Service. </p><p><strong>Service Providers</strong></p><p> I may employ third\\–party companies and individuals due to the following reasons: </p><ul><li>To facilitate our Service;</li><li>To provide the Service on our behalf;</li><li>To perform Service–related services; or</li><li>To assist us in analyzing how our Service is used.</li></ul><p> I want to inform users of this Service that these third parties have access to their Personal Information. The reason is to perform the tasks assigned to them on our behalf. However, they are obligated not to disclose or use the information for any other purpose. </p><p><strong>Security</strong></p><p> I value your trust in providing us your Personal Information, thus we are striving to use commercially acceptable means of protecting it. But remember that no method of transmission over the internet, or method of electronic storage is 100% secure and reliable, and I cannot guarantee its absolute security. </p><p><strong>Links to Other Sites</strong></p><p> This Service may contain links to other sites. If you click on a third–party link, you will be directed to that site. Note that these external sites are not operated by me. Therefore, I strongly advise you to review the Privacy Policy of these websites. I have no control over and assume no responsibility for the content, privacy policies, or practices of any third–party sites or services. </p><p><strong>Children\\’s Privacy</strong></p><div><p> These Services do not address anyone under the age of 13. I do not knowingly collect personally identifiable information from children under 13 years of age. In the case I discover that a child under 13 has provided me with personal information, I immediately delete this from our servers. If you are a parent or guardian and you are aware that your child has provided us with personal information, please contact me so that I will be able to do the necessary actions. </p></div><p><strong>Changes to This Privacy Policy</strong></p><p> I may update our Privacy Policy from time to time. Thus, you are advised to review this page periodically for any changes. I will notify you of any changes by posting the new Privacy Policy on this page. </p><p>This policy is effective as of 2023–01–04</p><p><strong>Contact Us</strong></p><p> If you have any questions or suggestions about my Privacy Policy, do not hesitate to contact me at blockersmart2022@gmail.com. </p></body></html>]]>",

    // Menu item
    MENU_INFO = "Инфо",
    MENU_DELETE = "Удалить",
    MENU_SEARCH = "Поиск",
    ERROR_MESSAGE = "Произошла ошибка",

    // Chats
    CHAT_CREATE_TITLE = "Создать новый чат?",
    CHAT_NAME = "Название чата",
    CHAT_RENAME_TITLE = "Изменить название чата?",
    CHAT_DELETE_TITLE = "Удалить чат?",
    CHAT_EMPTY_STATE = "Список чатов пуст",
    NEW_CHAT = "Новый чат",
    CHAT_CREATE_BUTTON = "Кнопка создания чата",
    CHAT_EDIT_BUTTON = "Кнопка редактирования чата",

    // Messages
    MESSAGE_ACTION_SELECTED = "Выбрано",
    MESSAGE_ACTION_SEND = "Отправлено",
    MESSAGE_ACTION_COPY = "Скопировано",
    MESSAGE_ACTION_TRANSFER = "Перенесено",
    MESSAGE_ACTION_DELETE = "Удалено",
    MESSAGE_ACTION_SHARE = "Отправить",
    MESSAGE_TRANSFER_CONFIRMATION = "Вы хотите перенести?",
    MESSAGE_DELETE_CONFIRMATION = "Вы хотите удалить?",
    MESSAGE_EMPTY_STATE = "Введите свой вопрос",
    MESSAGE_DELETE_BUTTON = "Кнопка удаления сообщения",
    MESSAGE_SHARE_BUTTON = "Кнопка перемещения сообщения",
    MESSAGE_COPY_BUTTON = "Кнопка копирования сообщения",
    MESSAGE_SEND_BUTTON = "Кнопка отправки сообщения",
    MESSAGE_ENTER_REQUEST = "Введите запрос",
    MESSAGE_MORE = "Больше",
    MESSAGE_HIDE = "Скрыть",

    UNKNOWN_ERROR = "Неизвестная ошибка",
    AI_AVATAR = "Аватар ИИ",
    ACCOUNT_AVATAR = "Аватар аккаунта",
    NAVIGATION_ICON = "Иконка навигации",
    ONBOARDING_ICON = "Иконка онбординга",
    ONBOARDING_SCREEN = "Экран онбординга"
)

class StringResourcesUK : StringResources(
    APP_NAME = "Talk to AI",
    APP_ID = "ca-app-pub-8778007212154570~5099361664",
    // App
    APP_EXIT = "Ви хочете вийти з програми?",
    APP_NETWORK_UNAVAILABLE_REPEAT =
        "Інтернет з'єднання відсутнє.\nДля продовження, підключіть інтернет і повторіть дію.",

    // Buttons
    BUTTON_NEXT = "Далі",
    BUTTON_ACCEPT = "Дозволити",
    BUTTON_CANCEL = "Скасувати",
    BUTTON_OK = "OK",
    BUTTON_CLOSE = "Закрити",

    // Onboarding
    ONBOARDING_INTRO =
        "Привіт! Я – Smart Blocker. Я буду вашим помічником у блокуванні небажаних дзвінків і в цьому мені допоможуть мої розумні фільтри.",
    ONBOARDING_FILTER_CONDITIONS =
        "Розумні фільтри будуть аналізувати вхідні дзвінки за заданими Вами ознаками та блокувати або дозволяти їх.",
    ONBOARDING_INFO =
        "Я завжди готовий допомогти розібратися в тому, як я працюю. Для цього знайдіть іконку <img src ='ic_info'> і по ній перейдіть на екран з інструкцією.",
    ONBOARDING_PERMISSIONS =
        "Для коректної роботи телефон запросить необхідні дозволи. Для цього виберіть \"Дозволити\" у системних вікнах.",

    // Authorization
    AUTHORIZATION_ENTRANCE = "Вхід",
    AUTHORIZATION_WITH_GOOGLE_ACCOUNT = "За допомогою Google",
    AUTHORIZATION_ENTER = "Увійти",
    AUTHORIZATION_OR = "Або",
    AUTHORIZATION_LOGIN_WITH_GOOGLE_DESCRIPTION = "Або увійти за допомогою Google",
    AUTHORIZATION_OR_WITH_EMAIL_PASSWORD_DESCRIPTION = "Або з Email та паролем",
    AUTHORIZATION_OR_WITHOUT_ACCOUNT_DESCRIPTION = "Або увійти без авторизації",
    AUTHORIZATION_EMAIL = "Email",
    AUTHORIZATION_PASSWORD = "Пароль",
    AUTHORIZATION_SIGN_UP = "Реєстрація",
    AUTHORIZATION_SIGN_UP_WITH_GOOGLE_DESCRIPTION = "Реєстрація за допомогою Google",
    AUTHORIZATION_FORGOT_PASSWORD = "Забули пароль?",
    AUTHORIZATION_CONTINUE_WITHOUT_ACCOUNT = "Без авторизації",
    AUTHORIZATION_FORGOT_PASSWORD_TITLE =
        "Введіть ваш Email і ми відправимо Вам інструкції.",
    AUTHORIZATION_ENTER_EMAIL = "Введіть ваш Email",
    AUTHORIZATION_PASSWORD_RESET_SUCCESS =
        "Лист надіслано на ваш Email. Перевірте у вхідних.",
    AUTHORIZATION_SIGN_UP_TITLE = "Ще немає облікового запису?&#160;",
    AUTHORIZATION_ENTRANCE_TITLE = "Є обліковий запис?&#160;",
    AUTHORIZATION_SIGNING_UP = "Зареєструватися",
    AUTHORIZATION_ACCOUNT_NOT_EXIST =
        "Користувача з електронною поштою не існує. Спочатку необхідно створити обліковий запис. Перейти на екран реєстрації?",
    AUTHORIZATION_ACCOUNT_EXIST =
        "Користувач із таким Email вже існує. Потрібно авторизуватися. Перейти на екран логіну?",
    AUTHORIZATION_UNAUTHORIZED_ENTER =
        "У неавторизованого користувача дані зберігаються локально у межах однієї сесії. Все одно увійти?",
    AUTHORIZATION_UNAUTHORIZED_ENTER_BUTTON = "Увійти",
    AUTHORIZATION_NETWORK_UNAVAILABLE =
        "Інтернет з'єднання відсутнє.\nДля продовження, підключіть інтернет і здійсніть повторний вхід.",

    // Empty state
    EMPTY_STATE_BLOCKERS = "Список блокувальників порожній",

    // Settings screens
    SETTINGS = "Налаштування",
    SETTINGS_CHAT = "Налаштування чату",
    SETTINGS_ACCOUNT = "Ваш обліковий запис",
    SETTINGS_LANGUAGE = "Мова",
    SETTINGS_THEME = "Вибір теми",
    SETTINGS_FEEDBACK = "Написати розробнику",
    SETTINGS_PRIVACY_POLICY = "Політика конфіденційності",

    // Settings account
    SETTINGS_ACCOUNT_LOG_OUT_TITLE = "Вийти",
    SETTINGS_ACCOUNT_UNAUTHORISED_LOG_OUT_TITLE = "Вийти",
    SETTINGS_ACCOUNT_UNAUTHORISED = "Неавторизований",
    SETTINGS_ACCOUNT_CHANGE_PASSWORD_TITLE = "Змінити пароль",
    SETTINGS_ACCOUNT_DELETE_TITLE = "Видалити обліковий запис",
    SETTINGS_ACCOUNT_ENTER_CURRENT_PASSWORD = "Поточний пароль",
    SETTINGS_ACCOUNT_ENTER_NEW_PASSWORD = "Новий пароль",
    SETTINGS_ACCOUNT_CHANGE_PASSWORD_SUCCEED = "Пароль успішно змінено",
    SETTINGS_ACCOUNT_LOG_OUT = "Ви дійсно хочете розлогінитися?",
    SETTINGS_ACCOUNT_UNAUTHORISED_LOG_OUT =
        "При виході з неавторизованого облікового запису ви втратите всі створені дані. Для збереження зареєструйтеся. Все одно вийти?",
    SETTINGS_ACCOUNT_EMAIL_DELETE =
        "Обліковий запис і всі створені дані будуть видалені безповоротно. Щоб продовжити, введіть поточний пароль.",
    SETTINGS_ACCOUNT_GOOGLE_DELETE =
        "Обліковий запис і всі створені дані будуть видалені безповоротно. Щоб продовжити, Google може запросити підтвердження авторизації.",
    SETTINGS_ACCOUNT_TRANSFER_DATA_TITLE = "Перенести дані?",
    SETTINGS_ACCOUNT_TRANSFER_DATA_TURN_ON =
        "Створені дані будуть перенесені до вашого облікового запису.",
    SETTINGS_ACCOUNT_TRANSFER_DATA_TURN_OFF = "Створені дані будуть видалені.",
    SETTINGS_ACCOUNT_EXIST =
        "Користувач із таким Email вже існує. Ви можете перейти до цього облікового запису. При включеному виборі перенесення даних - вони будуть перенесені в обліковий запис, при вимкненому - видалені безоплатно. Перейти?",
    EMPTY_STATE_ACCOUNT =
        "Ваші дані зберігаються локально в рамках однієї сесії і будуть втрачені при виході з цього облікового запису, очищення кеша або перевстановленні програми. Щоб підключити віддалене зберігання даних та отримати доступ до нього з будь-якого пристрою, зареєструйтесь.",

    // Settings language
    SETTINGS_LANGUAGE_RUSSIAN = "Російська",
    SETTINGS_LANGUAGE_UKRAINIAN = "Українська",
    SETTINGS_LANGUAGE_ENGLISH = "Англійська",

    // Settings theme
    SETTINGS_THEME_DAY = "Світла",
    SETTINGS_THEME_NIGHT = "Темна",
    SETTINGS_THEME_AUTO = "Згідно з налаштуваннями телефону",

    // Settings feedback
    SETTINGS_FEEDBACK_TITLE =
        "Якщо у вас є пропозиції або зауваження, ви можете їх описати нижче",
    SETTINGS_FEEDBACK_HINT = "Повідомлення",
    SETTINGS_FEEDBACK_SEND_BUTTON = "Надіслати",
    SETTINGS_FEEDBACK_SEND_SUCCESS = "Повідомлення успішно надіслано!",

    // Settings privacy
    PRIVACY_POLICY =
        "<![CDATA[<html><head><meta charset=\\'utf–8\\'><meta name=\\'viewport\\' content=\\'width=device–width\\'><title>Privacy Policy</title><style>body {font–family: \\'Helvetica Neue\\', Helvetica, Arial, sans–serif;padding: 1em;}</style></head><body><strong>Privacy Policy</strong><p> Tarasov Volodymyr built the SmartBlocker app as a Commercial app. This SERVICE is provided by Tarasov Volodymyr and is intended for use as is. </p><p> This page is used to inform visitors regarding my policies with the collection, use, and disclosure of Personal Information if anyone decided to use my Service. </p><p> If you choose to use my Service, then you agree to the collection and use of information in relation to this policy. The Personal Information that I collect is used for providing and improving the Service. I will not use or share your information with anyone except as described in this Privacy Policy. </p><p> The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which are accessible at SmartBlocker unless otherwise defined in this Privacy Policy. </p><p><strong>Information Collection and Use</strong></p><p> For a better experience, while using our Service, I may require you to provide us with certain personally identifiable information. The information that I request will be retained on your device and is not collected by me in any way. </p><div><p> The app does use third–party services that may collect information used to identify you. </p><p> Link to the privacy policy of third–party service providers used by the app </p><ul><li><a href=\"https://www.google.com/policies/privacy/\" target=\"_blank\" rel=\"noopener noreferrer\">Google Play Services</a></li><li><a href=\"AdMob policies and restrictions – Google AdMob Help target=\" _blank\" rel=\"noopener noreferrer\">AdMob</a></li><li><a href=\"https://firebase.google.com/policies/analytics\" target=\"_blank\" rel=\"noopener noreferrer\">Google Analytics for Firebase</a> </li><li><a href=\"Firebase Support target=\" _blank\" rel=\"noopener noreferrer\">Firebase Crashlytics</a></li></ul></div><p><strong>Log Data</strong></p><p> I want to inform you that whenever you use my Service, in a case of an error in the app I collect data and information (through third–party products) on your phone called Log Data. This Log Data may include information such as your device Internet Protocol (“IP”) address, device name, operating system version, the configuration of the app when utilizing my Service, the time and date of your use of the Service, and other statistics. </p><p><strong>Cookies</strong></p><p> Cookies are files with a small amount of data that are commonly used as anonymous unique identifiers. These are sent to your browser from the websites that you visit and are stored on your device\\'s internal memory. </p><p> This Service does not use these “cookies” explicitly. However, the app may use third\\–party code and libraries that use “cookies” to collect information and improve their services. You have the option to either accept or refuse these cookies and know when a cookie is being sent to your device. If you choose to refuse our cookies, you may not be able to use some portions of this Service. </p><p><strong>Service Providers</strong></p><p> I may employ third\\–party companies and individuals due to the following reasons: </p><ul><li>To facilitate our Service;</li><li>To provide the Service on our behalf;</li><li>To perform Service–related services; or</li><li>To assist us in analyzing how our Service is used.</li></ul><p> I want to inform users of this Service that these third parties have access to their Personal Information. The reason is to perform the tasks assigned to them on our behalf. However, they are obligated not to disclose or use the information for any other purpose. </p><p><strong>Security</strong></p><p> I value your trust in providing us your Personal Information, thus we are striving to use commercially acceptable means of protecting it. But remember that no method of transmission over the internet, or method of electronic storage is 100% secure and reliable, and I cannot guarantee its absolute security. </p><p><strong>Links to Other Sites</strong></p><p> This Service may contain links to other sites. If you click on a third–party link, you will be directed to that site. Note that these external sites are not operated by me. Therefore, I strongly advise you to review the Privacy Policy of these websites. I have no control over and assume no responsibility for the content, privacy policies, or practices of any third–party sites or services. </p><p><strong>Children\\’s Privacy</strong></p><div><p> These Services do not address anyone under the age of 13. I do not knowingly collect personally identifiable information from children under 13 years of age. In the case I discover that a child under 13 has provided me with personal information, I immediately delete this from our servers. If you are a parent or guardian and you are aware that your child has provided us with personal information, please contact me so that I will be able to do the necessary actions. </p></div><p><strong>Changes to This Privacy Policy</strong></p><p> I may update our Privacy Policy from time to time. Thus, you are advised to review this page periodically for any changes. I will notify you of any changes by posting the new Privacy Policy on this page. </p><p>This policy is effective as of 2023–01–04</p><p><strong>Contact Us</strong></p><p> If you have any questions or suggestions about my Privacy Policy, do not hesitate to contact me at blockersmart2022@gmail.com. </p></body></html>]]>",

    // Menu item
    MENU_INFO = "Інфо",
    MENU_DELETE = "Видалити",
    MENU_SEARCH = "Пошук",
    ERROR_MESSAGE = "Сталася помилка",

    // Chats
    CHAT_CREATE_TITLE = "Створити новий чат?",
    CHAT_NAME = "Назва чату",
    CHAT_RENAME_TITLE = "Змінити назву чату?",
    CHAT_DELETE_TITLE = "Видалити чат?",
    CHAT_EMPTY_STATE = "Список чатів порожній",
    NEW_CHAT = "Новий чат",
    CHAT_CREATE_BUTTON = "Кнопка створення чату",
    CHAT_EDIT_BUTTON = "Кнопка редагування чату",

    // Messages
    MESSAGE_ACTION_SELECTED = "Вибрано",
    MESSAGE_ACTION_SEND = "Відправлено",
    MESSAGE_ACTION_COPY = "Скопійовано",
    MESSAGE_ACTION_TRANSFER = "Перенесено",
    MESSAGE_ACTION_DELETE = "Видалено",
    MESSAGE_ACTION_SHARE = "Відправити",
    MESSAGE_TRANSFER_CONFIRMATION = "Ви хочете перенести?",
    MESSAGE_DELETE_CONFIRMATION = "Ви хочете видалити?",
    MESSAGE_EMPTY_STATE = "Введіть своє питання",
    MESSAGE_DELETE_BUTTON = "Кнопка видалення повідомлення",
    MESSAGE_SHARE_BUTTON = "Кнопка переміщення повідомлення",
    MESSAGE_COPY_BUTTON = "Кнопка копіювання повідомлення",
    MESSAGE_SEND_BUTTON = "Кнопка відправки повідомлення",
    MESSAGE_ENTER_REQUEST = "Введіть запит",
    MESSAGE_MORE = "Більше",
    MESSAGE_HIDE = "Приховати",

    UNKNOWN_ERROR = "Невідома помилка",
    AI_AVATAR = "Аватар ШІ",
    ACCOUNT_AVATAR = "Аватар облікового запису",
    NAVIGATION_ICON = "Іконка навігації",
    ONBOARDING_ICON = "Іконка онбордингу",
    ONBOARDING_SCREEN = "Екран онбордингу"
)

fun getStringResourcesByLocale(locale: String): StringResources {
    return when (locale) {
        APP_LANG_UK -> StringResourcesUK()
        APP_LANG_RU -> StringResourcesRU()
        else -> StringResourcesEN()
    }
}