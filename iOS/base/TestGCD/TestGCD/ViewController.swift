//
//  ViewController.swift
//  TestGCD
//
//  Created by cocoa on 2017/4/30.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    @IBOutlet weak var button: UIButton!
    @IBAction func clickButton(_ sender: Any) {
        
       // Thread.sleep(forTimeInterval: 5)
        
        let queue  = OperationQueue()
        queue.addOperation {
            
            // at child thread
            Thread.sleep(forTimeInterval: 5)
            let text  = "changed"
            OperationQueue.main.addOperation{
                print(text)
            }
            
        }
    }
    
    
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    
    

}

