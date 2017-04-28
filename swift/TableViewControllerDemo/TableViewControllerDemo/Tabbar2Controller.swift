//
//  Tabbar2Controller.swift
//  TableViewControllerDemo
//
//  Created by sj on 17/4/27.
//  Copyright © 2017年 sj. All rights reserved.
//

import UIKit

class Tabbar2Controller: UIViewController {

    @IBAction func click(_ sender: Any) {
        if let url  = URL(string:  "https://www.baidu.com"){
            UIApplication.shared.open(url)
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
