//
//  ViewController.swift
//  Chapter5
//
//  Created by cocoa on 2017/11/5.
//  Copyright © 2017年 cocoa. All rights reserved.
//
/**
*  视图控制器  View Controllers
*  
*
*
*
*
*/
import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        print("black view controller init")
    }
    
    
    override func viewWillAppear(_ animated: Bool) {
        print("black view controller will appear")
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

