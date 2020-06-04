//
//  Home.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/5/13.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI

struct Home: View {
    
    @State var showProfile = false
    
    
    var body: some View {
        ZStack {
            Color.gray.edgesIgnoringSafeArea(.all)
            
            HomeView(showProfile: $showProfile)
            .padding(.top,44)
            .background(Color.white)
            .scaleEffect(showProfile ? 0.9 : 1 )
                .rotation3DEffect(Angle(degrees: showProfile ? -10 : 0 ), axis: (x: 10.0, y: 0, z: 0))
            .offset(y: showProfile ? -500: 0)
            .animation(.spring(response: 0.5, dampingFraction: 0.6, blendDuration: 200))
            .cornerRadius(20)
            .edgesIgnoringSafeArea(.all)
            
            
            
            MenuView()
                .frame(height : 1000)
                .background(Color.black.opacity(0.01))
                .offset(y: showProfile ? 0 : screen.height)
                .animation(.spring(response: 0.5, dampingFraction: 0.6, blendDuration: 200))
                .onTapGesture {
                    self.showProfile.toggle()
            }
        }
            

    }
}

struct Home_Previews: PreviewProvider {
    static var previews: some View {
        Home()
    }
}

struct AvatarView: View {
    
    @Binding var showProfile : Bool
    
    var body: some View {
        Button(action:{self.showProfile.toggle()}) {
            Image("avatar").renderingMode(.original)
                .resizable()
                .frame(width: 30, height: 30)
                .clipShape(Circle())
        }
    }
}


let screen = UIScreen.main.bounds

