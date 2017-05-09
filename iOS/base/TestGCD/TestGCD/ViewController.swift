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
        // 方法一
        let queue  = OperationQueue()
        queue.maxConcurrentOperationCount = 5
        
        
        queue.addOperation {
            
            // at child thread
            Thread.sleep(forTimeInterval: 5)
            let text  = "changed"
            OperationQueue.main.addOperation{
                print(text)
            }
            
        }
        
        // 方法二
        let thread1 = BlockOperation{
            // child thread
        
            print("thread1 child thread")
            
            OperationQueue.main.addOperation{
                // UI thread
                print("thread1 UI thread")
            }
            
        }
        thread1.completionBlock = {
            print("thread1 ok")
        }
        
        let thread2 = BlockOperation {
            // child thread
            
            print("thread2 child thread")
            
            OperationQueue.main.addOperation{
                // UI thread
                print("thread2 UI thread")
            }
            
        }
        thread2.completionBlock = {
            print("thread2 ok")
        }
        
        thread1.addDependency(thread2)
    
        
        queue.addOperation(thread1)
        queue.addOperation(thread2)

        
    }
    
    
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    
    

}

