//
//  RandomNumber.swift
//  Lesson1
//
//  Created by cocoa on 2017/5/13.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import Foundation


class RandomNumber{

    let numberStr = [0,1,1,2,3,4,5,6,7,8,9]
    
    func getRandomNumberStr(_ length: Int) ->String
    {
        var str = ""
        for _ in 0..<length{
            str.append("\(generateRandomChar())")
        }
        return str
    }

    func generateRandomChar() -> Int {
       let index  = Int(arc4random_uniform(UInt32(numberStr.count)))
        return numberStr[index]
    }
    
    
}

