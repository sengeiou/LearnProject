//
//  Restaurant.swift
//  TableViewControllerDemo
//
//  Created by sj on 17/4/24.
//  Copyright © 2017年 sj. All rights reserved.
//

import Foundation

class Restaurant {
    var name = ""
    var type = ""
    var location = ""
    var image  = ""
    var isVisited = false
    
    init(name: String , type : String , location : String , image : String , isVisited : Bool ){
        self.name = name
        self.type = type
        self.location = location
        self.image = image
        self.isVisited = isVisited
    }

    
}

