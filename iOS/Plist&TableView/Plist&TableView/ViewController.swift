//
//  ViewController.swift
//  Plist&TableView
//
//  Created by jun shen on 2018/2/28.
//  Copyright © 2018年 jun shen. All rights reserved.
//

import UIKit

class ViewController: UITableViewController {

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let tableViewCell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)
        tableViewCell.textLabel?.text = (data[keys[indexPath.section]] as! [String])[indexPath.row]
        return tableViewCell
    }
    

    
    override func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return keys[section]
    }
    
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return (data[keys[section]] as! [String]).count
    }
    
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        return keys.count
    }
    
    
    var data : NSDictionary!
    var keys : [String]!
    override func viewDidLoad() {
        super.viewDidLoad()
        if let url =   Bundle.main.url(forResource: "data", withExtension: "plist"){
            data = NSDictionary(contentsOf: url)
            keys = data.allKeys as! [String]
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let str = (data[keys[indexPath.section]] as! [String])[indexPath.row]
        let vc = self.storyboard?.instantiateViewController(withIdentifier: "DetailViewController") as! DetailViewController
        vc.disText = str
        self.present(vc, animated: true, completion: nil)
        
    }


}

