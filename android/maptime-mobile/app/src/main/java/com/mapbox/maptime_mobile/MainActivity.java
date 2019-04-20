package com.mapbox.maptime_mobile;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;

import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import java.util.ArrayList;
import java.util.List;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconOffset;

public class MainActivity extends AppCompatActivity {
  private static final String SOURCE_ID = "SOURCE_ID";
  private static final String ICON_ID = "ICON_ID";
  private static final String LAYER_ID = "LAYER_ID";
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
      public void onMapReady(@NonNull final MapboxMap mapboxMap) {


        List<Feature> symbolLayerIconFeatureList = new ArrayList<>();
        symbolLayerIconFeatureList.add(Feature.fromGeometry(
                Point.fromLngLat(-122.271760, 37.811810)));


        // ⭐️ Challenge: Customize the Mapbox Style
        // Style.MAPBOX_STREETS is a convenient shorthand our SDK provides that points to
        // the most current Mapbox Streets style (see https://docs.mapbox.com/android/api/map-sdk/7.3.0/com/mapbox/mapboxsdk/maps/Style.html#MAPBOX_STREETS).
        // Can you change the style URL below to point to your custom Mapbox Studio Style?
        // • Example reference: https://docs.mapbox.com/android/maps/examples/use-a-mapbox-studio-style/

        mapboxMap.setStyle(new Style.Builder().fromUrl("mapbox://styles/mnorelli/cihpqdnu7001bnpm4eq11giyl")

          .withImage(ICON_ID, BitmapFactory.decodeResource(
                  MainActivity.this.getResources(), R.drawable.mapbox_marker_icon_default))
          .withSource(new GeoJsonSource(SOURCE_ID,
            FeatureCollection.fromFeatures(symbolLayerIconFeatureList)))
          .withLayer(new SymbolLayer(LAYER_ID, SOURCE_ID)
              .withProperties(PropertyFactory.iconImage(ICON_ID),
                      iconAllowOverlap(true),
                      iconOffset(new Float[] {0f, -9f}))


              ), new Style.OnStyleLoaded() {
          @Override
          public void onStyleLoaded(@NonNull Style style) {

            // Map is set up and the style has loaded. Now you can add data or make other map adjustments

            // ⭐️ Challenge: Set the center coordinate and zoom level
            // This map currently doesn't have a specified center or zoom level.
            // Can you change the map view so that it centers on your hometown?
            // • Example reference: https://docs.mapbox.com/android/maps/examples/animate-the-map-camera/



            CameraPosition position = new CameraPosition.Builder()
                    .target(new LatLng(37.8, -122.2)) // Sets the new camera position
                    .zoom(10) // Sets the zoom
                    .bearing(350) // Rotate the camera
                    .tilt(40) // Set the camera tilt
                    .build(); // Creates a CameraPosition from the builder

            mapboxMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(position), 2000);

            // ⭐️ Challenge: Add a basic marker
            // Can you add a marker at the center of the map?
            // The most basic way to add a marker is using a SymbolLayer icon.
            // • API reference: https://docs.mapbox.com/android/api/map-sdk/7.3.0/com/mapbox/mapboxsdk/style/layers/SymbolLayer.html
            // • Example reference: https://github.com/mapbox/mapbox-android-demo/blob/033426da7ea8b0c424c48a4e7a6acae34dbec837/MapboxAndroidDemo/src/main/java/com/mapbox/mapboxandroiddemo/examples/styles/MainActivity.java
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