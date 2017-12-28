//
//  ViewController.swift
//  Shiji
//
//  Created by jun shen on 2017/12/20.
//  Copyright © 2017年 jun shen. All rights reserved.
//

import UIKit
import Alamofire
import HandyJSON
import Kingfisher

class ViewController: UIViewController ,UITableViewDelegate,UITableViewDataSource{
    
    @IBOutlet weak var tableview: UITableView!
    
    let url : String = "http://116.196.79.208:8080/product/server/getItems?status=0"
    var items : [Item]? = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        Alamofire.request(url).responseJSON { response in
            
            if let data = response.data, let utf8Text = String(data: data, encoding: .utf8) {
                self.items =  [Item].deserialize(from: utf8Text) as! [Item]
                self.tableview.reloadData()
            }
        }
        let header = MJRefreshNormalHeader(refreshingTarget: self, refreshingAction: #selector(ViewController.refresh))
        //        header.setRefreshingTarget(self.tableview, refreshingAction: Selector("refresh"))
        self.tableview.mj_header = header
    }
    
    @objc func refresh(){
        sleep(2)
        print("下拉刷新")
        self.tableview.mj_header.endRefreshing()
    }
    
    
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return items!.count
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell : TableViewCell =  tableView.dequeueReusableCell(withIdentifier: "cell")
            as! TableViewCell
        cell.title.text = items![indexPath.row].title
        
        if let imgURL = items![indexPath.row].pict_url,let url = URL(string: imgURL){
            cell.img.kf.setImage(with: url)
        }
        
        return cell
        
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 160
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        let num_iid = items![indexPath.row].num_iid
        clk(itemId: num_iid!)
    }
    

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
    }
    
    func clk(itemId : String) {
        let page = AlibcTradePageFactory.itemDetailPage(itemId)
        print(type(of: page))
        
        let showParams = AlibcTradeShowParams();
        showParams.openType = AlibcOpenType.auto
        showParams.backUrl = "tbopen23781332"
        showParams.isNeedPush = false
        
        let taokeParams = AlibcTradeTaokeParams()
        taokeParams.pid = "mm_44823234_8206093_28096268"
        
        let dictParams = ["_viewType":"taobaoNative"]
        let sdk  = AlibcTradeSDK()
        
        sdk.tradeService().show(self, page: page, showParams: showParams, taoKeParams: taokeParams, trackParam: dictParams, tradeProcessSuccessCallback: success, tradeProcessFailedCallback: nil)
    }
    
    
    func success(result : AlibcTradeResult? ) -> Void {
        print("--------------")
        print(result ?? "123")
    }
    
}

