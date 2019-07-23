//: Playground - noun: a place where people can play

import UIKit

//类型转换 可以判断实例的类型，也可以将实例看做是其父类或者子类的实例。

// 类型转换在 Swift 中使用 is 和 as 操作符实现。这两个操作符提供了一种简单达意的方式去检查值的类型或者转换它的类型。

// 也可以用来检查类型是否实现了某个协议


//定义一个类层次作为例子


class MediaItem {
    var name : String?
    init(name: String ){
        self.name = name
    }
}

class Movie : MediaItem {
    var director : String
    init(name: String, director: String){
        self.director = director
        super.init(name: name)
    }
}


class Song : MediaItem {
    var artist : String
    init(name: String , artist : String){
        self.artist = artist
        super.init(name: name)
    }
}

let library = [
    Movie(name: "Casablanca", director: "Michael Curtiz"),
    Song(name: "Blue Suede Shoes", artist: "Elvis Presley"),
    Movie(name: "Citizen Kane", director: "Orson Welles"),
    Song(name: "The One And Only", artist: "Chesney Hawkes"),
    Song(name: "Never Gonna Give You Up", artist: "Rick Astley")
]

print(type(of: library))  // Array<MediaItem>

// 对 library 进行类型腿短，发现是  Array<MediaItem> 类型的，如果你对 library 进行遍历，那么每个item 都是 MediaItem 类型。所以要进行下面的操作，看下面的例子

for item in library {
    if item is Movie {
        print(type(of: item))
//        print(item.director)  这里并不能这么操作，说明 item 还是MediaItem 类型，但是上面的 type(of: item) => Movie  很奇怪
        print("find movie")
    }else  if item is Song{
        print("find song")
    }else {
        print("find media item")
    }
}

// 上面的操作 用类型检查操作符（is）来检查一个实例是否属于特定子类型。若实例属于那个子类型，类型检查操作符返回 true，否则返回 false。


// 向下转型  as? 或 as!
// 因为向下转型可能会失败，类型转型操作符带有两种不同形式。条件形式as? 返回一个你试图向下转成的类型的可选值。强制形式 as! 把试图向下转型和强制解包转换结果结合为一个操作。

//当你不确定向下转型可以成功时，用类型转换的条件形式（as?）。条件形式的类型转换总是返回一个可选值，并且若下转是不可能的，可选值将是 nil。这使你能够检查向下转型是否成功。

//只有你可以确定向下转型一定会成功时，才使用强制形式（as!）。当你试图向下转型为一个不正确的类型时，强制形式的类型转换会触发一个运行时错误。

// 这个例子会一直出警告，因为 MediaItem 永远都不是 button 的子类，但是却很好的解释了 as? 的操作
if let item  = library.first as? UIButton {
    print(item)
}else {
    print("item not instance of uibutton")
}

// 重新遍历 library 看看


for item in library {
    if let movie = item as? Movie {
        print(movie.director)
    } else if let song  = item as? Song {
        print(song.artist)
    }
}

// Any 和 AnyObject

//Any 可以表示任何类型，包括函数类型。
//AnyObject 可以表示任何类类型的实例。








