Load Indicators - Android library
==============

## Overview
Load Indicators is an Android library that takes a sprite animation and plays it in a view. 
Play a sprite animation with ease on Android.

Sample app available in store:

[![Foo](http://tcsdesignreno.com/wp-content/uploads/2012/09/Google-Play-Store-Icon.png)](https://play.google.com/store/apps/details?id=com.loadindicators.adrianlesniak.loadindicators)

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-LoadIndicators-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1191)



[![Foo](http://i.imgur.com/U812Pebl.png?1)](http://i.imgur.com/U812Pebl.png?1)
[![Foo](http://i.imgur.com/51MGXPZl.png?1)](http://i.imgur.com/51MGXPZl.png?1)

## Download
Add jitpack.io respository to the project-level build.gradle file.
```java
allprojects {
 repositories {
    ...
    maven { url "https://jitpack.io" }
 }
}
```
add the library to your app dependencies block:
```java
dependencies {
    ...
    implementation 'com.github.adrian110288:LoadIndicators:1.1.1'
}
```


## Usage
Add ```LoaderView``` to your xml layout:

```xml
<com.loadindicators.adrianlesniak.library.LoaderIndicator
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```

Use a number of custom attributes on the view to adjust look and feel of your sprint animation:

* ```app:loader_src```

    A drawable resource that represents a sprint animation. It is advised that PNG format is used. 
Refer
* ```app:loader_frameDuration```
    
    An integer value that represents a duration of each frame in the animation.

* ```app:loader_frameCount```
    
    An integer value that represents a number of frames in the animation. The field must be larger that 0 and it is     mandatory.
    Also ensure the correct number of frames is added.

* ```app:loader_autoStart```
    
    A boolean value that, when set to ```true```, will auto play animation when used in xml layout.

* ```app:loader_canLoop```

    A boolean value controlling looping behavior.  

* ```app:loader_loopInReverse```

    A boolean value that allows the unwinding animation to be played, if ```app:loader_canLoop``` is also set to ```true```.

Refer to sample app in the repository for example sprint animations. 

**Important!**

Sprint animations are downloadable for free from [Icons 8 Preloaders](https://icons8.com/preloaders/). Configure your sprint animations using the website, download the sprint as PNG and drop it into ```drawable``` folder of you app.

For any help regarding the usage of the library or the website, do not hesitate to contact me or create an issue on Github.
