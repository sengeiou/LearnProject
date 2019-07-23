//
//  ViewController.swift
//  chapter9
//
//  Created by cocoa on 2017/11/18.
//  Copyright © 2017年 cocoa. All rights reserved.
//

import UIKit

class ItemViewController: UITableViewController {
    
    
    var array : [Int] = [];
    
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return array.count
    }
    
   
    @IBAction func addNew(_ sender: UIButton) {
        let lastRow = tableView.numberOfRows(inSection: 0)
       let indexPath = IndexPath(item: lastRow, section: 0)
        array.append(lastRow)
        tableView.insertRows(at: [indexPath], with:.automatic)
        
    }
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
           let indexVlaue =  array[indexPath.row];
           remove(index: indexVlaue)
            tableView.deleteRows(at: [indexPath], with: .automatic)
            
        }
    }
    
    func remove(index: Int){
        if let _ =  array.index(of: index){
            array.remove(at: index)
        }
    }
    
    
    @IBAction func edit(_ sender: UIButton) {
        if(isEditing){
            setEditing(false, animated: true)
            sender.setTitle("edit", for: .normal)
        }else{
            setEditing(true, animated: true)
            sender.setTitle("done", for: .normal)
        }
        
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)
        cell.textLabel?.text = "\(indexPath.section) ---\(indexPath.row)"
        
        return cell
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        for a in 1...10 {
            array.append(a)
        }
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }


}

