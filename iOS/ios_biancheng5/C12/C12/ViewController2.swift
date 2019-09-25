//
//  ViewController2.swift
//  C12
//
//  Created by jun shen on 2019/6/26.
//  Copyright © 2019 jun shen. All rights reserved.
//

import UIKit

class ViewController2: UIViewController {

    var name : String?
    
    override func viewDidLoad() {
        super.viewDidLoad()
       
    }
    
    
    override func viewWillAppear(_ animated: Bool) {
        if let n = name {
            print(n)
        }
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
