//: Playground - noun: a place where people can play

import UIKit

protocol ListTableDataSource : class{
    func numberOfRows(listTable : ListTable) -> Int
    
    func cellForRowAtIndex (listTable : ListTable , index : Int) -> ListCell
}




class ListTable{
    
    var dataSource : ListTableDataSource?
    
    func draw() {
        if(self.dataSource != nil){
            for index in 1...self.dataSource!.numberOfRows(listTable: self){
                let litsCell = self.dataSource!.cellForRowAtIndex(listTable: self, index: index)
                litsCell.draw()
                
            }
        }
        
        
    }
}

class ListCell{
    func draw() {
        print("draw")
    }
}

class ListTableController : ListTableDataSource{
    var listTable : ListTable?
    
    init(){
        self.listTable = ListTable()
        self.listTable?.dataSource = self
    }
    
    
    func numberOfRows(listTable : ListTable) -> Int
    {
    return 10
    
    }
    func cellForRowAtIndex (listTable : ListTable , index : Int) -> ListCell
    {
        return ListCell()
    }

}


var listTableController = ListTableController()

listTableController.listTable!.draw()




