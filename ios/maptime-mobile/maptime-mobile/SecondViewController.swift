import UIKit
import Mapbox

class SecondViewController: UIViewController, MGLMapViewDelegate {

    var mapView: MGLMapView!

    override func viewDidLoad() {
        super.viewDidLoad()

        mapView = MGLMapView(frame: view.frame, styleURL: MGLStyle.darkStyleURL)
        mapView.centerCoordinate = CLLocationCoordinate2D(latitude: 15, longitude: -82)
        mapView.zoomLevel = 1.5
        mapView.autoresizingMask = [.flexibleWidth, .flexibleHeight]
        mapView.delegate = self
        view.addSubview(mapView)
    }

    // 🔥 Hot tip: Wait for the map to finish loading before trying to change it.
    // The below didFinishLoading method is called a "delegate method". It is called in response to the
    // map performing some event. In this case, this method gets called when the map's
    // style has finished loading. If you try to manipulate a map style before the style
    // has finished loading (such as in viewDidLoad), the app could crash.
    // API reference: https://docs.mapbox.com/ios/api/maps/4.9.0/Protocols/MGLMapViewDelegate.html

    func mapView(_ mapView: MGLMapView, didFinishLoading style: MGLStyle) {

        // 🔥 Hot tip: Change the water color at runtime!
        // The map style being used already has its water color defined. But, we can change
        // it at runtime through this code. This is called runtime styling, since we are changing
        // the map's style at runtime. To change the water color, we need to retrieve the layer
        // containing the water data and then we set the new color of the water.

        // The returned result of any attempt to retrieve a layer in a map is an optional value that may
        // or may not exist. This "if-let" statement is a way to guard against the water layer not existing. If the water
        // layer can't be found (perhaps someone deleted it from the original style or maybe it never existed!),
        // the code inside the brackets will not run. Read more about optionals in the Swift Programming Guide:
        // https://docs.swift.org/swift-book/LanguageGuide/TheBasics.html

        if let waterLayer = style.layer(withIdentifier: "water") as? MGLFillStyleLayer {
            waterLayer.fillColor = NSExpression(forConstantValue: UIColor(red:0.00, green:0.58, blue:1.00, alpha:1))
        }

        // ⭐️ Challenge: Customize color of the country borders
        // Using the above as a reference, can you change the color of the country borders?
        // Here are some tips to complete this task:
        // • The identifier of the country borders layer is "admin-0-boundary"
        // • Since country borders are comprised of line shapes, the layer type is MGLLineStyleLayer
        // • API reference: https://docs.mapbox.com/ios/api/maps/4.9.0/Classes/MGLLineStyleLayer.html
        // • Mapbox Streets V8 layer reference: https://docs.mapbox.com/vector-tiles/reference/mapbox-streets-v8/#layer-reference

        // ⭐️ Challenge: Add data from an external API
        // One of the most powerful features of mobile mapping is the ability to read data sources from
        // somewhere else and add them to a map! Below is a url to a GeoJSON feed of earthquakes recorded
        // by the USGS within the past week. In this challenge, you should:
        // • Register a new data source with the map by creating a new MGLShapeSource with the below URL
        //   API reference: https://docs.mapbox.com/ios/api/maps/4.9.0/Classes/MGLShapeSource.html
        // • Create a new style layer to visualize the data source using MGLCircleStyleLayer
        //   API reference: https://docs.mapbox.com/ios/api/maps/4.9.0/Classes/MGLCircleStyleLayer.html
        // • Add the new data source and style layer to the map's style
        //   API reference: https://docs.mapbox.com/ios/api/maps/4.9.0/Classes/MGLStyle.html

        let earthquakeUrl = URL(string: "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.geojson")!

        // ⭐️ Challenge: Style each circle based off of an earthquake's intensity
        // Once you have completed the above challenge, you will see black circles on your map
        // representing the locations of earthquakes that have occurred within the past week.
        // To better visualize this data, you will now apply a different color to each circle based
        // off its intensity. In this challenge, you should:
        // • Use the below dictionary of stop values to set the layer's circle color based on the
        //   severity of the earthquake, using the data source's "mag" field which represents its magnitude.
        //   Example: https://docs.mapbox.com/ios/maps/examples/dds-circle-layer/

        let earthquakeStops = [
            0: NSExpression(forConstantValue: UIColor.green),
            2: NSExpression(forConstantValue: UIColor.yellow),
            5: NSExpression(forConstantValue: UIColor.orange),
            10: NSExpression(forConstantValue: UIColor.red)
        ]

        let fallbackColor = UIColor.white
    }
}
