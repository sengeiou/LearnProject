//
//  RestaurantDetailController.swift
//  FoodPin
//
//  Created by cocoa on 2017/7/22.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit

class RestaurantDetailController: UIViewController ,UITableViewDelegate, UITableViewDataSource{
    @IBOutlet weak var tableView: UITableView!
    
    @IBOutlet weak var image: UIImageView!
    var restaurantImage = ""
    var restaurant : Restaurant?
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.automaticallyAdjustsScrollViewInsets = false
        image.image = UIImage(named: restaurantImage)
        tableView.backgroundColor = UIColor(red: 240.0/255.0, green: 240.0/255.0, blue: 240.0/255.0, alpha: 0.2)
        
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 4
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell  = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath) as! RestaurantDetailTableViewCell
        
        switch indexPath.row {
        case 0:
            cell.key.text = "name"
            cell.value.text = restaurant?.name
        case 1:
            cell.key.text = "type"
            cell.value.text = restaurant?.type
        case 2:
            cell.key.text = "location"
            cell.value.text = restaurant?.location
        default:
            cell.key.text = ""
            cell.value.text = ""
            
        }
        
        
        return cell
    }
    
    
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
