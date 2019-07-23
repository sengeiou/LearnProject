//
//  Item.swift
//  chapter9
//
//  Created by cocoa on 2017/11/18.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit

class Item {
    var name : String
    var valueInDollars : Int
    var serialNumber : String?
    let dateCreater : NSDate
    
    init(name : String , serialNumber : String?,valueInDollars : Int ) {
        self.name = name
        self.serialNumber = serialNumber
        self.valueInDollars = valueInDollars
        self.dateCreater = NSDate()
    }
}




