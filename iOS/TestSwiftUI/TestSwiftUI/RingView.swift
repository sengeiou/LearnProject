//
//  RingView.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/6/7.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI


struct RingView: View {
    
    var width : CGFloat = 100
    var height : CGFloat = 100
    var precent : CGFloat = 70
    
    @Binding var show : Bool
    
    
    var body: some View {
        ZStack {
            Circle()
                .stroke(Color(#colorLiteral(red: 0.8039215803, green: 0.8039215803, blue: 0.8039215803, alpha: 1)), style: StrokeStyle(lineWidth: 5, lineCap: .round, lineJoin: .round, miterLimit: .infinity, dash: [20,0], dashPhase: 0))
                .frame(width: width, height: height, alignment: .center)
            Circle()
                .trim(from: show ? (100 - precent) / 100  : 1 , to: 1)
            .stroke(LinearGradient(gradient: Gradient(colors: [Color(#colorLiteral(red: 0.2196078449, green: 0.007843137719, blue: 0.8549019694, alpha: 1)),Color(#colorLiteral(red: 0.9254902005, green: 0.2352941185, blue: 0.1019607857, alpha: 1))]), startPoint: .topLeading, endPoint: .bottomTrailing), style: StrokeStyle(lineWidth: 5, lineCap: .round, lineJoin: .round, miterLimit: .infinity, dash: [20,0], dashPhase: 0))
            .rotationEffect(Angle(degrees: 90.0))
            .rotation3DEffect(Angle(degrees: 180), axis: (x: 1, y: 0, z: 0))
            .frame(width: width, height: height, alignment: .center)
            .shadow(color: .white, radius: 0, x: 0, y: 0)
//            .animation(.easeInOut)
            
            
            Text("\(Int(precent))%")
                .font(.system(size: 25, weight: .bold, design: .default))
                .animation(.easeInOut)
                .onTapGesture {
                    self.show.toggle()
            }
        }
        .frame(width: width, height: height)
    }
}

struct RingView_Previews: PreviewProvider {
    static var previews: some View {
        RingView(show: .constant(true))
    }
}
