//
//  ViewController.swift
//  UILabelTest
//
//  Created by cocoa on 2017/10/26.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        let label = UILabel(frame: CGRect(x: 100, y: 100, width: 200, height: 40))
        label.text = "123"
        label.lineBreakMode = .byCharWrapping
        label.textColor = UIColor.red
        label.textAlignment = .center
        label.backgroundColor = UIColor.gray
        self.view.addSubview(label)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

}

