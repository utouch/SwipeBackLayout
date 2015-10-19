#SwipeBackLayout
让你的应用通过手势滑动返回

#Example
![](example.git)

#Issue
* 在4.4系统上滑动黑屏或显示桌面主题

  ```
  <style name="Main.AppTheme" parent="AppTheme.Base">
        <!-- Customize your theme here. -->
        <item name="android:windowIsTranslucent">false</item>
  </style>
  ```
    
    主界面引用
    
    ```
     <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        `
        android:theme="@style/AppTheme"
        ` >
        <activity
            android:name=".activitys.MainActivity"
            `
            android:theme="@style/Main.AppTheme"
            `>
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        ...
    ```
        
* 使用 Meterial Design 中，与 SystemBarTint 结合使用状态栏颜色问题

  ```
    public void attachToActivity(Activity activity) {
        mActivity = activity;
        TypedArray a = activity.getTheme().obtainStyledAttributes(new int[]{
                android.R.attr.windowBackground
        });
        int background = a.getResourceId(0, 0);
        a.recycle();
        `
        ViewGroup decor = (ViewGroup) activity.getWindow().getDecorView().findViewById(Window.ID_ANDROID_CONTENT);
        `
        ViewGroup decorChild = (ViewGroup) decor.getChildAt(0);
        decorChild.setBackgroundResource(background);
        decor.removeView(decorChild);
        addView(decorChild);
        setContentView(decorChild);
        decor.addView(this);
    }
    ```

  关键代码

  ```
  ViewGroup decor = (ViewGroup) activity.getWindow().getDecorView().findViewById(Window.ID_ANDROID_CONTENT);
  ```

#Library
###[SwipeBackLayout](https://github.com/ikew0ngSwipeBackLayout)&nbsp;&nbsp;&nbsp;[SystemBarTint](https://github.com/xiaoqi05/SystemBarTint)

#License
Copyright 2013 Square, Inc.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.