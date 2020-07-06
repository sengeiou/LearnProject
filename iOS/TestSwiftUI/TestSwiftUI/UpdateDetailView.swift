//
//  UpdateDetailView.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/6/4.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI

struct UpdateDetailView: View {
    
    var update : Update = updateList[0]
        
    var body: some View {
        List{ 
            VStack {
                Image(update.image)
                Text(update.text)
                    .frame(maxWidth: .infinity, alignment: .leading)
            }
            .navigationBarTitle(update.title)
        }
    }
}

struct UpdateDetailView_Previews: PreviewProvider {
    static var previews: some View {
        UpdateDetailView()
    }
}
