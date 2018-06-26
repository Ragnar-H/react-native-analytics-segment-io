package com.leo_pharma.analytics_segment_io.example;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.leo_pharma.analytics.AnalyticsPackage;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new AnalyticsPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
  }

  @Override
  public void onReactInitialized(ReactContext reactContext) {
    super.onReactInitialized(reactContext);

    initSegment();
  }

  private void initSegment() {
    SegmentModule segmentModule = new SegmentModule(new ReactApplicationContext(getBaseContext()));

    WritableMap options = new WritableNativeMap();
    options.putBoolean("trackApplicationLifecycleEvents", true);

    Callback callback = new Callback() {
      @Override
      public void invoke(Object... args) {
        // No-op
      }
    };

    segmentModule.setup(BuildConfig.SEGMENT_KEY, options, new PromiseImpl(callback, callback));
  }
}
