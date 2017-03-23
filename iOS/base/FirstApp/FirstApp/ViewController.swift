//
//  ViewController.swift
//  FirstApp
//
//  Created by sj on 17/3/23.
//  Copyright © 2017年 sj. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var resultLabel: UILabel!
    
    @IBOutlet weak var doraChoose: UIImageView!
    
    @IBOutlet weak var youChoose: UIImageView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func buttonClick(_ sender: Any) {
            let  title  = "result"
            let message = "hahah"
        
            let alert = UIAlertController(title: title, message: message, preferredStyle: .alert)

            let action = UIAlertAction(title: "ok", style: .default, handler: nil)
            alert.addAction(action)
        
            self.present(alert, animated: true, completion: nil)
        
        
            youChoose.image = UIImage(named: "paper")
        
        
    }

}

