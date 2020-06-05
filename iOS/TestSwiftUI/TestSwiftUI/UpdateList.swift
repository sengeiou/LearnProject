//
//  UpdateList.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/6/2.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI

struct UpdateList: View {
    var body: some View {
        NavigationView {
            List {
                ForEach(updateList) { item in
                    NavigationLink(destination: UpdateDetailView(update: item)) {
                        
                        HStack(alignment: .top) {
                            
                            Image(item.image)
                                .resizable()
                                .frame(width: 100 , height : 100)
                                .aspectRatio(contentMode: .fit)
                                .background(Color.black)
                                .cornerRadius(20)

                            
                            VStack(alignment: .leading) {
                                Text(item.title)
                                    .font(.system(size: 20, weight: .bold, design: .default))
                                Text(item.text)
                                    .font(.system(.subheadline, design: .default))
                                    .lineLimit(2)
                            }
                        }
                        
                    }
                }
                .onDelete{ index in
                    
                }
            }
            .navigationBarTitle(
                Text("title")
            )
            .navigationBarItems(leading: Button(action: {
                
            }) {
                Text("add item")
                    .font(.system(size: 20, weight: .bold, design: .default))
            }, trailing: Button(action: {
                
            }) {
                Text("del item")
            })
            
        }
    }
}

struct UpdateList_Previews: PreviewProvider {
    static var previews: some View {
        UpdateList()
    }
}



struct Update : Identifiable {
    var id = UUID()
    var title : String
    var text : String
    var image : String
    var date : String
}


let updateList  = [
    
    Update(title: "this is title", text: "Welcome to the Swift community. Together we are working to build a programming language to empower everyone to turn their ideas into apps on any platform.", image: "Card1", date: "jan 1"),
    
    Update(title: "Switf UI", text: "Welcome to the Swift community. Together we are working to build a programming language to empower everyone to turn their ideas into apps on any platform.", image: "Card2", date: "jan 1")

]

