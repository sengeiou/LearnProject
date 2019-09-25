//
//  ViewController.swift
//  RGBWell
//
//  Created by cocoa on 2017/5/29.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import Cocoa

class ViewController: NSViewController {
    
    var r  = 0.0
    var g  = 0.0
    var b  = 0.0
    var a  = 1.0

    @IBOutlet weak var colorView: NSColorWell!
    
    @IBAction func red(_ sender: NSSlider) {
    r = sender.doubleValue
    let color = NSColor(deviceRed: CGFloat(r), green: CGFloat(g), blue: CGFloat(b), alpha: CGFloat(a))
       colorView.color = color
    }
    
    @IBAction func blue(_ sender: NSSlider) {
        b = sender.doubleValue
        let color = NSColor(deviceRed: CGFloat(r), green: CGFloat(g), blue: CGFloat(b), alpha: CGFloat(a))
        colorView.color = color
        
        
            }
    
    @IBAction func green(_ sender: NSSlider) {
        g = sender.doubleValue
        let color = NSColor(deviceRed: CGFloat(r), green: CGFloat(g), blue: CGFloat(b), alpha: CGFloat(a))
colorView.color = color        
    }

    override func viewDidLoad() {
        super.viewDidLoad()

    }
    
    override var representedObject: Any? {
        didSet {
        // Update the view, if already loaded.
        }
    }


}

