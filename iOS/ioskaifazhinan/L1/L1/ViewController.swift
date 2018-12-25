//
//  ViewController.swift
//  L1
//
//  Created by cocoa on 2017/9/3.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit
// 基本控件的使用
class ViewController: UIViewController {
    
    var textField : UITextField?
    var button : UIButton?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        textField = UITextField(frame: CGRect(x: 100, y: 100, width:300, height: 100))
        textField!.borderStyle = UITextBorderStyle.roundedRect
        textField!.placeholder =  "im a placeholder"
        textField!.center = self.view.center
        // 清除的按钮
        textField!.clearButtonMode = .always
        textField!.backgroundColor = UIColor.red
        textField!.font =  UIFont.systemFont(ofSize:CGFloat(40))
        
        textField!.textAlignment = .center
        self.view.addSubview(textField!)
        
        button = UIButton(type: .system)
        button!.frame = CGRect(x: 10, y: 10, width: 100, height: 100)
        button!.setTitle("start", for: UIControlState())
        button!.addTarget(self, action: #selector(ViewController.test(_:)), for: UIControlEvents.touchUpInside)
        self.view.addSubview(button!)
    }
    @objc func test(_ sender : UIButton){
        if let labelMsg = sender.titleLabel?.text {
            print(labelMsg)
        }
        let message = textField?.text
        if let result = message {
            print(result)
        }
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

