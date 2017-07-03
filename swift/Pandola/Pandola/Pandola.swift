//
//  Pandola.swift
//  Pandola
//
//  Created by cocoa on 2017/7/1.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit

class Pandola: UIView {

    var width : CGFloat  {
        return min(bounds.size.width,bounds.size.height)
    }

    // 六边形的算法，以一个圆为例，360/6 根据角度算出每个的点的x和y （sin cos）
    // 然后连接起来
    
    override func draw(_ rect: CGRect) {
        print(center)
//        let rect = CGRect(x: center.x - (width/2)+5, y: center.y - (width/2)+5, width: width-9, height: width-9)
//        let path = UIBezierPath(roundedRect: rect, cornerRadius:0)
//        path.lineWidth = 3
//        path.stroke()
        
        let path = UIBezierPath()
        let array = createPointerArray(point: center, radio: Double(width / 2), size: 6)
        for index in 0..<array.count{
        
            if(index == 0){
                path.move(to: CGPoint(x: CGFloat(array[index].x), y: CGFloat(array[index].y)))
            } else {
                path.addLine(to: CGPoint(x: CGFloat(array[index].x), y: CGFloat(array[index].y)))
            }
        }
        
        path.lineWidth = 3
        path.stroke()
        
    }
    
    func createPointerArray(point : CGPoint ,radio : Double , size : Int) ->[CCRect]{
        var array : [CCRect] = []
        let angel : Double =  360.0 / Double(size)
        for index in 0...size {
            let rect = CCRect()
            // 偏移30度
            rect.x = Double(point.x) + radio * cos(((angel * Double(index))+30.0) * Double.pi / Double(180))
            rect.y = Double(point.y) + radio * sin(((angel * Double(index))+30.0) * Double.pi / Double(180))
            array.append(rect)
        }
        return array
    }
    
    
    
    

}
