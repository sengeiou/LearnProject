//
//  SwiftUITest1.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/6/8.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI

struct SwiftUITest1: View {
    
    @State var index  = 1
    
    var body: some View {
        ZStack {
            
            Color(#colorLiteral(red: 1, green: 1, blue: 1, alpha: 1))
                .edgesIgnoringSafeArea(.all)
            
            VStack {
                HStack {
                    Picker(selection: self.$index, label: /*@START_MENU_TOKEN@*/Text("Picker")/*@END_MENU_TOKEN@*/) {
                            Text("全部").tag(1)
                            Text("已确认").tag(2)
                            Text("已关闭").tag(3)
                        }
                    .background(Color(#colorLiteral(red: 0.501960814, green: 0.501960814, blue: 0.501960814, alpha: 1)))
                    .cornerRadius(10)
                    .pickerStyle(SegmentedPickerStyle())
                }
                .padding(.horizontal, 30)
            
                Text("the index of segment = \(index)")
                
                Button(action: /*@START_MENU_TOKEN@*/{}/*@END_MENU_TOKEN@*/) {
                 Capsule().frame(width: 10, height: 200)
                                           .foregroundColor(Color(#colorLiteral(red: 0.6000000238, green: 0.6000000238, blue: 0.6000000238, alpha: 1)))
                }
                Button(action: {
                    print("123")
                }){
                    Text("123").font(.largeTitle)
                }
                
                
           
            HStack {
                ForEach(1..<5) { index in
                    ZStack(alignment: .bottom ) {
                        Capsule().frame(width: 10, height: 200)
                            .foregroundColor(Color(#colorLiteral(red: 0.6000000238, green: 0.6000000238, blue: 0.6000000238, alpha: 1)))
                        Capsule().frame(width: 10, height: CGFloat(index * 20),alignment: .bottom)
                            .foregroundColor(Color(#colorLiteral(red: 0.9254902005, green: 0.2352941185, blue: 0.1019607857, alpha: 1)))
                    }.frame(width: 10, height: 200)
                }
               
               }
            
            }

        }
        
    }
}

struct SwiftUITest1_Previews: PreviewProvider {
    static var previews: some View {
        SwiftUITest1()
    }
}
