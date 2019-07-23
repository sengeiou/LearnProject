//: Playground - noun: a place where people can play

import UIKit



protocol ListTableDataSource {
    func numberOfRows(listTable : ListTable) -> Int
    
    func cellForRowAtIndex(listTable : ListTable ,index: Int) -> ListCell
}


class ListTable{
    var dataSource : ListTableDataSource?
    
    func draw(){
        if (self.dataSource != nil) {
            for i in 0..<self.dataSource!.numberOfRows(listTable :self){
               let cell = self.dataSource!.cellForRowAtIndex(listTable : self, index : i)
                cell.draw()
            }
        }
    }
}

class ListCell{
    func draw (){
        print("im a list cell")
    }
}


class ListTableController : ListTableDataSource{
    
    var listTable : ListTable!
    
    init() {
        self.listTable = ListTable()
    }
    
    func listWillDisplay(){
        self.listTable.dataSource = self
    }
    
    func numberOfRows (listTable : ListTable ) -> Int {
        return 10
    }
    func cellForRowAtIndex(listTable : ListTable ,index: Int) -> ListCell{
        return ListCell()
    }
    
}

let b : Bool = 10 % 2 == 0


var controller : ListTableController  = ListTableController()

controller.listWillDisplay()

controller.listTable.draw()



