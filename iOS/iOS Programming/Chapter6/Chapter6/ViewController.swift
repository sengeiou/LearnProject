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
        
       let margins = view.layoutMarginsGuide
        
       let topConstraint = segmentControl.topAnchor.constraint(equalTo: topLayoutGuide.bottomAnchor)
       let leadingConstraint = segmentControl.leadingAnchor.constraint(equalTo: margins.leadingAnchor)
       let trailinConstraint = segmentControl.trailingAnchor.constraint(equalTo: margins.trailingAnchor)
        
        topConstraint .isActive = true
            leadingConstraint.isActive = true
        trailinConstraint.isActive = true
        
        segmentControl.addTarget(self, action: #selector(typeChanged(seg:)), for: .valueChanged)
    }
    
    @objc func typeChanged(seg: UISegmentedControl){
        switch seg.selectedSegmentIndex {
        case 0:
            print("0")
        case 1:
            print("1")
        case 2:
            print("2")
        default:
            print("default")
        }
        
        
    }
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

