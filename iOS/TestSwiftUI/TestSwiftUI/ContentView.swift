//
//  ContentView.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/4/19.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            HStack {
                VStack {
                    Text("Hello, World!")
                        .font(.title)
                        .foregroundColor(Color.white)
                    Text("Placeholder").foregroundColor(Color.white)
                }
                Spacer()
                Image("Logo1")
            }.padding(EdgeInsets(top: 10, leading: 10, bottom: 10, trailing: 10))
            Spacer()
            Image("Card1").resizable().aspectRatio(contentMode: .fill)
                .frame(width: 300, height: 110 , alignment: .top)
        }
        .background(Color.black)
        .frame(width: 340.0, height: 220.0)
        .cornerRadius(20)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
