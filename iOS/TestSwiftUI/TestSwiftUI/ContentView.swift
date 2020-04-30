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
        ZStack {
            BackCardView()
                .background(Color("card4"))
                .cornerRadius(20)
                .shadow(radius: 20)
                .offset(x: 0.0, y: -40.0)
                .scaleEffect(0.9)
                .rotationEffect(.degrees(10))
                .rotation3DEffect(Angle(degrees: 10), axis: (x: 10.0, y: 5.0, z: 0.0))
                .blendMode(.hardLight)
            
            
            BackCardView()
                .background(Color("card3"))
                .cornerRadius(20)
                .shadow(radius: 20)
                .offset(x: 0.0, y: -20.0)
                .scaleEffect(0.95)
                .rotationEffect(.degrees(5))
                .rotation3DEffect(Angle(degrees: 5), axis: (x: 10.0, y: 0.0, z: 0.0))
                .blendMode(.hardLight)
            
            CardView()
                .blendMode(.hardLight)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

struct CardView : View {
    var body: some View {
        VStack {
            HStack {
                VStack(alignment: .leading){
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

struct BackCardView: View {
    var body: some View {
        VStack {
            Text("123").frame(width: 340, height: 220, alignment: .center)
        }.frame(width: 340.0, height: 220.0)
            
            
    }
}
