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
    
    let url : String = "http://116.196.79.208:8898/product/server/getItems?status=0"
    var items : [Item?] = []
    
    // request page index
    var pageIndex : Int = 0
 
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let header = MJRefreshNormalHeader(refreshingTarget: self, refreshingAction: #selector(ViewController.refresh))
        self.tableview.mj_header = header
        
        let footer = MJRefreshBackNormalFooter(refreshingTarget: self, refreshingAction: #selector(ViewController.loadmore))
        self.tableview.mj_footer = footer
        
        getItems()
    }
    
    func getItems() {
        Alamofire.request(url).responseJSON { response in
            
            self.stopRefresh()
            
            if let data = response.data, let utf8Text = String(data: data, encoding: .utf8) {
                
                if(self.pageIndex == 0){
                    self.items.removeAll(keepingCapacity: false)
                }
                if let tempItems = [Item].deserialize(from: utf8Text) {
                    self.items += tempItems
                    self.tableview.reloadData()
                }
            }
        }
    }
    
    
    
    @objc func refresh(){
        pageIndex = 0
        getItems()
    }
    
    
    @objc func loadmore(){
        pageIndex += 1
        getItems()
    }
    
    func stopRefresh(){
        if (pageIndex == 0){
            self.tableview.mj_header.endRefreshing()
        }else{
            self.tableview.mj_footer.endRefreshing()
        }
    }
    
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return items.count
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell : TableViewCell =  tableView.dequeueReusableCell(withIdentifier: "cell")
            as! TableViewCell
        if let item =  items[indexPath.row] {
            cell.title.text = item.title
            
           // let range = NSRangePointer(
            
//            let attributeStr = NSAttributedString(string: "¥ " + item.zk_final_price!)
//            attributeStr.attribute(NSBackgroundColorAttributeName, at: 30, effectiveRange: )
            
//            cell.price.text = attributeStr.string
            cell.sales.text  = "月销:" + item.sales!
            if let imgURL = item.pict_url,let url = URL(string: imgURL){
                cell.img.kf.setImage(with: url)
            }
        }
        return cell
    }

    
    // MARK: row height
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 160
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
        if let item = items[indexPath.row], let num_iid = item.num_iid
        {
            clk(itemId: num_iid)
        }
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
    
    // MARK: 123
    func success(result : AlibcTradeResult? ) -> Void {
        print("--------------")
        print(result ?? "123")
    }
    
    
    
    
    
}

