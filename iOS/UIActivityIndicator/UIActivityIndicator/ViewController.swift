//
//  ViewController.swift
//  UIActivityIndicator
//
//  Created by cocoa on 2017/7/8.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
       let activityIndicatorView = UIActivityIndicatorView(activityIndicatorStyle: UIActivityIndicatorViewStyle.gray)
       activityIndicatorView.center = self.view.center
       self.view.addSubview(activityIndicatorView)
        
        activityIndicatorView.startAnimating()
        // hiddent view
        activityIndicatorView.hidesWhenStopped = true
        
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

