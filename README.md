FontPagerTitleStrip
===================
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FontPagerTitleStrip-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/979)

Library that allows you to customize the font of a `PagerTitleStrip`.

![image](IMG_20140531_205042.jpg)

## Usage

###Download
```groovy
compile 'me.alexrs:font-pager-titlestrip:1.0.0'
```
 
You can use the following attributes:
```XML
<me.alexrs.fontpagertitlestrip.lib.FontPagerTitleStrip
	android:id="@+id/titlestrip"
	android:layout_width="match_parent"
	android:layout_height="30dp"
	app:fontFamily="sans-serif|sans-serif-light|sans-serif-condensed|sans-serif-thin"
	app:textStyle="normal|bold|italic" />
```
## Show me the code!
Also, this library provides the following methods to customize the font and the appearance of your `FontPagerTitleStrip`

```JAVA
FontPagerTitleStrip mPagerTitleStrip = (FontPagerTitleStrip) findViewById(R.id.titlestrip);
```
- By font family. (sans-serif | sans-serif-light | sans-serif-condensed | sans-serif-thin)
```JAVA
mPagerTitleStrip.setTypefaceByFontFamily("sans-serif-condensed"); // You can use sans-serif|sans-serif-light|sans-serif-condensed|sans-serif-thin
```
- By font family, but you can also determine the font style.
```JAVA
mPagerTitleStrip.setTypefaceByFontFamily("sans-serif-light", Typeface.BOLD);
````
- From assets
```JAVA
mPagerTitleStrip.setTypefaceFromAssets("fonts/myfont.ttf");
````
- With your own `Typeface`
```JAVA
Typeface mTypeface = Typeface.createFromAsset(getAssets(), "fonts/myfont.ttf");
mTitleStrip.setTypeface(mTypeface, "myfont");
```

If you have any doubt or suggestion, please, let me know!
