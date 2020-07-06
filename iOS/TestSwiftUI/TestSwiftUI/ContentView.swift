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
    @State var viewState = CGSize.zero
    @State var showCard = false
    @State var bottomState = CGSize.zero
    
    var body: some View {
        ZStack {
            TitleView()
                .offset(y: showCard ? -100 : 0)
                .opacity(showCard ?  0.2 : 1)
                .blur(radius: show ? 20 : 0)
                .animation(.default)

            BackCardView()
                .background(Color("card4"))
                .cornerRadius(20)
                .shadow(radius: 20)
                .offset(x: 0.0, y: show ? -250 : -40.0)
                .offset(x: viewState.width, y: viewState.height)
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
                .offset(x: viewState.width, y: viewState.height)
                .scaleEffect(0.95)
                .rotationEffect(.degrees(show ?0:5))
                .rotation3DEffect(Angle(degrees: show ? 0 : 5), axis: (x: 10.0, y: 0.0, z: 0.0))
                .blendMode(.hardLight)
               .animation(.easeIn(duration: 0.3))

            
            CardView()
                .background(Color.black)
                .frame(width: showCard ? 375 : 340.0, height: 220.0)
                .cornerRadius(showCard ? 30 : 20)
                .offset(x: viewState.width, y: viewState.height)
                .blendMode(.hardLight)
                .animation(.spring(response: 0.3, dampingFraction: 0.6, blendDuration: 0))
                .onTapGesture {
                    self.showCard.toggle()
                    
            }
            .gesture(DragGesture().onChanged{ value in
                self.viewState = value.translation
                self.show = true
            }.onEnded{ value in
                self.viewState = .zero
                self.show = false
            })
//            Text("\(bottomState.height)").offset(y: -300)
            
//            Image(systemName: "gear").offset(y: -300)
            
            
            BottomCardView()
                .offset(x: 0.0, y: showCard ? 360 : 1000)
                .offset(y: bottomState.height)
                .blur(radius: show ? 20 : 0)
                .animation(.linear)
                .gesture(DragGesture().onChanged{value in
                    self.bottomState = value.translation
                    }
                .onEnded{value in
                    if(self.bottomState.height > 100){
                        self.showCard = false
                    }
                    
                    if(self.bottomState.height < -100){
                        self.bottomState.height = -200
                    }else{
                        self.bottomState = .zero
                    }
                }
                )
            
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
        
    }
}
