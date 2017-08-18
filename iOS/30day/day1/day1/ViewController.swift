//
//  ViewController.swift
//  day1
//
//  Created by sj on 17/8/15.
//  Copyright © 2017年 sj. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var startBtn: UIButton!
    @IBOutlet weak var timerLabel: UILabel!
    var timer = Timer()
    var count : Int = 100
    

    
    @IBAction func startTimer(_ sender: Any) {
        timer = Timer.scheduledTimer(timeInterval: 1.0, target: self, selector: Selector("updateTime:") , userInfo: nil, repeats: true)
        
        timer.fire()
    }
    
    
    func updateTime(){
        count = count - 1
        timerLabel.text = String(count)
    }
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        timerLabel.text = String(count)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

