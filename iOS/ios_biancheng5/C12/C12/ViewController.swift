//
//  ViewController.swift
//  C12
//
//  Created by jun shen on 2019/6/26.
//  Copyright © 2019 jun shen. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "show"{
            
            let c = segue.destination as! ViewController2
            c.name = "cocoa"
            
        }
        
        
    }


}

