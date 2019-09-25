//: Playground - noun: a place where people can play

import UIKit


// type casting
// 类型转换可以判断实例的类型，也可以判断实例是否是某个类的父类或子类
// 类型转换在 Swift 中使用 is 和 as 操作符实现
// 也可以用他来检查一个类型是否实现了某个协议

// demo  
// 定义了MediaItem 类
class MediaItem{
    var name : String
    init(name : String){
        self.name = name
    }
}

// 定义了电影类， 增加了字符串类型的导演属性
class Movie : MediaItem{
    var director : String
    init(name : String , director : String){
        self.director = director
        super.init(name: name)
    }
}

// 定义了歌曲类，定义了艺术家的属性
class Song : MediaItem{
    var artist : String
    init(name: String, artist: String) {
        self.artist = artist
        super.init(name: name)
    }
}


// 定义了 library 属性

let library  = [
    Movie(name: "Casablanca", director: "Michael Curtiz"),
    Song(name: "Blue Suede Shoes", artist: "Elvis Presley"),
    Movie(name: "Citizen Kane", director: "Orson Welles"),
    Song(name: "The One And Only", artist: "Chesney Hawkes"),
    Song(name: "Never Gonna Give You Up", artist: "Rick Astley")
]
// 数组 library 的类型被推断为 [MediaItem]
// let library : [MediaItem]  很好理解，不然编译器就会报错的
// 如果你要让它们作为原本的类型工作，你需要检查它们的类型或者向下转换它们到其它类型，接着看


// # 检查类型
//用类型检查操作符（is）来检查一个实例是否属于特定子类型。若实例属于那个子类型，类型检查操作符返回 true，否则返回 false。

print("the library[0] is Movie \(library[0] is Movie)")
print("the library[1] is Movie \(library[1] is Movie)")


var movieCount  = 0
var songCount = 0

for item in library{
    if item is Movie{
        movieCount += 1
    } else if item is Song{
        songCount += 1
    }
}

print("Media library contains \(movieCount) movies and \(songCount) songs")



// #向下转型
// 某类型的一个常量或变量可能在幕后实际上属于一个子类。当确定是这种情况时，你可以尝试向下转到它的子类型，用类型转换操作符（as? 或 as!）。

//因为向下转型可能会失败，类型转型操作符带有两种不同形式。条件形式as? 返回一个你试图向下转成的类型的可选值。强制形式 as! 把试图向下转型和强制解包（转换结果结合为一个操作。

for item in library {
    if let mm = item as? Movie{
        print(mm.director)
    }
}

// 只有你确定向下转型一定成功时，才能使用 as!



// # Any 和 AnyObject 的类型转换

// Swift 为不确定类型提供了两种特殊的类型别名：

// 1.Any 可以表示任何类型，包括函数类型。
// 2.AnyObject 可以表示任何类类型的实例。


// demo

var things = [Any]()

things.append(0)
things.append(0.0)
things.append(42)
things.append(3.14159)
things.append("hello")
things.append((3.0, 5.0))
things.append(Movie(name: "Ghostbusters", director: "Ivan Reitman"))
things.append({ (name: String) -> String in "Hello, \(name)" }) // 闭包表达式


// 这个实在搞不懂 ，这么变态
for thing in things{
    switch thing {
    case let thing as Int:
        print(thing)
    default:
        print("default")
    }
}

//Any类型可以表示所有类型的值，包括可选类型。Swift 会在你用Any类型来表示一个可选值的时候，给你一个警告。如果你确实想使用Any类型来承载可选值，你可以使用as操作符显式转换为Any，如下所示：

let optionalNum : Int? = 3
//things.append(optionalNum)  会报错
things.append(optionalNum as Any)   // 上面说的as 是向下转换，现在成了向上，后续再来理解吧





















