//
//  SwiftUITest2.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/6/9.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI

struct SwiftUITest2: View {
    
    @State var check = false

    var body: some View {
        VStack {
            Toggle(LocalizedStringKey("11"),isOn: $check)
            Toggle(LocalizedStringKey("22"),isOn: $check)
                .frame(width: .zero, height: 30)
            Text("\(check.description)")
        
        }
    }
}

struct SwiftUITest2_Previews: PreviewProvider {
    static var previews: some View {
        SwiftUITest2()
    }
}
