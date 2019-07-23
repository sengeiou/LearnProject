//
//  ViewController.swift
//  AutoLayoutTest
//
//  Created by jun shen on 2017/10/27.
//  Copyright © 2017年 jun shen. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
       
    }

    func getUrl() -> String? {
         let documentDir =  FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)
            
         var documentDirFirst = documentDir.first
        if documentDirFirst != nil
        {
            documentDirFirst!.appendPathComponent("cocoa")
        }
        
    }
    
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

