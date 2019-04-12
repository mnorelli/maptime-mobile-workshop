package com.mapbox.maptime_mobile;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

public class MainActivity extends AppCompatActivity {

  private MapView mapView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
    setContentView(R.layout.activity_main);
    mapView = findViewById(R.id.mapView);
    mapView.onCreate(savedInstanceState);
    mapView.getMapAsync(new OnMapReadyCallback() {
      @Override
      public void onMapReady(@NonNull MapboxMap mapboxMap) {


        // ⭐️ Challenge: Customize the Mapbox Style
        // Style.MAPBOX_STREETS is a convenient shorthand our SDK provides that points to
        // the most current Mapbox Streets style (see https://docs.mapbox.com/android/api/map-sdk/7.3.0/com/mapbox/mapboxsdk/maps/Style.html#MAPBOX_STREETS).
        // Can you change the style URL below to point to your custom Mapbox Studio Style?
        // • Example reference: https://docs.mapbox.com/android/maps/examples/use-a-mapbox-studio-style/

        mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
          @Override
          public void onStyleLoaded(@NonNull Style style) {

            // Map is set up and the style has loaded. Now you can add data or make other map adjustments

            // ⭐️ Challenge: Set the center coordinate and zoom level
            // This map currently doesn't have a specified center or zoom level.
            // Can you change the map view so that it centers on your hometown?
            // • Example reference: https://docs.mapbox.com/android/maps/examples/animate-the-map-camera/





            // ⭐️ Challenge: Add a basic marker
            // Can you add a marker at the center of the map?
            // The most basic way to add a marker is using a SymbolLayer icon.
            // • API reference: https://docs.mapbox.com/android/api/map-sdk/7.3.0/com/mapbox/mapboxsdk/style/layers/SymbolLayer.html
            // • Example reference: https://github.com/mapbox/mapbox-android-demo/blob/033426da7ea8b0c424c48a4e7a6acae34dbec837/MapboxAndroidDemo/src/main/java/com/mapbox/mapboxandroiddemo/examples/styles/BasicSymbolLayerActivity.java
            // • Example reference's GIF: https://github.com/mapbox/mapbox-android-demo/pull/1030#issue-269831788


          }
        });
      }
    });
  }

  @Override
  public void onStart() {
    super.onStart();
    mapView.onStart();
  }

  @Override
  public void onResume() {
    super.onResume();
    mapView.onResume();
  }

  @Override
  public void onPause() {
    super.onPause();
    mapView.onPause();
  }

  @Override
  public void onStop() {
    super.onStop();
    mapView.onStop();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mapView.onDestroy();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mapView.onSaveInstanceState(outState);
  }
}