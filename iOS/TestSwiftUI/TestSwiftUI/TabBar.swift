//
//  TabBar.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/6/6.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI

struct TabBar: View {
    var body: some View {
        TabView {
            Home().tabItem {
                Image(systemName: "bell")
                Text("home")
            }
            ContentView().tabItem {
                Image(systemName: "bell")
                Text("content")
            }
        }
    }
}

struct TabBar_Previews: PreviewProvider {
    static var previews: some View {
        TabBar()
    }
}
