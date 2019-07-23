//
//  ViewController.swift
//  C6
//
//  Created by jun shen on 2019/6/25.
//  Copyright © 2019 jun shen. All rights reserved.
//

import UIKit
import MapKit

class ViewController: UIViewController {

    var mapView : MKMapView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        mapView = MKMapView()
        self.view = mapView
        addSf()
    }
    
    
    func addSf(){
        let segmentCotrol = UISegmentedControl(items: ["aa","bb","cc"])
        segmentCotrol.backgroundColor = UIColor.white.withAlphaComponent(0.8)
        segmentCotrol.selectedSegmentIndex = 0
        segmentCotrol.translatesAutoresizingMaskIntoConstraints = false
        self.view.addSubview(segmentCotrol)
        
        let top = segmentCotrol.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor)

        let left = segmentCotrol.leadingAnchor.constraint(equalTo: view.leadingAnchor,constant: 10)
        
        let right = segmentCotrol.trailingAnchor.constraint(equalTo: view.trailingAnchor,constant: -10)

        top.isActive = true
        left.isActive = true
        right.isActive = true
        
        segmentCotrol.addTarget(self, action: #selector(change), for: .valueChanged)
    }
    
    
    @objc func change(sc : UISegmentedControl){
        switch sc.selectedSegmentIndex {
        case 0:
            mapView.mapType = .hybrid
        case 1:
            mapView.mapType = .standard
            let customLoc2D = CLLocationCoordinate2DMake(31.27006030476515, 120.70549774169922)
            mapView.setCenter(customLoc2D, animated: true)
//            mapView.addOverlay(MKOverlay)
        default:
            mapView.mapType = .satellite

        }
        
        
    }

}

