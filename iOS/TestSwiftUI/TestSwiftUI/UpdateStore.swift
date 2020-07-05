//
//  UpdateStore.swift
//  TestSwiftUI
//
//  Created by jun shen on 2020/6/5.
//  Copyright © 2020 jun shen. All rights reserved.
//

import SwiftUI
import Combine

class UpdateStore : ObservableObject{
    
    @Published var updates : [Update] = updateList
}
