//
//  RestaurantDetailController.swift
//  FoodPin
//
//  Created by cocoa on 2017/7/22.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit

class RestaurantDetailController: UIViewController {

    @IBOutlet weak var image: UIImageView!
    var restaurantImage = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        image.image = UIImage(named: restaurantImage)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
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
