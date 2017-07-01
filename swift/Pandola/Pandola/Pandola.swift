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

    
    
    
    override func draw(_ rect: CGRect) {
    
        print(center)
        let rect = CGRect(x: center.x - (width/2)+5, y: center.y - (width/2)+5, width: width-9, height: width-9)
        let path = UIBezierPath(roundedRect: rect, cornerRadius:0)
        path.lineWidth = 3
        path.stroke()
        
        
    }
    
    
    

}
