//
//  ViewController.swift
//  XiaoboTest
//
//  Created by jun shen on 2018/1/17.
//  Copyright © 2018年 jun shen. All rights reserved.
//

import UIKit

class TableViewController: UITableViewController {

    var itemList : [CellItem] = []
    
    func addItems(){
        for i  in 0...10{
            
            
            var cell = CellItem(nane: "name\(i)", age: i)
            
            if i % 2 == 0 {
                    cell = CellItem(nane: "namenamenamenamenamenamenamenamenamenamenamenamenamenamename\(i)", age: i)
            }
             itemList.append(cell)
        }
    }
    
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
    }
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if (segue.identifier == "main"){
            if let controller =  segue.destination as? DetailTableViewController {
                controller.index = itemList[tableView.indexPathForSelectedRow!.row].age
            }
        }
    }
    
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return itemList.count
    }
    
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath) as! TableViewCell
        cell.name.text = "\(itemList[indexPath.row].age)"
        cell.age.text = itemList[indexPath.row].nane
        return cell
    }
 
    override func viewDidLoad() {
        super.viewDidLoad()
        addItems()
        tableView.separatorColor = UIColor.red
        tableView.estimatedRowHeight = 40
        tableView.rowHeight = UITableViewAutomaticDimension
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }


}

