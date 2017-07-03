//
//  ViewController.swift
//  Pandola
//
//  Created by cocoa on 2017/7/1.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var p: Pandola!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        p.backgroundColor = UIColor.red
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

