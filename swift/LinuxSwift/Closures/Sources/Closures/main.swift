

func sorted(_ s1 : String, _ s2 : String ) -> Bool {
    return s1 < s2
}


// example1
let names = ["b1","a2","c2","v3"]
let sortedList = names.sorted(by : sorted)
print("\(sortedList)")


// example2
let sortedList2 = names.sorted(by : {(s1 : String, s2 :String) -> Bool in
    return s1 < s2  
})
print("\(sortedList2)")


// example3
let sortedList3  = names.sorted(by :  {(s1 , s2 ) -> Bool in 
    return s1 < s2
})
print("\(sortedList3)")



// example4
let sortedList4 = names.sorted(by : {s1 , s2  in  s1 < s2})
print("\(sortedList4)")


// example5
let sortedList5  = names.sorted(by : { $0 < $1})
print("\(sortedList5)")


