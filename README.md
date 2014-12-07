LoadIndicators
==============

## Overview
Neat 2D and 3D load indicators/spinners to use in your app. The library converts pre made spritesheets to an AnimationDrawable to returns a Loader object than extends from ImageView. A very simple idea that can liven up your app. 

Have a look at my example app to see them in action:

[![Foo](http://tcsdesignreno.com/wp-content/uploads/2012/09/Google-Play-Store-Icon.png)](https://play.google.com/store/apps/details?id=com.loadindicators.adrianlesniak.loadindicators)





[![Foo](http://i.imgur.com/U812Pebl.png?1)](http://i.imgur.com/U812Pebl.png?1)
[![Foo](http://i.imgur.com/51MGXPZl.png?1)](http://i.imgur.com/51MGXPZl.png?1)


## Usage
In order to use the library you can add the Loader widget to your layout xml file like that:

```xml
<com.loadindicators.adrianlesniak.library.LoaderView
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/imageLoader"
    app:loaderType="pacman"
    app:loaderFrameDelay="40"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_centerInParent="true"/>
```

There are two custom attributes ```loaderType``` and ```loaderFrameDelay```.
```loaderFrameDelay``` basically (as the name suggests :) delays each frame letting you control the speed of the animation. The default value is 50 which in my opinion gives the best effect. This attribute is optional.

```loaderType``` allows yout to specify what animation you would like to display. Ate the moment all available are animations are:
```xml
flop flop
intersect
map marker
mini balls
pacman
pulse
radar
ring race
running snake
searching
skype
snake
spin fade
spinning gear
time machine
windows 8
```

Another way to embed the Laoder view is through code. Simple instantiate a LaoderView object like this:
```java
LoaderView loader = new LoaderView(Context, LaoderType);
```
The latter parameter is an ```enum``` type with all available loaders.

or like this:
```java
LaoderView loader = new LoaderView(Context);
```
and call a 
```java
setLoader(LoaderType)
``` 
or 
```java
setLaoderWithDelay(LoaderType, int)
```
and optionally 
```java
setDelay(int)
```

I hope you will find the library useful for yourself. I am looking forward to getting feedback from you and if anyone want to participate in developing the library further, do not hesitate to contact me.

Do not forget to check you my example app on Play Store :)

My future tasks will be to:
* upload the library to Maven 
* app different colors of the loaders

P.S.
The example app uses to Google Analytics which track "I Like buttons clicks" in order for me to track app engagament and favourite loaders so I can plan for future additions of new loaders.

Big thanks for http://preloaders.net/ for providing spritesheets for the loaders and for Android Arsenal to help me advertise this library.

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-LoadIndicators-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1191)
