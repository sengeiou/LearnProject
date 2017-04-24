//
//  DetailViewController.swift
//  TableViewControllerDemo
//
//  Created by sj on 17/4/20.
//  Copyright © 2017年 sj. All rights reserved.
//

import UIKit

class DetailViewController: UIViewController, UITableViewDelegate, UITableViewDataSource{
    
    
    
    public func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "detailCell", for: indexPath)
        return cell
    }


    @IBOutlet weak var ss: UIImageView!
    var restaurantImage =  ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        ss.image = UIImage(named: restaurantImage)
        self.automaticallyAdjustsScrollViewInsets = false
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 10
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    

}
