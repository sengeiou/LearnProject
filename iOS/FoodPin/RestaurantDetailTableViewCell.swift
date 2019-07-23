//
//  RestaurantDetailTableViewCell.swift
//  FoodPin
//
//  Created by cocoa on 2017/8/16.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit

class RestaurantDetailTableViewCell: UITableViewCell {
    
    @IBOutlet  var key :UILabel!
    @IBOutlet var value : UILabel!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
