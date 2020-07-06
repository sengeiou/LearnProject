//
//  ShadowModifier.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/6/15.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI

struct ShadowModifier: ViewModifier{
    
    func body(content: Content) -> some View{
        content.shadow(color: Color(#colorLiteral(red: 0.2549019754, green: 0.2745098174, blue: 0.3019607961, alpha: 1)), radius: 5, x: 5, y: 0)
    }
    
}
