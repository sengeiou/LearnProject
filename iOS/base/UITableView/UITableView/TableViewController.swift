//
//  ViewController.swift
//  UITableView
//
//  Created by shenjun on 17/3/28.
//  Copyright © 2017年 shenjun. All rights reserved.
//

import UIKit

class TableViewController: UITableViewController {

    var tableViewCellArray : [TableViewCell] = []
    
    func getCell(){
        for i in 0..<10 {
            let e  = TableViewCell()
            e.title = "cell for \(i)"
            e.isViewed = i % 2 == 0
            tableViewCellArray.append(e)
        }
    }
    
    
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return tableViewCellArray.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell  = tableView.dequeueReusableCell(withIdentifier: "CellItem", for: indexPath)
    
        let label  = cell.viewWithTag( 1024 ) as! UILabel
        
        print(type(of : cell.viewWithTag( 1024 )))
        
        label.text =  tableViewCellArray[indexPath.row].title
        
        cell.accessoryType = tableViewCellArray[indexPath.row].isViewed ? .checkmark : .none
        
        return cell
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        getCell()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }


}

