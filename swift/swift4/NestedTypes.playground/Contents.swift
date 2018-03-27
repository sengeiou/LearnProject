//: Playground - noun: a place where people can play

import UIKit


// 嵌套类型
// 在一个类型中嵌套另一个类型，将嵌套类型的定义写在其外部类的 {} 内，并且可以根据需要定义多级嵌套。


// 看下面的例子

struct BlackjackCard {
    
    enum Suit : Character {
            case spades = "♠", heart = "♡", diamonds = "♢", clubs = "♣"
    }
    
    enum Rank : Int {
        case two = 2, three, four, five, six , seven, eight, nine, ten
        case jack, queen, king, ace
        struct Value {
            let first : Int
            let second : Int?
        }
        var value : Value {
            switch self {
            case .ace:
                return Value(first: 1, second: 11)
            case .jack, .queen, .king :
                return Value(first: 10, second: nil)
            default:
                return Value(first:self.rawValue, second: nil)
            }
        }
    }
        let rank : Rank
        let suit : Suit
        var description : String {
            var output = "suit is \(suit.rawValue)" +
            "value is \(rank.value.first)"
            if let second = rank.value.second {
                output += "or \(second)"
            }
            return output
        }

}

 let theAceOfSpades = BlackjackCard(rank: .ace, suit: .spades)
  print(theAceOfSpades.description)

 let heartSymbol = BlackjackCard.Suit.heart.rawValue

// 很奇怪，上面已经写成 case jack, queen, king, ace ，但是这里打印发现
// BlackjackCard.Rank.jack.rawValue = 11
BlackjackCard.Rank.jack.rawValue



