//
//  ViewController.swift
//  MacOS1
//
//  Created by jun shen on 2019/6/13.
//  Copyright © 2019 jun shen. All rights reserved.
//

import Cocoa

class ViewController: NSViewController {

    @IBAction func aa(_ sender: Any) {
//        let controller = self.storyboard?.instantiateController(withIdentifier: "cc"
//        ) as! NSViewController
        
        let controller = TestController()
         presentAsModalWindow(controller)
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
//        self.con
    }

    override var representedObject: Any? {
        didSet {
        // Update the view, if already loaded.
        }
    }


}

