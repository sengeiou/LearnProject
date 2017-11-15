//
//  ViewController.swift
//  Chapter4
//
//  Created by cocoa on 2017/11/5.
//  Copyright © 2017年 cocoa. All rights reserved.
//
//  文本输入与委托
//  UITextField 在 ib 中选择 keybroad type 用来选择键盘的类型
//  spell checking (拼写检查)  correction (自动修正)
//





import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    @IBOutlet var disLabel : UILabel!
    
    @IBOutlet weak var textField: UITextField!
    
    // 绑定了 editing changed 的事件
    @IBAction func textChanged(textField : UITextField){
//            disLabel.text  = textField.text
        
        if let text = textField.text , !text.isEmpty {
            disLabel.text = text
        }else {
            disLabel.text = "???"
        }
    }
    
    @IBAction func dismissKB (sender : AnyObject){
        print("123")
        self.view.endEditing(true)
        textField.resignFirstResponder()
    }
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        
        print(textField.text)
        print(string)
        if "." == string {
            return false
        }
        
        return true
    }
    
    
}

