//
//  TableViewController.swift
//  TableViewControllerDemo
//
//  Created by sj on 17/4/12.
//  Copyright © 2017年 sj. All rights reserved.
//

import UIKit

class TableViewController: UITableViewController , UISearchResultsUpdating {
    var restaurantsData:[Restaurant] = [
        Restaurant(name: "Cafe Deadend", type: "Coffee & Tea Shop", location: "HongKong", image: "cafedeadend.jpg", isVisited: false),
            Restaurant(name: "Homei", type: "Cafe", location: "Hong Kong", image:
                "homei.jpg", isVisited: false),
            Restaurant(name: "Teakha", type: "Tea House", location: "Hong Kong", image:
                "teakha.jpg", isVisited: false),
            Restaurant(name: "Cafe loisl", type: "Austrian / Causual Drink", location:
                "Hong Kong", image: "cafeloisl.jpg", isVisited: false),
            Restaurant(name: "Petite Oyster", type: "French", location: "Hong Kong",
                       image: "petiteoyster.jpg", isVisited: false),
            Restaurant(name: "For Kee Restaurant", type: "Bakery", location: "HongKong", image: "forkeerestaurant.jpg", isVisited: false),
                Restaurant(name: "Po's Atelier", type: "Bakery", location: "Hong Kong",
                           image: "posatelier.jpg", isVisited: false),
                Restaurant(name: "Bourke Street Backery", type: "Chocolate", location:
                    "Sydney", image: "bourkestreetbakery.jpg", isVisited: false),
                Restaurant(name: "Haigh's Chocolate", type: "Cafe", location: "Sydney",
                           image: "haighschocolate.jpg", isVisited: false),
                Restaurant(name: "Palomino Espresso", type: "American / Seafood", location:
                    "Sydney", image: "palominoespresso.jpg", isVisited: false),
                Restaurant(name: "Upstate", type: "American", location: "New York", image:
                    "upstate.jpg", isVisited: false),
                Restaurant(name: "Traif", type: "American", location: "New York", image:
                    "traif.jpg", isVisited: false),
                Restaurant(name: "Graham Avenue Meats", type: "Breakfast & Brunch",
                           location: "New York", image: "grahamavenuemeats.jpg", isVisited: false),
                Restaurant(name: "Waffle & Wolf", type: "Coffee & Tea", location: "NewYork", image: "wafflewolf.jpg", isVisited: false),
                    Restaurant(name: "Five Leaves", type: "Coffee & Tea", location: "New York",
                               image: "fiveleaves.jpg", isVisited: false),
                    Restaurant(name: "Cafe Lore", type: "Latin American", location: "New York",
                               image: "cafelore.jpg", isVisited: false),
                    Restaurant(name: "Confessional", type: "Spanish", location: "New York",
                               image: "confessional.jpg", isVisited: false),
                    Restaurant(name: "Barrafina", type: "Spanish", location: "London", image:
                        "barrafina.jpg", isVisited: false),
                    Restaurant(name: "Donostia", type: "Spanish", location: "London", image:
                        "donostia.jpg", isVisited: false),
                    Restaurant(name: "Royal Oak", type: "British", location: "London", image:
                        "royaloak.jpg", isVisited: false),
                    Restaurant(name: "CASK Pub and Kitchen", type: "Thai", location: "London",
                               image: "caskpubkitchen.jpg", isVisited: false)
        ]
        

    var restaurants:[Restaurant]  = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        restaurants = restaurantsData
        
        let serchController =  UISearchController(searchResultsController: nil)
        serchController.searchResultsUpdater = self
        definesPresentationContext = true
        serchController.dimsBackgroundDuringPresentation = false
        tableView.tableHeaderView = serchController.searchBar
        serchController.loadViewIfNeeded()
    }
    
    func updateSearchResults(for searchController: UISearchController) {
        print("123123")
        
        if let text = searchController.searchBar.text
        {
            filterContent(key: text)
            tableView.reloadData()
            print(restaurants.count)
        }
    }
    
    
    func filterContent(key : String){
        restaurants = restaurantsData.filter({
            $0.name.localizedCaseInsensitiveContains(key)
        })
    }
    
    
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    // MARK: - Table view data source
    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return restaurants.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell : RestraurantTableViewCell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath) as! RestraurantTableViewCell
        
        cell.IMG?.image = UIImage(named: restaurants[indexPath.row].image)
        cell.IMG.layer.cornerRadius = 30.0
        cell.IMG.clipsToBounds = true
    
        cell.label?.text =  restaurants [indexPath.row].name
        return cell
    }
    
    
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
//        
//        let alertController  = UIAlertController(title: "hahah", message: "what do you want?", preferredStyle: .actionSheet)
//        
//        alertController.addAction(UIAlertAction(title: "123123", style: .cancel, handler:
//                    {(action: UIAlertAction!) -> Void in
//                         let alertMsg = UIAlertController(title: "call phone", message: "13656657389", preferredStyle: .alert)
//                        
//                         alertMsg.addAction(UIAlertAction(title: "CANCEL", style: .cancel , handler: nil))
//                        
//                         self.present(alertMsg, animated: true, completion: nil)
//                        
//                    }
//        ))
//
//        present(alertController, animated: true, completion: nil)
        
    }
    
//    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
//        if( editingStyle == .delete ){
//            restaurantNames.remove(at: indexPath.row)
//            restaurantImages.remove(at: indexPath.row)
//        }
//        tableView.deleteRows(at: [indexPath], with: .bottom)
//    }
    
    
    override func tableView(_ tableView: UITableView, editActionsForRowAt indexPath: IndexPath) -> [UITableViewRowAction]? {
        
        let shareAction = UITableViewRowAction(style: .default, title: "Share", handler: {(action,indexPath) -> Void in
           
            let defaultText = "Just checking in at " +
                self.restaurants[indexPath.row].name
            let activityController = UIActivityViewController(activityItems:
                [defaultText], applicationActivities: nil)
            self.present(activityController, animated: true, completion: nil)
        
        })
        
        shareAction.backgroundColor = UIColor.orange
        
        
        let deleteAction = UITableViewRowAction(style: .default, title: "Delete", handler: {(action,indexPath) -> Void in
            self.restaurants.remove(at: indexPath.row)
            self.restaurants.remove(at: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .bottom)
        })
        
        
        return [shareAction,deleteAction]
    }
    
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if  segue.identifier == "showDetail"{
            if  let indexPath = tableView.indexPathForSelectedRow {
                
                let destinationController = segue.destination as! DetailViewController
                destinationController.restaurantImage = restaurants[indexPath.row].image
                
            }
        }
    }
    
    
    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
