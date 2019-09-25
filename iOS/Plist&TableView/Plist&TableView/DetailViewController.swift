//
//  DetailViewController.swift
//  Plist&TableView
//
//  Created by jun shen on 2018/2/28.
//  Copyright © 2018年 jun shen. All rights reserved.
//

import UIKit

class DetailViewController: UIViewController {
    @IBOutlet weak var disLabel: UILabel!
    var disText = ""
    override func viewDidLoad() {
        super.viewDidLoad()
        disLabel.text = disText
    }

    @IBAction func btnClicked(_ sender: Any) {
        let viewController = self.parent as! ViewController
        viewController.data.setValue(["111","222"], forKey: "雄安")
        viewController.keys = viewController.data.allKeys as! [String]
        viewController.tableView.reloadData()
        
        self.dismiss(animated: true, completion: nil)
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
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
