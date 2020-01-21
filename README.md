## Html Editor

<p align="left">
  <img src="https://raw.githubusercontent.com/appsfeature/html-editor/master/screenshots/preview.png" alt="Preview 1" width="250" /> 
</p>

Replacement for Android's EditText, which allows user to input text with formatting.
Features:
1. Bold
2. Italic
3. Underline
4. Text color
5. Text background color
6. Bullets
7. Numbered list
8. Inline image
  
## Setup 
Add this to your project build.gradle
``` gradle
allprojects {
    repositories {
        maven {
            url "https://jitpack.io"
        }
    }
}
```

#### Dependency
[![](https://jitpack.io/v/appsfeature/html-editor.svg)](https://jitpack.io/#appsfeature/html-editor)
```gradle
dependencies {
        implementation 'com.github.appsfeature:html-editor:x.y'
}
```
#### Usage 
in your xml file
```xml
    <com.htmleditor.HtmlTextEditor
        android:id="@+id/html_editor"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```
Retrive HTML Data
```java
    htmlTextEditor = (HtmlTextEditor) findViewById(R.id.html_editor);
    String htmlData = htmlTextEditor.getText()
```

Set HTML Data
```java
    htmlTextEditor.setText("<h2>Hello World.<h2><br><h3> I'am Summernote</h3>");
```
 
