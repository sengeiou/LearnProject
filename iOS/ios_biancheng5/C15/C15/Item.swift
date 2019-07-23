//
//  Item.swift
//  C15
//
//  Created by jun shen on 2019/6/28.
//  Copyright © 2019 jun shen. All rights reserved.
//

import Foundation


class Item : NSCoding{
    func encode(with aCoder: NSCoder) {
        aCoder.encode(name, forKey: "name")
        aCoder.encode(age, forKey: "age")
    }
    
    required init?(coder aDecoder: NSCoder) {
        <#code#>
    }
    
    var name : String
    var age : Int
    
    init(name : String , age : Int) {
        self.name  = name
        self.age = age
    }
    
    
}
