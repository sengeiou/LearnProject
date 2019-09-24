//
//  ImageStore.swift
//  C14
//
//  Created by jun shen on 2019/6/27.
//  Copyright © 2019 jun shen. All rights reserved.
//

import UIKit


class ImageStore{
    
    static let cache  = NSCache<AnyObject, AnyObject>()
    
    func setImage(img : UIImage , key : String){
        ImageStore.cache.setObject(img, forKey: key as AnyObject)
    }
    
    func getImage(key : String) -> UIImage? {
        return ImageStore.cache.object(forKey: key as AnyObject) as? UIImage
    }
}
