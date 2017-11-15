//
//  ViewController.swift
//  Chapter6
//
//  Created by cocoa on 2017/11/14.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit
import MapKit

class ViewController: UIViewController {
    
    var mapView : MKMapView!
    
    override func loadView() {
        mapView = MKMapView()
        self.view = mapView
        
        let segmentControl = UISegmentedControl(items: ["item1","item2","item3"])
        segmentControl.selectedSegmentIndex =  0
        segmentControl.translatesAutoresizingMaskIntoConstraints = false
        self.view.addSubview(segmentControl)
        
        
        
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

