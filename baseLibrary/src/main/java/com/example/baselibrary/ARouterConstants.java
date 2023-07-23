package com.example.baselibrary;

/**
 * 只要path路径不变，任你包名或者类名变化，都可以成功的跳转到对应的页面。
 */
public class ARouterConstants {
    // 这里的路径需要注意的是至少需要有两级，/xx/xx
    public static final String ACTIVITY_URL_MAIN = "/app/MainActivity";
    public static final String ACTIVITY_URL_SETTING = "/app/SettingActivity";
    public static final String ACTIVITY_URL_PERSONAL_INFO = "/app/PersonalInfoActivity";
    public static final String ACTIVITY_URL_MODIFY_INFO = "/app/ModifyInfoActivity";
    public static final String ACTIVITY_URL_FEEDBACK = "/app/FeedbackActivity";
    public static final String ACTIVITY_URL_LOAD_ERROR = "/app/LoadErrorActivity";
    public static final String ACTIVITY_URL_TEST = "/app/TestActivity";

    public static final String ACTIVITY_URL_LOGIN = "/login/LoginActivity";
    public static final String ACTIVITY_URL_PASSWORD_LOGIN_FRAGMENT = "/login/PasswordLoginFragment";
    public static final String ACTIVITY_URL_PHONE_NUMBER_LOGIN_FRAGMENT = "/login/PhoneNumberLoginFragment";

    public static final String ACTIVITY_URL_REGISTER = "/register/RegisterActivity";
    public static final String ACTIVITY_URL_EMAIL_REGISTER_FRAGMENT = "/register/EmailRegisterFragment";
    public static final String ACTIVITY_URL_PHONE_NUMBER_REGISTER_FRAGMENT = "/register/PhoneNumberRegisterFragment";
}
