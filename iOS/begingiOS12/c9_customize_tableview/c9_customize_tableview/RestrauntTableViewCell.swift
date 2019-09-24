//
//  RestrauntTableViewCell.swift
//  c9_customize_tableview
//
//  Created by jun shen on 2019/4/1.
//  Copyright © 2019 jun shen. All rights reserved.
//

import UIKit

class RestrauntTableViewCell: UITableViewCell {
    
    @IBOutlet var nameLabel : UILabel?
    @IBOutlet var locationLabel : UILabel?
    @IBOutlet var typeLabel : UILabel?
    @IBOutlet var imgView: UIImageView?
    

    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
