//
//  ViewController.swift
//  Lesson1
//
//  Created by cocoa on 2017/5/13.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import Cocoa

class ViewController: NSViewController {
    @IBOutlet weak var label: NSTextField!
    
    
    
    
    @IBAction func tt(_ sender: Any) {
    
        let randomer = RandomNumber()
        label.stringValue = randomer.getRandomNumberStr(10)
        
    }

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override var representedObject: Any? {
        didSet {
        // Update the view, if already loaded.
        }
    }


}

