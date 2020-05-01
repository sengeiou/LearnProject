//
//  ContentView.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/4/19.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    
    @State var show  = false
    
    var body: some View {
        ZStack {
            TitleView()
                .blur(radius: show ? 20 : 0)
                .animation(.default)

            BackCardView()
                .background(Color("card4"))
                .cornerRadius(20)
                .shadow(radius: 20)
                .offset(x: 0.0, y: show ? -250 : -40.0)
                .scaleEffect(0.9)
                .rotationEffect(.degrees(show ? 0 : 10))
                .rotation3DEffect(Angle(degrees: show ? 0 : 10), axis: (x: 10.0, y: 5.0, z: 0.0))
                .blendMode(.hardLight)
                .animation(.easeIn(duration: 0.3))
            
            
            BackCardView()
                .background(Color("card3"))
                .cornerRadius(20)
                .shadow(radius: 20)
                .offset(x: 0.0, y: show ? -130 : -20.0)
                .scaleEffect(0.95)
                .rotationEffect(.degrees(show ?0:5))
                .rotation3DEffect(Angle(degrees: show ? 0 : 5), axis: (x: 10.0, y: 0.0, z: 0.0))
                .blendMode(.hardLight)
               .animation(.easeIn(duration: 0.3))

            
            CardView()
                .blendMode(.hardLight)
                .onTapGesture {
                    self.show.toggle()
            }
            
            BottomCardView()
                .blur(radius: show ? 20 : 0)
                .animation(.default)
            
                
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
            Text("").frame(width: 340, height: 220, alignment: .center)
        }.frame(width: 340.0, height: 220.0)
            
            
    }
}

struct TitleView: View {
    var body: some View {
        VStack {
            HStack {
                Text("Placeholder")
                    .font(.largeTitle)
                    .fontWeight(.bold)
                Spacer()
            }.padding()
            Image("Background1")
            Spacer()
        }
    }
}

struct BottomCardView: View {
    var body: some View {
        VStack(spacing: 20.0){
            Rectangle()
                .frame(width: 40, height: 5)
                .cornerRadius(3)
                .opacity(0.2)
            
            Text("Swift is a fantastic way to write software, whether it’s for phones, desktops, servers, or anything else that runs code. It’s a safe, fast, and interactive programming language that combines the best in modern language thinking with wisdom from the wider Apple engineering culture and the diverse contributions from its open-source community. The compiler is optimized for performance and the language is optimized for development, without compromising on either.")
                .font(.subheadline)
            Spacer()
        }
        .padding()
        .background(Color.white)
        .cornerRadius(30.0)
        .shadow(radius: 20)
        .offset(x: 0.0, y: 500.0)
    }
}
