# Experiment 8: Implement Menus and WebView in an Android Application

## Student Details

- **Author:** Vishwajeet Singh
- **USN:** 25MCAR0219
- **Programme:** Master of Computer Applications (MCA)
- **University:** Jain (Deemed-to-be University), Bengaluru
- **Department/Lab:** Mobile Application Development (MAD)
- **Experiment:** 8
- **GitHub Repository:** [MAD-Experiment-8-WebView-Pro](https://github.com/Vishwajeetsingh22/MAD-Experiment-8-WebView-Pro)

## 1. Aim

To design and implement an Android application that demonstrates menu-based navigation and displays web pages inside the application using the Android `WebView` component.

## 2. Software and Technologies Used

- Android Studio
- Kotlin
- Android SDK
- XML layouts and Android resources
- Android `WebView`, `WebViewClient`, and browser navigation controls
- Android device or emulator
- Internet connection for online websites

## 3. Experiment Overview

**WebView Pro** is a purple-themed Android web browsing application. Its home screen provides a URL/search field, an **Open Website** action, quick-access cards for Wikipedia, Google, GitHub, and About/USN, and a list of key features. The browser screen displays websites within the app and includes back, forward, reload, address-bar, and additional-menu controls. The app also includes student information and a settings screen.

The supplied screenshots document the application's home screen, WebView browsing, student information, and settings interface.

## 4. Concepts and Theory

### Android Options Menu

An options menu presents actions that users can select to perform common tasks, such as opening settings, viewing information, or exiting an application.

### WebView

`WebView` is an Android UI component that renders web content inside an application. It can be configured with a `WebViewClient` to keep ordinary web navigation within the app. A `WebChromeClient` can support browser-related features such as page-loading progress and file chooser interactions.

### Navigation Controls

Back, forward, reload, and URL-entry controls make it possible to navigate between web pages from the application's browser interface.

### Internet Permission

Online browsing requires the following permission in `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

Only include additional permissions when the implemented features require them.

## 5. Application Features

- Premium dark-purple interface with violet and cyan accents.
- Home screen with URL/search input and an Open Website button.
- Quick access to Wikipedia, Google, and GitHub.
- Web pages displayed inside the app using WebView.
- Back, forward, and reload browser controls.
- About dialog showing the application and student information.
- Student details displayed in the app:
  - **Name:** Vishwajeet Singh
  - **USN:** 25MCAR0219
  - **Course:** MCA
  - **University:** Jain (Deemed-to-be University)
- Settings screen with a JavaScript toggle, browsing-data clearing action, and app/student information.
- Responsive layout intended for Android phone screens.

> Note: Features and behavior described above are based on the supplied screenshots. Verify each control on the running build before claiming that every feature is fully functional.

## 6. Procedure

1. Open Android Studio.
2. Create or open the Android project for **WebView Pro**.
3. Implement the home screen layout and apply the app's purple theme.
4. Add a WebView browser screen and configure the appropriate WebView client.
5. Add the Internet permission to `AndroidManifest.xml`.
6. Implement URL entry and website loading.
7. Add browser navigation controls such as Back, Forward, and Reload.
8. Implement the app's menu/navigation actions.
9. Add an About screen or dialog that displays the student's name and USN.
10. Add the settings interface and connect its controls to the appropriate application logic.
11. Run the application on an Android emulator or physical device with internet access.
12. Execute the test cases below and capture screenshots of the actual application output.
13. Add the screenshots and this README to the GitHub repository.

## 7. Screenshot Evidence

The screenshots below were supplied by the student and are included in this repository package.

### 7.1 Home Screen

![WebView Pro home screen](screenshots/01_home_screen.jpg)

### 7.2 Wikipedia Home Page in WebView

![Wikipedia home page displayed in WebView](screenshots/02_wikipedia_home.jpg)

### 7.3 WebView Article and Browser Controls

![Article displayed inside WebView](screenshots/03_webview_article.jpg)

### 7.4 Google Search in WebView

![Google search displayed in WebView](screenshots/04_google_search.jpg)

### 7.5 GitHub Website in WebView

![GitHub website displayed in WebView](screenshots/05_github_webview.jpg)

### 7.6 About Dialog — Name and USN

![About dialog showing student name and USN](screenshots/06_about_student_usn.jpg)

### 7.7 Settings Screen

![WebView Pro settings screen](screenshots/07_settings_screen.jpg)

## 8. Test Cases

| Test Case | Test Steps | Expected Result | Evidence |
|---|---|---|---|
| **TC1: Home screen display** | Launch WebView Pro. | The home screen displays the app branding, URL/search field, Open Website button, quick-access cards, and feature list. | [Home screen](screenshots/01_home_screen.jpg) |
| **TC2: Open a website** | Tap a quick-access website or enter a URL and open it. | The selected website loads inside the app's WebView. | [Wikipedia home](screenshots/02_wikipedia_home.jpg), [article](screenshots/03_webview_article.jpg), [Google](screenshots/04_google_search.jpg), [GitHub](screenshots/05_github_webview.jpg) |
| **TC3: Display student information** | Open About / USN. | The About dialog displays the app name, student name, USN, and course/university information. | [About and USN](screenshots/06_about_student_usn.jpg) |
| **TC4: Settings screen** | Open Settings. | The settings screen displays available WebView and browsing-data options. | [Settings](screenshots/07_settings_screen.jpg) |

**USN requirement:** Test Case 3 includes the student's name and USN in the supplied screenshot.

## 9. Project Structure

The suggested Android project structure is shown below. The exact package name and source files should match the implementation in Android Studio.

```text
WebViewPro/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/webviewpro/
│           │   ├── MainActivity.kt
│           │   ├── BrowserActivity.kt        # if separated in the project
│           │   └── SettingsActivity.kt       # if separated in the project
│           ├── res/
│           │   ├── layout/
│           │   ├── drawable/
│           │   ├── mipmap-*/                 # launcher icon resources
│           │   ├── values/
│           │   └── menu/                     # if menu XML resources are used
│           └── AndroidManifest.xml
├── screenshots/
│   ├── 01_home_screen.jpg
│   ├── 02_wikipedia_home.jpg
│   ├── 03_webview_article.jpg
│   ├── 04_google_search.jpg
│   ├── 05_github_webview.jpg
│   ├── 06_about_student_usn.jpg
│   └── 07_settings_screen.jpg
├── README.md
└── LICENSE
```

## 10. How to Run

1. Clone or download the Android project repository.
2. Open the project folder in Android Studio.
3. Allow Gradle sync to complete.
4. Connect an Android device or start an emulator.
5. Ensure the device has an internet connection for online websites.
6. Click **Run** in Android Studio.
7. Test the home screen, website navigation, About/USN dialog, and settings screen.

## 11. GitHub Submission

From the root of the actual Android project, place this README at `README.md` and add the screenshots folder. Then run:

```bash
git add README.md screenshots/ LICENSE
git commit -m "Update Experiment 8 documentation and license"
git push origin main
```

If you have not created a `LICENSE` file, remove `LICENSE` from the `git add` command or create the license file first. If the screenshots are already tracked, avoid creating duplicate copies unnecessarily. Confirm the repository's default branch before pushing.

## 12. Author

**Vishwajeet Singh**

- **USN:** 25MCAR0219
- **Programme:** Master of Computer Applications (MCA)
- **Subject:** Mobile Application Development (MAD)
- **University:** Jain (Deemed-to-be University), Bengaluru
- **Experiment:** 8 — Implement Menus and WebView in an Android Application
- **GitHub:** [Vishwajeetsingh22](https://github.com/Vishwajeetsingh22)
- **Project Repository:** [MAD-Experiment-8-WebView-Pro](https://github.com/Vishwajeetsingh22/MAD-Experiment-8-WebView-Pro)

## 13. License

This project is licensed under the **MIT License**. You may use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the software, subject to the conditions of the MIT License.

See the [`LICENSE`](LICENSE) file in this repository for the complete license text.

> Include the MIT license only if you intend to publish your project under those terms. If you do not want to grant these permissions, remove this section and the `LICENSE` file.

## 14. Result

The WebView Pro application demonstrates an Android interface for menu-based navigation and in-app web browsing using WebView. The supplied output screenshots show the home screen, website loading, browser navigation, About dialog with student name and USN, and settings screen.

**Final verification:** Run the app and confirm each test case on the actual build before submission. The screenshots in this README are evidence supplied for documentation; they do not independently prove that every feature passes on all devices.
