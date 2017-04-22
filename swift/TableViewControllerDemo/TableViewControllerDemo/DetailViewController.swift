//
//  DetailViewController.swift
//  TableViewControllerDemo
//
//  Created by sj on 17/4/20.
//  Copyright © 2017年 sj. All rights reserved.
//

import UIKit

class DetailViewController: UIViewController {

    @IBOutlet weak var detailImg: UIImageView!
    var restaurantImage =  ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        detailImg.image = UIImage(named: restaurantImage)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    


}
