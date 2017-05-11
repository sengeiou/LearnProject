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
//        queue.addOperation {
//            
//            // at child thread
//            Thread.sleep(forTimeInterval: 5)
//            let text  = "changed"
//            OperationQueue.main.addOperation{
//                print(text)
//            }
//            
//        }
        
        let thread1 = BlockOperation{
            print("thread1 start")
            Thread.sleep(forTimeInterval: 3)

        }
        queue.maxConcurrentOperationCount = 5
        
        
        queue.addOperation {
            
            // at child thread
            Thread.sleep(forTimeInterval: 5)
            OperationQueue.main.addOperation({
                print("thread1 ok")
            })
        }
            
        thread1.completionBlock = {
            print("thread1 is complete")
        }
        
        let thread2  = BlockOperation{
            print("thread2 start")
            Thread.sleep(forTimeInterval: 3)
            OperationQueue.main.addOperation({
                print("thread2 ok")
            })
        }
        
        thread2.addDependency(thread1)
        
        queue.addOperation(thread1)
        queue.addOperation(thread2)
        
        
        // cancel task
//        Thread.sleep(forTimeInterval: 1)
//        queue.cancelAllOperations()
        

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}

