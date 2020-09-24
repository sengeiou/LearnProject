//
//  CourseList.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/7/6.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI

struct CourseList: View {
    var body: some View {
        VStack {
            CourseView()
        }
        
    }
}

struct CourseList_Previews: PreviewProvider {
    static var previews: some View {
        CourseList()
    }
}

struct CourseView: View {
    
    @State var show  = false
    
    var body: some View {
        VStack {
            HStack {
                VStack(alignment: .leading, spacing: 8.0) {
                    Text("Swift UI avd")
                        .font(.system(size: 20, weight: .bold))
                    Text("12312312")
                    
                }.foregroundColor(.white)
                
                Spacer()
                
                Image(uiImage: #imageLiteral(resourceName: "Logo1")).clipShape(/*@START_MENU_TOKEN@*/Circle()/*@END_MENU_TOKEN@*/)
            }
            Spacer()
            
            Image(uiImage: #imageLiteral(resourceName: "Card2"))
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(height : 140)
                .frame(maxWidth: .infinity)
        }
        .padding(30)
        .padding(.top, show ? 30 : 0)
        .frame(maxWidth: show ? .infinity: screen.width - 60 , maxHeight: show ? .infinity: 280)
        .background(Color(#colorLiteral(red: 0.2196078449, green: 0.007843137719, blue: 0.8549019694, alpha: 1)))
        .clipShape(RoundedRectangle(cornerRadius: 30, style: .continuous))
        .shadow(color: Color(#colorLiteral(red: 0.2196078449, green: 0.007843137719, blue: 0.8549019694, alpha: 1)).opacity(0.3), radius: 20, x: 10, y: 20)
        .animation(.easeInOut)
        .onTapGesture {
            self.show.toggle()
        }
        .edgesIgnoringSafeArea(.all)
    }
}
