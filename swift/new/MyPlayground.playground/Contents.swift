import UIKit

var someInts = [Int]()
print(someInts)
print(someInts.count)

var threeDoubles = Array(repeating: 0.0, count: 3)

print(threeDoubles)

var sixDoubles  = threeDoubles + threeDoubles
print(sixDoubles)


var arr : [Int] = [1,2,3]
print(arr)

// 上面介绍了创建数组的四种方式

// 访问数组和修改数组

print(arr.count)
print(arr[1])
arr[1] = 123
print(arr[1])


// 遍历
for item in arr{
    print(item)
}

for (index ,value) in arr.enumerated(){
    print("\(index )   \(value)")
}

// set
// create set

var letters = Set<String>()

letters.insert("1")
letters.insert("2")

print(letters.count)
print(letters)

var fav : Set<String> = ["1","2","3"]

var numbers : Set = [1,2,3]

if let removeKey  = numbers.remove(1){
        print("remove success \(removeKey)")
}else {
        print("remove failed")
}

print(numbers.contains(2))

for item in numbers{
    print(item)
}



// map
var airports :[String: String] = ["1":"1111","2":"2222"]


print(airports)
print(airports.isEmpty)
if let k = airports.updateValue("3333", forKey: "2"){
    print("update success \(k)")
}

if let v = airports["1"]{
    print(v)
}

for (k1,v1) in airports{
    print("\(k1) \(v1)")
}

for k2 in airports.keys{
    print(k2)
}



