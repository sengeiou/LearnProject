//
//  Downloader.swift
//  SerialQueue
//
//  Created by shenjun on 17/4/4.
//  Copyright © 2017年 shenjun. All rights reserved.
//

import UIKit
class Downloader {
    
    class func downloadImageWithURL(url:String) -> UIImage! {
        let data = NSData(contentsOf: NSURL(string: url) as! URL)
        return UIImage(data: data! as Data)
    }
}
