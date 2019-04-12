import UIKit
import Mapbox

class FirstViewController: UIViewController, MGLMapViewDelegate {

    var mapView: MGLMapView!

    override func viewDidLoad() {
        super.viewDidLoad()

        // ⭐️ Challenge: Customize the Mapbox Style
        // MGLStyle.streetsStyleURL is a convenient shorthand our SDK provides that points to
        // the most current Mapbox Streets style (see https://docs.mapbox.com/ios/api/maps/4.9.0/Classes/MGLStyle.html).
        // Can you change the style URL below to point to your custom Mapbox Studio Style?
        // • Example reference: https://docs.mapbox.com/ios/maps/examples/custom-style/
        mapView = MGLMapView(frame: view.frame, styleURL: MGLStyle.streetsStyleURL)
        mapView.delegate = self
        mapView.autoresizingMask = [.flexibleWidth, .flexibleHeight]

        // ⭐️ Challenge: Set the center coordinate and zoom level
        // This map currently doesn't have a specified center or zoom level.
        // Can you change the map view so that it centers on your hometown?
        // • API reference: https://docs.mapbox.com/ios/api/maps/4.9.0/Classes/MGLMapView.html#/Manipulating%20the%20Viewpoint
        // • Example reference: https://docs.mapbox.com/ios/maps/examples/simple-map-view/


        // ⭐️ Challenge: Add a basic marker
        // Can you add a marker at the center of the map?
        // The most basic way to add a marker is using MGLPointAnnotation.
        // • API reference: https://docs.mapbox.com/ios/api/maps/4.9.0/Classes/MGLPointAnnotation.html
        // • Example reference: https://docs.mapbox.com/ios/maps/examples/marker/
        view.addSubview(mapView)
    }

    // This function tells any MGLPointAnnotation to display a callout. Uncomment the code below
    // if you want to show a callout when you tap on your marker.
    
//    func mapView(_ mapView: MGLMapView, annotationCanShowCallout annotation: MGLAnnotation) -> Bool {
//        return true
//    }
}
