//
//  ViewController.swift
//  SerialQueue
//
//  Created by shenjun on 17/4/4.
//  Copyright © 2017年 shenjun. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var imgView: UIImageView!
    let imageUrls = [
        "https://dn-boxueio.qbox.me/image1-big.jpg",
        "https://dn-boxueio.qbox.me/image2-big.jpg",
        "https://dn-boxueio.qbox.me/image3-big.jpg",
        "https://dn-boxueio.qbox.me/image4-big.jpg"
    ]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        self.imgView.image = Downloader.downloadImageWithURL(url: imageUrls[0])
        self.imgView.clipsToBounds = true
    
    }


}

