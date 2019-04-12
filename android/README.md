# Maptime Mobile Mapping Workshop - Android platform

## Installation instructions

In order to spend less time configuring a new project and more time building, the Android project in this folder contains an app already set up with the Mapbox Maps SDK for Android.

You will need to complete a couple of more steps to get it running:

1. Open Android Studio and open this repository's android project folder when Android Studio gives you the option to `Open an exisiting Android Studio project`
2. Remain in Android Studio and then double tap the `Shift` key on your keyboard to open a search bar. Type `strings.xml` to find and open the project's `strings.xml` file. Alternatively, you can find the file by following this path `maptime-mobile-workshop/android/maptime-mobile/app/src/main/res/values/strings.xml`.
3. Find the `mapbox_access_token` string value in the `strings.xml` file, and enter your access token as a string value where it says `PASTE_YOUR_TOKEN_HERE`. You can find your access token at https://account.mapbox.com/access-tokens/.
4. Press the ![Screen Shot 2019-04-10 at 12 27 42 PM](https://user-images.githubusercontent.com/4394910/55907662-3983d180-5b8c-11e9-84ed-c3c4784bcb42.png)
button on the top right corner to run the project. If you don't see a map but your app runs, make sure you've entered your access token correctly.

## Task 2 
### Understanding the basics of the Mapbox Maps SDKs for Android

All of your code will go in the `MainActivity` file. Every time you want run this file, you will need to re-run the application. Comments are prefaced with a double forward slash (`//`), and will guide you through the exercises.

## Task 3 
### Advanced topics within the Mapbox Maps SDKs for Android


To set up your project for the next round of tasks, navigate to the `AndroidManifest.xml` file and move the following intent filter to the `TaskThreeActivity` section in the `AndroidManifest.xml` file. This is to tell the Android app to use the `TaskThreeActivity` file as the first screen displayed when the app opens. 

```
<intent-filter>
	<action android:name="android.intent.action.MAIN" />
 	<category android:name="android.intent.category.LAUNCHER" />
</intent-filter> 
```

Delete the intent filter from the `<activity android:name=".MainActivity">` section in the `AndroidManifest.xml` file.

Once you've completed this, you can move on to more advanced tasks by working in the `TaskThreeActivity` file. Comments are prefaced with a double forward slash (`//`), and will guide you through the next set of exercises.
