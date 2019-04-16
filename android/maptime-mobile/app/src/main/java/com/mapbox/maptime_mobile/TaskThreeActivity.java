package com.mapbox.maptime_mobile;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.Layer;

import static com.mapbox.mapboxsdk.style.expressions.Expression.rgba;
import static com.mapbox.mapboxsdk.style.expressions.Expression.stop;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.fillColor;

public class TaskThreeActivity extends AppCompatActivity implements MapView.OnDidFinishLoadingStyleListener {

  private MapView mapView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
    setContentView(R.layout.activity_main);
    mapView = findViewById(R.id.mapView);
    mapView.onCreate(savedInstanceState);
    mapView.addOnDidFinishLoadingStyleListener(this);
    mapView.getMapAsync(new OnMapReadyCallback() {
      @Override
      public void onMapReady(@NonNull final MapboxMap mapboxMap) {

        mapboxMap.setStyle(Style.DARK,
          new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {

              // 🔥 Hot tip: Change the water color at runtime!
              // The map style being used already has its water color defined. But, we can change
              // it at runtime through this code.
              //
              // Run the app to see the custom rgb color used for the water color. Then delete
              // this hot tip's code below and re-run the app to see the original water color.
              //
              // This is called runtime styling, since we are changing
              // the map's style at runtime. To change the water color, we need to retrieve the layer
              // containing the water data and then we set the new color of the water.
              // The returned result of any attempt to retrieve a layer in a map is an optional value that may
              // or may not exist. This "null check" statement is a way to guard against the water layer not existing.
              // If the water layer can't be found (perhaps someone deleted it from the original style or maybe
              // it never existed!), the code inside the brackets will not run.

              if (style.getLayer("water") != null) {
                Layer waterLayer = style.getLayer("water");
                waterLayer.setProperties(fillColor(rgba(4,147,255, 1)));
              }

              // ⭐️ Challenge: Customize color of the country borders
              // Using the above as a reference, can you change the color of the country borders?
              // Here are some tips to complete this task:
              // • The identifier of the country borders layer is "admin-0-boundary"
              // • Since country borders are comprised of line shapes, the layer type is a LineLayer
              // • API reference: https://docs.mapbox.com/android/api/map-sdk/7.3.0/com/mapbox/mapboxsdk/style/layers/LineLayer.html
              // • Mapbox Streets V8 layer reference: https://docs.mapbox.com/vector-tiles/reference/mapbox-streets-v8/#layer-reference


              // ⭐️ Challenge: Add data from an external API
              // One of the most powerful features of mobile mapping is the ability to read data sources from
              // somewhere else and add them to a map! Below is a URL to a GeoJSON feed of earthquakes recorded
              // by the USGS within the past week. In this challenge, you should:
              // • Register a new data source with the map by creating a new MGLShapeSource with the above URL
              //   API reference: https://docs.mapbox.com/android/api/map-sdk/7.3.0/com/mapbox/mapboxsdk/style/sources/GeoJsonSource.html
              // • Create a new style layer to visualize the data source using a CircleLayer
              //   API reference: https://docs.mapbox.com/android/api/map-sdk/7.3.0/com/mapbox/mapboxsdk/style/layers/CircleLayer.html
              // • Add the new data source and style layer to the map's style
              //   API reference: https://docs.mapbox.com/android/api/map-sdk/7.3.0/com/mapbox/mapboxsdk/maps/Style.html

              String earthquakeGeoJsonUrl = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.geojson";

              // ⭐️ Challenge: Style each circle based off of an earthquake's intensity
              // Once you have completed the above challenge, you will see black circles on your map
              // representing the locations of earthquakes that have occurred within the past week.
              // To better visualize this data, you will now apply a different color to each circle based
              // off its intensity. In this challenge, you should:
              // • Use the below dictionary of stop values to set the layer's circle color based on the
              //   severity of the earthquake, using the data source's "mag" field which represents its magnitude.
              //   Examples: https://docs.mapbox.com/android/maps/examples/style-circles-categorically
              //             https://docs.mapbox.com/android/maps/examples/circle-layer-clustering

              Expression.Stop[] stopArray = new Expression.Stop[] {
                stop(0, Color.GREEN),
                stop(2, Color.YELLOW),
                stop(5, Color.MAGENTA),
                stop(10, Color.RED),
              };

            }
          });
      }
    });
  }

  @Override
  public void onDidFinishLoadingStyle() {
    // 🔥 Hot tip: Wait for the map to finish loading before trying to change it.
    // The onDidFinishLoadingStyle() method is called an "interface method". It is called in response to the
    // map performing some event. In this case, this method gets called when the map's
    // style has finished loading. The app could crash if you tried to manipulate a map style before the style
    // has finished loading.
    // API reference: https://docs.mapbox.com/android/api/map-sdk/7.3.0/com/mapbox/mapboxsdk/maps/MapView.OnDidFinishLoadingMapListener.html
    Log.d("TaskThreeActivity", "onDidFinishLoadingStyle: ");


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