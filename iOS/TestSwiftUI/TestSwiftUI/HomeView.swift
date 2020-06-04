//
//  HomeView.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/5/26.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI

struct HomeView: View {
    
    var list : Array<Int?> = []
    
    @Binding var showProfile : Bool
    @State var showUpdate : Bool = false

    var body: some View {
        
       VStack{
        HStack(alignment: .center) {
                Text("Watching")
                    .font(.system(size: 20, weight: .bold))
                Spacer()
                AvatarView(showProfile: $showProfile)
                Button(action: {
                    self.showUpdate.toggle()
                }) {
                    Image(systemName: "bell")
                        .renderingMode(.original)
                    .frame(width : 30 , height: 30)
                    .background(Color.white)
                    .clipShape(Circle())
                        .shadow(color: Color.gray.opacity(0.5), radius: 10, x: 0, y: 0)
                }
                
                .sheet(isPresented: $showUpdate){
                    ContentView()
                }
                
            }.padding(.top,100)
            .padding(.horizontal, 20)
         
            
        ScrollView(.horizontal, showsIndicators: false) {
            HStack (spacing: 30) {
                ForEach(sectionData) { item in
                    SecctionView(section: item)
                }
            }.padding(30)
        }

        Divider()
        
        Spacer()
        
        }
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView(showProfile: .constant(false))
    }
}

struct SecctionView: View {
    
    var section : Section
    
    var body: some View {
        VStack {
            HStack {
                Text(section.title)
                    .font(.system(size: 24, weight: .bold))
                    .frame(width: 160,alignment: .leading)
                    .foregroundColor(Color.white)
                Spacer()
                Image(section.logo)
            }
            Text(section.text).bold().frame(maxWidth: .infinity, alignment: .leading)
            section.image
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(width: 210)
        }
        .padding(30)
        .frame(width: 270, height: 270)
        .background(section.color)
        .cornerRadius(20)
    }
}


struct Section : Identifiable{
    var id = UUID()
    var title : String
    var text : String
    var logo : String
    var image : Image
    var color : Color
}

let sectionData = [
                    Section(title: "Swift Ui swiftUI", text: "18 sections", logo: "Logo1", image: Image("Card1"), color: Color("card1")),
                   Section(title: "AndroidUI %% AndroidUI", text: "22 sections", logo: "Logo1", image: Image("Card2"), color: Color("card2"))
]

