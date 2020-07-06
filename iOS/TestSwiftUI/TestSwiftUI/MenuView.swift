//
//  MenuView.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/5/10.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI

struct MenuView: View {
    var body: some View {
        VStack {
            Color.white
                .frame(width: 30, height: 8)
                .cornerRadius(3)
                .frame(width: 120, height: 8, alignment: .leading)
                .background(Color.gray.opacity(0.7))
                .cornerRadius(3)
                .padding()
                .frame(width: 150 ,height: 10)
                .padding(.vertical, 6)
                .background(Color.gray.opacity(0.3))
                .cornerRadius(10)
            MenuRow(title: "Account", icon: "gear")
            MenuRow(title: "singn", icon: "gear")
            MenuRow(title: "log out", icon: "gear")
        }
        .frame(maxWidth: .infinity)
        .frame(height: 300)
        .background(LinearGradient(gradient: Gradient(colors:[Color(#colorLiteral(red: 0.2392156869, green: 0.6745098233, blue: 0.9686274529, alpha: 1)), Color(#colorLiteral(red: 1, green: 1, blue: 1, alpha: 1))]), startPoint: .top, endPoint: .bottom))
        .cornerRadius(20)
        .shadow(radius: 20)
        .padding(20)
        .overlay(
            Image("avatar")
            .resizable()
            .frame(width: 60, height: 60)
            .aspectRatio(contentMode: .fill)
                .clipShape(Circle())
            .offset(y: -150)
        )
    }
}

struct MenuView_Previews: PreviewProvider {
    static var previews: some View {
        MenuView()
    }
}

struct MenuRow: View {
    var title : String
    var icon : String
    
    var body: some View {
        HStack {
            Image(systemName: icon)
                .font(.system(size: 20, weight: .bold))
                .imageScale(.large)
                .frame(width: 36, height: 36)
            Text(title)
                .font(.system(size: 20, weight: .bold, design: .rounded))
                .frame(width: 120, alignment: .leading)
        }
    }
}
