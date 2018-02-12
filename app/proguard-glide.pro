# Begin: Proguard rules for glide

-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# If you're targeting any API level less than Android API 27, also include:
-dontwarn com.bumptech.glide.load.resource.bitmap.VideoDecoder

# End: Proguard rules for glide