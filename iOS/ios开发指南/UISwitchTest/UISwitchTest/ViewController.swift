//
//  ViewController.swift
//  UISwitchTest
//
//  Created by cocoa on 2017/10/26.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        let swc = UISwitch(frame: CGRect(x: 100, y: 100, width: 100, height: 100))
        //swc.setOn(true, animated: true)
        swc.addTarget(self, action: #selector(setOnOff(swc:)), for: UIControlEvents.valueChanged)
        swc.onTintColor = UIColor.red
        print(swc.isOn)
        self.view.addSubview(swc)
    }
    @objc func setOnOff(swc : UISwitch){
        print(swc.isOn)
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

