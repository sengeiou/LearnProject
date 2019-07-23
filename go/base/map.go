package main

import(
  "fmt"
)

/**
1 map的定义 ：var map1 map[keytype]valuetype
        example1： var map1 map[string] string = map[string]string{}
        example2 ：  map2 := map[int]int{}   类型判断
        example3 :  map3 :=  make(map[keytype]valuetype)
2 在申明的时候不需要申明map的长度  map的长度可以动态增加
3 传递参数时，效率没有slice 和数组的 效率高


*/
func main(){
  fmt.Println("go map")
  var map1 map[string] string = map[string]string{}
  map2 := map[int]int{}
  map3 := make(map[int]int)


  map1["0"] = "0"
  map1["1"] = "1"


  map2[0] = 0

  map3[0] = 0


  fmt.Println(map1)
  fmt.Println(map2)
  fmt.Println(map3)

  v :=  map1["01"]
  fmt.Println(v)

  for index,value := range map1 {
      fmt.Println(index, value)
  }



}
