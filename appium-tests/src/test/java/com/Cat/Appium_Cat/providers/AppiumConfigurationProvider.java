package com.Cat.Appium_Cat.providers;

import java.io.File;

import com.Cat.Appium_Cat.helper.SystemPropertyReader;

import io.appium.java_client.remote.MobilePlatform;

/**
 * Collection of static methods to provide appium configuration parameters and desire capabilities read from System.getProperty 
 */
public class AppiumConfigurationProvider {

	/** default appium server host */
	private static final String DEFAULT_APPIUM_SERVER_HOST = "127.0.0.1";

	/** default appium server port */
	private static final String DEFAULT_APPIUM_SERVER_PORT = "4723";
	
	/** Auxiliary boolean to choose whether Android or iOS is the default platform */
	private static final Boolean IS_ANDROID_DEFAULT = true;

	/** default platform is android */
	private static final String DEFAULT_PLATFORM_NAME = IS_ANDROID_DEFAULT ? MobilePlatform.ANDROID : MobilePlatform.IOS;

	/** default device name */
	private static final String DEFAULT_DEVICE_NAME = IS_ANDROID_DEFAULT ? "Android Device" : "iPhone 6";
	
	/** Default implicit wait timeout of the appium driver in seconds */
	private static final Integer DEFAULT_IMPLICIT_TIMEOUT_IN_SECONDS = 60;

	/** Default explicit wait timeout of the appium driver in seconds */
	private static final Integer DEFAULT_EXPLICIT_TIMEOUT_IN_SECONDS = 50;

	/** Default device uid is empty */
	private static final String DEFAULT_DEVICE_UDID = "";
	
	/** Default absolute path of the app files. By default, is emtpy */
	private static final String DEFAULT_ABSOLUTE_PATH = "../app/build/outputs/apk/app-debug.apk";
	
	/** Hard-coded default Android package of the app (Android ONLY) */
	public static final String APP_PACKAGE = "com.example.stephentaylor.basicapp";

	/** Hard-coded Android launching activity of the app (Android ONLY)*/
	private static final String APP_ACTIVITY = "com.example.stephentaylor.daftcatapp_espresso.MainActivity";

	/** A failed test will be repeated {@code DEFAULT_MAXIMUM_NUMBER_OF_TIMES_REPEAT_FAILED_TEST} number of times before marking it as failed */
	private static final Integer DEFAULT_MAXIMUM_NUMBER_OF_TIMES_REPEAT_FAILED_TEST = 0;
	
	/**
	 * @return Port of appium server read from {@code appium_server_port} system property; default value is {@link AppiumConfigurationProvider#DEFAULT_APPIUM_SERVER_PORT}
	 */
	private static String port() {
		return SystemPropertyReader.readStringProperty("appium_server_port", DEFAULT_APPIUM_SERVER_PORT);
	}

	/**
	 * @return Host of appium server read from {@code appium_server_host} system property; default value is {@link AppiumConfigurationProvider#DEFAULT_APPIUM_SERVER_HOST}
	 */
	private static String host() {
		return SystemPropertyReader.readStringProperty("appium_server_host", DEFAULT_APPIUM_SERVER_HOST);
	}

	/**
	 * @return Url of appium server built using {@link AppiumConfigurationProvider#port()} and {@link AppiumConfigurationProvider#host()}
	 */
	public static String url() {
		return String.format("http://%s:%s/wd/hub", host(),port());
	}

	/**
	 * @return platform name ("ios" or "android") using {@code platform} system property; default value is {@link AppiumConfigurationProvider#DEFAULT_PLATFORM_NAME}
	 */
	public static String platformName() {
		return SystemPropertyReader.readStringProperty("platform_name", DEFAULT_PLATFORM_NAME);
	}

	/**
	 *  @return Return default package name {@link AppiumConfigurationProvider#APP_PACKAGE} 
	 */
	public static String appPackage() {
		return APP_PACKAGE;
	}

	/** 
	 * @return Return default activity name {@link AppiumConfigurationProvider#APP_ACTIVITY} 
	 */
	public static String appActivity() {
		return APP_ACTIVITY;
	}

	/**
	 * @return Implicit timeout in seconds of appium client read from {@code implicit_timeout} system property; default value is {@link AppiumConfigurationProvider#DEFAULT_IMPLICIT_TIMEOUT_IN_SECONDS} 
	 */
	public static Integer implicitTimeout() {
		return SystemPropertyReader.readIntegerProperty("implicit_timeout", DEFAULT_IMPLICIT_TIMEOUT_IN_SECONDS);
	}

	/**
	 * @return Explicit timeout in seconds of appium client read from {@code explicit_timeout} system property; default value is {@link AppiumConfigurationProvider#DEFAULT_EXPLICIT_TIMEOUT_IN_SECONDS}
	 */
	public static Integer explicitTimeout() {
		return SystemPropertyReader.readIntegerProperty("explicit_timeout", DEFAULT_EXPLICIT_TIMEOUT_IN_SECONDS);
	}

	/**
	 * @return device name. For example, "Android Device" or "iPhone 6". Read from {@code device_name} system property; default value is {@link AppiumConfigurationProvider#DEFAULT_DEVICE_NAME}
	 */
	public static String deviceName() {
		return SystemPropertyReader.readStringProperty("device_name", DEFAULT_DEVICE_NAME);
	}

	/**
	 * @return device uid (useful to run tests on multiple devices)
	 */
	public static String deviceUDID() {
		return SystemPropertyReader.readStringProperty("device_udid", DEFAULT_DEVICE_UDID);
	}
	
	/**
	 * @return Explicit timeout in seconds of appium client read from {@code explicit_timeout} system property; default value is {@link AppiumConfigurationProvider#DEFAULT_EXPLICIT_TIMEOUT_IN_SECONDS}
	 */
	public static Integer maximumNumberOfFailedTestRepeats() {
		return SystemPropertyReader.readIntegerProperty("repeat_failed_tests", DEFAULT_MAXIMUM_NUMBER_OF_TIMES_REPEAT_FAILED_TEST);
	}

	/**
	 * @return Absolute Path of the app (app folder for iOS, apk file for Android)
	 */
	public static String appAbsolutePath() {

		final String appAbsolutePath;
		final String appRelativePath = SystemPropertyReader.readStringProperty("app_path", DEFAULT_ABSOLUTE_PATH);
		if (appRelativePath != null && !appRelativePath.isEmpty()) {
			// in this way, property can be a relative path
			File file = new File(appRelativePath);
			appAbsolutePath = file.getAbsolutePath();
		}else {
			appAbsolutePath = DEFAULT_ABSOLUTE_PATH;
		}
		return appAbsolutePath;
	}

}
