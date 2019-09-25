//
//  ViewController2.swift
//  C14
//
//  Created by jun shen on 2019/6/27.
//  Copyright © 2019 jun shen. All rights reserved.
//

import UIKit

class ViewController2: UIViewController {

    @IBOutlet weak var imgview: UIImageView!

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let imgStore = ImageStore()
        if let img  = imgStore.getImage(key: "cocoa"){
            imgview.image = img
        }
        
    }
    
}
